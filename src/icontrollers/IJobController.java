/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Job;

/**
 *
 * @author Lenovo
 */
public interface IJobController {
    public String save(String id,String tittle, String maxSal, String minSal);
    public String delete(String id);
    public List<Job> search(String key);
    public Job getById(String id);
}
