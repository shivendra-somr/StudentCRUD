package com.agile.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agile.exception.StudentNotFoundException;
import com.agile.model.Student;
import com.agile.repository.StudentDB;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDB studentDB;

	@Override
	public String createStudent(Student student) {
		studentDB.add(student);
		return "Student created successfully";
	}

	@Override
	public List<Student> getAllStudents() {
		
		return studentDB.getAll();
	}

	@Override
	public Student getStudentByRoll(int roll) throws StudentNotFoundException {
		return studentDB.getStudentById(roll);
	}

	@Override
	public String updateStudentByRoll(int roll, int marks) {
		return studentDB.updateStudentById(roll, marks);
	}

	@Override
	public String deleteStudentByRoll(int roll) {
		
		return studentDB.deleteStudentById(roll);
	}

}
