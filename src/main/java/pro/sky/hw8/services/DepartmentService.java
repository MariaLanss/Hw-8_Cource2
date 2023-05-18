package pro.sky.hw8.services;

import pro.sky.hw8.models.Employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface DepartmentService {
    Employee getMaxSalaryEmployee(int department);

    Employee getMinSalaryEmployee(int department);

    List<Employee> getAllEmployeesForDepartment(int department);

    Map<Integer, List<Employee>> getEmployeesByDepartments();
}
