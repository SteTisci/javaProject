package models;

import java.util.ArrayList;
import java.util.List;

public class Classroom {
    private List<Student> students;
    private String className;

    public Classroom(String className) {
        this.students = new ArrayList<>();
        this.className = className;
    }

    // Aggiunge uno studente alla classe, verificando il limite massimo di 10
    public void add_student(Student student) {
        if (students.size() < 10 && !students.contains(student)) {
            students.add(student);
        } else if (students.contains(student)) {
            System.out.println("The student " + student.get_name() + " is already present in the classroom.");
        } else {
            System.out.println("The classroom is full.");
        }
    }

    // Rimuove uno studente dalla classe se presente nella lista
    public void remove_student(Student student) {
        if (students.contains(student)) {
            students.remove(student);
        }
    }

    // Mostra gli studenti della classe con un indice numerato
    public void show_students() {
        int i = 0;

        if (students.isEmpty()) {
            System.out.println("The classroom is empty.");
        } else {
            for (Student student : students) {
                System.out.println(++i + ". " + student.get_name());
            }
        }
    }

    public String get_className() {
        return className;
    }

    public List<Student> get_students() {
        return students;
    }
}
