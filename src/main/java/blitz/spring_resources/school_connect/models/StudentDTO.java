package blitz.spring_resources.school_connect.models;

public record StudentDTO(
        String firstName,
        String middleName,
        String lastName,
        String grade,
        String studentId,
        String mailId) {
}
