/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.List;
import models.Country;
import models.Location;

/**
 *
 * @author hp
 */
public interface ILocationController {

    /**
     * untuk mendapatkan semua data dari tabel
     *
     * @return
     */
    public List<Location> getAll();

    /**
     * Method yang digunakan untuk mendapatkan dan menyeleksi data dari tabel
     * berdasarkan id
     *
     * @param id
     * @return
     */
    public Location getById(short id);

    /**
     * Method yang digunakan untuk mendapatkan dan menyeleksi data dari tabel
     *
     * @param key
     * @return
     */
    public List<Location> search(String key);

    /**
     * Method yang digunakan untuk insert dan update data
     *
     * @param id
     * @param streetAddress
     * @param postalCode
     * @param city
     * @param stateProvince
     * @param country
     * @return
     */
    public String saveOrUpdate(Short id, String streetAddress, String postalCode, String city, String stateProvince, String country);

    /**
     * Method yang digunakan untuk menghapus satu baris data sesuai id masukan
     *
     * @param id
     * @return
     */
    public String delete(String id);

    /**
     * method digunakan untuk menampilkan coutryID pada id method ini dugunaka
     * pada combobox yang ada di view
     */
    public List<Location> searchID();
}
