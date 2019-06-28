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
	
	@Override
	public List<Student> queryInfoByCondition(String gradeName, String professionalName) {
		return workDao.queryInfoByCondition(gradeName,professionalName);
	}
	
	@Override
	public String queryAverage(String gradeName, String professionalName) {
		return workDao.queryAverage(gradeName,professionalName);
	}
	
	@Override
	public String queryScore(String low, String high, String gradeName, String professionalName) {
		return workDao.queryScore(low,high,gradeName,professionalName);
	}
	
	@Override
	public List<Student> queryHobby(String gradeName, String professionalName, String hobbyName) {
		return workDao.queryHobby(gradeName,professionalName,hobbyName);
	}
	
	@Override
	public List<Student> search(String low, String high, String code, List<String> awardName, List<String> honor) {
		return workDao.search(low,high,code,awardName,honor);
	}
	
}
