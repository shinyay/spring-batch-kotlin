package io.pivotal.shinyay.batch.entity

import org.springframework.batch.item.ItemProcessor

class DepartmentProcessor : ItemProcessor<Employee, Employee> {
    override fun process(item: Employee): Employee? {
        when(item.employeeNumber) {
            "1001" -> item.department = "Sales"
            "1002" -> item.department = "IT"
            else -> item.department = "Staff"
        }
        println("Employee Details --> $item")
        return item
    }
}