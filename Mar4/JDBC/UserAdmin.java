package Mar4.JDBC;

import java.util.Scanner;

public class UserAdmin {
    private UserDAO userDAO = new UserDAO();

    UserAdmin() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.println("1. 등록 2. 전체보기");
            int a = sc.nextInt();
            sc.nextLine();
            switch (a) {
                case 1:
                    add();
                    break;
                case 2:
                    allList();
                    break;
                default:
                    flag = false;
                    break;
            }
        }
    }

    private void allList() {
    }

    private void add() {
        Scanner sc = new Scanner(System.in);
        System.out.println("name");
        String name = sc.nextLine();
        System.out.println("id");
        String id = sc.nextLine();
        UserDTO user = new UserDTO();
        user.setName(name);
        user.setId(id);
        userDAO.insert(user);
    }
}
