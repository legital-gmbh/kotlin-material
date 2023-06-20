package org.legital.kotlin.rockpaperscissors

import org.legital.kotlin.rockpaperscissors.strategy.ChoosingStrategy

class Player(
    private val choosingStrategy: ChoosingStrategy
) {

    var wins = 0
        private set

    fun choose() = choosingStrategy.choose()

    fun incrementWins() = wins++
}
