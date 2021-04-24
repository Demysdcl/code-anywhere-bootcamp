package com.codeanywhere.kpersonapi.person

import org.mapstruct.Mapper
import org.mapstruct.Mapping
import org.mapstruct.factory.Mappers

@Mapper
interface PersonMapper {
    companion object {
        val INSTANCE: PersonMapper = Mappers.getMapper(PersonMapper::class.java)
    }

    @Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
    fun toModel(personDTO: PersonDTO): Person

    fun toDTO(person: Person): PersonDTO
}