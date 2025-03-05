package Mar5;

public class Test {

    public void abc() { // 예외 떠넘기기
        System.out.println("a");
        int[] aa = new int[3];
        try { // 예외 직접처리
            System.out.println(aa[2]);
            //System.out.println(aa[4]);
            Test t = null;
            t.kkk();
        } catch (NullPointerException e) {
            System.out.println("NullPointer");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("ArrayIndexOutOfBounds");
        } catch(Exception e){
            System.out.println("예외");
        } finally {
            System.out.println("try 구문 종료");
        }
        System.out.println("b");
        System.out.println("c");
        kkk(); // <-여기로 예외를 떠넘김
    }

    public void kkk() { // 예외 떠넘기기
        System.out.println("kkk");
    }
}
