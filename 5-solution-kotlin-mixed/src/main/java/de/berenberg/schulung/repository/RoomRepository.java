package de.berenberg.schulung.repository;

import de.berenberg.schulung.domain.Building;
import de.berenberg.schulung.domain.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    List<Room> findByBuilding(Building building);

}
