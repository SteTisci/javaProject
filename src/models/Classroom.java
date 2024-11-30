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
        if (students.size() < 10) {
            students.add(student);
        } else {
            System.out.println("\nThe classroom is full");
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
            System.out.println("\nThe classroom is empty");
        } else {
            System.out.println("\n- Students present in " + className + " class:");
            for (Student student : students) {
                System.out.println(++i + ") " + student.get_name());
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
