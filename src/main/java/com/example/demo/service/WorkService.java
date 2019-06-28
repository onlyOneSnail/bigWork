package com.example.demo.service;

import com.example.demo.doMain.Student;

import java.util.List;

public interface WorkService {
	List<Student> findAll();
	
	List<Student> findAllSeven(String classNm);
}
