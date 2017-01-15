package com.springmvc.dao;

import com.springmvc.entities.Department;
import com.springmvc.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * Spring-MVC
 * <p>
 * Created by JasonTang on 1/12/2017 10:51 PM.
 */
@Repository
public class EmployeeDAO {

    private static Map<Integer, Employee> employees = null;

    @Autowired
    private DepartmentDAO departmentDAO;

    static {
        employees = new HashMap<>();

        employees.put(1001, new Employee(1001, "E-AA", "male", new Department(101, "D-AA")));
        employees.put(1002, new Employee(1002, "E-BB", "male", new Department(102, "D-BB")));
        employees.put(1003, new Employee(1003, "E-CC", "female", new Department(103, "D-CC")));
        employees.put(1004, new Employee(1004, "E-DD", "female", new Department(104, "D-DD")));
        employees.put(1005, new Employee(1005, "E-EE", "male", new Department(105, "D-EE")));
    }

    private static Integer initId = 1006;

    public void save(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId++);
        }

        employee.setDepartment(departmentDAO.getDepartment(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    public Collection<Employee> getAll(){
        return employees.values();
    }

    public Employee get(Integer id){
        return employees.get(id);
    }

    public void delete(Integer id){
        employees.remove(id);
    }
}
