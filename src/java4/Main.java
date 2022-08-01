package java4;

import java4.사냥터.몬스터;
import java4.사냥터.사냥터;
import java4.아이템.대장간;
import java4.아이템.상점;
import java4.아이템.아이템;
import java4.스킬.스킬;
import java4.캐릭터.인벤토리;
import java4.캐릭터.캐릭터;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


//1안 : 메인 메소드에 모든 메인 정보만 넣고 입력은 이곳에서 받기
//2안 : 처음시작할때만 이곳에서 입력을 받고 이후부터는 다른 클래스로 이동하여 반복하기
public class Main {
    static public 캐릭터 플레이어 = new 캐릭터();

    public static void main(String[] args) throws InterruptedException {

        //캐릭터 초기화

        플레이어.인벤토리초기화();
        플레이어.스킬초기화();

        //캐릭터 초기화

        //상점 초기화

        상점 상점 = new 상점();//상점에 물건들을 진열하기 위한 코드

        //상점 초기화
        int 상점구매 = 0; //상점창에서 뭘 선택했는지 들어감, 구매완료 또는 취소 후에 0으로 초기화
        boolean 상점구매확인1 = false; //
        int 상점판매 = 0;
        boolean 상점판매확인1 = false; //
        int 강화선택 = 0; //대장간에서 뭘 선택했는지 들어감, 강화 완료 또는 취소 후에 0으로 초기화
        boolean 강화확인 = false;
        boolean 턴 = false;
        boolean 사망 = false;
        int 스택가능 = 0;
        int 구매개수 = 0;
        int 판매개수 = 0;
        int 개수 = 0;
        int 물약여부 = 0;
        아이템 아이템정보 = null;
        boolean 아이템사용 = false;
        boolean 아이템버리기 = false;
        int 사용선택 = -1;
        boolean 살펴보기출력 = false;
        StringBuilder 강화능력치표시 = new StringBuilder();

//        int 몬스터발견확률=3;
//        int 탐색결과=0;
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        int 입력 = -1; // 디폴트 입력값

        //몬스터변수
        String[] 몬스터종류배열 = {"슬라임", "고블린", "오크"};
        double 몬스터생성난수;
        int num;
        String 랜덤몬스터결과;

        ArrayList<몬스터> 몬스터어레이 = new ArrayList<>();
        String 몬스터번호; // 각 몬스터마다 고유 번호
        몬스터 몬스터정보; // 몬스터의 이름과 능력치가 들어있음
        int 몬스터머릿수 = 0; // 몬스터 생성시 1~5까지 난수로 생성
        int 죽은몬스터수 = 0; // 몬스터 사망 시 1 상승
        //몬스터변수


        //전투변수
        몬스터 몬스터타겟 = null; //몬스터 삭제에 사용되기 때문에 절대 null을 참조하지 말 것
        boolean 몬스터삭제 = false;
        ArrayList<아이템> 드랍템 = new ArrayList<>();
        아이템 드랍아이템;
        int 몬스터난수;
        int 경험치허브 = 0;
        int 소지금허브 = 0;
        boolean 전투아이템사용 = false;
        boolean 최종확인 = false;
        int 스킬선택 = 0;
        boolean 스킬발동 = false;
        int 스킬타겟 = 0;
        //전투변수

        //출력변수
        출력 메인 = new 출력();
        인벤토리 인벤토리 = new 인벤토리();
        사냥터 사냥터 = new 사냥터();
        대장간 대장간 = new 대장간();
        //boolean 사냥터반복;
        //boolean 전투반복;
        //boolean 전투행동반복;
        boolean 전투승리 = false;
        boolean 전투종료 = false;
        boolean 스킬반복 = false;
        boolean 전투인벤토리반복 = false;
        boolean 반복 = false;
        boolean 전투여부 = false;
        스킬 스킬;
        //출력변수

        //상점변수
        int 타겟;
        //상점변수

        캐릭터 플레이어2 = new 캐릭터();

//        인벤토리크기= 플레이어.소지품.size();
//        회복물약가방크기= 플레이어.회복물약가방.size();
//        전체가방크기=인벤토리크기+회복물약가방크기;
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

            switch (입력) {
                case 0: //디버깅용
                    System.out.println(플레이어.캐릭터공격력);
                    System.out.println(플레이어2.캐릭터공격력);
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
                break;
            }
        }
    }//psvm 닫힘
}//class 닫힘
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//