package org.example.demo.application.dto

import demo.application.dto.Gender

data class UserBaseInfo (
    val token : String,
    val id : Long?,
    val firstname : String,
    val lastname : String,
    val age : Int,
    val gender : Gender,
    val photo : String
)