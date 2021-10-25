package de.berenberg.schulung.service;

import com.google.gson.Gson;
import de.berenberg.schulung.domain.Building;
import de.berenberg.schulung.domain.ClassRoom;
import de.berenberg.schulung.domain.Room;
import de.berenberg.schulung.repository.RoomRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoomService {

    private final Logger log = LoggerFactory.getLogger(RoomService.class);

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room saveRoom(Building building) {
        ClassRoom room = new ClassRoom();
        room.setBuilding(building);
        room.setRoomNumber(101);
        room.setSeats(20);
        room.setProjectorPresent(true);
        room.setSmartboardPresent(true);

        return roomRepository.save(room);
    }

    public void searchRoom(Building building) {
        List<Room> rooms = roomRepository.findByBuilding(building);

        Gson gson = new Gson();
        for (Room room : rooms) {
            log.info("ROOM ---------------------");
            log.info(gson.toJson(room));
        }
    }
}
