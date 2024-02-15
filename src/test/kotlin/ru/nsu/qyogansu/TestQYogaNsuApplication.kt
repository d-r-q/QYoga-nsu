package ru.nsu.qyogansu

import org.springframework.boot.fromApplication
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.boot.with
import ru.nsu.qyogansu.app.QYogaApp

@TestConfiguration(proxyBeanMethods = false)
class TestQYogaNsuApplication

fun main(args: Array<String>) {
	fromApplication<QYogaApp>().with(TestQYogaNsuApplication::class).run(*args)
}
