package com.hoppers.towntalk.services

import com.hoppers.towntalk.beans.User
import com.hoppers.towntalk.repos.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class UserService {

    @Autowired
    lateinit var userRepository: UserRepository

    fun createUser(user: User) = userRepository.save(user)


    fun findByUUID(uuid: UUID): User? =
        userRepository.findById(uuid).get()

    fun findAll(): List<User> =
        userRepository.findAll()
            .toList()

    fun deleteByUUID(uuid: UUID) =
        userRepository.deleteById(uuid)
}