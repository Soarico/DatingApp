package org.example.demo.application.repository

import demo.application.dto.Profile
import org.example.demo.application.dto.User
import org.example.demo.application.dto.UserBaseInfo
import org.example.demo.application.dto.UserCreateResponse
import org.example.demo.application.dto.UserFormResponse
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

    fun addUser(user: User): UserCreateResponse {
        users.add(user)
        return UserCreateResponse(generateRandomString(10), user.login, user.id)
    }

    fun addForm(info: UserBaseInfo): UserFormResponse {
        var id: Long? = -1
        users.forEach { user ->
            if (user.token == info.token) {
                user.age = info.age
                user.gender = info.gender
                user.lastname = info.lastname
                user.firstname = info.firstname
                id = info.id
            }
        }
        return UserFormResponse(id)
    }

    private fun generateRandomString(len: Int = 15): String {
        val alphanumerics = CharArray(26) { it -> (it + 97).toChar() }.toSet()
            .union(CharArray(9) { it -> (it + 48).toChar() }.toSet())
        return (0..len - 1).map {
            alphanumerics.toList().random()
        }.joinToString("")
    }
}