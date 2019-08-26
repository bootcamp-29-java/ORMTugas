package controllers;

import daos.CountryDAO;
import icontrollers.ICountryController;
import idaos.ICountryDAO;
import java.math.BigDecimal;
import java.util.List;
import models.Country;
import models.Region;
import org.hibernate.SessionFactory;

public class CountryController implements ICountryController {

    private ICountryDAO icdao;

    public CountryController(SessionFactory factory) {
        icdao = new CountryDAO(factory);
    }

    @Override
    public Country getById(String id) {
        return icdao.getById(id);
    }

    @Override
    public List<Country> search(String key) {
        return icdao.search(key);
    }

    @Override
    public String save(String id, String name, String regionId) {
        String result = "";
        Country c = new Country();
        Region r = new Region(new BigDecimal(regionId));
        c.setId(id);
        c.setName(name);
        c.setRegion(r);
        if (icdao.saveOrdelete(c, true)) {
            result = "PROSES BERHASIL";
        } else {
            result = "PROSES GAGAL";
        }
        return result;
    }

    @Override
    public String delete(String id) {
        String result = "";
        Country c = new Country(id);
        if (icdao.saveOrdelete(c, false)) {
            result = "DATA BERHASIL DIHAPUS";
        } else {
            result = "DATA GAGAL DIHAPUS";
        }
        return result;
    }

    @Override
    public List<Country> getAll() {
        return icdao.search("");
    }

    @Override
    public List<Country> searchRegionId() {
        return icdao.searchRegionId();
    }
    

}
