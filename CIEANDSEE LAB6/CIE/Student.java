package CIE;
import SEE.Externals;
import java.util.Scanner;

public class Student {
    public String usn;
    public String name;
    public int sem;

    public void inputStudentDetails() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter USN: ");
        usn = sc.nextLine();
        System.out.print("Enter Name: ");
        name = sc.nextLine();
        System.out.print("Enter Semester: ");
        sem = sc.nextInt();
    }

    public void displayStudentDetails() {
        System.out.println("USN: " + usn);
        System.out.println("Name: " + name);
        System.out.println("Semester: " + sem);
    }

    public void calcFinalMarks(Internals cie, Externals see) {
        displayStudentDetails();
        System.out.println("Final Marks for 5 subjects:");
        for (int i = 0; i < 5; i++) {
            int finalMarks = cie.cieMarks[i] + (see.seeMarks[i] / 2);
            System.out.println("Subject " + (i + 1) + ": CIE = " + cie.cieMarks[i] +
                               ", SEE = " + see.seeMarks[i] +
                               ", Final = " + finalMarks);
        }
    }
}
