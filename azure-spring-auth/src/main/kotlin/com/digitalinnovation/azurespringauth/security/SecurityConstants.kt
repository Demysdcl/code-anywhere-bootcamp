package com.digitalinnovation.azurespringauth.security

object SecurityConstants {
   const val SECRET = "SecreteKeyToGenJWTs"
   const val EXPIRATION_TIME = 864_300_00
   const val TOKEN_PREFIX = "Bearer "
   const val HEADER_STRING = "Authorization"
   const val SIGN_UP_TIME = "/login"
   const val STATUS_URL = "/status"
}