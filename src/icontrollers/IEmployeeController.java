/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package icontrollers;

import java.util.Date;
import java.util.List;
import models.Department;
import models.Employee;
import models.Job;

/**
 *
 * @author ASUS
 */
public interface IEmployeeController {
    public List<Employee> getAll();
    public List<Employee> search(String key);
    public List<Employee> searchID(int key);
    public List<Employee> searchSalary(String key);
    public Employee getById(String id);
    public String save(String id, String firtName, String lastName, String email, String phone, String hireDate, String jobId, String salary, String commision, String managerId, String departmentId);
    public String delete(String id);
}
