package mar7.school;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("Enter = Start");
        Scanner sc = new Scanner(System.in);
        sc.nextLine();
        Admin admin = new Admin();
        admin.login();
    }
}
