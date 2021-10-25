package de.berenberg.schulung.repository;

import de.berenberg.schulung.domain.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LectureRepository extends JpaRepository<Lecture, Long> {
}
