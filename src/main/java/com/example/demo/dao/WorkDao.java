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
	
	@Select({"select id , className , score , hobby , awards from studentinfo where className is not null and score is not null and className like CONCAT('%',#{classNm},'%')"})
	List<Student> findAllSeven(@Param("classNm") String classNm);
}
