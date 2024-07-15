package com.hoppers.towntalk.controllers

import com.hoppers.towntalk.beans.Role
import com.hoppers.towntalk.beans.User
import com.hoppers.towntalk.services.UserService
import com.hoppers.towntalk.user.UserRequest
import com.hoppers.towntalk.user.UserResponse
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/user")
class UserController(
    private val userService: UserService
) {

    @PostMapping
    fun create(@RequestBody userRequest: UserRequest): UserResponse {
        val createdUser = userService.createUser(userRequest.toModel())

        return createdUser.toResponse()
    }

    @GetMapping
    fun listAll(): List<UserResponse> =
        userService.findAll()
            .map { it.toResponse() }

    @GetMapping("/{uuid}")
    fun findByUUID(@PathVariable uuid: UUID): UserResponse {
      val u =   userService.findByUUID(uuid)
            ?: throw RuntimeException( "User not found.")
        return u.toResponse()
    }

    @DeleteMapping("/{uuid}")
    fun deleteByUUID(@PathVariable uuid: UUID) {
         userService.deleteByUUID(uuid)


    }

    private fun User.toResponse(): UserResponse =
        UserResponse(
            uuid = this.id,
            email = this.email,
        )

    private fun UserRequest.toModel(): User =
        User(
            id = UUID.randomUUID(),
            email = this.email,
            password = this.password,
            role = Role.USER,
        )
}