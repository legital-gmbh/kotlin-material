package de.berenberg.schulung.action;

import com.google.gson.Gson;
import de.berenberg.schulung.domain.Building;
import de.berenberg.schulung.domain.Course;
import de.berenberg.schulung.domain.Room;
import de.berenberg.schulung.service.BuildingService;
import de.berenberg.schulung.service.de.berenberg.schulung.service.CourseService;
import de.berenberg.schulung.service.LectureService;
import de.berenberg.schulung.service.RoomService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class CreateLectureAction {

    private final Logger log = LoggerFactory.getLogger(CreateLectureAction.class);

    private final LectureService lectureService;

    private final BuildingService buildingService;

    private final RoomService roomService;

    private final CourseService courseService;

    public CreateLectureAction(LectureService lectureService, BuildingService buildingService, RoomService roomService, CourseService courseService) {
        this.lectureService = lectureService;
        this.buildingService = buildingService;
        this.roomService = roomService;
        this.courseService = courseService;
    }

    public void execute() {
        Building building = buildingService.saveBuilding();

        Room room = roomService.saveRoom(building);

        Course course = courseService.saveCourse();

        Gson gson = new Gson();
        log.info("ROOM ---------------------");
        log.info(gson.toJson(room));

        log.info("COURSE ---------------------");
        log.info(gson.toJson(course));

        lectureService.saveLectures(room, course);

        roomService.searchRoom(building);
    }

}
