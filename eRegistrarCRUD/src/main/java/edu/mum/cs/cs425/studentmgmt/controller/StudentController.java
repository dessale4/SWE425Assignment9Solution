package edu.mum.cs.cs425.studentmgmt.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.service.StudentService;


@Controller
@RequestMapping("/students")
public class StudentController {
	@Autowired
	StudentService studentService;
	
	@GetMapping("/new")
	public String getStudentRegistrationForm() {
		return "student/new";
	}
	@PostMapping("")
	public String saveSudent(@Valid Student student, BindingResult result, Model model) {
		
		if(result.hasErrors()) { 
			System.out.println("error");
			return "student/new";
		}
		studentService.save(student);
		return "redirect:/students";
	}
	@GetMapping("")
	public String getAllStudents(Student student, Model model){
		List<Student> allStudents = studentService.findAll();
		model.addAttribute("students",allStudents);
		model.addAttribute("studentCount", allStudents.size());
		return "student/show";
	}
	@GetMapping("/edit/{id}")
	public String getStudentUpdateForm(@PathVariable("id") Long id, Model model) {
		
		Student student = studentService.getStudent(id);
		
		model.addAttribute("student", student);
		
		return "student/edit";
	}
	@PutMapping("/edit/{id}")
	public String updateStudent(@PathVariable("id") Long id, @Valid @ModelAttribute Student student, Model model) {
		studentService.save(student);
		return "redirect:/students";
	}
	@PostMapping("/delete/{id}")
	public String deleteStudent(@PathVariable("id") Long id) {
		System.out.println("From delete method");
		studentService.delete(id);
		return "redirect:/students";
	}
}
