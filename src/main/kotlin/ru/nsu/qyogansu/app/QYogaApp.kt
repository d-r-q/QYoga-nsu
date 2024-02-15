package ru.nsu.qyogansu.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class QYogaApp

fun main(args: Array<String>) {
	runApplication<QYogaApp>(*args)
}
