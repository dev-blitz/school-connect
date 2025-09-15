package blitz.spring_resources.school_connect.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import blitz.spring_resources.school_connect.models.School;

public interface SchoolRepository extends JpaRepository<School, Integer> {
}
