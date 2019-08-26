/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import daos.AccountDAO;
import daos.DepartmentDAO;
import daos.RegionDAO;
import models.Account;
import models.Department;
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
    }
}
