/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import daos.RegionDAO;
import icontrollers.IRegionController;
import idaos.IRegionDAO;
import models.Region;
import tools.HibernateUtil;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Reza
 */
public class RegionController implements IRegionController{
    private SessionFactory factory = HibernateUtil.getSessionFactory();
    
    private IRegionDAO IRdao;

    public RegionController(SessionFactory factory){
        IRdao = new RegionDAO(factory);
    }

    @Override
    public List<Region> getAll() {
        return IRdao.getAll();}

    @Override
    public Region getById(String id) {
        return IRdao.getByid(new BigDecimal(id));
    }

    @Override
    public List<Region> search(String key) {
        return IRdao.search(key);
    }

    @Override
    public String save(String id, String name) {
        String result = "";
//        Region region = new Region();
//        region.setId(new BigDecimal(id));
//        region.setName(name);
//        if(IRdao.saveorupdate(region)){
//            result ="data berhasil di simpan";
//        }else{
//            result ="maaf data gagal disimpan";
//        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "";
        boolean issave=false;
        Region region = new Region();
        region.setId(new BigDecimal(id));
        if (issave==false) {
            IRdao.saveordelete(region,issave);
            result ="data berhasil di hapus";
        } else {
            result ="data gagal di hapus";
        }
        return result;
    }

    @Override
    public String saveorupdate(String id, String name) {
        String result = "";
        boolean issave = true;
        Region region = new Region();
        region.setId(new BigDecimal(id));
        region.setName(name);
        if (issave) {
            IRdao.saveordelete(region,issave);
            result ="data berhasil di simpan";
        } else {
            result ="data gagal di simpan";
            //IRdao.saveordelete(region, issave);
        }
        return result;
    }
    
}
