package de.berenberg.schulung.service;

import de.berenberg.schulung.domain.Building;
import de.berenberg.schulung.exception.ResourceNotFoundException;
import de.berenberg.schulung.repository.BuildingRepository;
import de.berenberg.schulung.to.BuildingTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class BuildingService {

    private final BuildingRepository buildingRepository;

    public BuildingService(BuildingRepository buildingRepository) {
        this.buildingRepository = buildingRepository;
    }

    public Building saveBuilding() {
        Building building = new Building();
        building.setCode('A');
        building.setDescription("Building A description");
        building.setConstructionDate(LocalDate.of(1930, 8,30));

        return buildingRepository.save(building);
    }

    public Building saveBuilding(BuildingTO buildingTO) {
        Building building = new Building();
        building.setCode(buildingTO.getCode());
        building.setDescription(buildingTO.getDescription());
        building.setConstructionDate(buildingTO.getConstructionDate());
        return buildingRepository.save(building);
    }

    public Building updateBuilding(Long id, BuildingTO buildingTO) {
        Building building = buildingRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        building.setCode(buildingTO.getCode());
        building.setDescription(buildingTO.getDescription());
        building.setConstructionDate(buildingTO.getConstructionDate());
        return buildingRepository.save(building);
    }

    public List<Building> findAll() {
        return buildingRepository.findAll();
    }

    public Optional<Building> findById(Long id) {
        return buildingRepository.findById(id);
    }

    public void deleteById(Long id) {
        Building building = buildingRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
        buildingRepository.delete(building);
    }
}
