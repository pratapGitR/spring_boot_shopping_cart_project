package org.example.sorting;

import org.example.sorting.Department;
import org.example.sorting.Employee;

import java.util.ArrayList;
import java.util.List;

public class SortingEmpAndDep {
    public static void main(String[] args) {

       Employee employee1 = new Employee(1,"pratap", 10000.00);
       Employee employee2 = new Employee(2,"sachin", 20000.00);
       Employee employee3 = new Employee(3,"rahul", 30000.00);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        System.out.println("Before "+employeeList);

        employeeList.sort((o1, o2) -> o2.empSalary.compareTo(o1.empSalary));
        System.out.println("After "+employeeList);

        Department department1 = new Department(1,"IT", "San Jose");
        Department department2 = new Department(2,"HR", "Dallas");
        Department department3 = new Department(3,"Sales", "Mumbai");

        List<Department> departmentList = new ArrayList<>();
        departmentList.add(department1);
        departmentList.add(department2);
        departmentList.add(department3);

        System.out.println("Before "+departmentList);
        departmentList.sort((o1, o2) -> o1.depLocation.compareTo(o2.depLocation));
        System.out.println("After "+departmentList);
    }
}

