package demo.application.controller

import demo.application.dto.Profile
import demo.application.service.UserService
import org.example.demo.application.dto.*
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
    fun get(@RequestBody info : UserBaseInfo): UserFormResponse {
        return service.addForm(info)
    }

    @GetMapping("/GET")
    fun getUsers() : List<Profile> {
        return service.getUsers()
    }

    @PostMapping("/users/{id}/reaction")
    fun makeReact(@RequestBody userTo : Int, @RequestBody userFrom : Int, @RequestBody reaction : Boolean) {
        return service.makeReaction(userTo, userFrom, reaction)
    }
}