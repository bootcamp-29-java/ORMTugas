/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IEmployeeDAO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import models.Employee;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author ASUS
 */
public class EmployeeDAO implements IEmployeeDAO {

    private Transaction transaction;
    private Session session;
    private SessionFactory factory;

    public EmployeeDAO(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Employee> search(String key) {
        List<Employee> listEmployee = new ArrayList<>();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Employee WHERE "
//                    + "id like :key OR "
                    + "firstName like :key OR "
                    + "lastName like :key OR "
                    + "email like :key OR "
                    + "phoneNumber like :key OR "
                    + "department like :key OR "
                    + "job like :key ORDER BY id");
            query.setParameter("key", "%" + key + "%");
            listEmployee = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return listEmployee;
    }

    @Override
    public Employee getById(int id) {
        Employee employee = new Employee();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Employee WHERE id like :id");
            query.setParameter("id", id);
            employee = (Employee) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return employee;
    }

    @Override
    public boolean saveOrDelete(Employee employee, boolean isSave) {
        boolean result = false;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            if (isSave) {
                session.saveOrUpdate(employee);
            } else {
                session.delete(employee);
            }
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return result;
    }

    @Override
    public List<Employee> searchSalary(BigDecimal key) {
        List<Employee> listEmployee = new ArrayList<>();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Employee WHERE "
                    + "id like :key OR "
                    + "salary like :key "
            );
            query.setParameter("key", key);
            listEmployee = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return listEmployee;
    }

}
