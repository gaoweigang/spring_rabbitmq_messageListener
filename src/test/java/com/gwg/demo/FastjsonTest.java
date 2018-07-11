package com.gwg.demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import com.alibaba.fastjson.JSON;

public class FastjsonTest {
	
	public static void main(String[] args) {
		
		Student stu = new Student("gaoweigang");
		
		List<Integer> idList = new ArrayList<Integer>();
		idList.add(11);
		idList.add(12);
		stu.setIdList(idList);
		System.out.println(JSON.toJSONString(stu));
		
		HashMap<String, String> map = new HashMap<String, String>();
		/*map.put("gao", "weigang");
		map.put("高", "红成");*/
		
		Vector<String> nameVec = new Vector();
		nameVec.add("gaoweigang");
		nameVec.add("GAO");
		List<String> nameList = nameVec.subList(0, nameVec.size());
		System.out.println(JSON.toJSONString(nameVec));
		
		for(String key : map.values()){
			System.out.println(key);
		}
		
		/*List<String> nameList = new ArrayList<String>();
		nameList.add("gaoweigang");
		nameList.add("高伟刚");
		System.out.println(nameList.contains("高伟"));*/
		
		
		Vector<Student> studentList = new Vector<Student>();
		studentList.add(new Student("gaoweignag"));
		studentList.add(new Student("gao"));
		
		//将list转数组
		Student[] studenta = studentList.toArray(new Student[studentList.size()]);
		
	    String str =  JSON.toJSONString(studentList);
	    System.out.println(str);
	    

	    Student[] studentArr = {new Student("gaoweignag"), new Student("gao")};
	    System.out.println(JSON.toJSONString(studentArr));
	}

}
