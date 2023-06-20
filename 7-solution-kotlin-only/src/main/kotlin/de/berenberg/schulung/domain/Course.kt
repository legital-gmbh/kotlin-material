package de.berenberg.schulung.domain

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Course (
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,
    var fieldOfStudy: String? = null,
    var number: Int = 0,
    var lecturer: String? = null,
    var title: String? = null
)
