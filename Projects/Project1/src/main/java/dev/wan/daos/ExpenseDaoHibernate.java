package dev.wan.daos;

import dev.wan.entities.Expense;
import dev.wan.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.hibernate.type.IntegerType;

import java.util.HashSet;
import java.util.Set;

public class ExpenseDaoHibernate implements ExpenseDao{
    Logger logger = Logger.getLogger(ExpenseDaoHibernate.class.getName());
    private SessionFactory sf = HibernateUtil.getSessionFactory();

    @Override
    public Expense createExpense(Expense expense) {
        try(Session session = sf.openSession()){
            session.beginTransaction();
            session.save(expense);
            session.getTransaction().commit();
            return expense;
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.toString());
            return null;
        }
    }

    @Override
    public Set<Expense> getAllExpenses() {
        try(Session session = sf.openSession()){
            String hql = "FROM Expense e";
            Query query = session.createQuery(hql);
            Set<Expense> allExpenses = new HashSet<>(query.list());
            return allExpenses;
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.toString());
            return null;
        }
    }

    @Override
    public Expense getExpenseById(int id) {
        try(Session session = sf.openSession()){
            String hql = "FROM Expense WHERE id='"+id+"'";
            Query query = session.createQuery(hql);
            Expense expense = (Expense) query.getSingleResult();
            return expense;
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.toString());
            return null;
        }
    }
    @Override
    public Set<Expense> getExpensesByEmployeeId(int employeeId) {
        try(Session session = sf.openSession()){
            String hql = "FROM Expense e WHERE e.employeeId="+employeeId;
            Query query = session.createQuery(hql);
            Set<Expense> expenses = new HashSet<Expense>(query.list());
            return expenses;
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.toString());
            return null;
        }
    }

    @Override
    public Set<Expense> getExpensesByStatus(String expenseStatus) {
        try(Session session = sf.openSession()){
            String hql = "FROM Expense e WHERE e.expenseStatus='"+expenseStatus+"'";
            Query query = session.createQuery(hql);
            Set<Expense> expenses = new HashSet<Expense>(query.list());
            return expenses;
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.toString());
            return null;
        }
    }

    @Override
    public Set<Expense> getExpensesBySubmitter(int submitterId) {
        try(Session session = sf.openSession()){
            String hql = "FROM Expense WHERE employeeId="+submitterId;
            Query query = session.createQuery(hql);
            Set<Expense> expenses = new HashSet<Expense>(query.list());
            return expenses;
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.toString());
            return null;
        }
    }

    @Override
    public Expense updateExpense(Expense expense) {
        try(Session session = sf.openSession()){
            session.beginTransaction();
            session.update(expense);
            session.getTransaction().commit();
            session.close();
            return expense;
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.toString());
            return null;
        }
    }

    @Override
    public boolean deleteExpenseById(int id) {
        try(Session session = sf.openSession()){
            session.beginTransaction();
            session.delete(this.getExpenseById(id));
            session.getTransaction().commit();
            session.close();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            logger.error(e.toString());
            return false;
        }
    }
}
