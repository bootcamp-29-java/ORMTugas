/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.AccountDAO;
import icontrollers.IAccountController;
import idaos.IAccountDAO;
import java.math.BigDecimal;
import models.Account;
import models.Employee;
import org.hibernate.SessionFactory;
import tools.BCrypt;

/**
 *
 * @author Lenovo
 */
public class AccountController implements IAccountController{
    private SessionFactory factory;
    private IAccountDAO iadao;
    public AccountController(SessionFactory factory) {
        iadao = new AccountDAO(factory);
    }
    
    @Override
    public String login(String username, String pass) {
        String result = "";
        
        if(iadao.login(username, pass)){
            result = "Login Berhasil";
            Account acc = new Account();
            acc.setUname(username);
        }else{
            result = "Maaf data gagal dikenali";
        }
        return result;
    }

    @Override
    public String register(String id, String username, String password) {
        String status;
        Account account = new Account();
        Employee employee = new Employee();
        employee.setId(Integer.parseInt(id));
        account.setEmployee(employee);
        account.setId(Integer.parseInt(id));
        account.setUsername(username);
        account.setPassword(BCrypt.hashpw(password, BCrypt.gensalt()));
        if (iadao.insert(account)) {
            status = "Data Berhasil Disimpan";
        }else{
            status = "Data Gagal Disimpan!";
        }
        return status;
    }

    @Override
    public Account getByUsername(String username) {
        return iadao.getByUsername(username);
//        return account;
    }
    
    
}
