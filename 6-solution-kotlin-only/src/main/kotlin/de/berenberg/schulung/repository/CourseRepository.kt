package de.berenberg.schulung.repository

import de.berenberg.schulung.domain.Course
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface CourseRepository : JpaRepository<Course, Long>
