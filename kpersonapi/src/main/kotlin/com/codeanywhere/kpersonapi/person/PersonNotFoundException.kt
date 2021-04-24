package com.codeanywhere.kpersonapi.person

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ResponseStatus

@ResponseStatus(HttpStatus.NOT_FOUND)
class PersonNotFoundException(private val id: Long) : Exception("Person not found with ID: $id")
