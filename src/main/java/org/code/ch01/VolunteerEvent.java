package org.code.ch01;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class VolunteerEvent {

    public static List<String> findStudentsWithIncompleteVolunteerEvents(List<String> students, Map<String, List<String>> attendeesMapping) {

        //create a counter [a map contains student name as a key and count number of appearances in attendees log as a value
        Map<String, Integer> studentEventCount = students.stream().collect(Collectors.toMap(student -> student, count -> 0));

        //count the student which had been logged in attendees map
        attendeesMapping.values()
                .forEach(list -> list.stream()
                        .filter(student -> studentEventCount.containsKey(student))
                        .forEach(student -> studentEventCount.put(student, studentEventCount.get(student) + 1)));


        // returns the students who didn't attend to events at least
        return studentEventCount.entrySet().stream()
                .filter(map -> map.getValue() < 2)
                .map(studentsWithIncompleteVolunteerEvents -> studentsWithIncompleteVolunteerEvents.getKey())
                .toList();
    }

    public static void main(String[] args) {
        List<String> students = List.of("Sally", "Polly", "Molly", "Tony", "Harry");

        Map<String, List<String>> attendeesMapping = Map.of(
                "Farmer's Market", List.of("Sally", "Polly"),
                "Car Wash Fundraiser", List.of("Molly", "Tony", "Polly"),
                "Cooking Workshop", List.of("Sally", "Molly", "Polly"),
                "Midnight Breakfast", List.of("Polly", "Molly"));

        System.out.println(findStudentsWithIncompleteVolunteerEvents(
                students, attendeesMapping));
    }
}
