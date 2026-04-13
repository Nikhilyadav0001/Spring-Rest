package nikhil.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import nikhil.model.Student;

public interface IStudentRepo extends JpaRepository<Student, Integer>{

}