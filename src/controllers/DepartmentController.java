package controllers;

import daos.DepartmentDAO;
import icontrollers.IDepartmentController;
import idaos.IDepartmentDAO;
import java.util.List;
import javax.swing.JOptionPane;
import models.Department;
import models.Employee;
import models.Location;
import org.hibernate.SessionFactory;

public class DepartmentController implements IDepartmentController {

    private IDepartmentDAO iddao;

    public DepartmentController(SessionFactory factory) {
        iddao = new DepartmentDAO(factory);
    }
    
    @Override
    public List<Department> searchID(int id) {
        return iddao.searchID(id);
    }

    @Override
    public Department getByID(String id) {
        return iddao.getByID(Short.parseShort(id));
    }
    
    @Override
    public List<Department> search(String key) {
        return iddao.search(key);
    }

    @Override
    public String save(String id, String name, String managerID, String locationID) {
        String result = "Gagal";
        Department department = new Department();
        department.setId(Short.parseShort(id));
        department.setName(name);
        
        Employee employee = new Employee((managerID=="-")?null : Integer.parseInt(managerID));
        department.setManager(employee);
        
        Location location = new Location(Short.parseShort(locationID));
        department.setLocation(location);
        
        if(iddao.saveOrDelete(department, true)){
            result = "Berhasil";
            JOptionPane.showMessageDialog(null, result);
        }
        return result;
    }
    
    @Override
    public String delete(String id) {
        String result = "Gagal";
        Department department = new Department();
        department = iddao.getByID(Short.parseShort(id));
        department.setId(Short.parseShort(id));
        if(iddao.saveOrDelete(department, false)){
            result = "Berhasil";
            JOptionPane.showMessageDialog(null, result);
        }
        return result;
    }
}