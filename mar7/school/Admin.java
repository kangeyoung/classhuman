package mar7.school;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.SQLException;
import java.util.Scanner;

@NoArgsConstructor
@Getter
public class Admin {
    private StudentA studentA;
    private TeacherA teacherA;
    @Setter
    private StudentDAO studentDAO;
    @Setter
    private TeacherDAO teacherDAO;



    public void login() throws SQLException, ClassNotFoundException {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Student Login 2. Teacher Login 3. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 3) {
                System.out.println("프로그램 종료");
                return;
            } else if (choice == 1 || choice == 2) {
                studentA = new StudentA();
                teacherA = new TeacherA();
                System.out.println("ID 입력");
                String id = sc.nextLine();
                System.out.println("Password 입력");
                String pass = sc.nextLine();
                if (choice == 1) {
                    if (studentA.login(id, pass)) {
                        studentA.menu();
                    } else {
                        System.out.println("Invalid login");
                    }
                } else {
                    if (teacherA.login(id, pass)) {
                        teacherA.menu();
                    } else {
                        System.out.println("정보가 없습니다. \n회원가입하시겠습니까?");
                        System.out.println("1. Yes 2. No");
                        choice = sc.nextInt();
                        sc.nextLine();
                        if (choice == 1) {
                            teacherA.addT(id, pass);
                        } else {
                            System.out.println("Invalid login");
                        }
                    }
                }
            } else {
                System.out.println("Invalid number");
            }
        }
    }

    public void selectMenu() throws SQLException {
        System.out.println("1. 학생 조회 2. 선생님 조회 Others. 선생님용");
        Scanner sc = new Scanner(System.in);
        int cho = sc.nextInt();
        sc.nextLine();
        switch (cho) {
            case 1:
                studentA.selectInfo();
                break;
            case 2:
                teacherA.selectInfo();
                break;
            default:
                break;
        }
    }
}

