package dev.wan.daos;

import dev.wan.entities.Expense;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Set;

class ExpenseDaoHibernateTest {
    static ExpenseDao edao = new ExpenseDaoHibernate();
    static Expense expense1 = new Expense(0,10,"lunch",1, "PENDING",1615793637,0,"",null);
    static Expense expense2 = new Expense(0,100,"lunch",1, "PENDING",1615793637,0,"",null);
    static Expense expense3 = new Expense(0,1000,"party",1, "PENDING",1615793637,0,"",null);
    static Expense expense4 = new Expense(0,1500,"rewards",1, "PENDING",1615793637,0,"",null);
    static Expense expense5 = new Expense(0,2000,"expedition",1, "PENDING",1615793637,0,"",null);
    static Expense expense6 = new Expense(0,5000,"bounties",1, "PENDING",1615793637,0,"",null);
    static Expense expense7 = new Expense(0,10000,"large expedition",1, "PENDING",1615793637,0,"",null);
    static Expense testexpense;

    @BeforeAll
    static void setUp(){
        edao.createExpense(expense1);
        edao.createExpense(expense2);
        edao.createExpense(expense3);
        edao.createExpense(expense4);
        edao.createExpense(expense5);
        edao.createExpense(expense6);
        edao.createExpense(expense7);
    }

    @AfterAll
    static void tearDown(){
        edao.deleteExpenseById(expense1.getExpenseId());
        edao.deleteExpenseById(expense2.getExpenseId());
        edao.deleteExpenseById(expense3.getExpenseId());
        edao.deleteExpenseById(expense4.getExpenseId());
        edao.deleteExpenseById(expense5.getExpenseId());
        edao.deleteExpenseById(expense6.getExpenseId());
        edao.deleteExpenseById(testexpense.getExpenseId());
    }

    @Test
    void create_expense(){
        Expense expense = new Expense(0,10,"lunch",1, "APPROVED",0,0,"",3);
        expense = edao.createExpense(expense);
        System.out.println(expense);
        testexpense = expense;

        Assertions.assertNotEquals(0, expense.getExpenseId());
    }

    @Test
    void get_expense_by_id(){
        Expense expense = edao.getExpenseById(expense1.getExpenseId());
        System.out.println(expense);

        Assertions.assertNotNull(expense);
    }

    @Test
    void get_all_expenses(){
        Set<Expense> expenses = edao.getAllExpenses();
        System.out.println(expenses);
        Assertions.assertTrue(expenses.size() >= 6);
    }

    @Test
    void get_expenses_by_status(){
        Set<Expense> expenses = edao.getExpensesByStatus("PENDING");
        System.out.println(expenses);

        Assertions.assertNotNull(expenses.size()>4);
    }

    @Test
    void get_expense_by_submitter(){
        Set<Expense> expenses = edao.getExpensesBySubmitter(1);
        System.out.println(expenses);

        Assertions.assertNotNull(expenses.size()>2);
    }

    @Test
    void delete_expense_by_id(){
        boolean result = edao.deleteExpenseById(expense7.getExpenseId());

        Assertions.assertTrue(result);
        Assertions.assertNull(edao.getExpenseById(expense7.getExpenseId()));
    }
}