package demo.application.controller

import demo.application.service.UserService
import org.example.demo.application.dto.About
import org.example.demo.application.dto.User
import org.example.demo.application.dto.UserCreateResponse
import org.example.demo.application.dto.UserFormResponse
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
}