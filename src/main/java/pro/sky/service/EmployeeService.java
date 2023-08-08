package pro.sky.service;

import pro.sky.skyprospringdemo.dto.Employee;

import java.util.List;

public interface EmployeeService {
   Employee addEmployee(String name, String lastname);

    Employee removeEmployees(String name, String lastname);

    Employee findEmployee(String name, String lastname);
    List<Employee> findAllEmployee();
}
