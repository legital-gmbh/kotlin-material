package de.berenberg.schulung.to

import java.time.LocalDate
import de.berenberg.schulung.domain.Building

class BuildingTO {
    var id: Long? = null
    var code: Char? = null
    var description: String? = null
    var constructionDate: LocalDate? = null

    companion object {
        fun from(building: Building): BuildingTO {
            return BuildingTO().also{
                it.id = building.id
                it.code = building.code
                it.description = building.description
                it.constructionDate = building.constructionDate
            }
        }
    }
}
