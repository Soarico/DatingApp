package org.example.demo.application.dto

data class About (
    val token : String,
    val id : Long?,
    val firstname : String,
    val lastname : String,
    val age : Int,
    val gender : Boolean
)