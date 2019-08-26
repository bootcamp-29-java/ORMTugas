package icontrollers;

import java.util.List;
import models.Department;

public interface IDepartmentController {
    public List<Department> searchID(int id);
    public Department getByID(String id);
    public List<Department> search(String key);
    public String save(String id, String name, String managerID, String locationID);
    public String delete(String id);
}
