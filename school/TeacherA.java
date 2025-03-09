package school;

import lombok.Getter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

@Getter
public class TeacherA extends Admin {

    public TeacherA() throws ClassNotFoundException, SQLException {
    }

    public void menu() throws SQLException {
        while (true) {
            System.out.println("1. 학생 추가 2. 조회 3. 성적 입력 4. 정보 수정 5. 로그아웃");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    super.getStudentA().add();
                    break;
                case 2:
                    selectMenu();
                    break;
                case 3:
                    addE();
                    break;
                case 4:
                    edit();
                    break;
                case 5:
                    System.out.println("Logout 완료");
                    return;
                default:
                    System.out.println("Invalid number.");
            }
        }
    }

    private void edit() {
    }

    private void addE() {
        System.out.println("----성적 입력----");
        Scanner sc = new Scanner(System.in);
        System.out.println("학생 아이디 입력");
        String sId = sc.nextLine();

    }

    @Override
    public void selectMenu() throws SQLException {
        super.selectMenu();
        Scanner sc = new Scanner(System.in);
        System.out.println("선생님용 1. 학생 전체 조회 2. 반별 조회");
        int choice = sc.nextInt();
        sc.nextLine();
        ArrayList<StudentDTO> studentList = null;
        switch (choice) {
            case 1:
                studentList = super.getStudentDAO().select();
                break;
            case 2:
                System.out.println("반 입력");
                String className = sc.nextLine();
                studentList = super.getStudentDAO().select(2, className);
                break;
            default:
                System.out.println("Invalid number.");
                break;
        }
        if (studentList != null) {
            for (StudentDTO studentDTO : studentList) {
                studentDTO.prt();
            }
        }
    }

    public void addT(String id, String pass) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("---회원가입---");
        System.out.println("선생님 이름 입력");
        String tname = sc.nextLine();
        System.out.println("1. 남자 2. 여자");
        int choice = sc.nextInt();
        sc.nextLine();
        boolean flag = choice == 1;
        System.out.println("반 입력");
        String className = sc.nextLine();
        System.out.println("과목 입력");
        String subject = sc.nextLine();
        System.out.println("직책");
        String position = sc.nextLine();
        TeacherDTO teacherDTO = new TeacherDTO(id, pass, tname, flag, className, subject, position);
        super.getTeacherDAO().add(teacherDTO);
    }

    public boolean login(String id, String pass) throws SQLException {
        return super.getTeacherDAO().login(id, pass);
    }

    public void selectInfo() {

    }
}
