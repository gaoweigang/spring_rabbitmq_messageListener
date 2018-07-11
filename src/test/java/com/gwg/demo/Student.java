package com.gwg.demo;

import java.io.Serializable;
import java.util.List;

public class Student implements Serializable{
	
	private String name;
	
	private List<Integer> idList;
	
	public Student(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Integer> getIdList() {
		return idList;
	}

	public void setIdList(List<Integer> idList) {
		this.idList = idList;
	}
	
	

}
