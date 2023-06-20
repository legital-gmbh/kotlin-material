package org.legital.kotlin.rockpaperscissors

import org.legital.kotlin.rockpaperscissors.strategy.ConsoleChoosingStrategy
import org.legital.kotlin.rockpaperscissors.strategy.RandomChoosingStrategy

fun main() = App().run()

class App {
    private val player = Player(choosingStrategy = ConsoleChoosingStrategy())
    private val computer = Player(choosingStrategy = RandomChoosingStrategy())
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
        val input = readInput("y", "n", emptyAllowed = true)
        return input != "n"
    }
}
