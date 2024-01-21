package com.agile.service;

import java.util.List;

import com.agile.exception.StudentNotFoundException;
import com.agile.model.Student;


public interface StudentService {
	String createStudent(Student student);

	List<Student> getAllStudents();

	Student getStudentByRoll(int roll) throws StudentNotFoundException;

	String updateStudentByRoll(int roll, int marks);

	String deleteStudentByRoll(int roll);
}
