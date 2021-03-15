package dev.wan.services;

import dev.wan.daos.EmployeeDao;
import dev.wan.daos.EmployeeDaoHibernate;
import dev.wan.daos.ExpenseDao;
import dev.wan.entities.Employee;
import org.apache.log4j.Logger;

public class LoginServiceImpl implements LoginService{
    private static EmployeeDao edao = new EmployeeDaoHibernate();


    public LoginServiceImpl(EmployeeDao employeeDao) {
        this.edao = employeeDao;
    }

    @Override
    public Employee getEmployeeByUsername(String username) {
        return this.edao.getEmployeeByUsername(username);
    }
}
