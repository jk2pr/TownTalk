package com.hoppers.towntalk

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TownTalkApplication

fun main(args: Array<String>) {
	runApplication<TownTalkApplication>(*args)
    println("TownTalk Server Start!")
}
