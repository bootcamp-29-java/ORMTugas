/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IJobDAO;
import java.util.ArrayList;
import java.util.List;
import models.Job;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Lenovo
 */
public class JobDAO implements IJobDAO{
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public JobDAO(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public boolean saveOrDelete(Job job, boolean isSave) {
        boolean result = false;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            if (isSave) {
                session.saveOrUpdate(job);
            }else{
                session.delete(job);
            }
            transaction.commit();
            result = true;
        } catch (Exception e) {
            e.getStackTrace();
        }finally {
            session.close();
        }        
        return result;
    }

    @Override
    public List<Job> search(String key) {
        List<Job> jobs = new ArrayList<>();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Job WHERE tittle LIKE :key OR id LIKE :key");
            query.setParameter("key", "%"+key+"%");
            jobs = query.list();
        } catch (Exception e) {
            e.getStackTrace();
        }finally {
            session.close();
        }        
        return jobs;
    }

    @Override
    public Job getById(String id) {
        Job job = new Job();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Job WHERE id = :id");
            query.setParameter("id", id);
            job =(Job) query.uniqueResult();
        } catch (Exception e) {
            e.getStackTrace();
        }finally {
            session.close();
        }        
        return job;
    }

   
}
