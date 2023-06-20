package de.berenberg.schulung.service

import java.time.LocalDate
import de.berenberg.schulung.domain.Building
import de.berenberg.schulung.to.BuildingTO
import de.berenberg.schulung.repository.BuildingRepository
import de.berenberg.schulung.exception.ResourceNotFoundException
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
@Transactional
class BuildingService(private val buildingRepository: BuildingRepository) {
    fun saveBuilding(): Building {
        val building = Building()
        building.code = 'A'
        building.description = "Building A description"
        building.constructionDate = LocalDate.of(1930, 8, 30)
        return buildingRepository.save(building)
    }

    fun saveBuilding(buildingTO: BuildingTO): Building {
        val building = Building()
        building.code = buildingTO.code
        building.description = buildingTO.description
        building.constructionDate = buildingTO.constructionDate
        return buildingRepository.save(building)
    }

    fun updateBuilding(id: Long, buildingTO: BuildingTO): Building {
        val building = buildingRepository.findById(id).orElseThrow { ResourceNotFoundException() }!!
        building.code = buildingTO.code
        building.description = buildingTO.description
        building.constructionDate = buildingTO.constructionDate
        return buildingRepository.save(building)
    }

    fun findAll(): List<Building> {
        return buildingRepository.findAll()
    }

    fun findById(id: Long): Optional<Building> {
        return buildingRepository.findById(id)
    }

    fun deleteById(id: Long) {
        val building = buildingRepository.findById(id).orElseThrow { ResourceNotFoundException() }!!
        buildingRepository.delete(building)
    }
}
