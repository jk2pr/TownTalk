package com.hoppers.towntalk.controllers

import com.hoppers.towntalk.beans.User
import com.hoppers.towntalk.services.UserService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/user")
class RegistrationController @Autowired constructor(
    private val service: UserService
) {


    @GetMapping
    fun getAllUser():List<User> {
        val result = service.findAllUser()
        println("GET ALL USER$result")
        return result
    }
}
