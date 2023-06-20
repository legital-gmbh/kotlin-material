package org.legital.kotlin.rockpaperscissors

class TwoPlayerGame(
    private val player1: Player,
    private val player2: Player
) {

    fun playRound() {

        val choice1 = player1.choose()
        println("Player 1 chooses: $choice1")
        val choice2 = player2.choose()
        println("Player 2 chooses: $choice2")

        when {
            choice1.beats(choice2) -> player1.incrementWins()
            choice2.beats(choice1) -> player2.incrementWins()
        }

        println("Player 1: ${player1.wins}, Player 2: ${player2.wins}")
    }
}
