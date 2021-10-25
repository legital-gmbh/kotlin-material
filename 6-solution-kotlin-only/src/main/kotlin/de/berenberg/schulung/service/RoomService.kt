package de.berenberg.schulung.service

import de.berenberg.schulung.domain.Building
import de.berenberg.schulung.domain.Room
import com.google.gson.Gson
import de.berenberg.schulung.repository.RoomRepository
import de.berenberg.schulung.domain.ClassRoom
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
@Transactional
class RoomService(private val roomRepository: RoomRepository) {
    private val log = LoggerFactory.getLogger(RoomService::class.java)
    fun saveRoom(building: Building?): Room {
        val room = ClassRoom()
        room.building = building
        room.roomNumber = 101
        room.seats = 20
        room.isProjectorPresent = true
        room.smartboardPresent = true
        return roomRepository.save(room)
    }

    fun searchRoom(building: Building) {
        val rooms = roomRepository.findByBuilding(building)
        val gson = Gson()
        for (room in rooms!!) {
            log.info("ROOM ---------------------")
            log.info(gson.toJson(room))
        }
    }
}
