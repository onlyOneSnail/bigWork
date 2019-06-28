package com.example.demo.dao;

import com.example.demo.doMain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WorkDao {
	@Select({"select id , className , score , hobby , awards from studentinfo where className is not null and score is not null"})
	List<Student> findAll();
	
	@Select({"<script>select id , className , score , hobby , awards from studentinfo where className is not null and score is not null " +
			"<if test= \'classNm != null\'>and className like CONCAT('%',#{classNm},'%')</if> </script>"})
	List<Student> findAllSeven(@Param("classNm") String classNm);
	
	@Select({"select id , className , score , hobby , awards from studentinfo where className is not null and " +
			"score is not null and className like CONCAT('%',#{gradeName},'%') and className like CONCAT('%',#{professionalName},'%')"})
	List<Student> queryInfoByCondition(@Param("gradeName")String gradeName, @Param("professionalName")String professionalName);
	
	@Select({"<script>SELECT avg(score) avgScore FROM studentinfo A WHERE className is not null and score is not null and <![CDATA[ A.score >= 0 AND A.score <= 5.0 ]]> " +
			"<if test= \'gradeName != null\'>and A.className like CONCAT('%',#{gradeName},'%')</if> " +
			"<if test= \'professionalName != null\'>and A.className like CONCAT('%',#{professionalName},'%')</if></script>"})
	String queryAverage(@Param("gradeName")String gradeName, @Param("professionalName")String professionalName);
	
	@Select({"<script>SELECT COUNT(1) dataCount FROM studentinfo A WHERE className is not null and score is not null AND <![CDATA[ A.score >= #{low} AND A.score <= #{high} ]]>" +
			"<if test= \'gradeName != null\'>and A.className like CONCAT('%',#{gradeName},'%')</if> " +
			"<if test= \'professionalName != null\'>and A.className like CONCAT('%',#{professionalName},'%')</if></script>"})
	String queryScore(@Param("low") String low, @Param("high")String high, @Param("gradeName")String gradeName, @Param("professionalName")String professionalName);
	
	@Select({"<script>SELECT id , className , score , hobby , awards FROM studentinfo A WHERE className is not null and score is not null" +
			"<if test= \'gradeName != null\'>and A.className like CONCAT('%',#{gradeName},'%')</if> " +
			"<if test= \'professionalName != null\'>and A.className like CONCAT('%',#{professionalName},'%')</if>" +
			"<if test= \'hobbyName != null\'>and A.hobby like CONCAT('%',#{hobbyName},'%')</if> </script>"})
	List<Student> queryHobby(@Param("gradeName")String gradeName, @Param("professionalName")String professionalName,@Param("hobbyName")String hobbyName);
	
	@Select({"<script>SELECT id , className , score , hobby , awards FROM studentinfo A WHERE className is not null and score is not null AND <![CDATA[ A.score >= #{low} AND A.score <= #{high} ]]>"+
			"<if test= \'code != null\'>and A.hobby like CONCAT('%',#{code},'%')</if> "+
			"<foreach collection=\"awardName\" open=\"and \" separator=\"and\" close=\"\" item=\"awardName\">" +
					"          A.awards like CONCAT('%',#{awardName},'%')" +
					"        </foreach>"+
			"<foreach collection=\"honor\" open=\"and \" separator=\"and\" close=\"\" item=\"honor\">" +
			"          A.awards like CONCAT('%',#{honor},'%')" +
			"</foreach></script>"})
	List<Student> search(@Param("low") String low, @Param("high")String high, @Param("code")String code, @Param("awardName")List<String> awardName, @Param("honor") List<String> honor);
}
