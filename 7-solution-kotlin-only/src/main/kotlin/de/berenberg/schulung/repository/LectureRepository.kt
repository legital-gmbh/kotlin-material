package de.berenberg.schulung.repository

import de.berenberg.schulung.domain.Lecture
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface LectureRepository : JpaRepository<Lecture, Long>
