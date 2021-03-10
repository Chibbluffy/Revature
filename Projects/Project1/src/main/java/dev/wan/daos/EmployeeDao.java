package dev.wan.daos;

import dev.wan.entities.Employee;

import java.util.Set;

public interface EmployeeDao {
    Employee getEmployeeByUsername(String username);
}
