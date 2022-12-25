import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                WorkingDirectory wd = new WorkingDirectory();
                BaseLine bl = new BaseLine();
                System.out.print("Folder Path : ");
                String path = sc.nextLine();
                System.out.println("\nChoose one of the options : ");
                System.out.println("1.Create a base file.");
                System.out.println("2.Check File Integrity.");
                System.out.print("\nEnter Your Choice -> ");
                int choice = sc.nextInt();
                if (choice == 1) {
                    System.out.println("\nCreating Base File...");
                    bl.BaseFileOrigin(path);
                    System.out.println("\nBase file Created.");
                } else if (choice == 2) {
                    System.out.println("\nChecking File Integrity...");
                    wd.CheckAlerts(path);
                } else {
                    System.out.println("\nEnter a valid option.\n");
                }
            } catch (Exception e) {
            }
        }
    }
}