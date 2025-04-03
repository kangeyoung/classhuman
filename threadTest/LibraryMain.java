package threadTest;

import java.util.ArrayList;

class JavaLibrary {
    public ArrayList<String> arrayList = new ArrayList<>();

    public JavaLibrary() {
        arrayList.add("1");
        arrayList.add("2");
        arrayList.add("3");
    }

    public synchronized String study() throws InterruptedException {
        Thread t = Thread.currentThread();
        if(arrayList.isEmpty()){
            System.out.println(t.getName()+"wait start");
            wait();
            System.out.println(t.getName()+"wait end");
        }
        if(!arrayList.isEmpty()){
            String seat = arrayList.remove(0);
            System.out.println(t.getName()+" : "+seat);
            return seat;
        }
        return null;
    }

    public synchronized void returnSeat(String seat){
        Thread t = Thread.currentThread();
        arrayList.add(seat);
        notify();
        System.out.println(t.getName()+" : "+seat+" return");
    }
}

class Student extends Thread{
    @Override
    public void run() {
        try {
            String seatNum = LibraryMain.library.study();
            if(seatNum == null){
                return;
            }
            sleep(5000);
            LibraryMain.library.returnSeat(seatNum);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
public class LibraryMain{
    public static JavaLibrary library = new JavaLibrary();
    public static void main(String[] args) {
        Student student1 = new Student();
        Student student2 = new Student();
        Student student3 = new Student();
        Student student4 = new Student();
        Student student5 = new Student();
        Student student6 = new Student();

        student1.start();
        student2.start();
        student3.start();
        student4.start();
        student5.start();
        student6.start();
    }
}

