package mar7.school;

import java.util.Scanner;

public class Admin {
    SuperDAO superDAO = new SuperDAO();

    public Admin() throws ClassNotFoundException {
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Student Login 2. Teacher Login 3. Exit");
            int choice = sc.nextInt();
            sc.nextLine();
            if (choice == 3) {
                System.out.println("프로그램 종료");
                return;
            } else if (choice == 1 || choice == 2) {
                System.out.println("ID 입력");
                String id = sc.nextLine();
                System.out.println("Password 입력");
                String pass = sc.nextLine();
                if (choice == 1) {
                    if (StudentDAO.login(id, pass)) {
                        studentMenu(id);
                    } else {
                        System.out.println("Invalid login");
                    }
                } else {
                    if (TeacherDAO.login(id, pass)) {
                        teacherMenu(id);
                    } else {
                        System.out.println("정보가 없습니다. \n회원가입하시겠습니까?");
                        System.out.println("1. Yes 2. No");
                        choice = sc.nextInt();
                        sc.nextLine();
                        if (choice == 1) {
                            addTeacher(id, pass);
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

    private void addTeacher(String id, String pass) {
        Scanner sc = new Scanner(System.in);
        System.out.println("이름 입력");
        String name = sc.nextLine();
        boolean gender = false;
        while (true) {
            System.out.println("성별 입력 1. 남자 2. 여자");
            int gen = sc.nextInt();
            if (gen == 1) {
                gender = true;
                break;
            } else if (gen == 2) {
                break;
            } else {
                System.out.println("다시 입력");
            }
        }
        System.out.println("반 입력");
        String className = sc.nextLine();
        System.out.println("과목 입력");
        String subject = sc.nextLine();
        System.out.println("직급 입력");
        String position = sc.nextLine();
        TeacherDTO teacherDTO = new TeacherDTO(id,pass,name,gender,className,subject,position);
        TeacherDAO.insert(teacherDTO);
    }

    private void studentMenu(String id) {
        System.out.println("학생은 조회만 가능합니다.");
        System.out.println("1. 학생 조회 2. 선생님 조회");
        Scanner sc = new Scanner(System.in);
        int cho = sc.nextInt();
        sc.nextLine();
        switch (cho) {
            case 1:
                StudentDAO.selectInfo(id);
                break;
            case 2:
                System.out.println("선생님 이름 입력");
                String tName = sc.nextLine();
                TeacherDAO.selectInfo(tName);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    private void teacherMenu(String id) {
        System.out.println("1. 등록 2. 조회 3. 수정&삭제");
        Scanner sc = new Scanner(System.in);
        int cho = sc.nextInt();
        sc.nextLine();
        switch (cho) {
            case 1:
                add();
                break;
            case 2:
                select();
                break;
            case 3:
                edit();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    private void add() {
        System.out.println("1. 학생 등록 2. 성적 입력");
        Scanner sc = new Scanner(System.in);
        int cho = sc.nextInt();
        sc.nextLine();
        switch (cho) {
            case 1:
                addStudent();
                break;
            case 2:
                addScore();
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    private void addScore() {
    }

    private void addStudent() {
    }

    private void select() {
        System.out.println("1. 학생 조회 2. 선생님 조회 3. 학생 전체 조회");
        Scanner sc = new Scanner(System.in);
        int cho = sc.nextInt();
        sc.nextLine();
        switch (cho) {
            case 1:
                System.out.println("학생 이름 입력");
                String sName = sc.nextLine();
                StudentDAO.selectInfo(sName);
                break;
            case 2:
                System.out.println("선생님 이름 입력");
                String tName = sc.nextLine();
                TeacherDAO.selectInfo(tName);
                break;
            case 3:
                StudentDAO.selectAll();
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    private void edit() {
        System.out.println("1. 학생 수정 2. 선생님 수정");
        Scanner sc = new Scanner(System.in);
        int cho = sc.nextInt();
        sc.nextLine();
        switch (cho) {
            case 1:
                System.out.println("학생 이름 입력");
                String sName = sc.nextLine();
                if (StudentDAO.selectsName(sName)) {
                    System.out.println("1. 수정 2. 삭제");
                    cho = sc.nextInt();
                    sc.nextLine();
                    switch (cho) {
                        case 1:
                            sChange(sName);
                            break;
                        case 2:
                            StudentDAO.delete(sName);
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                }
                break;
            case 2:
                System.out.println("선생님 이름 입력");
                String tName = sc.nextLine();
                if (TeacherDAO.selecttName(tName)) {
                    System.out.println("1. 수정 2. 삭제");
                    cho = sc.nextInt();
                    sc.nextLine();
                    switch (cho) {
                        case 1:
                            tChange(tName);
                            break;
                        case 2:
                            TeacherDAO.delete(tName);
                            break;
                        default:
                            System.out.println("Invalid choice");
                            break;
                    }
                }
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }
    }

    private void sChange(String sName) {
        System.out.println("수정할 부분 입력");
        System.out.println("1. 이름 2. 성별 3. 반 4. 번호");
        Scanner sc = new Scanner(System.in);
        int cho = sc.nextInt();
        sc.nextLine();
        System.out.println("수정할 내용 입력");
        String text = sc.nextLine();
        StudentDAO.update(cho, text, sName);
    }

    private void tChange(String sName) {
        System.out.println("수정할 부분 입력");
        System.out.println("1. 이름 2. 성별 3. 반 4. 과목 5. 직급");
        Scanner sc = new Scanner(System.in);
        int cho = sc.nextInt();
        sc.nextLine();
        System.out.println("수정할 내용 입력");
        String text = sc.nextLine();
        TeacherDAO.update(cho, text, sName);
    }


}

