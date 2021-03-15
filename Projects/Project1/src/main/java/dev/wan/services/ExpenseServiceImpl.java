package dev.wan.services;

import dev.wan.daos.ExpenseDao;
import dev.wan.entities.Expense;

import java.util.Set;

public class ExpenseServiceImpl implements ExpenseService{
    private static ExpenseDao expenseDao;

    public ExpenseServiceImpl(ExpenseDao expenseDao) {
        this.expenseDao = expenseDao;
    }

    @Override
    public Expense createExpense(Expense expense) {
        expense.setProcessedDate(0);
        expense.setProcessedReason("N/A");
        expense.setSubmittedDate((int)(System.currentTimeMillis()/1000));
        expense.setProcessedManagerId(null);
        expense.setStatus("PENDING");
        return this.expenseDao.createExpense(expense);
    }

    @Override
    public Set<Expense> getAllExpenses() {
        return this.expenseDao.getAllExpenses();
    }

    @Override
    public Expense getExpenseById(int id) {
        return this.expenseDao.getExpenseById(id);
    }

    @Override
    public Set<Expense> getExpensesByEmployeeId(int employeeId) {
        return this.expenseDao.getExpensesByEmployeeId(employeeId);
    }
    @Override
    public Set<Expense> getExpensesByStatus(String expenseStatus) {
        return this.expenseDao.getExpensesByStatus(expenseStatus);
    }

    @Override
    public Set<Expense> getExpensesBySubmitter(int submitterId) {
        return this.expenseDao.getExpensesBySubmitter(submitterId);
    }

    @Override
    public Expense updateExpense(Expense expense){
        return this.expenseDao.updateExpense(expense);
    }

    @Override
    public Expense approveExpense(Expense expense, int managerId){
        expense.setStatus("APPROVED");
        expense.setProcessedManagerId(managerId);
        expense.setProcessedDate((int)(System.currentTimeMillis()/1000));
        return this.expenseDao.updateExpense(expense);
    }

    @Override
    public Expense denyExpense(Expense expense, int managerId){
        expense.setStatus("DENIED");
        expense.setProcessedManagerId(managerId);
        expense.setProcessedDate((int)(System.currentTimeMillis()/1000));
        return this.expenseDao.updateExpense(expense);
    }

    @Override
    public boolean deleteExpenseById(int id) {
        return this.expenseDao.deleteExpenseById(id);
    }
}
