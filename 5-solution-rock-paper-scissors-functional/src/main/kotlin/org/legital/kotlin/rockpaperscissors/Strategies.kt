package org.legital.kotlin.rockpaperscissors.strategy

import org.legital.kotlin.rockpaperscissors.GameElement
import org.legital.kotlin.rockpaperscissors.readInput
import kotlin.random.Random

val console = {
    println("Choose one:")
    println("r: Rock")
    println("p: Paper")
    println("s: Scissors")

    when (readInput("r", "p", "s")) {
        "r" -> GameElement.ROCK
        "p" -> GameElement.PAPER
        "s" -> GameElement.SCISSORS
        else -> error("Unexpected input!")
    }
}

val random = {
    when (Random.nextInt(GameElement.values().size)) {
        0 -> GameElement.ROCK
        1 -> GameElement.PAPER
        2 -> GameElement.SCISSORS
        else -> error("Unexpected Input!")
    }
}
