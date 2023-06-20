package de.berenberg.schulung.repository;

import de.berenberg.schulung.domain.Building;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<Building, Long> {
}
