/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import idaos.ILocationDAO;
import daos.LocationDAO;
import icontrollers.ILocationController;
import java.util.ArrayList;
import java.util.List;
import models.Country;
import models.Location;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author affan
 */
public class LocationController implements ILocationController {

    private ILocationDAO ildao;
    private Session session;
    private SessionFactory factory;

    public LocationController(SessionFactory factory) {
        ildao = new LocationDAO(factory);
    }

    @Override
    public List<Location> getAll() {
        return ildao.getAll();
    }

    @Override
    public Location getById(short id) {
        return ildao.getById(id);
    }

    @Override
    public List<Location> search(String key) {
        return ildao.search(key);
    }

    @Override
    public String saveOrUpdate(Short id, String streetAddress, String postalCode, String city, String stateProvince, String country) {
        String result = "";
        boolean issave = true;
        Location l = new Location();
        Country c = new Country();
        l.setId(id);
        l.setStreetAddress(streetAddress);
        l.setPostalCode(postalCode);
        l.setCity(city);
        l.setStateProvince(stateProvince);
        c.setId(country);
        l.setCountry(c);
        if (issave == true) {
            ildao.saveOrUpdate(l, issave);
            result = "data berhasil di simpan";
        } else {
            result = " data gagal disimpan";
        }
        return result;
    }

    public String delete(String id) {
        String result = "";
        boolean issave = false;
        Location location = new Location();
        location = ildao.getById(Short.parseShort(id));
        location.setId(Short.parseShort(id));
        location.getCity();

        if (issave == false) {
            ildao.saveOrUpdate(location, issave);
            result = "data berhasil di hapus";
        } else {
            result = "data gagal dihapus";
        }
        return result;
    }

    @Override
    public List<Location> searchID() {       
        return ildao.searchID();
    }

}
