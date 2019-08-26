/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.EmployeeController;
import daos.EmployeeDAO;
import icontrollers.IEmployeeController;
import models.Employee;
import org.hibernate.SessionFactory;

/**
 *
 * @author ASUS
 */
public class Testing {
    public static void main(String[] args) {
        SessionFactory factory = HibernateUtil.getSessionFactory();
//        System.out.println(factory);
        IEmployeeController ce = new EmployeeController(factory);
        System.out.println(ce.getById("100"));
    }
}
