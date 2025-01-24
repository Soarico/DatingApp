package demo.application.controller

import demo.application.dto.Profile
import demo.application.service.UserService
import org.example.demo.application.dto.About
import org.example.demo.application.dto.User
import org.example.demo.application.dto.UserCreateResponse
import org.example.demo.application.dto.UserFormResponse
import org.example.demo.application.repository.UserRepository
import org.springframework.web.bind.annotation.*

@RestController
class UserController(
    val service: UserService
) {
    @GetMapping("/POST")
    fun post(@RequestBody user : User): UserCreateResponse {
        return service.addUser(user)
    }
    @GetMapping("/GET")
    fun get(@RequestBody about : About): UserFormResponse {
        return service.addForm(about)
    }

    @GetMapping("/GET")
    fun getUsers() : List<Profile> {
        return service.getUsers()
    }

    @GetMapping("/POST")
    fun makeReact(@RequestParam userTo : Int, @RequestParam userFrom : Int, @RequestParam reaction : Boolean) {
        return service.makeReaction(userTo, userFrom, reaction)
    }
}