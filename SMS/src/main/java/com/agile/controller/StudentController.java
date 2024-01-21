package com.agile.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agile.exception.StudentNotFoundException;
import com.agile.model.Student;
import com.agile.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	@PostMapping("/student/create")
	public ResponseEntity<String> registerStudent(@RequestBody Student student){
		return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudent(){
		return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
	}
	
	@GetMapping("/students/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int studentId) throws StudentNotFoundException {
        Student student = studentService.getStudentByRoll(studentId);
        return student != null ? new ResponseEntity<>(student, HttpStatus.OK)
                				: new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
	
	@PatchMapping("/student/update/{id}/{marks}")
	public ResponseEntity<String> updateStudentById(@PathVariable int id, @PathVariable int marks){
		return new ResponseEntity<>(studentService.updateStudentByRoll(id, marks), HttpStatus.OK);
	}
	
	@DeleteMapping("student/delete/{id}")
	public ResponseEntity<String> deleteStudentbyId(@PathVariable int id){
		return new ResponseEntity<>(studentService.deleteStudentByRoll(id), HttpStatus.OK);
	}

}
