package de.berenberg.schulung.service

import de.berenberg.schulung.domain.Room
import de.berenberg.schulung.domain.Course
import com.google.gson.Gson
import java.time.LocalDateTime
import de.berenberg.schulung.repository.LectureRepository
import de.berenberg.schulung.domain.Lecture
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class LectureService(
    private val lectureRepository: LectureRepository
) {

    private val log = LoggerFactory.getLogger(LectureService::class.java)

    @Value("Hallo Welt")
    lateinit var contactEmailAddress: String

    fun saveLectures(room: Room?, course: Course?) {
        val lectureToday = Lecture()
        lectureToday.room = room
        lectureToday.course = course
        lectureToday.begin = LocalDateTime.now().withHour(9).withMinute(30).withSecond(0)
        lectureToday.end = LocalDateTime.now().withHour(11).withMinute(30).withSecond(0)
        val lectureNextWeek = Lecture()
        lectureNextWeek.room = room
        lectureNextWeek.course = course
        lectureNextWeek.begin = LocalDateTime.now().plusDays(7).withHour(9).withMinute(30).withSecond(0)
        lectureNextWeek.end = LocalDateTime.now().plusDays(7).withHour(11).withMinute(30).withSecond(0)
        lectureRepository.save(lectureToday)
        lectureRepository.save(lectureNextWeek)
        val gson = Gson()
        log.info("LECTURE TODAY ---------------------")
        log.info(gson.toJson(lectureToday))
        log.info("LECTURE NEXT WEEK ---------------------")
        log.info(gson.toJson(lectureNextWeek))
    }
}
