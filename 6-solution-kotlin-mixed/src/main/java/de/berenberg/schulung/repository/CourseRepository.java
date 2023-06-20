package de.berenberg.schulung.repository;

import de.berenberg.schulung.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
