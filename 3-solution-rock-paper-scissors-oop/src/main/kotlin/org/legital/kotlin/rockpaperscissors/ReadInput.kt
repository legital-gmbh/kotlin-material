package org.legital.kotlin.rockpaperscissors

fun readInput(vararg allowedInputs: String, emptyAllowed: Boolean = false): String? {
    while (true) {
        val input = readLine()
        if (emptyAllowed && input.isNullOrEmpty()) {
            return null;
        }

        if (allowedInputs.contains(input?.lowercase())) {
            return input
        } else {
            println("Wrong input! - Allowed input(s) are ${allowedInputs.asList()}")
        }

    }
}
