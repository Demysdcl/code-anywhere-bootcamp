package com.codeanywhere.kpersonapi.person

import com.codeanywhere.kpersonapi.person.phone.Phone
import java.time.LocalDate
import javax.persistence.*

@Entity
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val firstName: String = "",

    @Column(nullable = false)
    val lastName: String = "",

    @Column(nullable = false, unique = true)
    val cpf: String = "",

    @Column(nullable = false)
    val birthDate: LocalDate = LocalDate.now(),

    @OneToMany(
        fetch = FetchType.LAZY,
        cascade = [
            CascadeType.PERSIST,
            CascadeType.MERGE,
            CascadeType.REMOVE
        ]
    )
    val phones: List<Phone> = listOf()
)