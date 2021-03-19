package dev.wan.services;

import dev.wan.daos.ExpenseDao;
import dev.wan.entities.Expense;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.AdditionalAnswers.returnsFirstArg;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class ExpenseServiceImplTest {
    @Mock
    private ExpenseDao expenseDao;
    private static ExpenseService es = null;

    @Test
    void createExpense() {
        Mockito.when(expenseDao.createExpense(any())).then(returnsFirstArg());
        this.es = new ExpenseServiceImpl(this.expenseDao);
        Expense expense = new Expense();
        expense = this.es.createExpense(expense);

        Assertions.assertNotEquals(0, expense.getSubmittedDate());
        Assertions.assertEquals(0, expense.getProcessedDate());
        Assertions.assertTrue(expense.getProcessedReason().equals("N/A"));
        Assertions.assertEquals(null, expense.getProcessedManagerId());
        Assertions.assertTrue(expense.getExpenseStatus().equals("PENDING"));
    }

    @Test
    void approve_expense() {
        Mockito.when(expenseDao.updateExpense(any())).then(returnsFirstArg());
        this.es = new ExpenseServiceImpl(this.expenseDao);
        Expense expense = new Expense();
        expense = this.es.approveExpense(expense, 1);

        Assertions.assertEquals("APPROVED", expense.getExpenseStatus());
        Assertions.assertEquals(1, expense.getProcessedManagerId());
        Assertions.assertTrue(0 < expense.getProcessedDate());
    }

    @Test
    void deny_expense() {
        Mockito.when(expenseDao.updateExpense(any())).then(returnsFirstArg());
        this.es = new ExpenseServiceImpl(this.expenseDao);
        Expense expense = new Expense();
        expense = this.es.denyExpense(expense, 1);

        Assertions.assertEquals("DENIED", expense.getExpenseStatus());
        Assertions.assertEquals(1, expense.getProcessedManagerId());
        Assertions.assertTrue(0 < expense.getProcessedDate());
    }
}