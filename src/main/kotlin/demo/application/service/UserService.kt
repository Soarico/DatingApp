package demo.application.service

import demo.application.repository.ReactRepository
import org.example.demo.application.dto.*
import org.example.demo.application.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class UserService(
    val userRepository : UserRepository,
    val reactRepository : ReactRepository
) {
    fun addUser(user: User): UserCreateResponse {
        return userRepository.addUser(user)
    }

    fun addForm(info: UserBaseInfo): UserFormResponse {
        return userRepository.addForm(info)
    }

    fun getUsers() = userRepository.getUsersProfile()

    fun makeReaction(userTo: Int, userFrom: Int, reaction : Boolean) {
        reactRepository.react(reaction, userTo, userFrom)
    }
}