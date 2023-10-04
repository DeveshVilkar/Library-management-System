package com.jsp.controller;

import com.jsp.dto.Student;
import com.jsp.service.StudentService;

public class StudentSave {
	public static void main(String[] args) {
		StudentService studentService = new StudentService();
		Student student = new Student();

		student.setName("kaushal");
		student.setPh_no(12322233314l);

		studentService.insertData(student);
	}

}
