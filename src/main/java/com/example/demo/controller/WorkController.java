package com.example.demo.controller;

import com.example.demo.doMain.Student;
import com.example.demo.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo *
 * @description: *
 * @author: *
 * @create: 2019-06-27 19:28
 **/
@Controller
@RequestMapping(value = "/work")
public class WorkController {
	
	@Autowired
	WorkService workService;
	
	@RequestMapping(value = "/showAllInfo",method = RequestMethod.GET)
	@ResponseBody
	public String showAllInfo(){
		//查询所有年级人员，去除className为kong和绩点为空的数据
		List<Student> students = workService.findAll();
		return "信息条数："+students.size()+"条\r\n  人员信息展示: " + students.toString();
	}
	
	@RequestMapping(value = "/showGrade",method = RequestMethod.GET)
	@ResponseBody
	public String showGrade(String gradeName){
		//查询分别属于15、16、17年级的人员信息
		List<Student> students = workService.findAllSeven(gradeName);
		return "信息条数："+students.size()+"条\r\n  人员信息展示: " + students.toString();
	}
	
	@RequestMapping(value = "/queryInfo",method = RequestMethod.GET)
	@ResponseBody
	public String queryInfoByCondition(String gradeName , String professionalName){
		//查询某年级某专业班级人员信息
		List<Student> students = workService.queryInfoByCondition(gradeName,professionalName);
		return "信息条数："+students.size()+"条\r\n  人员信息展示: " + students.toString();
	}
	
	@RequestMapping(value = "/queryAverage",method = RequestMethod.GET)
	@ResponseBody
	public String queryAverage(String gradeName , String professionalName){
		//查询平均分
		String average = workService.queryAverage(gradeName,professionalName);
		return "平均分: "+average;
	}
	
	@RequestMapping(value = "/queryScore",method = RequestMethod.GET)
	@ResponseBody
	public String queryScore(String low ,String high, String gradeName , String professionalName){
		//查询处于绩点区间人数
		String count = workService.queryScore(low,high,gradeName,professionalName);
		String str = "绩点处于"+low+"到"+high+"区间";
		if (gradeName != null && !"".equals(gradeName)){
			str+=gradeName+"届";
		}
		if (professionalName != null && !"".equals(professionalName)){
			str+=professionalName+"专业";
		}
		str+= "的人数: "+count;
		return str;
	}
	
	@RequestMapping(value = "/queryHobby",method = RequestMethod.GET)
	@ResponseBody
	public String queryHobby(String gradeName , String professionalName,String hobbyName){
		//查询爱好
		List<Student> students = workService.queryHobby(gradeName,professionalName,hobbyName);
		String str = "人  ";
		if (gradeName != null && !"".equals(gradeName)){
			str+=gradeName+"届";
		}
		if (professionalName != null && !"".equals(professionalName)){
			str+=professionalName+"专业";
		}
		str+="爱好与"+hobbyName+"有关的人员信息: ";
		return "有该爱好的人员数量: "+students.size() +str+students.toString();
	}
	
	@RequestMapping(value = "/search",method = RequestMethod.GET)
	@ResponseBody
	public String search(String low ,String high, String code , String awardName , String honor){
		ArrayList<String> awardNameList = new ArrayList<>();
		if(awardName != null && awardName.contains("省二")){
			awardNameList.add("省二");
		}else if (awardName != null && awardName.contains("省三")){
			awardNameList.add("省三");
		}else if (awardName != null && awardName.contains("省一")){
			awardNameList.add("省一");
		}else if (awardName != null && awardName.contains("国三")){
			awardNameList.add("国三");
		}else if (awardName != null && awardName.contains("国二")){
			awardNameList.add("国二");
		}else if (awardName != null && awardName.contains("国一")){
			awardNameList.add("国一");
		}
		awardNameList.add(awardName);
		ArrayList<String> honorList = new ArrayList<>();
		honorList.add(honor);
		//总查询
		List<Student> students = workService.search(low,high,code,awardNameList,honorList);
		return "信息条数："+students.size()+"条\r\n  人员信息展示: " + students.toString();
	}
}
