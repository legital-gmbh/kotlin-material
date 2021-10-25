package de.berenberg.schulung.domain

import java.time.LocalDate
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "BUILDING") // not required, default table name is equal to class name
class Building(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long? = null,

    @Column(nullable = false)
    var code: Char? = null,
    var description: String? = null,
    var constructionDate: LocalDate? = null,
)
