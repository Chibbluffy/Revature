package dev.wan.services;

import dev.wan.daos.ExpenseDao;
import dev.wan.daos.ExpenseDaoHibernate;
import dev.wan.entities.Expense;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ExpenseServiceImplTest {
    @Mock
    ExpenseDao expenseDao = null;
    private static ExpenseService es = null;
    private static Expense testexpense = null;

    @BeforeEach
    void setUp() {
        Expense expense = new Expense();
        Mockito.when(expenseDao.createExpense(ArgumentMatchers.any())).thenAnswer(invocation -> invocation.getArguments()[0]);
        Mockito.when(expenseDao.updateExpense(ArgumentMatchers.any())).thenAnswer(invocation -> invocation.getArguments()[0]);
        Mockito.when(expenseDao.createExpense(ArgumentMatchers.any())).thenAnswer(invocation -> invocation.getArguments()[0]);

        this.es = new ExpenseServiceImpl(this.expenseDao);
    }

    @Test
    void createExpense() {

    }

    @Test
    void getExpenses() {
    }

    @Test
    void getExpenseById() {
    }

    @Test
    void updateExpense() {
    }

    @Test
    void deleteExpenseById() {
    }
}