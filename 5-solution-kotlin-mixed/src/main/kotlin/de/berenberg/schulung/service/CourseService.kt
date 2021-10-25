package de.berenberg.schulung.service.de.berenberg.schulung.service

import de.berenberg.schulung.repository.CourseRepository
import de.berenberg.schulung.domain.Course
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class CourseService(private val courseRepository: CourseRepository) {
    fun saveCourse(): Course {
        val course = Course()
        course.fieldOfStudy = "I"
        course.number = 10
        course.lecturer = "Lennart Gamradt"
        course.title = "Spring Kurs"
        return courseRepository.save(course)
    }
}
