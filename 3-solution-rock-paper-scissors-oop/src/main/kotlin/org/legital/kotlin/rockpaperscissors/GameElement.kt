package org.legital.kotlin.rockpaperscissors

enum class GameElement {
    ROCK, PAPER, SCISSORS;

    fun beats(other: GameElement) =
        when (this) {
            ROCK -> other === SCISSORS
            PAPER -> other === ROCK
            SCISSORS -> other === PAPER
        }
}
