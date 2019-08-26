/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.JobDAO;
import icontrollers.IJobController;
import idaos.IJobDAO;
import java.util.List;
import models.Job;
import org.hibernate.SessionFactory;

/**
 *
 * @author Lenovo
 */
public class JobController implements IJobController{
private SessionFactory factory;
    private IJobDAO iedao;
    public JobController(SessionFactory factory) {
        iedao = new JobDAO(factory);
    }
    @Override
    public List<Job> search(String key) {
        return iedao.search(key);
    }

    @Override
    public Job getById(String id) {
        return iedao.getById(id);
    }

    @Override
    public String save(String id, String tittle, String maxSal, String minSal) {
        String result = "";
        Job job = new Job();
        job.setId(id);
        job.setTittle(tittle);
        job.setMinSalary(Integer.parseInt(minSal));
        job.setMaxSalary(Integer.parseInt(maxSal));
        if (iedao.saveOrDelete(job, true)) {
            result = "Data Berhasil Disimpan";
        }else{
            result = "Data Gagal Disimpan";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "";
        Job job = new Job(id);
        job = iedao.getById(id);
        if (iedao.saveOrDelete(job, false)) {
            result = "Data Baerhasil Dihapus";
        }else{
            result = "Data Gagal Dihapus";
        }
        return result;
    }
    
    
}
