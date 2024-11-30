package models;

import java.util.ArrayList;
import java.util.List;

public class School {

    private String schoolName;
    private List<Classroom> schoolClassrooms; // Lista delle classi della scuola
    private List<Student> schoolStudents; // Lista degli studenti iscritti alla scuola

    public School(String schoolName) {
        this.schoolName = schoolName;
        this.schoolClassrooms = new ArrayList<>();
        this.schoolStudents = new ArrayList<>();
    }

    // Aggiunge una classe alla lista della scuola
    public void add_classroom(Classroom classroom) {
        if (schoolClassrooms.add(classroom)) {
            System.out.println(classroom.get_className() + " classroom created");
        }
    }

    // Rimuove una classe dalla lista della scuola
    public void remove_classroom(Classroom classroom) {
        if (schoolClassrooms.remove(classroom)) {
            System.out.println(classroom.get_className() + " classroom removed");
        }
    }

    // Registra un nuovo studente nella scuola
    public void add_student_to_school(Student student) {
        if (schoolStudents.add(student)) {
            System.out.println("Student " + student.get_name() + " registered at " + get_schoolName());
        }
    }

    // Rimuove uno studente dalla scuola
    public void remove_student_from_school(Student student) {
        if (schoolStudents.remove(student)) {
            System.out.println("Student " + student.get_name() + " removed from " + get_schoolName());
        }
    }

    // Mostra la lista delle classi nella scuola
    public void show_classrooms() {
        if (schoolClassrooms.isEmpty()) {
            System.out.println("No classrooms present in the school");
        } else {
            int i = 0;
            for (Classroom classroom : schoolClassrooms) {
                System.out.println(++i + ") " + classroom.get_className() + " class");
            }
        }
    }

    // Mostra la lista degli studenti con i corsi a cui sono iscritti
    public void show_school_students() {
        if (schoolStudents.isEmpty()) {
            System.out.println("No students present in the school");
        } else {
            for (Student student : schoolStudents) {
                System.out.println("- " + student.get_name() + ", courses: " + student.get_courses());
            }
        }
    }

    // Mostra solo i nomi degli studenti registrati
    public void show_students_names() {
        if (schoolStudents.isEmpty()) {
            System.out.println("No students present in the school");
        } else {
            int i = 0;
            for (Student student : schoolStudents) {
                System.out.println(++i + ") " + student.get_name());
            }
        }
    }

    public String get_schoolName() {
        return schoolName;
    }

    public List<Classroom> get_classrooms() {
        return schoolClassrooms;
    }

    public List<Student> get_school_students() {
        return schoolStudents;
    }
}
