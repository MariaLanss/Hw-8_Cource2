package pro.sky.hw8;

import org.springframework.stereotype.Service;
import pro.sky.hw8.models.Employee;
import pro.sky.hw8.services.DepartmentService;
import pro.sky.hw8.services.EmployeeService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DepartmentsServiceImpl implements DepartmentService {
    private final EmployeeService employees;

    public DepartmentsServiceImpl(EmployeeService employees) {
        this.employees = employees;
    }

    @Override
    public Employee getMaxSalaryEmployee(int department) {
        return employees.index().values().stream()
                .filter(e -> e.getDepartment() == department)
                .max(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(DepartmentNotFoundException::new);
    }

    @Override
    public Employee getMinSalaryEmployee(int department) {
        return employees.index().values().stream()
                .filter(e -> e.getDepartment() == department)
                .min(Comparator.comparingInt(Employee::getSalary))
                .orElseThrow(DepartmentNotFoundException::new);
    }

    @Override
    public List<Employee> getAllEmployeesForDepartment(int department) {
        return employees.index().values().stream()
                .filter(e -> e.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> getEmployeesByDepartments() {
        return employees.index().values().stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
