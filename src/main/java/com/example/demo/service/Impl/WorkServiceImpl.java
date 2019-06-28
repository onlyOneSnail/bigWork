package com.example.demo.service.Impl;

import com.example.demo.dao.WorkDao;
import com.example.demo.doMain.Student;
import com.example.demo.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: demo *
 * @description: *
 * @author: *
 * @create: 2019-06-27 19:33
 **/
@Service
public class WorkServiceImpl implements WorkService {
	@Autowired
	WorkDao workDao;
	
	@Override
	public List<Student> findAll() {
		return workDao.findAll();
	}
	
	@Override
	public List<Student> findAllSeven(String classNm) {
		return workDao.findAllSeven(classNm);
	}
}
