package com.example.demo.controller;

import com.example.demo.doMain.Student;
import com.example.demo.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	public String showAllInfo(String classNm){
//		List<Student> students = workService.findAll();
		List<Student> students = workService.findAllSeven(classNm);
		return students.toString();
	}
}
