package de.berenberg.schulung.repository

import de.berenberg.schulung.domain.Building
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface BuildingRepository : JpaRepository<Building, Long>
