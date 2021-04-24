package com.codeanywhere.kpersonapi.person

import com.codeanywhere.kpersonapi.response.MessageResponseDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/api/v1/people")
class PersonController @Autowired constructor (
    val personService: PersonService
) {

    @PostMapping
    fun createPerson(@RequestBody @Valid personDTO: PersonDTO): MessageResponseDTO = personService
        .createPerson(personDTO)

    @GetMapping
    fun getPeople() = personService.listAll()

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long) = personService.findById(id)

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteById(@PathVariable id: Long) = personService.delete(id)

    @PutMapping("/{id}")
    fun updateById(
        @PathVariable id: Long, @RequestBody @Valid personDTO: PersonDTO
    ): MessageResponseDTO = personService.updateById(id, personDTO)
}