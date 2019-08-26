/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.AccountDAO;
import daos.RegionDAO;
import models.Account;
import models.Region;
import org.hibernate.SessionFactory;

/**
 *
 * @author Reza
 */
public class Testmanual {
    public static void main(String[] args) {
         SessionFactory factory = HibernateUtil.getSessionFactory();
        System.out.println(HibernateUtil.getSessionFactory());
        
        RegionDAO Rdao = new RegionDAO(factory);
        AccountDAO Adao = new AccountDAO(factory);
        
        ///tes login
        //Account acc = new Account(102, "Lex", "Reza");
//       System.out.println(Adao.login("Lex", "Reza"));
//        
//        for(Account acc1 : Adao.getAll()){
//            System.out.println("Account -> "+acc1.getEmployeeId() +" - "+acc1.getUsername());
//            
//        }
        
        //tes regis
//        Account acc = new Account(102, "Lexi", "Reza");
//        System.out.println(Adao.register(acc));
        
        ///tes region
//        for(Region reg : Rdao.getAll()){
//            System.out.println("Region -> "+reg.getId() +" - "+reg.getCountrieList());
//            
//        }
//        for(Region region : Rdao.search("8")){
//         System.out.println(region.getName());
//        }
    }
}
