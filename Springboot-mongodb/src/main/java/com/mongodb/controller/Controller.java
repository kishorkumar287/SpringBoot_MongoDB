package com.mongodb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mongodb.model.Student;
import com.mongodb.repository.StudentRepo;

@RestController
public class Controller {

	@Autowired
	StudentRepo studentRepo;

	@RequestMapping(path = "/addstudent", method = RequestMethod.POST)
	public Student add(@RequestBody Student student) {
		return studentRepo.save(student);
	}

	@RequestMapping(path = "/getallstudent", method = RequestMethod.GET)
	public List<Student> getAll() {
		return studentRepo.findAll();
	}

	@RequestMapping(path = "/getstudent/{id}", method = RequestMethod.GET)
	public Student save(@PathVariable("id") int id) {
		return studentRepo.findById(id).get();
	}
	@RequestMapping(path = "/removestudent/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") int id) {
				studentRepo.deleteById(id);
				return "deleted sucessfully :"+id;
	}

}
