package org.legital.kotlin.rockpaperscissors

class Player(
    private val choosingStrategy: () -> GameElement
) {

    var wins = 0
        private set

    fun choose() = choosingStrategy()

    fun incrementWins() = wins++
}
