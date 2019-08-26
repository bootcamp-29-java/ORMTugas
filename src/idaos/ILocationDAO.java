/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import java.util.List;
import models.Location;

/**
 *
 * @author hp
 */
public interface ILocationDAO {

    public List<Location> getAll();

    public Location getById(Short id);

    public List<Location> search(String key);

    public boolean saveOrUpdate(Location location, boolean isSave);

    public List<Location> searchID();
}
