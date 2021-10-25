package org.legital.kotlin.rockpaperscissors

fun main() {
    val player = Player(choosingStrategy = ConsoleChoosingStrategy())
    val computer = Player(choosingStrategy = RandomChoosingStrategy())

    val game = TwoPlayerGame(
        player1 = player,
        player2 = computer
    )

    println("Welcome to rock paper scissors!")

    while (true) {
        game.playRound()

        println("Continue? [Y/n]")
        val input = readInput("y", "n", emptyAllowed = true)
        if (input == "n") {
            when {
                player.wins > computer.wins -> println("Player wins!")
                computer.wins > player.wins -> println("Computer wins!")
                else -> println("Game ended with a tie!")
            }
            return
        }
    }
}
