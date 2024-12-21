package org.example.demo.application.repository

import org.example.demo.application.dto.User
import org.springframework.stereotype.Repository

@Repository
class UserRepository {
    val users = mutableListOf<User>()
}