package demo.application.service

import org.example.demo.application.dto.About
import org.example.demo.application.dto.User
import org.example.demo.application.dto.UserCreateResponse
import org.example.demo.application.dto.UserFormResponse
import org.example.demo.application.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    val userRepository : UserRepository
) {
    fun addUser(user: User) : UserCreateResponse {
        userRepository.users.add(user)
        return UserCreateResponse(generateRandomString(10), user.login, user.id)
    }
    fun addForm(about : About) : UserFormResponse {
        var id : Long? = -1
        userRepository.users.forEach { user ->
            if (user.token == about.token) {
                user.age = about.age
                user.gender = about.gender
                user.lastname = about.lastname
                user.firstname = about.firstname
                id = about.id
            }
        }
        return UserFormResponse(id)
    }
    private fun generateRandomString(len: Int = 15): String{
        val alphanumerics = CharArray(26) { it -> (it + 97).toChar() }.toSet()
            .union(CharArray(9) { it -> (it + 48).toChar() }.toSet())
        return (0..len-1).map {
            alphanumerics.toList().random()
        }.joinToString("")
    }
}