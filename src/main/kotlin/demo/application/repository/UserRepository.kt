package org.example.demo.application.repository

import demo.application.dto.Profile
import org.example.demo.application.dto.User
import org.springframework.stereotype.Repository

@Repository
class UserRepository(
    val users: MutableList<User>
) {
    fun getUsersProfile() : List<Profile> {
        return users.map { user ->
            Profile(
                age = user.age ?: 0,
                lastname = user.lastname ?: "",
                firstname = user.firstname ?: "",
                photoUrl = user.photo ?: ""
            )
        }
    }
}