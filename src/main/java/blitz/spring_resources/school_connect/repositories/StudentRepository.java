package blitz.spring_resources.school_connect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import blitz.spring_resources.school_connect.models.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    
}
