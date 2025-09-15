package blitz.spring_resources.school_connect.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import blitz.spring_resources.school_connect.models.School;
import blitz.spring_resources.school_connect.models.SchoolDTO;
import blitz.spring_resources.school_connect.services.SchoolService;

@RestController
@RequestMapping("/schools")
public class SchoolController {
    private final SchoolService service;
    public SchoolController(SchoolService service) {
        this.service = service;
    }

    @GetMapping("/{school-id}")
    public ResponseEntity<?> getSchool(@PathVariable("school-id") int schoolId) {
        try {
            return new ResponseEntity<SchoolDTO>(service.getSchoolById(schoolId), HttpStatus.FOUND);
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
    @PostMapping("/")
    public ResponseEntity<?> saveSchool(@RequestBody School school) {
        try {
            return new ResponseEntity<SchoolDTO>(service.saveSchool(school), HttpStatus.CREATED);
        } catch (RuntimeException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }
    }

    @PutMapping("/{school-id}")
    public ResponseEntity<?> updateSchool(@PathVariable("school-id") int schoolId, @RequestBody School school) {
        try {
            return ResponseEntity.ok(service.updateSchool(schoolId, school));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @DeleteMapping("/{school-id}")
    public ResponseEntity<?> deleteSchool(@PathVariable("school-id") int schoolId) {
        try {
            return ResponseEntity.ok(service.deleteSchool(schoolId));
        } catch (RuntimeException e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
