/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Job;

/**
 *
 * @author Lenovo
 */
public interface IJobDAO {
    public boolean saveOrDelete(Job job,boolean isSave);
    public List<Job> search(String key);
    public Job getById(String id);
}
