package io.pivotal.shinyay.batch

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableBatchProcessing
class SimpleBatchApplication

fun main(args: Array<String>) {
	runApplication<SimpleBatchApplication>(*args)
}
