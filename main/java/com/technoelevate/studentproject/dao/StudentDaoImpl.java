package com.technoelevate.studentproject.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.technoelevate.studentproject.dto.Student;
@Component
public class StudentDaoImpl implements StudentDaoInter{
	
	JdbcTemplate template;
	
	public JdbcTemplate getTemplate() {
		return template;
	}

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	@Override
	public boolean insertStudent(Student student,int id,String name,String password) {
		String query="INSERT INTO student_database.student values(?,?,?)";
		int s=template.update(query,id,name,password);
		return true;

	}

	@Override
	public Student authenticStudent(String name){
		RowMapper<Student> row=new RowMapperImpl();
		String query="SELECT * FROM student_database.student WHERE username=?";
		Student std= template.queryForObject(query,row,name);
		return std;

	}

	@Override
 	public boolean deleteStudent(String name) {
		String query="DELETE FROM student_database.student WHERE username=?";
		template.update(query,name);
		return true;
	
	}

	@Override
	public Student getStudent(String name) {
		RowMapper<Student> row=new RowMapperImpl();
		String query="SELECT * FROM student_database.student WHERE username=?";
		Student std=template.queryForObject(query, row, name);
		return std;

	}

	@Override
	public List<Student> getAllStudent() {
		RowMapper<Student> row=new RowMapperImpl();
		String query="SELECT * FROM student_database.student";
		List<Student> std=template.query(query, row);
		return std;
	}

	@Override
	public boolean upadatestudent(String name,String password) {
	String qry="update student_database.student set password=? where username=?";
	int a=template.update(qry,password,name);
	if(a==1) {
		return true;
	}
	else {
		return false;
	}
	}
	
	

}
