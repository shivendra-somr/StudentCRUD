package com.agile.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.agile.exception.StudentNotFoundException;
import com.agile.model.Student;

@Repository
public class StudentDB {

	List<Student> getAllStudents;

	public StudentDB() {
		this.getAllStudents = new ArrayList<>();
		getAllStudents.add(new Student(1, "Ram", 99));
		getAllStudents.add(new Student(2, "Shyam", 95));
		getAllStudents.add(new Student(3, "Ghanshyam", 93));
		getAllStudents.add(new Student(4, "Krishna", 91));
		getAllStudents.add(new Student(5, "Bharat", 89));
	}

	public void add(Student student) {
		getAllStudents.add(student);
	}

	public List<Student> getAll() {
		return getAllStudents;
	}

	public Student getStudentById(int id) throws StudentNotFoundException {
	    Optional<Student> student = getAllStudents.stream().filter(s -> s.getRollNo() == id).findFirst();
	    return student.orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + id));
	}


	public String updateStudentById(int id, int marks) {
		Optional<Student> student = getAllStudents.stream().filter(s -> s.getRollNo() == id).findFirst();
		if (student.get() != null) {
			student.get().setMarks(marks);
			return "Student marks updated";
		}
		return "Invalid Roll No!";
	}

	public String deleteStudentById(int id) {
		return getAllStudents.removeIf(s -> s.getRollNo() == id) == true ? "Student Deleted successfully"
				: "Invalid Roll No!";
	}
}
