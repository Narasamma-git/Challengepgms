package com.technoelevate.studentproject.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.technoelevate.studentproject.dto.Student;

@Controller
public class StudentController {
	@Autowired
	StudentServiceImpl service;
	
	@GetMapping(path="/register")
	public String getLogin(ModelMap map) {
		return "register";
	}

	@PostMapping("/addstudent")
	public String addStudent(ModelMap map,Student student) {
		map.addAttribute("studentobject",student);
	service.insertStd(student) ;
	
		return "addstudent";
	}
	
	@GetMapping("getstudent")
	public String allStudent() {
		return "allstd";
	}
	@GetMapping("/getallstudent")
	public String getAllStudent(ModelMap map,Student student) {
		map.addAttribute("mystudentdetails",service.getAllStd());
		return "getallstudents";
	}
	
			
	@GetMapping("/deletestdd")
	public String deleteStd() {
		return "deletestudent";
	}
	
	@PostMapping("/deletestudentrecord") 
	public String deletestudent(ModelMap map,Student student) {
		map.addAttribute("mystudentobj", student);
		map.addAttribute("name",student.getName());
		if(student.getName()!=null) {
			service.deleteStd(student.getName());
			map.addAttribute("msg","Successfully deleted");
		}
		else {
			map.addAttribute("msg", "not deleted");
		}
		return "deletestd";
		}

	@GetMapping("/loginstd")
	public String authentication(Student student,HttpServletRequest req) {
		HttpSession session=req.getSession();
	session.setAttribute("name",student.getName());
	return "authentication";
	}
	@PostMapping("/loginstudent")
	public String authentication(ModelMap map,Student student) {
		map.addAttribute("mystudentobj", student);
		if(student.getName()!=null) {
			if(service.aunthenticateStd(student.getName(),student.getPassword())==true) {
				map.addAttribute("status","login successfull");
				map.addAttribute("username",student.getName());
				return "authenticationsuccess";
			}
			else {
				map.addAttribute("status","login failed");
				return "authenticationfail";
			}
		}
		return "authentication1";
	}
	@GetMapping("/singlestudentc")
		public String student(ModelMap map,Student student) {
		return "singlestudent";
	}
	@PostMapping("/getsinglestudent")
	public String getsinglestudent(ModelMap map,Student student) {
		
		map.addAttribute("getsinglestudent", student);
		if(student.getName()!=null) {
			map.addAttribute("singlestudentobj",service.getStd(student.getName()));
		}
		return "returnsinglestudent";
	}
	
	@GetMapping("/logout")
	public String searchstudent() {
		return "authentication";
	}

			@GetMapping("/upstdjsp")
			public String upstd() {
				return "upstdjsp";
			}
	@PostMapping("/upstudent")
	public String updatestd(ModelMap map,Student student) {
		map.addAttribute("username", student.getName());
		map.addAttribute("msg", "updated successfully");
				if(service.upstudent(student.getName(),student.getPassword())==true) {
					return "updateinfo";
				}else {
					map.addAttribute("msg","updation fails");
					return "updateinfo";
				}
	}
	
	}
	
