package com.jsp.service;

import java.util.List;

import com.jsp.dao.StudentDao;
import com.jsp.dto.Student;

public class StudentService {
	StudentDao studentDao = new StudentDao();

	public Student insertData(Student student) {
		return studentDao.insertData(student);
	}

	
	public Student deleteStudentById(int id) {
		Student student =studentDao.getStudentById(id);
		if (student != null) {
			return studentDao.deleteData(id);
		}
		return null;
	}

	public Student updateData(int id, Long ph_no) {
		Student student = studentDao.getStudentById(id);
		if (student != null) {
			return studentDao.updateData(id,ph_no);
		}
		return null;
	}


	public Student getStudentById(int id) {
		return studentDao.getStudentById(id);
	}

	public List<Student> getAllRes() {
		return studentDao.getAllRes();
	}

}
