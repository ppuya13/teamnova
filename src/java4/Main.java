package java4;

import java4.사냥터.사냥터출력;
import java4.대장간.대장간출력;
import java4.상점.상점;
import java4.인벤토리.인벤토리출력;
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
        인벤토리출력 인벤토리출력 = new 인벤토리출력();
        사냥터출력 사냥터출력 = new 사냥터출력();
        대장간출력 대장간출력 = new 대장간출력();
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

           switch (입력) {
                case 0: //디버깅용
                    System.out.println("디버깅용");
                    break;
                case 1: //사냥터
                    사냥터출력.사냥터();
                    break;
                case 2: //인벤토리
                    인벤토리출력.인벤토리();
                    break;
                case 3: //상점
                    상점.상점();
                    break;
                case 4: //대장간
                    대장간출력.대장간();
                    break;
                case 5: //휴식
                    플레이어.휴식();
                    break;
            }
            if (사망) {
                System.out.println("플레이어는 쓰러졌다.");
                System.exit(0);
                break;
            }
        }
    }//psvm 닫힘
}//class 닫힘

//0806 피드백(손동오 파트장님)
//1.결말을 완성하기.
//2.발표에 커서 사용을 줄이기(난잡해 보일 수 있음)
//3.실수에 관한 걸 빠르게 넘어가려고 하는 것 고치기(이런 스타일을 유지하려고 한다면 실수를 많이 줄이기)
//4.발표준비 좀 더 하기(내가 준비한 발표가 상대방이 느끼기에 어땠는가 생각하기)

//결말 :
//1.보스몹을 준비하고 매우 낮은 확률로 등장하게 하기? 또는 선택해서 잡을 수 있게 하기
//2.져서 사망할 경우 처음으로 돌아오게 하기




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
