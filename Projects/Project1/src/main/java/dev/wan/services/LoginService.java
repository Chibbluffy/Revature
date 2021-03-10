package dev.wan.services;

import dev.wan.entities.Employee;

public interface LoginService {
    //Read
    Employee getEmployeeByUsername(String username);

}
