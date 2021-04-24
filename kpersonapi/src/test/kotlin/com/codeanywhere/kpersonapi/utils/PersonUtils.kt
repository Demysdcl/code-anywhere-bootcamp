package one.digitalinnovation.personapi.utils


import com.codeanywhere.kpersonapi.person.Person
import com.codeanywhere.kpersonapi.person.PersonDTO
import com.codeanywhere.kpersonapi.utils.PhoneUtils
import java.time.LocalDate

object PersonUtils {
    private const val FIRST_NAME = "Rodrigo"
    private const val LAST_NAME = "Peleias"
    private const val CPF_NUMBER = "369.333.878-79"
    private const val PERSON_ID = 1L
    private val  BIRTH_DATE = LocalDate.of(2010, 10, 1)

    fun createFakeDTO(): PersonDTO = PersonDTO(
            firstName = FIRST_NAME,
            lastName = LAST_NAME,
            cpf = CPF_NUMBER,
            birthDate =  "04-04-2010",
            phones = listOf(PhoneUtils.createFakeDTO())
    )

    fun createFakeEntity(): Person =
        Person(
            id = PERSON_ID,
            firstName = FIRST_NAME,
            lastName = LAST_NAME,
            cpf = CPF_NUMBER,
            birthDate =  BIRTH_DATE,
            phones = listOf(PhoneUtils.createFakeEntity())
        )
}