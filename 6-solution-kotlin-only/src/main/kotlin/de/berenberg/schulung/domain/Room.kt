package de.berenberg.schulung.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Inheritance
import javax.persistence.InheritanceType
import javax.persistence.ManyToOne

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
open class Room(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,

    @ManyToOne
    var building: Building? = null,
    var roomNumber: Int? = null,
    var seats: Int? = null,
    var isProjectorPresent: Boolean = false,
)
