package feb18.event;

import java.util.Scanner;

public class EventManager {
    Event[] eventList = new Event[10];
    Scanner in = new Scanner(System.in);
    String search;
    int adminCnt;

    EventManager() {
        System.out.println("---이벤트 관리 페이지---");
        while (true) {
            System.out.println("1. 이벤트 추가 2. 이벤트 확인 3. 이벤트 관리 4. 종료");
            int i = in.nextInt();
            in.nextLine();
            if (i == 1) {
                add();
            } else if (i == 2) {
                checkEvent();
            } else if (i == 3) {
                modifyEvent();
            } else if (i == 4) {
                break;
            } else {
                System.out.println("잘못 눌렀습니다. 메뉴를 다시 출력합니다.");
            }
        }
    }

    public String searchEvent() {
        System.out.println("------이벤트 검색------");
        System.out.println("검색할 이벤트 명을 입력해주세요 \n Enter를 누르면 상위 메뉴로 돌아갑니다.");
        String search = in.nextLine();
        if (search.isEmpty()) {
            return null;
        }
        Event result = search(search);
        System.out.println("-검색 결과- \n이벤트 이름: " + result.name + "|| 이벤트 설명: " + result.description);
        return search(search).name;
    }

    public Event search(String search) {
        for (int j = 0; j < eventList.length; j++) {
            if (search.equals(eventList[j].name)) {
                return eventList[j];
            }
        }
        return null;
    }

    public void modifyEvent() {
        search = searchEvent();
        String modify;
        String modifyD;
        if (search == null) {
            System.out.println("상위 메뉴로 돌아갑니다.");
        } else {
            System.out.println("------이벤트 수정------");
            System.out.print("1. 이벤트 수정 2. 이벤트 삭제 \n다른 번호를 누르면 상위 메뉴로 돌아갑니다.");
            int i = in.nextInt();
            in.nextLine();
            if (i == 1) {
                System.out.println("바꿀 이벤트 명을 알려주세요");
                modify = in.nextLine();
                System.out.println("바꿀 이벤트 설명을 알려주세요");
                modifyD = in.nextLine();
                modi(modify, modifyD);
                System.out.println("수정이 완료되었습니다.");
            } else if (i == 2) {
                modi(null, null);
                System.out.println("삭제가 완료되었습니다.");
            } else {
                searchEvent();
            }
            System.out.println("1번을 누르시면 수정된 이벤트 정보를 확인할 수 있습니다. \n다른 번호를 누르면 상위 메뉴로 돌아갑니다.");
            int s = in.nextInt();
            in.nextLine();
            if (s == 1) {
                checkEvent();
            }
        }
    }

    public void modi(String modify, String modifyD) {
        for (int j = 0; j < eventList.length; j++) {
            if (search.equals(eventList[j].name)) {
                eventList[j].name = modify;
                eventList[j].description = modifyD;
                break;
            }
        }
    }

    public void checkEvent() {
        System.out.println("---이벤트 확인(1번을 누르면 hide된 이벤트도 볼 수 있습니다.)---");
        int num = in.nextInt();
        in.nextLine();
        for (int i = 0; i < eventList.length; i++) {
            if (eventList[i] != null && eventList[i].name != null) {
                if (num != 1 && eventList[i].hide) {
                    continue;
                }
                System.out.print("이벤트 명: " + eventList[i].name);
                System.out.println(" || 이벤트 설명: " + eventList[i].description);
            }

        }
    }

    public boolean duplicateCheck(String search) {
        for (int j = 0; j < eventList.length; j++) {
            if (eventList[j] != null && search.equals(eventList[j].name)) {
                return true;
            }
        }
        return false;
    }

    private void add() {
        System.out.println("------이벤트 등록-------");
        System.out.println("이벤트 명을 입력해주세요");
        String name = in.nextLine();
        if (duplicateCheck(name)) {
            System.out.println("이벤트 명이 중복됩니다. \n 상위메뉴로 돌아갑니다.");
            return;
        }
        System.out.println("이벤트 설명을 입력해주세요");
        String description = in.nextLine();
        System.out.println("담당자 명을 입력해주세요");
        String adminName = in.nextLine();
        for (int i = 0; i < eventList.length; i++) {
            if (eventList[i] != null && adminName.equals(eventList[i].admin)) {
                adminCnt++;
            }
        }
        if (adminCnt > 2) {
            System.out.println("한 담당자는 2개까지만 이벤트를 담당할 수 있습니다. \n 상위메뉴로 돌아갑니다.");
            return;
        }
        System.out.println("1번을 누르면 이벤트를 숨길 수 있습니다.");
        int num = in.nextInt();
        in.nextLine();
        boolean hide;
        hide = num == 1;
        Event tempEvent = new Event(name, description, adminName, hide);
        for (int i = 0; i < eventList.length; i++) {
            if (eventList[i] == null) {
                eventList[i] = tempEvent;
                break;
            }
        }
    }
}
