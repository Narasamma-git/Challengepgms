package com.technoelevate.studentproject.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;
import com.technoelevate.studentproject.dto.Student;
public class RowMapperImpl implements RowMapper<Student> {

	@Override
	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		Student std=new Student();
		std.setId(rs.getInt(1));
		std.setName(rs.getString(2));
		std.setPassword(rs.getString(3));
		return std;
	
	}
}