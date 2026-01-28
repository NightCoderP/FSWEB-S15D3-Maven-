package org.example;

import org.example.entity.Employee;

import java.util.*;

public class Main {

    public static List<Employee> findDuplicates(List<Employee> employees) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        HashMap<Integer, Employee> firstSeen = new HashMap<>();

        for (Employee e : employees) {
            if (e == null) continue; 
            counts.put(e.getId(), counts.getOrDefault(e.getId(), 0) + 1);
            firstSeen.putIfAbsent(e.getId(), e);
        }

        List<Employee> duplicates = new LinkedList<>();

        Set<Integer> added = new HashSet<>();
        for (Employee e : employees) {
            if (e == null) continue;
            int id = e.getId();
            if (counts.getOrDefault(id, 0) > 1 && added.add(id)) {
                duplicates.add(firstSeen.get(id));
            }
        }

        return duplicates;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        HashMap<Integer, Employee> map = new HashMap<>();
        for (Employee e : employees) {
            if (e == null) continue; 

            map.putIfAbsent(e.getId(), e);
        }
        return map;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        HashMap<Integer, Integer> counts = new HashMap<>();
        for (Employee e : employees) {
            if (e == null) continue; 
            counts.put(e.getId(), counts.getOrDefault(e.getId(), 0) + 1);
        }

        List<Employee> singles = new LinkedList<>();
        for (Employee e : employees) {
            if (e == null) continue; 
            if (counts.get(e.getId()) == 1) {
                singles.add(e);
            }
        }
        return singles;
    }
}