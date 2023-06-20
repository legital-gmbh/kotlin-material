import kotlin.random.Random

const val ROCK = "Rock"
const val PAPER = "Paper"
const val SCISSORS = "Scissors"

fun main() {
    var player = 0
    var computer = 0

    println("Welcome to rock paper scissors!")

    while (true) {
        val playerChoice = playersChoice()
        println("Player chooses: $playerChoice")

        val computerChoice = computersChoice()
        println("Computer chooses: $computerChoice")

        when (playerChoice) {
            ROCK -> when (computerChoice) {
                SCISSORS -> player++
                PAPER -> computer++
            }
            PAPER -> when (computerChoice) {
                SCISSORS -> computer++
                ROCK -> player++
            }
            SCISSORS -> when (computerChoice) {
                ROCK -> computer++
                PAPER -> player++
            }
        }

        println("Player: $player, Computer: $computer")
        println("Continue? [Y/n]")
        val input = readInput("y", "n", emptyAllowed = true)
        if (input == "n") {
            when {
                player > computer -> println("Player wins!")
                computer > player -> println("Computer wins!")
                else -> println("Game ended with a tie!")
            }
            return
        }
    }
}

private fun readInput(vararg allowedInputs: String, emptyAllowed: Boolean = false): String? {
    while (true) {
        val input = readLine()
        if (emptyAllowed && input.isNullOrEmpty()) {
            return null
        }

        if (allowedInputs.contains(input?.lowercase())) {
            return input
        } else {
            println("Wrong input! - Allowed input(s) are ${allowedInputs.asList()}")
        }
    }
}

private fun playersChoice(): String {
    println("Choose one:")
    println("r: Rock")
    println("p: Paper")
    println("s: Scissors")

    return when (readInput("r", "p", "s")) {
        "r" -> ROCK
        "p" -> PAPER
        "s" -> SCISSORS
        else -> error("Unexpected input!")
    }
}

private fun computersChoice() =
    when (Random.nextInt(3)) {
        0 -> ROCK
        1 -> PAPER
        2 -> SCISSORS
        else -> error("Unexpected input!")
    }
