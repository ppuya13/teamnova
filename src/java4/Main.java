package java4;

import java4.출력.*;
import java4.스킬.스킬;
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

        상점 상점=new 상점();//상점에 물건들을 진열하기 위한 코드

        ArrayList<String> 상점판매개수 = new ArrayList<>();
        for(int i = 0 ; i<=상점.리스트.size()-1;i++){
            if(상점.리스트.get(i).상점판매여부) {
                상점판매개수.add(상점.리스트.get(i).아이템이름);
            }
        } //진열된 물건들의 종류가 몇 개인지 알기 위한 코드

        //상점 초기화

        //장면 제어 변수
        boolean 첫시작 = true;
        int 화면=1; //1:메인화면, 2:사냥터, 3:상점, 4:대장간, 5:전투
        int 세부1=0;
        int 세부2=0;
        boolean 패스 = false;
        int 상점구매=0; //상점창에서 뭘 선택했는지 들어감, 구매완료 또는 취소 후에 0으로 초기화
        boolean 상점구매확인1=false; //
        int 상점판매=0;
        boolean 상점판매확인1=false; //
        int 강화선택=0; //대장간에서 뭘 선택했는지 들어감, 강화 완료 또는 취소 후에 0으로 초기화
        boolean 강화확인=false;
        boolean 턴=false;
        boolean 사망=false;
        int 스택가능=0;
        int 구매개수=0;
        int 판매개수=0;
        int 개수=0;
        int 물약여부=0;
        아이템 아이템정보 = null;
        int 회복물약가방크기=0;
        int 인벤토리크기=0;
        int 전체가방크기=0;
        boolean 아이템사용=false;
        boolean 아이템버리기=false;
        int 사용선택=-1;
        boolean 살펴보기출력=false;
        StringBuilder 강화능력치표시 = new StringBuilder();

//        int 몬스터발견확률=3;
//        int 탐색결과=0;
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        int 입력 = -1; // 디폴트 입력값

        //몬스터변수
        String[] 몬스터종류배열 = {"슬라임","고블린","오크"};
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
        boolean 몬스터삭제=false;
        ArrayList<아이템> 드랍템 = new ArrayList<>();
        아이템 드랍아이템;
        int 몬스터난수;
        int 경험치허브 = 0;
        int 소지금허브 = 0;
        boolean 전투아이템사용=false;
        boolean 최종확인=false;
        int 스킬선택 = 0;
        boolean 스킬발동=false;
        int 스킬타겟=0;
        //전투변수

        //출력변수
        출력 메인 = new 출력();
        마을 마을 = new 마을();
        사냥터 사냥터 = new 사냥터();
        대장간 대장간 = new 대장간();
        boolean 사냥터반복;
        boolean 전투반복;
        boolean 전투행동반복;
        boolean 전투승리=false;
        boolean 전투종료=false;
        boolean 스킬반복=false;
        boolean 전투인벤토리반복=false;
        boolean 반복=false;
        boolean 전투여부=false;
        스킬 스킬;
        //출력변수

        캐릭터 플레이어2 = new 캐릭터();

        인벤토리크기= 플레이어.소지품.size();
        회복물약가방크기= 플레이어.회복물약가방.size();
        전체가방크기=인벤토리크기+회복물약가방크기;
        플레이어.최종능력치적용();

        while(true){

            System.out.println(메인.능력치창());
            System.out.print(
                    "\n이곳은 마을입니다. 무엇을 하시겠습니까?" +
                            "\n1.사냥터" +
                            "\n2.인벤토리" +
                            "\n3.상점" +
                            "\n4.대장간" +
                            "\n5.휴식" +
                            "\n→");

            if(!패스){
                패스=false;
                입력=sc.nextInt();
            }

            switch (입력){
                case 0: //디버깅용
                    System.out.println(플레이어.캐릭터공격력);
                    System.out.println(플레이어2.캐릭터공격력);
                    break;
                case 1: //사냥터
                    사냥터반복=true;
                    while(사냥터반복){
                        입력=-1;
                        System.out.println(메인.능력치창());
                        사냥터.사냥터메인();
                        입력=sc.nextInt();
                        switch (입력){
                            case 0: //나가기
                                사냥터반복=false;
                                break;
                            case 1: //탐색(전투시작)
                                전투반복=true;
                                사냥터.몬스터생성();
                                while(전투반복) {
                                    입력=-1;
                                    System.out.println(메인.능력치창());
                                    System.out.println(사냥터.몬스터목록());
                                    사냥터.사냥터행동();
                                    입력=sc.nextInt();
                                    switch (입력){
                                        case 1: //공격
                                            전투행동반복=true;
                                            while(전투행동반복){
                                                입력=-1;
                                                System.out.println(메인.능력치창());
                                                System.out.println("\n공격할 몬스터를 선택하세요.");
                                                System.out.print(사냥터.행동몬스터목록());
                                                System.out.print("\n→");
                                                입력=sc.nextInt();
                                                if(입력==0){
                                                    break;
                                                }else if(입력>0 && 입력<= 사냥터.몬스터머릿수-사냥터.죽은몬스터수){
                                                    몬스터타겟 = 사냥터.몬스터어레이.get(입력 -1);
                                                    플레이어.캐릭터공격(몬스터타겟);
                                                    몬스터삭제 = true;
                                                    턴=true;
                                                    전투행동반복=false;
                                                }
                                            }
                                            break;
                                        case 2: //스킬
                                            스킬반복=true;
                                            while(스킬반복) {
                                                System.out.println(메인.능력치창());
                                                System.out.println("\n보유 중인 스킬 리스트");
                                                System.out.println(메인.스킬창());
                                                System.out.print("" +
                                                        "사용할 스킬을 선택해주세요. " +
                                                        "\n→");
                                                입력 = sc.nextInt();
                                                if(입력==0){
                                                    break;
                                                }else if(입력>0 && 입력<=플레이어.스킬목록.size()){
                                                    몬스터타겟=사냥터.몬스터어레이.get(입력-1);
                                                    스킬=플레이어.스킬목록.get(입력-1);

                                                    switch (스킬.타입){
                                                        case 1:
                                                            플레이어.단일스킬(몬스터타겟, 스킬);
                                                            몬스터삭제 = true;
                                                            턴=true;
                                                            스킬반복=false;
                                                            break;
                                                        case 3:
                                                            플레이어.광역스킬(사냥터.몬스터어레이,스킬);
                                                            몬스터삭제 = true;
                                                            턴=true;
                                                            스킬반복=false;
                                                            break;
                                                    }
                                                }
                                            }
                                            break;
                                        case 3: //아이템
                                            반복=true;
                                            while(반복){
                                                System.out.println(메인.능력치창());
                                                System.out.println("\n아이템 사용하기");
                                                System.out.println(메인.행동인벤토리());
                                                System.out.print("" +
                                                        "아이템을 선택해주세요. " +
                                                        "\n소모품만을 사용할 수 있으며, 아이템 사용 시 턴을 넘기게됩니다." +
                                                        "\n→");
                                                입력 = sc.nextInt();
                                                if(입력==0){
                                                    break;
                                                } else if(입력>0 && 입력<=전체가방크기){
                                                    System.out.println("아이템사용시작");
                                                    플레이어.전투아이템사용(플레이어.아이템사용(입력),플레이어.아이템사용2(입력));
                                                    플레이어.소모템적용();
                                                    break;
                                                }
                                            }
                                            break;
                                        case 4: //살펴보기
                                        case 5: //도망치기
                                            System.out.println("도망쳤습니다.");
                                            플레이어.사용중.clear();
                                            전투종료=true;
                                            전투반복=false;
                                            Thread.sleep(1000);
                                            break;
                                    }
                                    if(턴){
                                        플레이어.소모템적용(); //소모템 지속시간도 여기서 감소시킴
                                    }
                                    플레이어.능력치적용();

                                    //플레이어의 행동이 끝난 뒤
                                    사냥터.몬스터삭제(몬스터삭제,몬스터타겟);
                                    전투승리 = 사냥터.전투종료판정();

                                    if(전투승리){
                                        턴=false;
                                        전투종료=true;
                                        플레이어.사용중.clear();
                                    }
                                    if(턴){
                                        턴=false;
                                    }
                                    if(전투종료){//전투가 종료됐다면
                                        사냥터.전투정산(전투승리, 플레이어);
                                        전투승리 = false;
                                        전투종료 = false;
                                        break;
                                    }
                                }
                                break;
                            case 2: //탐색 인벤토리
                            case 3: //휴식
                        }
                    }//사냥터 while문 끝
                    break;
                case 2: //인벤토리
                case 3: //상점
                case 4: //대장간
                case 5: //휴식
                    break;
            }
            if(사망) {
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





