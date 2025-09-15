package blitz.spring_resources.school_connect.models;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students", catalog = "school_connect_db")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @JsonProperty(value = "first-name")
    private String firstName;
    @JsonProperty(value = "middle-name")
    private String middleName;
    @JsonProperty(value = "last-name")
    private String lastName;
    private int age;
    private String grade;
    @JsonProperty(value = "student-id")
    @Column(name = "student_id", unique = true)
    private String studentId;
    @JsonProperty(value = "mail-id")
    @Column(name = "mail_id", unique = true)
    private String mailId;
    private String address;
    private String city;
    private String state;
    private String country;
    @JsonProperty(value = "zip-code")
    private String zipCode;
    @ManyToOne(cascade = CascadeType.ALL)
    private School school;

    public Student(String name, int age, String grade, String studentId) {
        this.firstName = name;
        this.age = age;
        this.grade = grade;
        this.studentId = String.valueOf(LocalDate.now().getYear()) + name.substring(0);
    }
}
