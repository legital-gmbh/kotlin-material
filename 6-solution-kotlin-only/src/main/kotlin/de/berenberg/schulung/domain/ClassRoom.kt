package de.berenberg.schulung.domain

import javax.persistence.Entity

@Entity
class ClassRoom : Room() {
    var smartboardPresent: Boolean? = null
}
