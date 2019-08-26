package daos;

import idaos.ICountryDAO;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import models.Country;
import models.Region;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CountryDAO implements ICountryDAO {

    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public CountryDAO(SessionFactory factory) {
        this.factory = factory;
    }


    @Override
    public Country getById(String id) {
        Country c = new Country();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM Country WHERE id =:id");
            q.setParameter("id", id);
            c = (Country) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return c;
    }

    @Override
    public List<Country> search(String key) {
        List<Country> c = new ArrayList<>();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM Country WHERE name LIKE :key OR id LIKE :key ORDER BY id ASC");
            q.setParameter("key", "%" + key + "%");
            c = q.list();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            session.close();
        }
        return c;
    }

    @Override
    public boolean saveOrdelete(Country country, boolean isSave) {
        boolean result = false;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            if (isSave) {
                session.saveOrUpdate(country);
            } else {
                session.delete(country);
            }
            result = true;
            transaction.commit();
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
    public List<Country> searchRegionId() {
        List<Country> listRegion = new ArrayList<>();
        String query = null;
        query = "SELECT Id FROM Region";
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            listRegion = session.createQuery(query).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (transaction != null) {
                transaction.rollback();
            }
            session.close();
        }
        return listRegion;
    }

}
