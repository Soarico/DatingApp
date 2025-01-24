package demo.application.dto

data class Reaction(
    val id: Int,
    val userFrom: Int,
    val userTo: Int,
    var reaction: Boolean
)