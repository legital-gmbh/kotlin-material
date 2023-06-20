package de.berenberg.schulung.domain

import javax.persistence.Entity

@Entity
class ConferenceRoom : Room() {
    var phoneNumber: String? = null
}
