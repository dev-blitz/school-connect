package blitz.spring_resources.school_connect.services;

import org.springframework.stereotype.Service;

import blitz.spring_resources.school_connect.mapper.MapperUtil;
import blitz.spring_resources.school_connect.models.Student;
import blitz.spring_resources.school_connect.models.StudentDTO;
import blitz.spring_resources.school_connect.repositories.StudentRepository;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final MapperUtil mapper;

    public StudentService(StudentRepository studentRepository, MapperUtil mapper) {
        this.studentRepository = studentRepository;
        this.mapper = mapper;
    }

    public StudentDTO createStudent(Student student) {
        Student savedStudent = studentRepository.save(student);
        return mapper.toDto(savedStudent);
    }

    public StudentDTO getStudentById(int id) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found with id: " + id));
        return mapper.toDto(student);
    }

    public StudentDTO updateStudent(int id, Student updatedStudent) {
        if (!studentRepository.existsById(id)) {
            throw new RuntimeException("Student not found with id: " + id);
        }

        Student savedStudent = studentRepository.save(updatedStudent);
        return mapper.toDto(savedStudent);
    }

    public StudentDTO deleteStudent(int id) {
        Student student = studentRepository.findById(id).orElse(null);
        if (student != null) {
            student.setActive(false);
            studentRepository.save(student);
        } else {
            throw new RuntimeException("Student not found with id: " + id);
        }
        return mapper.toDto(studentRepository.save(student));
    }
}
