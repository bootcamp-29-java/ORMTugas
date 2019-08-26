package daos;

import idaos.IDepartmentDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import models.Department;
import models.Region;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class DepartmentDAO implements IDepartmentDAO{
    private Transaction transaction;
    private Session session;
    private SessionFactory factory;
    
    public DepartmentDAO(SessionFactory factory){
        this.factory = factory;
    }
    
    @Override
    public List<Department> searchID(int key) {
        List<Department> listDepartment = new ArrayList<>();
        String query = null;
        if (key == 1) {
            query = "SELECT id FROM Employee";
        } else if (key == 2) {
            query = "SELECT id FROM Location";
        }
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            listDepartment = session.createQuery(query).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (transaction != null) {
                transaction.rollback();
            }
            session.close();
        }
        return listDepartment;
    }
    
    @Override
    public Department getByID(Short id){
        Department department = new Department();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Department WHERE department_id = :id");
            query.setParameter("id", id);
            department = (Department) query.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return department;
    }
    
    @Override
    public List<Department> search(String key) {
        List<Department> listDepartment = new ArrayList<Department>();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Department WHERE department_id LIKE :key OR department_name LIKE :key OR manager_id LIKE :key OR location_id LIKE :key ORDER BY department_id");
            query.setParameter("key", "%" + key + "%");
            listDepartment = query.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return listDepartment;
    }
    
    @Override
    public boolean saveOrDelete(Department department, boolean isSave) {
        Boolean result = false;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            if (isSave) {
                session.saveOrUpdate(department);
            }
            else {
                session.delete(department);
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
}