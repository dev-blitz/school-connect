package blitz.spring_resources.school_connect.mapper;

import org.springframework.stereotype.Service;

import blitz.spring_resources.school_connect.models.School;
import blitz.spring_resources.school_connect.models.SchoolDTO;
import blitz.spring_resources.school_connect.models.Student;
import blitz.spring_resources.school_connect.models.StudentDTO;

@Service
public class MapperUtil {
    public StudentDTO toDto(Student student) {
        return new StudentDTO(
            student.getFirstName(),
            student.getMiddleName(),
            student.getLastName(),
            student.getGrade(),
            student.getStudentId(),
            student.getMailId()
        );
    }

    public SchoolDTO toDto(School school) {
        return new SchoolDTO(
            school.getName(),
            school.getAddress(),
            school.getMailId()
        );
    }
}
