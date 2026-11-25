import java.util.Scanner;

class Student {

    private int studentId;
    private String name;
    private String department;
    private int subject1, subject2, subject3;

    Student(int studentId, String name, String department) {
        this.studentId = studentId;
        this.name = name;
        this.department = department;
    }

    public void enterMarks(int s1, int s2, int s3) {
        subject1 = s1;
        subject2 = s2;
        subject3 = s3;
    }

    public int calculateTotal() {
        return subject1 + subject2 + subject3;
    }

    public double calculateAverage() {
        return calculateTotal() / 3.0;
    }

    public String calculateGrade() {
        double avg = calculateAverage();

        if (avg >= 90)
            return "A+";
        else if (avg >= 80)
            return "A";
        else if (avg >= 70)
            return "B";
        else if (avg >= 60)
            return "C";
        else if (avg >= 50)
            return "D";
        else
            return "Fail";
    }

    public String calculateResult() {
        if (calculateGrade().equals("Fail"))
            return "FAIL";
        else
            return "PASS";
    }

    public void displayStudent() {
        System.out.println("\n===== STUDENT REPORT =====");
        System.out.println("Student ID : " + studentId);
        System.out.println("Name       : " + name);
        System.out.println("Department : " + department);
        System.out.println("Total Marks: " + calculateTotal());
        System.out.println("Average    : " + calculateAverage());
        System.out.println("Grade      : " + calculateGrade());
        System.out.println("Result     : " + calculateResult());
    }
}

public class StudentManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Student student = null;
        int choice;

        do {
            System.out.println("\n===== STUDENT MANAGEMENT SYSTEM =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display Student");
            System.out.println("3. Enter Marks");
            System.out.println("4. Calculate Total");
            System.out.println("5. Calculate Average");
            System.out.println("6. Calculate Grade");
            System.out.println("7. Pass/Fail");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Department: ");
                    String department = sc.nextLine();

                    student = new Student(id, name, department);
                    System.out.println("Student added successfully!");
                    break;

                case 2:
                    if (student != null)
                        student.displayStudent();
                    else
                        System.out.println("Add student first.");
                    break;

                case 3:
                    if (student != null) {
                        System.out.print("Enter Subject 1 Marks: ");
                        int s1 = sc.nextInt();

                        System.out.print("Enter Subject 2 Marks: ");
                        int s2 = sc.nextInt();

                        System.out.print("Enter Subject 3 Marks: ");
                        int s3 = sc.nextInt();

                        student.enterMarks(s1, s2, s3);
                        System.out.println("Marks entered successfully!");
                    } else {
                        System.out.println("Add student first.");
                    }
                    break;

                case 4:
                    if (student != null)
                        System.out.println("Total: " + student.calculateTotal());
                    else
                        System.out.println("Add student first.");
                    break;

                case 5:
                    if (student != null)
                        System.out.println("Average: " + student.calculateAverage());
                    else
                        System.out.println("Add student first.");
                    break;

                case 6:
                    if (student != null)
                        System.out.println("Grade: " + student.calculateGrade());
                    else
                        System.out.println("Add student first.");
                    break;

                case 7:
                    if (student != null)
                        System.out.println("Result: " + student.calculateResult());
                    else
                        System.out.println("Add student first.");
                    break;

                case 8:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 8);

        sc.close();
    }
}
