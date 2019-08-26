/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.math.BigDecimal;
import models.Account;

/**
 *
 * @author Lenovo
 */
public interface IAccountDAO {
    public boolean insert(Account account);
    public boolean login(String username, String password);
    public Account getByUsername(String username);
}
