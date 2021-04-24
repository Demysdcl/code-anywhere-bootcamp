package com.codeanywhere.kpersonapi.person.phone

import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size

data class PhoneDTO(
    val id: Long? = null,

    @Enumerated(EnumType.STRING)
    val type: PhoneType = PhoneType.MOBILE,

    @NotEmpty
    @Size(min = 13, max = 14)
    val number: String = ""

)
