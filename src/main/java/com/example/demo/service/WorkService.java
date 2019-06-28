package com.example.demo.service;

import com.example.demo.doMain.Student;

import java.util.List;

public interface WorkService {
	List<Student> findAll();
	
	List<Student> findAllSeven(String classNm);
	
	List<Student> queryInfoByCondition(String gradeName, String professionalName);
	
	
	String queryAverage(String gradeName, String professionalName);
	
	String queryScore(String low, String high, String gradeName, String professionalName);
	
	List<Student> queryHobby(String gradeName, String professionalName, String hobbyName);
	
	List<Student> search(String low, String high, String code, List<String> awardName, List<String> honor);
}
