package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeQuestions {
   public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee(101,"Yashavanth", 80000, "Software"),
                new Employee(102,"Pavan", 50000, "Software"),
                new Employee(103,"Harshitha", 65000, "HR"),
                new Employee(104, "Priyanka", 30000, "IT")
        );
       System.out.println("All Employees");
       employees.forEach(System.out::println);

       System.out.println("***GreaterThan50000***");
       employees.stream().filter(e -> e.getSalary() > 50000).forEach(System.out::println);

       System.out.println("***Employees belongs to IT***");
       employees.stream().filter(e -> e.getDepartment().equals("IT")).forEach(System.out::println);

       System.out.println("***Employee with highest salary***");
       employees.stream().max(Comparator.comparingInt(Employee::getSalary)).ifPresent(System.out::println);

       System.out.println("***Employee with lowest salary***");
       employees.stream().min(Comparator.comparingInt(Employee::getSalary)).ifPresent(System.out::println);

       System.out.println("***Total Salary of All Employees***");
       int totalSalary = employees.stream().mapToInt(Employee::getSalary).sum();
       System.out.println("Total Salary: " + totalSalary);

       System.out.println("***Average Salary of All Employees***");
       double averageSalary = employees.stream().mapToInt(Employee::getSalary).average().orElse(0.0);
       System.out.println("Average Salary: " + averageSalary);

       System.out.println("***Count total number of employees***");
       Long totalCount = employees.stream().count();
       System.out.println("Total Count: " + totalCount);

       System.out.println("***Employees whose name starts with P");
       employees.stream().filter(e -> e.getName().startsWith("P")).forEach(System.out::println);

       employees.stream().sorted((e1, e2) -> e2.getSalary() - e1.getSalary()).skip(1).findFirst()
               .ifPresent(e -> System.out.println("Second highest salary employee: " + e));

       employees.stream().sorted((e1, e2) -> e2.getSalary() - e1.getSalary()).skip(1).findFirst()
               .ifPresent(e -> System.out.println("Second highest salary: " + e.getSalary()));

       System.out.println("***Highest Paid Employee in Each Dept***");
       employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
               Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))))
               .forEach((dept, emp) -> System.out.println(dept + " -> " + emp.orElse(null)));

       System.out.println("***Lowest Paid Employee in Each Dept***");
       employees.stream().collect(Collectors.groupingBy(Employee::getDepartment,
               Collectors.minBy(Comparator.comparingInt(Employee::getSalary))))
               .forEach((dept, emp) -> System.out.println(dept + " -> " + emp.orElse(null)));

       System.out.println("***Average Salary of Each Dept***");
       employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getSalary)))
                .forEach((dept, avgSalary) -> System.out.println(dept + " -> " + avgSalary));

       System.out.println("***Sum of Salary of Each Dept***");
       employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getSalary)))
               .forEach((dept, sum) -> System.out.println(dept + " -> " + sum));

       System.out.println("***Number of Employees in Each Dept***");
       employees.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()))
               .forEach((dept, count) -> System.out.println(dept + " -> " + count));

       System.out.println("***Employees Grouped By Dept***");
       employees.stream().collect(Collectors.groupingBy(Employee::getDepartment))
               .forEach((dept, empList) -> System.out.println(dept + "-> " + empList));

       System.out.println("***Sort in Ascending order***");
       employees.stream().sorted(Comparator.comparingInt(Employee::getSalary)).forEach(System.out::println);

       System.out.println("***Sort in Descending order***");
       employees.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed()).forEach(System.out::println);

       System.out.println("***Sort by Name***");
       employees.stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);

       System.out.println("***Sort by Dept and Salary***");
       employees.stream().sorted(Comparator.comparing(Employee::getDepartment).thenComparing(Employee::getSalary))
               .forEach(System.out::println);

       System.out.println("***Employees salary between 50000 and 80000***");
       employees.stream().sorted(Comparator.comparingInt(Employee::getSalary))
               .filter(e -> e.getSalary() > 50000 && e.getSalary() < 80000)
               .forEach(System.out::println);

       System.out.println("*** Top 3 highest paid Employees ***");
       employees.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed())
               .limit(3).forEach(System.out::println);

       System.out.println("*** Top 2 Highest paid Employees grouped by Department ***");
       employees.stream().sorted(Comparator.comparingInt(Employee::getSalary).reversed())
               .collect(Collectors.groupingBy(Employee::getDepartment))
               .forEach((dept, empList) -> System.out.println(dept + " -> " + empList.stream().limit(2).toList()));

       System.out.println("*** Employees having salary greater than average salary ***");
       double avgSalary = employees.stream().mapToInt(Employee::getSalary).average().orElse(0.0);
       employees.stream().filter(e -> e.getSalary() > avgSalary).forEach(System.out::println);

       System.out.println("*** Employees having salary greater than department average salary ***");
         Map<String, Double> avgSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getSalary)));
         employees.stream().filter(e -> e.getSalary() > avgSalaryByDept.get(e.getDepartment()))
                 .forEach(e -> System.out.println(e.getName()+" - "+e.getSalary()+"-"+e.getDepartment()));


    }

}

