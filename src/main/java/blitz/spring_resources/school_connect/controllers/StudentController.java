package blitz.spring_resources.school_connect.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blitz.spring_resources.school_connect.models.Student;
import blitz.spring_resources.school_connect.models.StudentDTO;
import blitz.spring_resources.school_connect.services.StudentService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;




@RestController
@RequestMapping(value = "/students")
public class StudentController {
    private final StudentService service;
    public StudentController(StudentService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ResponseEntity<?> saveStudent(@RequestBody Student student) {
        try {
            return new ResponseEntity<StudentDTO>(service.createStudent(student), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }
    

    @GetMapping("/{student-id}")
    public ResponseEntity<?> getStudent(@PathVariable("student-id") int studentId) {
        try {
            return new ResponseEntity<StudentDTO>(service.getStudentById(studentId), HttpStatus.FOUND);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
    
    @PutMapping("/{student-id}")
    public ResponseEntity<?> putMethodName(@PathVariable String id, @RequestBody String entity) {
        try {
            return ResponseEntity.ok(service.updateStudent(Integer.parseInt(id), null));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping("/{student-id}")
    public ResponseEntity<?> deleteStudent(@PathVariable("student-id") int studentId) {
        try {
            return ResponseEntity.ok(service.deleteStudent(studentId));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
