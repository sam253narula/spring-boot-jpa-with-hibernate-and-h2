package mc.springboot.rest.example.springbootjpawithhibernateandh2.service;
import java.util.List;

import mc.springboot.rest.example.springbootjpawithhibernateandh2.model.Student;

public interface StudentService {
	List<Student> getStudentList();
	Student insertStudent(Student student);
	void deleteStudent(Long id);
	Student updatestudent(Student student);

}
