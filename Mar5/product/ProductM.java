package Mar5.product;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductM {
    private ProductDAO productDAO;

    ProductM() throws ClassNotFoundException, SQLException {
        productDAO = ProductDAO.getInstance();
        while (true) {
            System.out.println("1. 등록 2. 조회 3. 수정 4. 종료");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    add();
                    break;
                case 2:
                    search();
                    break;
                case 3:
                    edit();
                    break;
                case 4:
                    System.out.println("시스템 종료");
                    return;
                default:
                    System.out.println("번호 오류");
                    break;
            }
        }
    }

    private void edit() throws SQLException {
        System.out.println("제품 이름 입력");
        Scanner sc = new Scanner(System.in);
        String name = "'%" + sc.next() + "%'";
        sc.nextLine();
        System.out.println(name);
        ArrayList<ProductDTO> productList = productDAO.select(2, name);
        for (ProductDTO product : productList) {
            product.prt();
        }
        System.out.println("수정할 제품 이름 입력");
        name = sc.nextLine();
        System.out.println("1. 수정 2. 삭제");
        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                change(name);
                break;
            case 2:
                productDAO.delete(name);
                break;
            default:
                System.out.println("이전 메뉴로 돌아갑니다.");
                break;
        }
    }


    private void change(String name) throws SQLException {
        System.out.println("수정할 부분 선택");
        System.out.println("1. 수량 2. 가격 3. 종류 4. 담당자 5. 설명");
        Scanner sc = new Scanner(System.in);
        int cho = sc.nextInt();
        sc.nextLine();
        System.out.println("수정할 내용 입력");
        String text = sc.nextLine();
        productDAO.change(cho, text, name);
    }

    private void search() throws SQLException {
        System.out.println("1. 전체보기 2. 종류로 검색 3. 부분 검색");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        sc.nextLine();
        ArrayList<ProductDTO> productList = null;
        switch (choice) {
            case 1:
                productList = productDAO.select(1, null);
                break;
            case 2:
                String type = productType();
                productList = productDAO.select(3, type);
                break;
            case 3:
                System.out.println("제품명 또는 제품설명 검색(부분검색 가능)");
                String name = "%" + sc.nextLine() + "%";
                productList = productDAO.select(2, name);
                break;
            default:
                System.out.println("이전 메뉴로 돌아갑니다.");
                return;
        }
        if (productList != null) {
            for (ProductDTO productDTO : productList) {
                productDTO.prt();
            }
        } else {
            System.out.println("찾을 수 없습니다.");
        }
    }

    private void add() throws SQLException {
        System.out.println("---ADD---");
        ProductDTO productDTO = new ProductDTO();
        Scanner sc = new Scanner(System.in);
        System.out.println("제품 이름");
        String name = sc.nextLine();
        System.out.println("제품 수량");
        String quantity = sc.nextLine();
        System.out.println("제품 가격");
        String price = sc.nextLine();
        String type = productType();
        System.out.println("제품 담당자");
        String manager = sc.nextLine();
        System.out.println("제품 설명");
        String description = sc.nextLine();
        String seq = productDAO.seq();
        String id = ProductDTO.hm + seq;
        System.out.println("제품 아이디= " + id);
        productDTO.setProductDTO(id, name, quantity, price, type, manager, description);
        productDAO.add(productDTO);
    }


    private String productType() {
        while (true) {
            System.out.println("제품 종류");
            Scanner sc = new Scanner(System.in);
            System.out.println("1. 생필품(a) 2. 가전류(b) 3. 스포츠(c) 4. 자동차(d)");
            int cho = sc.nextInt();
            sc.nextLine();
            switch (cho) {
                case 1:
                    return "a";
                case 2:
                    return "b";
                case 3:
                    return "c";
                case 4:
                    return "d";
                default:
                    System.out.println("다시 선택");
                    break;
            }
        }
    }

}
