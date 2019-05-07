package io.pivotal.shinyay.batch

import org.springframework.batch.core.launch.JobLauncher
import org.springframework.batch.core.launch.support.SimpleJobLauncher
import org.springframework.batch.core.repository.JobRepository
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BatchConfiguration {

    @Bean
    fun jobLauncher(jobRepo: JobRepository): JobLauncher = SimpleJobLauncher().apply { setJobRepository(jobRepo) }

}