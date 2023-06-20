package org.legital.kotlin.functional

import java.io.File

const val ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz"

fun main() {
    println("Number of all words containing 'e' or 'a':")
    File("src/main/resources/ipsum.txt")
        .bufferedReader()
        .readLines()
        .filterNot(String::isEmpty)
        .flatMap { line ->
            line
                .split(" ")
                .filter { it.contains("e") || it.contains("a") }
        }
        .count()
        .also(::println)

    println("Sum of all characters in the file:")
    File("src/main/resources/ipsum.txt")
        .bufferedReader()
        .readLines()
        .filterNot(String::isEmpty)
        .flatMap { line ->
            line
                .split("")
                .map { ALPHABET.indexOf(it) }
                .filter { it >= 0 }
        }.sum()
        .also(::println)
}
