/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IRegionDAO;
import models.Region;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Reza
 */
public class RegionDAO implements IRegionDAO{
    private Transaction transaction;
    
    private Session session;
    
    private SessionFactory factory;
    
    @Override
    public  List<Region> getAll(){
        List<Region> reg = new ArrayList<>();
        
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            reg = session.createQuery("from Region").list();
            
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction!=null) {
                transaction.rollback();
            }
        }
          finally{
            session.close();
        }
        
        return reg;
    }

    public RegionDAO(SessionFactory factory) {
        this.factory = factory;
    }
    
    @Override
    public Region getByid(BigDecimal id){
        Region r = new Region();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Query querry = session.createQuery("from Region where Id =:id");
            querry.setParameter("id", id);
            r = (Region) querry.uniqueResult();
        } catch (Exception e) {
            e.printStackTrace();
            if (transaction!=null) {
                transaction.rollback();
            }
        }
        finally{
            session.close();
        }
        
        return r;
    }
    
    @Override
    public List<Region> search(String key){
        List<Region> region = new ArrayList<>();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Query querry = session.createQuery("FROM Region WHERE Name LIKE :key or Id like :key");
            querry.setParameter("key","%"+key+"%");
            region = querry.list();
        } catch (Exception e) {
            e.printStackTrace();
            if(transaction == null){
                transaction.rollback();
            }  
        }
        finally{
            session.close();
        }
        
        return region;
    }
    @Override
    public boolean saveordelete (Region region, boolean issave){
        boolean result = false;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            if (issave) {
                session.saveOrUpdate(region);
            } else {
                session.delete(region);
            }
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            session.close();
        }
        return result;
    }
    
    @Override
    public boolean saveorupdate(Region region){
        boolean result = false;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.saveOrUpdate(region);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            session.close();
        }
        return result;
    }
    
    @Override
    public boolean deleteaja(Region region){
        
        boolean result = false;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.delete(region);
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            session.close();
        }
        return result;
    }
}
