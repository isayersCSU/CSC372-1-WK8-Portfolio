import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;

public class StudentList {

    public static void main(String[] args) {
        // Load students from file
        LinkedList<Student> students =  new LinkedList<Student>();
        Scanner scanner = new Scanner(System.in);
        boolean addMore = true;

        while (addMore) {
            System.out.println("Enter Student Information:");
            System.out.print("Name: ");
            String name = scanner.nextLine();

            double gpa = getValidGPA(scanner);

            System.out.print("Address: ");
            String address = scanner.nextLine();

            Student student = new Student(gpa, name, address);
            students.add(student);

            // Display students
            System.out.println("\nCurrent Student List:");
            for (Student s : students) {
                System.out.println("Name: " + s.getName() + ", GPA: " + s.getGPA() + ", Address: " + s.getAddress());
            }

            // Write students to file
            saveStudentsToFile(students, "students.txt");

            System.out.print("Add another student? (yes/no): ");
            String response = scanner.nextLine();
            addMore = response.equalsIgnoreCase("yes");
        }

        scanner.close();
    }

    public static double getValidGPA(Scanner scanner) {
        double gpa;
        while (true) {
            System.out.print("GPA: ");
            try {
                gpa = scanner.nextDouble();
                scanner.nextLine();
                if (gpa >= 0.0 && gpa <= 4.0) {
                    return gpa;
                } else {
                    System.err.println("Invalid GPA. GPA must be between 0.00 and 4.00.");
                }
            } catch (InputMismatchException e) {
                System.err.println("Invalid input. Please enter a numerical value for GPA.");
                scanner.nextLine();
            }
        }
    }


    public static void saveStudentsToFile(LinkedList<Student> students, String filename) {
        try (FileWriter writer = new FileWriter(filename)) {
            for (Student s : students) {
                writer.write("Name: " + s.getName() + ", GPA: " + s.getGPA() + ", Address: " + s.getAddress() + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}