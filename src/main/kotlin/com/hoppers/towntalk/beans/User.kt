package com.hoppers.towntalk.beans

import jakarta.annotation.Generated
import jakarta.persistence.Entity
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.UniqueConstraint
import java.util.*


@Entity
@Table(
    name = "app_user",
    uniqueConstraints = [UniqueConstraint(columnNames = arrayOf("email"))]
)
data class User(
    @Id
    @Generated
    val id: UUID,
    val email: String,
    val password: String,
    val role: Role
)

enum class Role {
    USER, ADMIN
}