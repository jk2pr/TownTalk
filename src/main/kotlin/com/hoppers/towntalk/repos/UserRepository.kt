package com.hoppers.towntalk.repos

import com.hoppers.towntalk.beans.User
import org.springframework.stereotype.Repository

@Repository
class UserRepository {

    fun getAllUser(): List<User> = listOf(
        User("uid1", "user1@example.com", "User One", "Bio for User One", "http://example.com/profile1.jpg"),
        User("uid2", "user2@example.com", "User Two", "Bio for User Two", "http://example.com/profile2.jpg"),
        User("uid3", "user3@example.com", "User Three", "Bio for User Three", "http://example.com/profile3.jpg"),
        User("uid4", "user4@example.com", "User Four", "Bio for User Four"),
        User("uid5", "user5@example.com", "User Five", "Bio for User Five", "http://example.com/profile5.jpg"),
        User("uid6", "user6@example.com", "User Six", "Bio for User Six"),
        User("uid7", "user7@example.com", "User Seven", "Bio for User Seven", "http://example.com/profile7.jpg"),
        User("uid8", "user8@example.com", "User Eight", "Bio for User Eight"),
        User("uid9", "user9@example.com", "User Nine", "Bio for User Nine", "http://example.com/profile9.jpg"),
        User("uid10", "user10@example.com", "User Ten", "Bio for User Ten", "http://example.com/profile10.jpg")
    )

}