package pro.sky.skyprospringdemo.dto;

import java.util.Objects;

public class Employee {
    private final String lastName;
    private final String name;

    public Employee(String lastName, String name) {
        this.lastName = lastName;
        this.name = name;

    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastName;
    }

    @Override
    public String toString() {
        return
                "ФИО " + getLastname()
                        + " " + getName();
    }

    @Override
    public boolean equals(Object other) {
        if (this == other)
            return true;
        if (other == null || getClass() != other.getClass())
            return false;
        Employee employee = (Employee) other;
        return Objects.equals(lastName, employee.lastName) && Objects.equals(name, employee.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, name);
    }
}



