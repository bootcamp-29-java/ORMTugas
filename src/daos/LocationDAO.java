/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.ILocationDAO;
import java.util.ArrayList;
import java.util.List;
import models.Location;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author hp
 */
public class LocationDAO implements ILocationDAO {

    private Session session;
    private SessionFactory factory;
    private Transaction transaction;

    public LocationDAO(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<Location> getAll() {
        List<Location> locations = new ArrayList<>();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            locations = session.createQuery("FROM Location").list();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return locations;
    }

    public Location getById(Short id) {
        Location location = new Location();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Query q = session.createQuery("FROM Location Where id=:id");
            q.setParameter("id", id);
            location = (Location) q.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
        return location;
    }

    public boolean saveOrUpdate(Location location, boolean isSave) {
        boolean result = false;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            if (isSave) {
                session.saveOrUpdate(location);
            } else {
                session.delete(location);
            }
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
            transaction.rollback();
        } finally {
            session.close();
        }
        return result;
    }

    public List<Location> search(String key) {
        List<Location> locations = new ArrayList<>();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Location WHERE streetAddress like :key OR postalCode like :key OR city like :key OR stateProvince like :key OR country like :key");
            query.setParameter("key", "%" + key + "%");
            locations = query.list();
        } catch (Exception e) {
            transaction.rollback();
        } finally {
            session.close();
        }
        return locations;
    }
//    public boolean delete(Location location){
//        boolean result = false;
//        try {
//            session = factory.openSession();
//            transaction = session.beginTransaction();
//            session.delete(location);
//            transaction.commit();
//            result = true;
//        } catch (Exception e) {
//            transaction.rollback();
//        }finally{
//            session.close();
//        }
//        return result;
//    }

    @Override
    public List<Location> searchID() {
        List<Location> listCountry = new ArrayList<>();
        String query = null;
        query = "SELECT id FROM Country";
//        if(id == 1){
//            
//        }
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            listCountry = session.createQuery(query).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (transaction != null) {
                transaction.rollback();
            }
            session.close();
        }
        return listCountry;
    }

}
