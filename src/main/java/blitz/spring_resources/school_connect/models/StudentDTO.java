package blitz.spring_resources.school_connect.models;

public record StudentDTO(
        String firstName,
        String middleName,
        String lastName,
        int age,
        String grade,
        String studentId) {
}
