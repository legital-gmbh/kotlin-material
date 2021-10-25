package org.legital.kotlin.rockpaperscissors

import kotlin.random.Random

class RandomChoosingStrategy : ChoosingStrategy {
    override fun choose(): GameElement =
        when (Random.nextInt(3)) {
            0 -> GameElement.ROCK
            1 -> GameElement.PAPER
            2 -> GameElement.SCISSORS
            else -> throw IllegalStateException()
        }
}
