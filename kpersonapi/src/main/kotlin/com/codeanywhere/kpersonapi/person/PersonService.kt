package com.codeanywhere.kpersonapi.person

import com.codeanywhere.kpersonapi.response.MessageResponseDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PersonService @Autowired constructor(
    private val personRepository: PersonRepository
){
    private val personMapper = PersonMapper.INSTANCE

    fun listAll(): List<PersonDTO> = personRepository
        .findAll()
        .map(personMapper::toDTO)

    fun createPerson(personDTO: PersonDTO): MessageResponseDTO = personRepository
        .save(personMapper.toModel(personDTO))
        .let { MessageResponseDTO("Created person with ID: ${it.id}") }

    private fun verifyIfExists(id: Long): Person = personRepository
        .findById(id)
        .orElseThrow { PersonNotFoundException(id)  }

    fun findById(id: Long): PersonDTO = verifyIfExists(id)
        .let(personMapper::toDTO)

    fun delete(id: Long) = verifyIfExists(id)
        .also (personRepository::delete)

    fun updateById(id: Long, personDTO: PersonDTO): MessageResponseDTO = verifyIfExists(id)
        .let (personRepository::save)
        .let { MessageResponseDTO("Person with id $id was updated") }
}