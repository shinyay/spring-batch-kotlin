package io.pivotal.shinyay.batch

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class SimpleBatchApplication

fun main(args: Array<String>) {
	runApplication<SimpleBatchApplication>(*args)
}
