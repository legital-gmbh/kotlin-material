package de.berenberg.schulung.controller

import de.berenberg.schulung.exception.ResourceNotFoundException
import de.berenberg.schulung.service.BuildingService
import de.berenberg.schulung.to.BuildingTO
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("api/buildings")
class BuildingController(private val buildingService: BuildingService) {
    @get:GetMapping
    val all: List<BuildingTO>
        get() = buildingService.findAll()
            .map(BuildingTO::from)


    @GetMapping("{id}")
    fun getOne(@PathVariable id: Long): BuildingTO {
        return BuildingTO.from(buildingService.findById(id).orElseThrow { ResourceNotFoundException() })
    }

    @PostMapping
    fun save(@RequestBody buildingTO: BuildingTO, ucb: UriComponentsBuilder): ResponseEntity<Void> {
        val building = buildingService.saveBuilding(buildingTO)
        return ResponseEntity.created(ucb.path("api/buildings/{id}").buildAndExpand(building.id).toUri()).build()
    }

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody buildingTO: BuildingTO): BuildingTO {
        return BuildingTO.from(buildingService.updateBuilding(id, buildingTO))
    }

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        buildingService.deleteById(id)
        return ResponseEntity.ok().build()
    }
}
