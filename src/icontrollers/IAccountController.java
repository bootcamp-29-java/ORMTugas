/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import models.Account;

/**
 *
 * @author Lenovo
 */
public interface IAccountController {
    public String register(String id, String username, String password);
    public Account getByUsername(String username);
    public String login(String username, String pass);
}
