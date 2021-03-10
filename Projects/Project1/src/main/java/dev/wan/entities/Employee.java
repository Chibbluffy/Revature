package dev.wan.entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="employee_id")
    int id;

    @Column(name="username")
    String username;

    @Column(name="passhash")
    String passhash;

    @Column(name="employee_role")
    String position;

    @OneToMany(mappedBy = "employeeId")
    private Set<Expense> expenses = new HashSet<Expense>();

    public Employee() {
    }

    public Employee(int id, String username, String passhash, String position) {
        this.id = id;
        this.username = username;
        this.passhash = passhash;
        this.position = position;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasshash() {
        return passhash;
    }

    public void setPasshash(String passhash) {
        this.passhash = passhash;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Set<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(Set<Expense> expenses) {
        this.expenses = expenses;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
