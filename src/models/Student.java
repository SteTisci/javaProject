package models;

import java.util.List;
import java.util.ArrayList;

public class Student {
    private String name;
    private List<String> courses; // Lista dei corsi a cui lo studente è iscritto

    public Student(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
    }

    // Aggiunge un corso alla lista dello studente se non già presente
    public void add_course(String courseName) {
        if (!courses.contains(courseName)) {
            courses.add(courseName);
            System.out.println(name + " added to the " + courseName + " course");
        }
    }

    // Rimuove un corso dalla lista dello studente se presente
    public void remove_course(String courseName) {
        if (courses.contains(courseName)) {
            courses.remove(courseName);
            System.out.println(name + " removed from the " + courseName + " course");
        }
    }

    public String get_name() {
        return name;
    }

    public List<String> get_courses() {
        return courses;
    }
}
