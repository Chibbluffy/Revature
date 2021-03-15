package dev.wan.services;

import dev.wan.entities.Expense;

import java.util.Set;

public interface ExpenseService {
    Expense createExpense(Expense expense);

    Set<Expense> getAllExpenses();
    Expense getExpenseById(int id);
    Set<Expense> getExpensesByEmployeeId(int employeeId);
    Set<Expense> getExpensesByStatus(String expenseStatus);
    Set<Expense> getExpensesBySubmitter(int submitterId);

    Expense updateExpense(Expense expense);
    public Expense approveExpense(Expense expense, int managerId);
    public Expense denyExpense(Expense expense, int managerId);


        boolean deleteExpenseById(int id);
}
