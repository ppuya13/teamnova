package java4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Main {//public:공공의(보안적인 부분 초보때는 신경쓰지 말고 public 쓰면 됨.), class:클래스, Main:클래스이름

    public static void main(String[] args) { //사용자가 입력한 코드를 실행한다 라는 의미의 클래스
        //ststic : 프로그램 시작 전에 먼저 실행하는 매서드. 기본적인 시스템 메서드를 선언할때 보통 사용한다.
        //void : 인자도 없고 리턴값도 없음

//        a.공격력 = 10;
//        a.방어력 = 55.5f;
//        a.이름 = "안연창";
//        선언자가 없을경우 이런식으로 일일히 해야함


//        마린.소지품.codePoints(); //소지품은 static으로 선언된 변수이므로 바로 사용할 수 있다.

        마린 a= new 마린(10, 55.5f, "안연창");
        마린 b= new 마린(99,33.5f, "김은호");


        System.out.println(a.이름);
        String 싸움결과 = a.공격("고블린");
        System.out.println(싸움결과);

        String c;
        String d;
        //배열로도 가능함

        String 아무문자열="섹스";

        System.out.println("\n");
        a.인자도없고리턴값도없음();
        a.인자만있는경우("");
        a.인자만있는경우(아무문자열);
        a.인자만있는경우("안녕!!");

        a.시스템비밀번호(); //리턴값만 있는 함수를 호출했기 때문에 "1234"만 남음
        System.out.println(a.시스템비밀번호()); //그러므로 따로 무언가를 해줘야함

        String 리턴값 = a.시스템비밀번호();
        System.out.println(리턴값); //또는 이런식으로도 쓸수있음


        System.out.println(a.sum(10,20)); //숫자 두개를 입력받아서 덧셈값을 리턴받는 메서드

        int 덧셈결과 = a.sum(10,20);
        System.out.println(덧셈결과); //또는 이런식으로 깔끔하게 쓸수도있음

//        String 랜덤값 = test.랜덤값();
//        System.out.println("랜덤값 : " + 랜덤값);
//        String 몬스터뽑은결과 = test.랜덤몬스터();

    }
}
