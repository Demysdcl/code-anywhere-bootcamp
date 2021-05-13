package com.digitalinnovation.azurespringauth.contexts.status

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StatusController {

    @GetMapping("/status")
    fun viewStatus() = "online"
}