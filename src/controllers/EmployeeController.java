/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import daos.EmployeeDAO;
import icontrollers.IEmployeeController;
import idaos.IEmployeeDAO;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import models.Department;
import models.Employee;
import models.Job;
import org.hibernate.SessionFactory;
/**
 *
 * @author ASUS
 */
public class EmployeeController implements IEmployeeController{

    private IEmployeeDAO iedao;
    
    public EmployeeController (SessionFactory factory){
        iedao = new EmployeeDAO(factory);
    }
    
    @Override
    public List<Employee> getAll() {
        return iedao.search("");
    }

    @Override
    public List<Employee> search(String key) {
        return iedao.search(key);
    }

    @Override
    public Employee getById(String id) {
        return iedao.getById(Integer.parseInt(id));
    }

    @Override
    public String save(String id, String firtName, String lastName, String email, String phone, String hireDate, String jobId, String salary, String commision, String managerId, String departmentId) {
        String result = "";
        Employee employee = new Employee();
        Job j = new Job(jobId);
        Department d = new Department(Short.parseShort(departmentId));
        Employee manager = new Employee(Integer.parseInt(managerId));
        BigDecimal sal = new BigDecimal(salary);
        BigDecimal com = new BigDecimal(commision);
        
        employee.setId(Integer.parseInt(id));
        employee.setFirstName(firtName);
        employee.setLastName(lastName);
        employee.setEmail(email);
        employee.setPhoneNumber(phone);
        
        try {
            Date date = new SimpleDateFormat("MM/dd/yyyy").parse(hireDate);
            employee.setHireDate(date);
        } catch (ParseException ex) {
            Logger.getLogger(EmployeeController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        employee.setJob(j);
        employee.setSalary(sal);
        employee.setCommissionPct(com);
        employee.setManager(manager);
        employee.setDepartment(d);
        if(iedao.saveOrDelete(employee, true)){
            result = "Proses Berhasil";
        }else{
            result = "Proses Gagal";
        }
        return result;
    }

    @Override
    public List<Employee> searchSalary(String key) {
        BigDecimal bd = new BigDecimal(key);
        return iedao.searchSalary(bd);
    }

    @Override
    public String delete(String id) {
        String result = "";
        Employee employee = new Employee(Integer.parseInt(id));
        employee = iedao.getById(Integer.parseInt(id));
        if(iedao.saveOrDelete(employee, false)){
            result = "Data Berhasil Dihapus";
        }else{
            result = "Data Gagal Dihapus";
        }
        return result;
    }
    
}
