package idaos;

import java.math.BigDecimal;
import java.util.List;
import models.Country;
import models.Region;

public interface ICountryDAO {
    public Country getById(String id);
    public List<Country> search(String key);
    public List<Country> searchRegionId();
    public boolean saveOrdelete(Country country,boolean isSave);   
}
