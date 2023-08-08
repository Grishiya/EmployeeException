package pro.sky.service;


import org.springframework.stereotype.Service;
import pro.sky.exception.EmployeeAlreadyAddedException;
import pro.sky.exception.EmployeeNotFoundException;
import pro.sky.exception.EmployeeStorageIsFullException;
import pro.sky.skyprospringdemo.dto.Employee;


import java.util.ArrayList;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employees;
    private static final int EMPLOYEES_MAX_SIZE = 10;

    public EmployeeServiceImpl() {
        this.employees = new ArrayList<>();
    }

    @Override
    public Employee addEmployee(String name, String lastName) {
        if (employees.size() == EMPLOYEES_MAX_SIZE) {
            throw new EmployeeStorageIsFullException("Превышен лимит количества сотрудников в фирме");
        }
        Employee employee = new Employee(name, lastName);

        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException("Добавляемый сотрудник уже имеется в списке");
        }
        employees.add(employee);
        return employee;
    }


    @Override
    public Employee removeEmployees(String name, String lastName) {
        Employee employee = new Employee(name, lastName);
        if (!employees.remove(employee)) {
            throw new EmployeeNotFoundException("Удаляемый сотрудник не найден");
        }
        employees.remove(employee);
        return employee;//Работает потому что переопределили метод equals(), так как он сравнивает по name и lastname
    }

    @Override
    public Employee findEmployee(String name, String lastName) {
        Employee employee = new Employee(name, lastName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Cотрудник не найден");
        }
        return employee;
    }

    @Override
    public List<Employee> findAllEmployee() {
        return employees;
    }
}