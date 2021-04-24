package com.codeanywhere.kpersonapi.person

import com.codeanywhere.kpersonapi.response.MessageResponseDTO
import one.digitalinnovation.personapi.utils.PersonUtils
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentMatchers
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension


@ExtendWith(MockitoExtension::class)
class PersonServiceTest {
    @Mock
    private val personRepository: PersonRepository? = null

    @Mock
    private val personMapper: PersonMapper? = null

    @InjectMocks
    private val personService: PersonService? = null

    @Test
    fun testGivenPersonDTOThenReturnSuccessSavedMessage() {
        val personDTO: PersonDTO = PersonUtils.createFakeDTO()
        val expectedSavedPerson: Person = PersonUtils.createFakeEntity()
        Mockito.`when`(personMapper!!.toModel(personDTO)).thenReturn(expectedSavedPerson)
        Mockito.`when`(personRepository!!.save(ArgumentMatchers.any(Person::class.java)))
            .thenReturn(expectedSavedPerson)
        val expectedSuccessMessage = createExpectedSuccessMessage(expectedSavedPerson.id)
        val successMessage: MessageResponseDTO = personService.createPerson(personDTO)
        Assertions.assertEquals(expectedSuccessMessage, successMessage)
    }

    private fun createExpectedSuccessMessage(savedPersonId: Long?): MessageResponseDTO =
        MessageResponseDTO("Person successfully created with ID $savedPersonId")


}
