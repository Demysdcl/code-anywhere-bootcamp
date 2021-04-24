package com.codeanywhere.kpersonapi.person

import one.digitalinnovation.personapi.utils.PersonUtils.createFakeDTO
import one.digitalinnovation.personapi.utils.PersonUtils.createFakeEntity
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest


@SpringBootTest
class PersonMapperTest {

    @Autowired
    private val personMapper: PersonMapper? = null

    @Test
    fun testGivenPersonDTOThenReturnPersonEntity() {
        val personDTO = createFakeDTO()
        val (_, firstName, lastName, cpf, _, phones) = personMapper!!.toModel(personDTO)
        Assertions.assertEquals(personDTO.firstName, firstName)
        Assertions.assertEquals(personDTO.lastName, lastName)
        Assertions.assertEquals(personDTO.cpf, cpf)
        val (_, type, number) = phones[0]
        val (_, type1, number1) = personDTO.phones[0]
        Assertions.assertEquals(type1, type)
        Assertions.assertEquals(number1, number)
    }

    @Test
    fun testGivenPersonEntityThenReturnPersonDTO() {
        val person = createFakeEntity()
        val (_, firstName, lastName, cpf, _, phones) = personMapper!!.toDTO(person)
        Assertions.assertEquals(person.firstName, firstName)
        Assertions.assertEquals(person.lastName, lastName)
        Assertions.assertEquals(person.cpf, cpf)
        val (_, type, number) = person.phones[0]
        val (_, type1, number1) = phones[0]
        Assertions.assertEquals(type, type1)
        Assertions.assertEquals(number, number1)
    }
}