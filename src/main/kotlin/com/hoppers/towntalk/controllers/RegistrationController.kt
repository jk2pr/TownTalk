package com.hoppers.towntalk.controllers

import com.hoppers.towntalk.beans.Role
import com.hoppers.towntalk.beans.User
import com.hoppers.towntalk.services.UserService
import com.hoppers.towntalk.user.UserRequest
import com.hoppers.towntalk.user.UserResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/api/user")
class UserController(
    private val userService: UserService
) {

    @PostMapping
    fun create(@RequestBody userRequest: UserRequest):ResponseEntity<Map<String, String>> {
        return runCatching {
            userService.createUser(userRequest.toModel())
            ResponseEntity.status(HttpStatus.CREATED).body(mapOf("message" to "Created successfully"))
        }.getOrElse {
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(mapOf("message" to "Error creating User"))
        }
    }

    @GetMapping
    fun listAll(): List<UserResponse> =
        userService.findAll()
            .map { it.toResponse() }

    @GetMapping("/{uuid}")
    fun findByUUID(@PathVariable uuid: UUID): UserResponse {
        val u = userService.findByUUID(uuid)
            ?: throw RuntimeException("User not found.")
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