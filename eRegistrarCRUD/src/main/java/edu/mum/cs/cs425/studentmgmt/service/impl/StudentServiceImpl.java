package edu.mum.cs.cs425.studentmgmt.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.cs.cs425.studentmgmt.model.Student;
import edu.mum.cs.cs425.studentmgmt.repository.StudentRepository;
import edu.mum.cs.cs425.studentmgmt.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	StudentRepository studentRepository;
	
	@Override
	public void save(Student student) {
		
		studentRepository.save(student);
	}

	@Override
	public List<Student> findAll() {
		
		return studentRepository.findAll();
	}

	@Override
	public void delete(Long id) {
		
		studentRepository.deleteById(id);
	}

	@Override
	public Student getStudent(Long id) {
		
		return studentRepository.getOne(id);
	}

//	@Override
//	public void updateStudent(Student student, Long id) {
//		studentRepository.update(student, id);
//		
//	}

}
