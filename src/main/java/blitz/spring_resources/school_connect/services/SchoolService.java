package blitz.spring_resources.school_connect.services;

import org.springframework.stereotype.Service;

import blitz.spring_resources.school_connect.mapper.MapperUtil;
import blitz.spring_resources.school_connect.models.School;
import blitz.spring_resources.school_connect.models.SchoolDTO;
import blitz.spring_resources.school_connect.repositories.SchoolRepository;

@Service
public class SchoolService {
    private final SchoolRepository repository;
    private final MapperUtil mapper;

    public SchoolService(SchoolRepository repository, MapperUtil mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public SchoolDTO saveSchool(School school) {
        School savedSchool = repository.save(school);
        return mapper.toDto(savedSchool);
    }

    public SchoolDTO getSchoolById(int id) {
        School school = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("School not found with id: " + id));
        return mapper.toDto(school);
    }

    public SchoolDTO updateSchool(int id, School updatedSchool) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("School not found with id: " + id);
        }

        School savedSchool = repository.save(updatedSchool);
        return mapper.toDto(savedSchool);
    }

    public SchoolDTO deleteSchool(int id) {
        School school = repository.findById(id).orElse(null);
        if (school != null) {
            school.setActive(false);
            repository.save(school);
        } else {
            throw new RuntimeException("School not found with id: " + id);
        }
        return mapper.toDto(school);
    }
}
