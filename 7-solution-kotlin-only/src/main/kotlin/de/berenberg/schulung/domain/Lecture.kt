package de.berenberg.schulung.domain

import java.time.LocalDateTime
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity
class Lecture(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,
    var begin: LocalDateTime? = null,
    var end: LocalDateTime? = null,

    @ManyToOne
    var course: Course? = null,

    @ManyToOne
    var room: Room? = null
)
