package org.example;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Practice_Programs {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 2, 4, 6);

        numbers.stream().filter(n -> n % 2 == 0).forEach(System.out::println);

        List<Integer> evenList =  numbers.stream().filter(n -> n % 2 == 0).toList();
        System.out.println("even list:" + evenList);

        Optional<Integer> sum = numbers.stream().reduce((a, b) -> a + b);
        System.out.println("Sum: " + sum.orElse(0));

        int sum1 = numbers.stream().reduce(0, Integer::sum);
        System.out.println("Sum1: " + sum1);

        Optional<Integer> max = numbers.stream().max(Integer::compareTo);
        System.out.println("Max: " + max.orElse(0));

        Optional<Integer> min = numbers.stream().min((a, b) -> a.compareTo(b));
        System.out.println("Min: " + min.orElse(0));

        List<Integer> nums = Arrays.asList(1, 2, 3, 5, 6, 7, 8, 9, 10);
        int number = 10;
        int expectedSum = number * (number + 1) / 2;
        int actualSum = nums.stream().reduce(0, Integer::sum);
        int missingNumber = expectedSum - actualSum;
        System.out.println("Missing Number: " + missingNumber);

        Optional<Integer> secondMax = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        System.out.println("secondMax: " + secondMax.orElse(0));

        System.out.println("Remove Duplicates");
        List<Integer> removeDuplicate = numbers.stream().distinct().toList();
        removeDuplicate.forEach(System.out::println);

        System.out.println("Print Duplicates");
        Set<Integer> seen = new HashSet<>();
        numbers.stream().filter(n -> !seen.add(n)).forEach(System.out::println);

        Set<Integer> seen1 = new HashSet<>();
        boolean hasDuplicates = numbers.stream().anyMatch(n -> !seen1.add(n));
        System.out.println("Contains Duplicates: " + hasDuplicates);

        System.out.println("Partition into odd and even");
        Map<Boolean, List<Integer>> partitioned = numbers.stream()
                .collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Even Numbers: " + partitioned.get(true));
        System.out.println("Odd Numbers: " + partitioned.get(false));

        List<Integer> top3 = numbers.stream()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .toList();
        System.out.println("Top 3 numbers: " + top3);

        List<Integer> top3Distinct = numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .limit(3)
                .toList();
        System.out.println("Top 3 Distinct Numbers: " + top3Distinct);

        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        List<Integer> list2 = Arrays.asList(4, 5, 6, 7, 8, 9);

        List<Integer> commonElements = list1.stream()
                .filter(list2::contains)
                .toList();
        System.out.println("Common Elements: " + commonElements);

        List<Integer> mergedList = Stream.concat(list1.stream(), list2.stream())
                .distinct()
                .toList();
        System.out.println("Merged List (no duplicates): " + mergedList);


        List<String> names = Arrays.asList("yashavanth", "pavan", "harshitha", "Priyanka", "Ankith", "Anjali");

        names.stream().map(name -> name.toUpperCase()).forEach(System.out::println);

        List<String> upperNames = names.stream().map(String::toUpperCase).toList();
        System.out.println("upperNames: " + upperNames);

        System.out.println("Length of each element in an array");
        names.stream().map(s -> s.length()).forEach(System.out::println);

        System.out.println("Element starts with A");
        names.stream().filter(s -> s.startsWith("A")).forEach(System.out::println);

        Long count = names.stream().filter(s -> s.startsWith("A")).count();
        System.out.println("Count of Element starts with A: " + count);

        Optional<String> longest = names.stream().max(Comparator.comparingInt(String::length));
        System.out.println("Longest String: " + longest.orElse(""));

        String s = " ";
        Predicate<String> isEmpty = m -> m.length() == 0;
        System.out.println(isEmpty.test(s));

        Predicate<String> isBlank = m -> m.trim().length() == 0;
        System.out.println(isBlank.test(s));

        String sentence = "hello world welcome to java programming";

        Function<String, Integer> wordsCount = w -> w.split(" ").length;
        System.out.println("wordsCount is: " + wordsCount.apply(sentence));

        Function<String, Integer> wordsCountStream = w -> (int) Arrays.stream(w.split(" ")).count();
        System.out.println("wordsCountStream is: " + wordsCountStream.apply(sentence));

        String reversed = new StringBuilder(sentence).reverse().toString();
        System.out.println("Reversed sentence: " + reversed);

        String reverseEachWord = Arrays.stream(sentence.split(" "))
                .map(word -> new StringBuilder(word).reverse().toString()).collect(Collectors.joining(" "));
        System.out.println("Reverse each word: " + reverseEachWord);

        Map<Character, Long> frequency = sentence.chars()
                .filter(c -> c != ' ')
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, Collectors.counting()));
        System.out.println("Frequency of Letters: " + frequency);

        List<Employee> employees = Arrays.asList(
                new Employee(101,"Yashavanth", 80000, "Software"),
                new Employee(102,"Pavan", 50000, "Software"),
                new Employee(103,"Harshitha", 65000, "HR"),
                new Employee(104, "Priyanka", 30000, "IT")
        );
        List<Employee> sorted = employees.stream().sorted((o1, o2) -> o1.getSalary() - o2.getSalary()).toList();
        System.out.println("Sorted Employees: " + sorted);

        List<Employee> sortedAsc = employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary))
                .toList();
        sortedAsc.forEach(System.out::println);

        List<Employee> sortedReverse = employees.stream().sorted((o1, o2) -> o2.getSalary() - o1.getSalary()).toList();
        System.out.println("Sorted Employees Reverse: " + sortedReverse);

        System.out.println("Sorted Employees Reverse: ");

        List<Employee> sortedDesc = employees.stream()
                .sorted(Comparator.comparingInt(Employee::getSalary)
                        .reversed())
                .toList();
        sortedDesc.forEach(System.out::println);

        System.out.println("***GreaterThan50000***");
        List<Employee> greaterThan50000 = employees.stream()
                .filter(e -> e.getSalary() > 50000)
                .toList();
        greaterThan50000.forEach(System.out::println);

        Optional<Employee> highestPaid = employees.stream()
                .max(Comparator.comparingInt(Employee::getSalary));
        System.out.println("Highest Paid Employee: " + highestPaid.orElse(null));

        System.out.println("***SortByDept***");
        List<Employee> sortByDept = employees.stream()
                .sorted(Comparator.comparing(Employee::getDepartment))
                .toList();
        sortByDept.forEach(System.out::println);

        System.out.println("***GroupByDept***");
        Map<String, List<Employee>> groupByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        groupByDept.forEach((dept, empList) -> {
            System.out.println(dept + " -> " + empList);
        });

        System.out.println("***TotalSalaryByDept***");
        Map<String, Integer> totalSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.summingInt(Employee::getSalary)));
        System.out.println("Total Salary by Department: " + totalSalaryByDept);

        System.out.println("***AverageSalaryByDept***");
        Map<String, Double> averageSalaryByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingInt(Employee::getSalary)));
        System.out.println("Total Salary by Department: " + averageSalaryByDept);

        System.out.println("***HighestPaidSalaryByDept***");
        Map<String, Optional<Employee>> highestPaidByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.maxBy(Comparator.comparingInt(Employee::getSalary))));
        System.out.println("Highest Paid by Department: " + highestPaidByDept);

        System.out.println("***CountEmployeesByDept***");
        Map<String, Long> countEmployeesByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("Count Employees by Department: " + countEmployeesByDept);
    }
}
