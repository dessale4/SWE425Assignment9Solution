package edu.mum.cs.cs425.studentmgmt.service;

import java.util.List;

import edu.mum.cs.cs425.studentmgmt.model.Student;

public interface StudentService {
	
	public void save(Student student);
	public List<Student>findAll();
	public void delete(Long id);
	public Student getStudent(Long id);
	public void updateStudent(Student student, Long id);
}
