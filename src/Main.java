import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException{

        WorkingDirectory wd = new WorkingDirectory();
        BaseLine bl = new BaseLine();
        System.out.print("Folder Path : ");
        String path = sc.nextLine();
        System.out.println("Choose one of the options : ");
        System.out.println("1.Create a base file");
        System.out.println("2.Check File Integrity");
        System.out.print("Your Choice : ");
        int choice = sc.nextInt();
        if(choice == 1){System.out.println("Creating Base File...");bl.BaseFileOrigin(path);System.out.println("Base file Created.");}
        else if(choice == 2){System.out.println("Checking File Integrity...");wd.CheckAlerts(path);}
        else{System.out.println("Enter a valid option.");}

    }
}