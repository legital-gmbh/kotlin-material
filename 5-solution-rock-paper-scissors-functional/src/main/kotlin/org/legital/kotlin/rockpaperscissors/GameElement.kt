package org.legital.kotlin.rockpaperscissors

enum class GameElement(
    private val beatingFunction: (GameElement) -> Boolean
) {
    ROCK(beatingFunction = { it === PAPER }),
    PAPER(beatingFunction = { it === ROCK }),
    SCISSORS(beatingFunction = { it === PAPER });

    fun beats(other: GameElement) = beatingFunction(other)
}
