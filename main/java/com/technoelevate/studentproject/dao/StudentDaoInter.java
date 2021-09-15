package com.technoelevate.studentproject.dao;

import java.util.List;

import com.technoelevate.studentproject.dto.Student;
public interface StudentDaoInter {
	public boolean insertStudent(Student std,int id,String name,String password);
	public Student authenticStudent(String name);
	public boolean deleteStudent(String name);
	public Student getStudent(String name);
	public List<Student> getAllStudent();
public boolean upadatestudent(String name,String password);
}
