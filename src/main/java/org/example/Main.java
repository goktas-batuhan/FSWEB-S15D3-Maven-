package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {

    public static List<Employee> findDuplicates(List<Employee> employees) {
        List<Employee> duplicates = new LinkedList<>();
        if (employees == null) {
            return duplicates;
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (Employee employee : employees) {
            if (employee != null) {
                countMap.put(employee.getId(), countMap.getOrDefault(employee.getId(), 0) + 1);
            }
        }

        Set<Integer> addedIds = new HashSet<>();
        for (Employee employee : employees) {
            if (employee != null && countMap.get(employee.getId()) > 1 && !addedIds.contains(employee.getId())) {
                duplicates.add(employee);
                addedIds.add(employee.getId());
            }
        }

        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Integer, Employee> uniques = new HashMap<>();
        if (employees == null) {
            return uniques;
        }

        for (Employee employee : employees) {
            if (employee != null) {
                uniques.put(employee.getId(), employee);
            }
        }

        return uniques;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        List<Employee> result = new LinkedList<>();
        if (employees == null) {
            return result;
        }

        Map<Integer, Integer> countMap = new HashMap<>();
        for (Employee employee : employees) {
            if (employee != null) {
                countMap.put(employee.getId(), countMap.getOrDefault(employee.getId(), 0) + 1);
            }
        }

        for (Employee employee : employees) {
            if (employee != null && countMap.get(employee.getId()) == 1) {
                result.add(employee);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(4, "Burak", "Cevizli"));
        employees.add(null);

        System.out.println("Duplicates: " + findDuplicates(employees));
        System.out.println("Uniques: " + findUniques(employees));
        System.out.println("Removed Duplicates: " + removeDuplicates(employees));
    }
}