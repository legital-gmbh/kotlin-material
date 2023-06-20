package de.berenberg.schulung.action

import de.berenberg.schulung.service.LectureService
import de.berenberg.schulung.service.BuildingService
import de.berenberg.schulung.service.RoomService
import de.berenberg.schulung.service.de.berenberg.schulung.service.CourseService
import com.google.gson.Gson
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class CreateLectureAction(
    private val lectureService: LectureService,
    private val buildingService: BuildingService,
    private val roomService: RoomService,
    private val courseService: CourseService
) {
    private val log = LoggerFactory.getLogger(CreateLectureAction::class.java)
    fun execute() {
        val building = buildingService.saveBuilding()
        val room = roomService.saveRoom(building)
        val course = courseService.saveCourse()
        val gson = Gson()
        log.info("ROOM ---------------------")
        log.info(gson.toJson(room))
        log.info("COURSE ---------------------")
        log.info(gson.toJson(course))
        lectureService.saveLectures(room, course)
        roomService.searchRoom(building)
    }
}
