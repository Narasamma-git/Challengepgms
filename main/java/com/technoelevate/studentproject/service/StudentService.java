package com.technoelevate.studentproject.service;

import java.util.List;

import com.technoelevate.studentproject.dto.Student;



public interface StudentService {

public boolean insertStd(Student std);
public boolean aunthenticateStd(String name,String password);

public boolean deleteStd(String name);
public Student getStd(String name);
public List<Student> getAllStd();
public boolean upstudent(String name, String password);
	
}
