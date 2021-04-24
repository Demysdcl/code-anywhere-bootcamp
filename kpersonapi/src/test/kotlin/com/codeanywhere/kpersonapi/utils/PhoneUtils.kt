package com.codeanywhere.kpersonapi.utils


import com.codeanywhere.kpersonapi.person.phone.Phone
import com.codeanywhere.kpersonapi.person.phone.PhoneDTO
import com.codeanywhere.kpersonapi.person.phone.PhoneType


object PhoneUtils {
    private const val PHONE_NUMBER = "1199999-9999"
    private val PHONE_TYPE = PhoneType.MOBILE
    private const val PHONE_ID = 1L

    fun createFakeDTO(): PhoneDTO =
        PhoneDTO(number = PHONE_NUMBER, type = PHONE_TYPE)

    fun createFakeEntity(): Phone =
        Phone(id = PHONE_ID, number = PHONE_NUMBER, type = PHONE_TYPE)
}