package mc.springboot.rest.example.springbootjpawithhibernateandh2.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mc.springboot.rest.example.springbootjpawithhibernateandh2.model.Student;
import mc.springboot.rest.example.springbootjpawithhibernateandh2.repository.StudentRepository;
import mc.springboot.rest.example.springbootjpawithhibernateandh2.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public List<Student> getStudentList() {
		return studentRepository.findAll();
	}

	@Override
	public Student insertStudent(Student student) {
		return studentRepository.save(student);
	}

	@Override
	public void deleteStudent(Long id) {
		studentRepository.delete(id);
	}

	@Override
	public Student updatestudent(Student student) {
		return studentRepository.saveAndFlush(student);
	}

}
