package com.hoppers.towntalk.repos


import com.hoppers.towntalk.beans.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface UserRepository : JpaRepository<User, UUID>


/*@Repository
class UserRepository  {

    private val users = mutableSetOf(
        User(
            id = UUID.randomUUID(),
            email = "email-1@gmail.com",
            password = "pass1",
            role = Role.USER,
        ),
        User(
            id = UUID.randomUUID(),
            email = "email-2@gmail.com",
            password = "pass2",
            role = Role.ADMIN,
        ),
        User(
            id = UUID.randomUUID(),
            email = "email-3@gmail.com",
            password = "pass3",
            role = Role.USER,
        ),
    )

    fun save(user: User): Boolean {
        val updated = user.copy(password = user.password)

        return users.add(updated)
    }

    fun findByEmail(email: String): User? =
        users
            .firstOrNull { it.email == email }

    fun findAll(): Set<User> =
        users

    fun findByUUID(uuid: UUID): User? =
        users
            .firstOrNull { it.id == uuid }

    fun deleteByUUID(uuid: UUID): Boolean {
        val foundUser = findByUUID(uuid)

        return foundUser?.let {
            users.removeIf {
                it.id == uuid
            }
        } ?: false
    }
}

 */