/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaos;

import models.Region;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Reza
 */
public interface IRegionDAO {

    public List<Region> getAll();

    public Region getByid(BigDecimal id);

    public List<Region> search(String key);

    public boolean saveordelete(Region region, boolean issave);

    public boolean saveorupdate(Region region);

    public boolean deleteaja(Region region);
}
