package de.berenberg.schulung

import org.springframework.boot.autoconfigure.SpringBootApplication
import kotlin.jvm.JvmStatic
import org.springframework.boot.SpringApplication

@SpringBootApplication
class RoommanagementApplication

fun main(args: Array<String>) {
    SpringApplication.run(RoommanagementApplication::class.java, *args)
}
