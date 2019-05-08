package io.pivotal.shinyay.batch

import io.pivotal.shinyay.batch.entity.Employee
import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.batch.core.launch.support.SimpleJobLauncher
import org.springframework.batch.core.repository.JobRepository
import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BatchConfiguration(private val jobBuilderFactory: JobBuilderFactory,
                         private val stepBuilderFactory: StepBuilderFactory) {

    @Bean
    fun jobLauncher(jobRepo: JobRepository): JobLauncher = SimpleJobLauncher().apply { setJobRepository(jobRepo) }

    @Bean
    fun departmentReader(): FlatFileItemReader<Employee> = DepartmentReader().reader()

    @Bean
    fun departmentProcessor(): DepartmentProcessor = DepartmentProcessor()

    @Bean
    fun departmentWriter(): DepartmentWriter = DepartmentWriter()

    @Bean
    fun departmentProcessingJob(): Job = jobBuilderFactory.get("departmentProcessingJob")
            .flow(step1())
            .end()
            .build()

    @Bean
    fun step1(): Step = stepBuilderFactory.get("step1").chunk<Employee, Employee>(1)
            .reader(departmentReader())
            .processor(departmentProcessor())
            .writer(departmentWriter())
            .build()
}