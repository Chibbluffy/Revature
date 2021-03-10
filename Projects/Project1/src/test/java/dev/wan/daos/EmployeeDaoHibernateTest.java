package dev.wan.daos;

import dev.wan.entities.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDaoHibernateTest {
    EmployeeDao edao = new EmployeeDaoHibernate();
    @Test
    void get_employee_by_username(){
        Employee employee = edao.getEmployeeByUsername("Jean");
        System.out.println(employee);
        Assertions.assertNotNull(employee);
    }

    @Test
    void get_employee_by_invalid_username(){
        Employee employee = edao.getEmployeeByUsername("Tom");
        System.out.println(employee);
        Assertions.assertNull(employee);
    }
}