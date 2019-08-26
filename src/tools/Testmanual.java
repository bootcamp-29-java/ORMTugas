/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.AccountDAO;
import daos.DepartmentDAO;
import daos.LocationDAO;
import daos.CountryDAO;
import daos.RegionDAO;
import models.Account;
import models.Department;
import models.Location;
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
        System.out.println(HibernateUtil.getSessionFactory());
        
        DepartmentDAO ddao = new DepartmentDAO(factory);
//        Department department = ddao.getByID(Short.parseShort("310"));
//        System.out.println(department.getId()+" - "+department.getName());
        Department department = new Department();
        department.setId(Short.parseShort("320"));
        department.setName("WowWoWoW");
        System.out.println(ddao.saveOrDelete(department,true));
        System.out.println(factory);

//        RegionDAO Rdao = new RegionDAO(factory);
        LocationDAO ldao = new LocationDAO(factory);
//        AccountDAO Adao = new AccountDAO(factory);

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
        //tes Location
//        for(Location location : ldao.search("t")){
//         System.out.println(location.getStateProvince()+"-"+location.getCity());
//        }
        for (Location location : ldao.getAll()) {
            System.out.println("Region -> " + location.getId() + " - " + location.getStateProvince());

        }
    }
}
