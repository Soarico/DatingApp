package demo.application.client

import org.example.demo.application.dto.About
import org.example.demo.application.dto.User
import org.example.demo.application.dto.UserCreateResponse
import org.example.demo.application.dto.UserFormResponse
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@FeignClient(name = "appClient", url = "http://localhost:8080/")
interface AppClient {

    @PostMapping(value = ["/users"])
    fun makeUser(@RequestBody user: User): ResponseEntity<UserCreateResponse>

    @PutMapping(value = ["/users"])
    fun fillForm(@RequestBody about: About, @RequestHeader("Authorization") token: String): ResponseEntity<UserFormResponse>
}