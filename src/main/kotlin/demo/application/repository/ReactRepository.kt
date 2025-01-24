package demo.application.repository

import demo.application.dto.Reaction

class ReactRepository (
    val reactions: MutableList<Reaction>
) {
    fun react(reaction: Boolean, userTo: Int, userFrom: Int) {
        val Reaction = reactions.find { it.userFrom == userFrom && it.userTo == userTo }

        if (Reaction != null) {
            Reaction.reaction = reaction
        } else {
            reactions.add(Reaction(reactions.size, userFrom, userTo, reaction))
        }
    }
}