package com.hoppers.towntalk.services

import com.hoppers.towntalk.repos.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(private val repository: UserRepository) {
    fun findAllUser() = repository.getAllUser()

}