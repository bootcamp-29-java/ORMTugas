package idaos;

import java.util.List;
import models.Department;

public interface IDepartmentDAO {
    public List<Department> searchID(int key);
    public Department getByID(Short id);
    public List<Department> search(String key);
    public boolean saveOrDelete(Department department, boolean isSave);
}
