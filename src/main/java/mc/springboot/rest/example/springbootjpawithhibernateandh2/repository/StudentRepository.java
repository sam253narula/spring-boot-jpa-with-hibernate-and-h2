package mc.springboot.rest.example.springbootjpawithhibernateandh2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import mc.springboot.rest.example.springbootjpawithhibernateandh2.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
