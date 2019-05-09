package io.pivotal.shinyay.batch

import org.springframework.batch.core.Job
import org.springframework.batch.core.JobParameters
import org.springframework.batch.core.JobParametersBuilder
import org.springframework.batch.core.launch.JobLauncher
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class BatchCommandLineRunner(val jobLauncher: JobLauncher, val departmentProcessingJob: Job) : CommandLineRunner {

    override fun run(vararg args: String?) {

        val param: JobParameters = JobParametersBuilder()
                .addString("JobID",System.currentTimeMillis().toString()).toJobParameters()

        jobLauncher.run(departmentProcessingJob, param)
    }

}