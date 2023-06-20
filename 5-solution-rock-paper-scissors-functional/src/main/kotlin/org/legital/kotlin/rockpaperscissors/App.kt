package org.legital.kotlin.rockpaperscissors

import org.legital.kotlin.rockpaperscissors.strategy.console
import org.legital.kotlin.rockpaperscissors.strategy.random

fun main() = App().run()

class App {
    private val player = Player(choosingStrategy = console)
    private val computer = Player(choosingStrategy = random)
    private val game = TwoPlayerGame(player1 = player, player2 = computer)

    fun run() {
        println("Welcome to rock paper scissors!")

        do {
            game.playRound()
        } while (shouldContinue())

        when {
            player.wins > computer.wins -> println("Player 1 wins!")
            computer.wins > player.wins -> println("Player 2 wins!")
            else -> println("Game ended with a tie!")
        }
    }

    private fun shouldContinue(): Boolean {
        println("Continue? [Y/n]")
        return readInput("y", "n", emptyAllowed = true)
            .let { it != "n" }
    }
}
