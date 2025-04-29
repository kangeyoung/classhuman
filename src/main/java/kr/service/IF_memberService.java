package kr.service;

import kr.VO.MemberVO;

public interface IF_memberService {
    // addUser는 회원가입 비지니스를 처리하기 위해 정의된 함수
    // 매개변수가 MemberVO 타입인 것은 컨트롤러가 회원의 정보를 넘겨줄 때 이를 받기 위한 것
    // 리턴타입이 void인 것은 데이터베이스 작업 결과를 컨트롤러에게 리턴할 필요가 없어서
    public void addUser(MemberVO membervo);
    // viewUser은 회원이 자기의 정보를 보기 기능을 처리하기 위해 정의한 함수
    // 매개변수가 String인 이유는 회원의 아이디로 검색하야만 비지니스를 처리할 수 있기 때문이다.
    // 리턴타입이 MemberVO인 것은 데이터베이스 작업 결과를 컨트롤러에게 리턴하고
    // 컨트롤러는 다시 뷰에게 리턴해서 클라이언트에게 보낼 화면을 만들기 위해서
    public MemberVO viewUser(String id);
}
