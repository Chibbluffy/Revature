package dev.wan.daos;

import dev.wan.entities.Expense;

import java.util.Set;

public interface ExpenseDao {
    // Create
    Expense createExpense(Expense expense);

    // Read
    Set<Expense> getAllExpenses();
    Expense getExpenseById(int id);
    Set<Expense> getExpensesByEmployeeId(int employeeId);
    Set<Expense> getExpensesByStatus(String expenseStatus);
    Set<Expense> getExpensesBySubmitter(int submitterId);

    // Update
    Expense updateExpense(Expense expense);

    // Delete
    boolean deleteExpenseById(int id);
}
