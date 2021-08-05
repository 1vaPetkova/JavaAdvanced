package T06DefiningClasses.exercise.P02CompanyRoster;

import java.util.ArrayList;
import java.util.List;

public class Department {
    private String deptName;
    private List<Employee> employees;


    public Department(String deptName) {
        this.deptName = deptName;
        this.employees = new ArrayList<>();
    }


    public double getAvgSalary() {
        return this.employees.stream().mapToDouble(Employee::getSalary).average().orElse(0.0);
    }

    public String getDeptName() {
        return deptName;
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
