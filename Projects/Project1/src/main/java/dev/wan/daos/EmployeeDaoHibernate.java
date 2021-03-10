package dev.wan.daos;

import dev.wan.entities.Employee;
import dev.wan.utils.HibernateUtil;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class EmployeeDaoHibernate implements EmployeeDao{
    Logger logger = Logger.getLogger(EmployeeDaoHibernate.class.getName());
    private SessionFactory sf = HibernateUtil.getSessionFactory();

    @Override
    public Employee getEmployeeByUsername(String username) {
        try(Session session = sf.openSession()){
            String hql = "FROM Employee WHERE username='"+username+"'";
            logger.info(hql);
            Query query = session.createQuery(hql);
            if (query.list().size()!=0){
                Employee employee = (Employee) query.list().get(0);
                return employee;
            }
        }catch(Exception e){
            e.printStackTrace();
            logger.error(e.toString());
        }
        return null;
    }
}
