package icontrollers;

import java.util.List;
import models.Country;
import models.Region;

public interface ICountryController {

    public Country getById(String id);

    public List<Country> search(String key);

    public String save(String id, String name, String regionId);
    
    public String delete(String id);
    
    public List<Country> getAll();
    
    public List<Country> searchRegionId();
}
