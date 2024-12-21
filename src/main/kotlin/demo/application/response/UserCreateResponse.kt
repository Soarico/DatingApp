package org.example.demo.application.dto

data class UserCreateResponse (
    val token : String,
    val login : String,
    val id : Long?
)