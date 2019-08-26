/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tools;

import controllers.EmployeeController;
import daos.EmployeeDAO;
import icontrollers.IEmployeeController;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
//        IEmployeeController ce = new EmployeeController(factory);
//        System.out.println(ce.getById("100"));

//        final Pattern pattern = Pattern.compile("<tag>(.+?)</tag>", Pattern.DOTALL);
//        final Matcher matcher = pattern.matcher("<tag>String I want to extract</tag>");
//        matcher.find();
//        System.out.println(matcher.group(1));
        
        String nama = "< 100 > Mustofa";
        Pattern p = Pattern.compile("< (.+?) >", Pattern.DOTALL);
        Matcher m = p.matcher(nama);
        m.find();
        String hasil = m.group(1);
        System.out.println(hasil);
    }
}
