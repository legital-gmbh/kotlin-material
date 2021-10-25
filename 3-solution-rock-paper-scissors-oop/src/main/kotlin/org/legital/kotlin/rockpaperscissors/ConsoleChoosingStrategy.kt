package org.legital.kotlin.rockpaperscissors

import java.lang.IllegalStateException

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
            else -> throw IllegalStateException()
        }
    }
}
