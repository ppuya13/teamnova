package java4;

import java4.사냥터.사냥터;
import java4.대장간.대장간;
import java4.상점.상점;
import java4.인벤토리.인벤토리;
import java4.캐릭터.캐릭터;
import java.util.Scanner;

public class Main {
    static public 캐릭터 플레이어 = new 캐릭터();

    public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {

        //캐릭터 초기화
        플레이어.인벤토리초기화();
        플레이어.스킬초기화();
        //캐릭터 초기화

        //상점 초기화
        상점 상점 = new 상점();//상점에 물건들을 진열하기 위한 코드
        //상점 초기화



        Scanner sc = new Scanner(System.in);
        int 입력 = -1; // 디폴트 입력값
        boolean 사망 = false;

        //출력변수
        출력 메인 = new 출력();
        인벤토리 인벤토리 = new 인벤토리();
        사냥터 사냥터 = new 사냥터();
        대장간 대장간 = new 대장간();
        //출력변수
        플레이어.최종능력치적용();


        마을:
        while (true) {

            System.out.println(메인.능력치창());
            System.out.print(
                    "\n이곳은 마을입니다. 무엇을 하시겠습니까?" +
                            "\n1.사냥터" +
                            "\n2.인벤토리" +
                            "\n3.상점" +
                            "\n4.대장간" +
                            "\n5.휴식" +
                            "\n→");

            입력 = sc.nextInt();

            //캐릭터 클래스 용도 나누기(super 사용해보기)
            //객체지향 재사용성에 대해 공부하기
            //그 밖에 과중한 업무를 맡고 있는 클래스가 있다면 조각내기
            //오버라이딩 알아보기
            //플레이어가 static이면 멀티쓰레딩에 안좋을 수 있으니 고려하기

            //현재 캐릭터 클래스의 용도
            //능력치관련
            //아이템관련(인벤토리)
            //아이템관련(상점)
            //스킬사용관련

            //개편 후
            //클래스 구조 예상
            //abstract 능력치(변수선언)
            //abstract 캐릭인벤토리(아이템 사용 등 인벤토리 동작들이 담긴 클래스)
            //abstract 캐릭터전투(스킬 사용, 공격 등 행동들이 담긴 클래스)
            //class 캐릭터
            //이후에 직업같은게 추가되면 캐릭터 대신 직업을 넣음

            //상점 관련 메소드는 전부 상점 클래스로 이동
            //아이템 메소드는 아이템 마다 클래스 생성
            //abstract 아이템(변수선언)
            //class 각각아이템

           switch (입력) {
                case 0: //디버깅용
                    System.out.println(플레이어.캐릭터공격력);
                    break;
                case 1: //사냥터
                    사냥터.사냥터();
                    break;
                case 2: //인벤토리
                    인벤토리.인벤토리();
                    break;
                case 3: //상점
                    상점.상점();
                    break;
                case 4: //대장간
                    대장간.대장간();
                    break;
                case 5: //휴식
                    플레이어.휴식();
                    break;
            }
            if (사망) {
                System.out.println("사망판정");
                System.exit(0);
                break;
            }
        }
    }//psvm 닫힘
}//class 닫힘