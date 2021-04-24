package com.codeanywhere.kpersonapi.person.phone

import javax.persistence.*

@Entity
data class Phone(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    val type: PhoneType? = PhoneType.MOBILE,

    @Column(nullable = false)
    val number: String = ""
)