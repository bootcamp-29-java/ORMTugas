/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.AccountDAO;
import daos.CountryDAO;
import daos.RegionDAO;
import models.Account;
import models.Country;
import models.Region;
import org.hibernate.SessionFactory;

/**
 *
 * @author Reza
 */
public class Testmanual {
    public static void main(String[] args) {
         SessionFactory factory = HibernateUtil.getSessionFactory();
        System.out.println(factory);
//      
        CountryDAO dao = new CountryDAO(factory);
        for (Country c : dao.search("")) {
            System.out.println(c.getName());
        }
    }
}
