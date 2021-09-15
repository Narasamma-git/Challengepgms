package com.technoelevate.studentproject.service;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.technoelevate.studentproject.dao.StudentDaoImpl;
import com.technoelevate.studentproject.dao.StudentDaoInter;
import com.technoelevate.studentproject.dto.Student;
@Component 
public class StudentServiceImpl implements StudentService {
	ApplicationContext context=new ClassPathXmlApplicationContext("com/technoelevate/studentproject/dao/config.xml");
	StudentDaoInter dao=context.getBean("student",StudentDaoImpl.class);
 
	@Override
	public boolean insertStd(Student student) {
		return dao.insertStudent(student,student.getId(),student.getName(),student.getPassword());
	
	}

	@Override
	public boolean aunthenticateStd(String name, String password) {
		Student s=dao.authenticStudent(name);
		if(name.equalsIgnoreCase(s.getName()) ){
			return true;
		}else {
			return false;
		}
	}


	@Override
	public boolean deleteStd(String name) {
		 dao.deleteStudent(name);
		 return true;
	}

	@Override
	public Student getStd(String name) {
	
		return dao.getStudent(name);
	}

	@Override
	public List<Student> getAllStd() {
   List<Student> studentdetails= dao.getAllStudent();
   return studentdetails;
	}

	@Override
	public boolean upstudent(String name, String password) {
		if(dao.upadatestudent(name, password)==true) {
			return true;
		}
		else {
		return false;
		}
	}
	
	

}
 