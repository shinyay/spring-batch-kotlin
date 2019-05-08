package io.pivotal.shinyay.batch

import io.pivotal.shinyay.batch.entity.Employee
import org.springframework.batch.item.ItemWriter

class DepartmentWriter : ItemWriter<Employee> {
    override fun write(items: MutableList<out Employee>) {
        var employeeList: MutableList<String> = mutableListOf()

        items.forEach{
            employeeList.add(arrayOf(it.id, it.employeeNumber, it.salary, it.department).joinToString(","))
        }
        employeeList.forEach{ println()}
    }
}