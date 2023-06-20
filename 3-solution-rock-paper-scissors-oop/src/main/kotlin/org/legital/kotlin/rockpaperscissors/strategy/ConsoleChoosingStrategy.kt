package org.legital.kotlin.rockpaperscissors.strategy

import org.legital.kotlin.rockpaperscissors.GameElement
import org.legital.kotlin.rockpaperscissors.readInput

class ConsoleChoosingStrategy: ChoosingStrategy {
    override fun choose(): GameElement {
        println("Choose one:")
        println("r: Rock")
        println("p: Paper")
        println("s: Scissors")

        return when (readInput("r", "p", "s")) {
            "r" -> GameElement.ROCK
            "p" -> GameElement.PAPER
            "s" -> GameElement.SCISSORS
            else -> error("Unexpected input!")
        }
    }
}
