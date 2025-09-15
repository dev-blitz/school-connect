package blitz.spring_resources.school_connect.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "schools", catalog = "school_connect_db")
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String address;
    private String city;
    private String state;
    private String country;
    private String zipCode;
    private boolean active;
    @JsonProperty(value = "mail-id")
    @Column(name = "mail_id", unique = true)
    private String mailId;
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    private List<Student> students;
}
