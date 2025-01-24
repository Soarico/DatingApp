package org.example.demo.application.dto

data class User(
    val token : String? = null,
    val login : String,
    val password : String,
    val id : Long? = null,
    var age : Int? = null,
    var gender : Boolean? = null,
    var firstname : String? = null,
    var lastname : String? = null,
    var photo : String? = null
)
