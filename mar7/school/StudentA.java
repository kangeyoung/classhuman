package mar7.school;

import lombok.Getter;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

@Getter
public class StudentA extends Admin{

    public StudentA() throws ClassNotFoundException, SQLException {

    }

    public void menu() throws SQLException {
        System.out.println("학생은 조회만 가능합니다.");
        super.selectMenu();
    }

    public boolean login(String id, String pass) throws SQLException, ClassNotFoundException {
        super.setStudentDAO(new StudentDAO());
        return super.getStudentDAO().login(id,pass);
    }

    public void add() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("학생 아이디 입력");
        String sid = sc.nextLine();
        System.out.println("학생 비밀번호 입력");
        String spass = sc.nextLine();
        System.out.println("학생 이름 입력");
        String sname = sc.nextLine();
        System.out.println("1. 남자 2. 여자");
        int choice = sc.nextInt();
        sc.nextLine();
        boolean flag = choice == 1;
        System.out.println("학생 반 입력");
        String className = sc.nextLine();
        System.out.println("학생 번호 입력");
        String snum = sc.nextLine();
        StudentDTO studentDTO = new StudentDTO(sid,spass,sname,flag,className,snum);
        super.getStudentDAO().add(studentDTO);
    }

    public void selectInfo() throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("학생 이름 입력");
        String sName = sc.nextLine();
        ArrayList<StudentDTO> studentList = super.getStudentDAO().select(1,sName);
        for (StudentDTO studentDTO : studentList) {
            studentDTO.prt();
        }
    }
}