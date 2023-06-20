package org.legital.kotlin.rockpaperscissors.strategy

import org.legital.kotlin.rockpaperscissors.GameElement
import kotlin.random.Random

class RandomChoosingStrategy : ChoosingStrategy {
    override fun choose(): GameElement =
        when (Random.nextInt(GameElement.values().size)) {
            0 -> GameElement.ROCK
            1 -> GameElement.PAPER
            2 -> GameElement.SCISSORS
            else -> error("Unexpected Input!")
        }
}
