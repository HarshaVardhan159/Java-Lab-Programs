package CIE;
import java.util.Scanner;

public class Internals extends Student {
    public int[] cieMarks = new int[5];

    public void inputCIEmarks() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter CIE marks for 5 subjects:");
        for (int i = 0; i < 5; i++) {
            System.out.print("Subject " + (i + 1) + ": ");
            cieMarks[i] = sc.nextInt();
        }
    }
}