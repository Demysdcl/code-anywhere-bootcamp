package com.digitalinnovation.azurespringauth.contexts.user

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserDetailsServiceImpl @Autowired constructor(var bCryptPasswordEncoder: BCryptPasswordEncoder) :
    UserDetailsService {

    override fun loadUserByUsername(username: String?): UserDetails =
        findUser(username)
            .map { User(it.userName, it.password, listOf())  }
            .orElseThrow{ UsernameNotFoundException("Username not found") }

    private fun findUser(username: String?): Optional<UserData> =
       Optional.of( UserData(username!!, bCryptPasswordEncoder.encode("nimda")))


}