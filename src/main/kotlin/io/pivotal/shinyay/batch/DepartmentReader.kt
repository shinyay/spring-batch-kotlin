package io.pivotal.shinyay.batch

import io.pivotal.shinyay.batch.entity.Employee
import org.springframework.batch.item.file.FlatFileItemReader
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper
import org.springframework.batch.item.file.mapping.DefaultLineMapper
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer
import org.springframework.core.io.ClassPathResource

class DepartmentReader {

    fun reader(): FlatFileItemReader<Employee> = FlatFileItemReader<Employee>()
            .also { reader ->
                reader.setResource(ClassPathResource("employee_data.dat"))
                reader.setLineMapper(DefaultLineMapper<Employee>()
                        .apply {
                            setLineTokenizer(
                                    DelimitedLineTokenizer()
                                            .apply {
                                                setNames("id", "employeenumber", "salary")
                                            }
                            )
                            setFieldSetMapper(
                                    BeanWrapperFieldSetMapper<Employee>()
                                            .apply {
                                                setTargetType(Employee::class.java)
                                            }
                            )
                        }
                )
            }
}