/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package daos;

import idaos.IAccountDAO;
import models.Account;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import tools.BCrypt;

/**
 *
 * @author Lenovo
 */
public class AccountDAO implements IAccountDAO{
    private SessionFactory factory;
    private Session session;
    private Transaction transaction;

    public AccountDAO(SessionFactory factory) {
        this.factory = factory;
    }
    @Override
    public boolean insert(Account account) {
        boolean result = false;
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            session.save(account);
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
    public boolean login(String username, String password) {
        boolean result = false;
        Account acc = new Account();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("from Account where username=:username");
            query.setParameter("username", username);
            acc = (Account) query.uniqueResult();
            if (BCrypt.checkpw(password, acc.getPassword())) {
                result = true;
            } else {
                result = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            if(transaction==null){
                transaction.rollback();
            }
        }
        finally{
            session.close();
        }
                
        return result;
    }

    @Override
    public Account getByUsername(String username) {
         Account account = new Account();
        try {
            session = factory.openSession();
            transaction = session.beginTransaction();
            Query query = session.createQuery("FROM Account WHERE username =:key");
            query.setParameter("key", username);
            account = (Account) query.uniqueResult();
        } catch (Exception e) {
            System.out.println(e.getStackTrace());
        }
        return account;
    }
    
}
