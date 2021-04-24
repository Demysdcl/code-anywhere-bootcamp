package com.codeanywhere.kpersonapi.person

import com.codeanywhere.kpersonapi.person.phone.PhoneDTO
import org.hibernate.validator.constraints.br.CPF
import javax.validation.Valid
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.Size


data class PersonDTO(

    val id: Long? = null,

    @NotEmpty
    @Size(min=2, max=100)
    val firstName: String = "",

    @NotEmpty
    @Size(min=2, max=100)
    val lastName: String = "",

    @NotEmpty
    @CPF
    val cpf: String = "",

    val birthDate: String = "",

    @NotEmpty
    @Valid
    val phones: List<PhoneDTO> = listOf()
)