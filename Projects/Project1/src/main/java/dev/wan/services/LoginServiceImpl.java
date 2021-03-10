package dev.wan.services;

import dev.wan.daos.EmployeeDao;
import dev.wan.entities.Employee;
import org.apache.log4j.Logger;

public class LoginServiceImpl implements LoginService{
    private static EmployeeDao edao;

    @Override
    public Employee getEmployeeByUsername(String username) {
        return this.edao.getEmployeeByUsername(username);
    }
}
