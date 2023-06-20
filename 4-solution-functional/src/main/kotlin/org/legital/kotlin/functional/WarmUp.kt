package org.legital.kotlin.functional

fun main() {
    // Task 1
    listOf(1, 2, 3, 4, 5).map { it + 2 }.forEach(::println)

    // Task 2
    println((1..100).filter { it % 2 == 0 }.sumOf { it * it })
}
