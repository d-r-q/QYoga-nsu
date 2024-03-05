package ru.nsu.qyogansu.app

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Import
import ru.nsu.qyogansu.core.users.UsersConfig

@Import(
	UsersConfig::class
)
@SpringBootApplication
class QYogaApp

fun main(args: Array<String>) {
	runApplication<QYogaApp>(*args)
}
