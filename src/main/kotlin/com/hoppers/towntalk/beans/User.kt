package com.hoppers.towntalk.beans

data class User(
    val uid: String,
    val email: String,
    val name: String,
    val bio: String,
    val profileImageUrl: String? = null
)