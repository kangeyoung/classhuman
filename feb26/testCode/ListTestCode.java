package feb26.testCode;

import java.util.ArrayList;

public class ListTestCode {
    public static void main(String[] args) {
        // List 테스트용
        ArrayList<String> a = new ArrayList<String>();
        // 추가하는 방법
        String name = "kim";
        a.add(name);
        System.out.println("사이즈: "+a.size());
        a.add("1234");
        System.out.println("사이즈: "+a.size());
        System.out.println(a.get(0));
        System.out.println(a.get(1));
        a.add(name);
        // 순서있고 전체 출력
        for(int i=0; i<a.size(); i++){
            System.out.println(i+" 인덱스 값: "+a.get(i));
        }
        // + 확장된 for로 작성
        for (String s: a){
            System.out.println(s);
        }
        // 삭제
        a.remove(1);
        for(int i=0; i<a.size(); i++){
            System.out.println(i+" 인덱스 값: "+a.get(i));
        }
        // 삽입, 0번 인덱스에 삽입하고 원래 데이터는 밀려남
        a.add(0,"park");
        System.out.println(a);
        // 수정
        a.set(1,"kbk");
        System.out.println(a);
        System.out.println("\uF0FE");
    }
}
