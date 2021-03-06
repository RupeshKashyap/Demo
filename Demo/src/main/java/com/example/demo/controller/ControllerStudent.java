package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.modal.Student;
import com.example.demo.seiviceInterface.ServiceStudentInterface;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;



@RestController
@RequestMapping("/api") 
@Api(value="Studet Information", description = "Student management")
public class ControllerStudent {
	private static final Logger logger = LogManager.getLogger(ControllerStudent.class);

	@Autowired
	private ServiceStudentInterface serviceStudentInterface;
	@ApiOperation(value = "default method")
	@GetMapping()
	String get() {
		//		System.out.println("Rest controller executing");
		logger.debug("Rest controller executing");
		logger.debug("Debugging log in our greeting method");
		logger.info("Info log in our greeting method");
		logger.warn("Warning log in our greeting method");
		logger.error("Error in our greeting method");
		logger.fatal("Damn! Fatal error. Please fix me.");
		return"hello world";
	}

	@ApiOperation(value = "Get All Student details")
	@GetMapping(value = "/students")
	List getStudent() {
		System.out.println("getstudent method executing");
		ArrayList<Student> list = new ArrayList<Student>();
		list = serviceStudentInterface.getStudent();
		return list;
	}

	@ApiOperation(value = "Add a student")
	@PostMapping(value = "/student")
	ResponseEntity<Object> saveStudent(@RequestBody Student student){
		serviceStudentInterface.saveStudent(student);
		return new ResponseEntity<>("Student is created successfully", HttpStatus.CREATED);
	}

	@ApiOperation(value = "Delete a Student")
	@DeleteMapping(value ="/student/{id}")
	ResponseEntity<Object> deleteStudent(@PathVariable("id")Integer id){
		serviceStudentInterface.deleteStudent(id);
		return new ResponseEntity<>("Student is deleted successfully", HttpStatus.CREATED);
	}

	@ApiOperation(value = "Edit a Student")
	@PutMapping(value = "/student/{id}")
	ResponseEntity<Object> updateStudent(@PathVariable("id") Integer id,@RequestBody Student student){
		serviceStudentInterface.updateStudent(id,student);
		return new ResponseEntity<>("Student is updated successfully", HttpStatus.CREATED);
	}

}
