package de.berenberg.schulung.repository

import de.berenberg.schulung.domain.Building
import de.berenberg.schulung.domain.Room
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface RoomRepository : JpaRepository<Room, Long> {
    fun findByBuilding(building: Building): List<Room>
}
