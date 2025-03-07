package mar4.book;

import java.util.ArrayList;
import java.util.Scanner;

public class Manage {
    private BookDAO bookDAO = new BookDAO();
    private UserDAO userDAO = new UserDAO();
    Manage() {
        while (true) {
            System.out.println("1. 등록 2. 대여 3. 반납 4. 종료");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    plus();
                    break;
                case 3:
                    minus();
                    break;
                case 4:
                    return;
                default:
                    break;
            }
        }
    }

    private void minus() {
        System.out.println("---반납---");
        System.out.println("이름 입력");
        Scanner sc = new Scanner(System.in);
        String uname = sc.nextLine();
        int result = userDAO.searchuname(uname);
        if (result == 1) {
            ArrayList<Book> bookList = bookDAO.selectAll();
            for (Book book : bookList) {
                System.out.println(book.getBname());
            }
            System.out.println("책 이름 입력");
            String bname = sc.nextLine();
            Book book = new Book();
            book.setUname(uname);
            book.setBname(bname);
            bookDAO.delete(book);
        }
    }

    private void plus() {
        System.out.println("---대출---");
        System.out.println("이름 입력");
        Scanner sc = new Scanner(System.in);
        String uname = sc.nextLine();
        int result = userDAO.searchuname(uname);
        if (result == 1) {
            System.out.println("책 이름 입력");
            String bname = sc.nextLine();
            System.out.println("날짜 입력");
            String bdate = sc.nextLine();
            Book book = new Book();
            book.setUname(uname);
            book.setBname(bname);
            book.setBdate(bdate);
            bookDAO.insert(book);
        }

    }

    private void add() {
        System.out.println("이름 입력");
        Scanner sc = new Scanner(System.in);
        String uname = sc.nextLine();
        System.out.println("아이디 입력");
        String uide = sc.nextLine();
        int bnum = 0;
        User user = new User();
        user.setUname(uname);
        user.setUide(uide);
        user.setBnum(bnum);
        userDAO.insert(user);
    }
}
