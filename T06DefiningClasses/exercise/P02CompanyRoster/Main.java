package T06DefiningClasses.exercise.P02CompanyRoster;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int lines = Integer.parseInt(scan.nextLine());
        HashMap<String, Department> departments = new HashMap<>();
        while (lines-- > 0) {
            String[] tokens = scan.nextLine().split("\\s+");
            String name = tokens[0];
            double salary = Double.parseDouble(tokens[1]);
            String position = tokens[2];
            String department = tokens[3];
            Employee employee = new Employee(name, salary, position, department);
            if (tokens.length == 5) {
                try {
                    employee.setAge(Integer.parseInt(tokens[4]));
                } catch (Exception e) {
                    employee.setEmail(tokens[4]);
                }
            } else if (tokens.length == 6) {
                employee.setEmail(tokens[4]);
                employee.setAge(Integer.parseInt(tokens[5]));

            }
            departments.putIfAbsent(department, new Department(department));
            departments.get(department).getEmployees().add(employee);
        }

        Department maxAvgSalaryDept = departments.entrySet()
                .stream()
                .max(Comparator.comparingDouble(d -> d.getValue().getAvgSalary()))
                .get().getValue();
        System.out.printf("Highest Average Salary: %s\n", maxAvgSalaryDept.getDeptName());
        maxAvgSalaryDept.getEmployees().stream().sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(System.out::println);
    }
}
