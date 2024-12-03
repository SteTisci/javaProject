package models;

import java.util.List;
import java.util.Scanner;

public class Controller {

    private final Scanner scanner;
    private String input;

    public Controller() {
        this.scanner = new Scanner(System.in);
        this.input = "";
    }

    public void manage_school(School school) {
        System.out.println("\n" + school.get_schoolName() + " interface");

        // Ciclo principale del menu della scuola
        while (!input.equals("8")) {
            System.out.println(
                    "\n- Select one of the options below:\n" +
                            "1) Create classroom\n" +
                            "2) Remove classroom\n" +
                            "3) Manage classroom\n" +
                            "4) Show classrooms\n" +
                            "5) Student registration\n" +
                            "6) Student cancellation\n" +
                            "7) Show registered students\n" +
                            "8) Exit\n");
            input = scanner.nextLine();

            // Le liste vengono aggiornate ad ogni iterazione del ciclo while
            List<Classroom> schoolClassrooms = school.get_classrooms();
            List<Student> studentInSchool = school.get_school_students();

            switch (input) {
                case "1":
                    System.out.println("- Insert the course name:");
                    String className = scanner.nextLine();

                    // Creazione e aggiunta di una nuova aula
                    Classroom classroom = new Classroom(className);
                    school.add_classroom(classroom);
                    break;

                case "2":
                    System.out.println("- Classrooms:");
                    school.show_classrooms();
                    if (!schoolClassrooms.isEmpty()) {
                        System.out.println("\n- Select the class to remove:");
                        int classIndex = readInt();

                        // Verifica che l'indice sia valido
                        if (classIndex > 0 && classIndex <= schoolClassrooms.size()) {
                            Classroom selectedClass = schoolClassrooms.get(classIndex - 1);
                            school.remove_classroom(selectedClass);
                        } else {
                            System.out.println("Invalid choice.");
                        }
                    }
                    break;

                case "3":
                    System.out.println("- Classrooms:");
                    school.show_classrooms();

                    if (!schoolClassrooms.isEmpty()) {
                        System.out.println("\n- Select the class to manage:");
                        int classroomIndex = readInt();

                        // Gestione dell'aula selezionata
                        if (classroomIndex > 0 && classroomIndex <= schoolClassrooms.size()) {
                            Classroom classToManage = schoolClassrooms.get(classroomIndex - 1);

                            manage_classroom(classToManage, school);
                        } else {
                            System.out.println("Invalid choice.");
                        }
                    }
                    break;

                case "4":
                    System.out.println("- Classrooms:");
                    school.show_classrooms();
                    break;

                case "5":
                    System.out.println("- Insert student full name:");
                    String name = scanner.nextLine();

                    // Registrazione di un nuovo studente alla scuola
                    Student student = new Student(name);
                    school.add_student_to_school(student);
                    break;

                case "6":
                    System.out.println("- Students:");
                    school.show_students_names();

                    if (!studentInSchool.isEmpty()) {
                        System.out.println("\n- Select the student to remove:");
                        int index = readInt();

                        // Rimozione di uno studente dalla scuola
                        if (index > 0 && index <= studentInSchool.size()) {
                            Student StudentToRemove = studentInSchool.get(index - 1);
                            school.remove_student_from_school(StudentToRemove);
                        } else {
                            System.out.println("Invalid choice.");
                        }
                    }
                    break;

                case "7":
                    // Visualizzazione degli studenti registrati
                    System.out.println("- Registered students to " + school.get_schoolName() + ":");
                    school.show_school_students();
                    break;

                case "8":
                    // Uscita dal menu
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }

    private void manage_classroom(Classroom classroom, School school) {
        // Ciclo del menu per la gestione di una singola aula
        while (!input.equals("4")) {
            System.out.println(
                    "\n- " + classroom.get_className() + " class\n" +
                            "1) Add student\n" +
                            "2) Remove student\n" +
                            "3) Show students\n" +
                            "4) Go back\n");
            input = scanner.nextLine();

            // Le liste vengono aggiornate ad ogni iterazione del ciclo while
            List<Student> studentsinClass = classroom.get_students();
            List<Student> studentsInSchool = school.get_school_students();

            // Rimozione studente in classe se rimosso da studenti della scuola
            studentsinClass.removeIf(student -> !studentsInSchool.contains(student));

            switch (input) {
                case "1":
                    System.out.println("- Students:");
                    school.show_students_names();

                    if (!studentsInSchool.isEmpty()) {
                        System.out.println("\n- Select the student to add:");
                        int studentIndex = readInt();

                        // Aggiunta dello studente selezionato alla classe
                        if (studentIndex > 0 && studentIndex <= studentsInSchool.size()) {
                            Student studentToAdd = studentsInSchool.get(studentIndex - 1);
                            classroom.add_student(studentToAdd);
                            studentToAdd.add_course(classroom.get_className());
                        } else {
                            System.out.println("Invalid choice.");
                        }
                    }
                    break;

                case "2":
                    System.out.println("- Students:");
                    classroom.show_students();

                    if (!studentsinClass.isEmpty()) {
                        System.out.println("\n- Select the student to remove:");
                        int studentIndex = readInt();

                        // Rimozione dello studente selezionato dalla classe
                        if (studentIndex > 0 && studentIndex <= studentsinClass.size()) {
                            Student studentToRemove = studentsinClass.get(studentIndex - 1);
                            classroom.remove_student(studentToRemove);
                            studentToRemove.remove_course(classroom.get_className());
                        } else {
                            System.out.println("Invalid choice.");
                        }
                    }
                    break;

                case "3":
                    // Visualizzazione degli studenti della classe
                    System.out.println("- Students:");
                    classroom.show_students();
                    break;

                case "4":
                    System.out.println("- Returning to the previous menu...");
                    break;

                default:
                    System.out.println("Invalid choice, please try again.");
                    break;
            }
        }
    }

    // Metodo per leggere un intero con gestione degli errori
    private int readInt() {
        int value = -1;

        try {
            value = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid number.");
        }
        return value;
    }
}
