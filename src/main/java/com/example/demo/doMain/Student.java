package com.example.demo.doMain;

import java.io.Serializable;

/**
 * @program: demo *
 * @description: *
 * @author: *
 * @create: 2019-06-27 19:39
 **/
public class Student implements Serializable {
	//主键ID
	private Integer id;
	//班级名称
	private String className;
	
	@Override
	public String toString() {
		return "Student{" +
				"className='" + className + '\'' +
				", score='" + score + '\'' +
				", hobby='" + hobby + '\'' +
				", awards='" + awards + '\'' +
				'}';
	}
	
	//绩点
	private String score;
	//爱好
	private String hobby;
	//奖项
	
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getClassName() {
		return className;
	}
	
	public void setClassName(String className) {
		this.className = className;
	}
	
	public String getScore() {
		return score;
	}
	
	public void setScore(String score) {
		this.score = score;
	}
	
	public String getHobby() {
		return hobby;
	}
	
	public void setHobby(String hobby) {
		this.hobby = hobby;
	}
	
	public String getAwards() {
		return awards;
	}
	
	public void setAwards(String awards) {
		this.awards = awards;
	}
	
	private String awards;
}
