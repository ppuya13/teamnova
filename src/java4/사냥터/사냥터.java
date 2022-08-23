package java4.사냥터;

import java4.사냥터.몬스터.고블린.*;
import java4.사냥터.몬스터.몬스터;
import java4.사냥터.몬스터.스킬.몬스터스킬;
import java4.사냥터.몬스터.슬라임.*;
import java4.사냥터.몬스터.오크.*;
import java4.스킬.지속피해.지속피해;
import java4.아이템.아이템;
import java4.인벤토리.인벤토리출력;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java.lang.Thread.sleep;
import static java4.Main.*;
import static java4.사냥터.사냥터.사냥터입력.사냥터입력값;
import static java4.캐릭터.캐릭터.*;

public class 사냥터 {

    public static ArrayList<몬스터> 몬스터어레이 = new ArrayList<>();
    static int 몬스터머릿수;
    static int 죽은몬스터수;
    public static boolean 사냥터; //사냥터 안에 있다면 true, 사냥터 밖이라면 false(입력받는 방식이 달라서 필요함)
    //    public static 사냥터입력 사냥터입력 = new 사냥터입력();
    public static 사냥터입력 사냥터입력 = new 사냥터입력();
    public static 사냥터출력 사냥터출력 = new 사냥터출력();
    //    public static 전투_행동게이지 전투_행동게이지;
//    public static 턴타이머 턴타이머;
    public static boolean 도망치기사용 = false;
    public static boolean 전투중=false; //전투중일때만 전투관련 선택지가 출력되게 함
    public static boolean 입력대기 = false;
    public static boolean 턴여부=false;
    public static boolean 행동중=false;
    public static boolean 보스전초전=false;
    public static boolean 보스전;
    public static boolean 전초전승리 =false;

    java4.인벤토리.인벤토리출력 인벤토리출력 = new 인벤토리출력();
    String 몬스터번호;
    double 몬스터생성난수;
    int num;
    String[] 몬스터종류배열 = {"슬라임","고블린","오크"};
    String 랜덤몬스터결과;
    Random rd = new Random();
    몬스터 몬스터정보;
    int 몬스터난수;
    ArrayList<아이템> 드랍템 = new ArrayList<>();
    아이템 드랍아이템;
    int 경험치허브;
    int 소지금허브;
    boolean 보스토벌;
    전투_몬스터창 몬스터창 = new 전투_몬스터창();
    전투_캐릭터창 캐릭터창 = new 전투_캐릭터창();
    public static 턴타이머 턴타이머 = new 턴타이머();


    public void 사냥터() throws InterruptedException, CloneNotSupportedException {

//        Thread.sleep(1000);
//        System.out.println("사냥터.사냥터()| 전투.getState(): "+전투.getState());
        while(true) {
//            System.out.println("사냥터.사냥터()|발동1");
            메인.능력치창();
            사냥터출력.사냥터메인();
            synchronized (사냥터입력) {
                사냥터입력.notify();
            }
            입력대기=true;
            while(입력대기){
                Thread.sleep(50);
            }
            switch (사냥터입력값) {
                case 0: //마을로 돌아가기
                    사냥터=false;
                    return;
                case 1: //몬스터 탐색(전투시작)
                    전투중=true;
                    보스전=false;
                    플레이어.전투횟수++;
                    this.몬스터생성();//몬스터어레이 셋팅
                    this.전투(보스전,보스전초전);//전투메소드 실행
                    break;
                case 2: //인벤토리
                    인벤토리출력.인벤토리();
                    break;
                case 3: //휴식
                    플레이어.휴식();
                    break;
                case 4: //보스전
                    사냥터출력.보스전확인();
                    synchronized (사냥터입력) {
                        사냥터입력.notify();
                    }
                    입력대기=true;
                    while(입력대기){
                        Thread.sleep(50);
                    }
                    switch (사냥터입력값) {
                        case 0:
                            break;
                        case 1:
                        전투중=true;
                        플레이어.전투횟수++;
                        보스전=false;
                        보스전초전=true;
                        this.보스전생성1();
                        this.전투(보스전,보스전초전);
                        보스전초전=false;

                        if(전초전승리) {
                            전투중=true;
                            플레이어.전투횟수++;
                            보스전 = true;
                            this.보스전생성2();
                            this.전투(보스전,보스전초전);
                            if (보스토벌) {//오크로드를 잡았다면
                                Thread.sleep(1000);
                                System.out.println("" +
                                        "\n사투 끝에 오크 로드는 쓰러졌고" +
                                        "\n마을의 평화는 지켜졌습니다.");
                                메인.엔딩();
                            }
                        }
                        break;
                    }
            }
        }//while문 끝
    }
    public static class 사냥터입력 extends Thread{
        Scanner sc = new Scanner(System.in);
        public static int 사냥터입력값;
        public void run(){
            while(true) {
                synchronized (this) {//첫 시작시나 사냥터에서 나올경우 기다림
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                while (사냥터) { //사냥터 안에 있을땐 입력을 받음
                    System.out.print("→");
                    사냥터입력값 = sc.nextInt();
                    입력대기 = false;
                    synchronized (this) {//입력을 받은 후엔 기다림
                        try {
                            this.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        }
    }
    public void 몬스터생성() throws InterruptedException {
//        for(int i = 0 ; i < 몬스터어레이.size() ; i++){
//            몬스터어레이.get(i).interrupt();
//        }


        몬스터어레이.clear();
        몬스터머릿수 = rd.nextInt(9) + 2;
//        몬스터머릿수 = rd.nextInt(4) + 2;
        System.out.println(몬스터머릿수 + "마리의 몬스터를 발견했다!!!");
        Thread.sleep(1000);

        for (int i = 1; i <= 몬스터머릿수; i++) {
            몬스터번호 = Integer.toString(i);
            몬스터생성난수 = Math.random();
            num = (int) Math.floor(몬스터생성난수 * 몬스터종류배열.length);
            랜덤몬스터결과 = 몬스터종류배열[num];
            if (랜덤몬스터결과.equals("슬라임")) {
                num = rd.nextInt(5) + 1;
                if (num <= 2) {
                    몬스터정보 = new 빨간슬라임(몬스터번호);
                } else {
                    몬스터정보 = new 초록슬라임(몬스터번호);
                }
            } else if (랜덤몬스터결과.equals("고블린")) {
                num = rd.nextInt(10) + 1; //1~10
                if (num <= 4) {
                    몬스터정보 = new 고블린궁수(몬스터번호);
                } else if (num <= 8) {
                    몬스터정보 = new 고블린전사(몬스터번호);
                } else {
                    몬스터정보 = new 보물고블린(몬스터번호);
                }
            } else{
//            } else if (랜덤몬스터결과.equals("오크")) {
                num = rd.nextInt(10) + 1; //1~10
                if(num<=4){
                    몬스터정보 = new 오크전사(몬스터번호);
                }else if(num<=8){
                    몬스터정보 = new 오크전사(몬스터번호);
                }else{
                    몬스터정보 = new 오크주술사(몬스터번호);
                }
            }
            몬스터어레이.add(몬스터정보);
        }
    }
    public void 보스전생성1() throws InterruptedException {
        for(int i = 0 ; i < 몬스터어레이.size() ; i++){
//            몬스터어레이.get(i).interrupt();
        }
        this.몬스터어레이.clear();
//        this.몬스터머릿수 = rd.nextInt(9) + 1;
        this.몬스터머릿수 = 8;
        System.out.println("오크 로드를 토벌하러 출발합니다.");
        Thread.sleep(1500);
        System.out.println("오크 로드의 병사가 나타났습니다!");
        Thread.sleep(1500);

        몬스터정보 = new 오크주술사(Integer.toString(1));
        this.몬스터어레이.add(몬스터정보);
        몬스터정보 = new 오크주술사(Integer.toString(2));
        this.몬스터어레이.add(몬스터정보);
        몬스터정보 = new 오크전사(Integer.toString(3));
        this.몬스터어레이.add(몬스터정보);
        몬스터정보 = new 오크전사(Integer.toString(4));
        this.몬스터어레이.add(몬스터정보);
        몬스터정보 = new 오크전사(Integer.toString(5));
        this.몬스터어레이.add(몬스터정보);
        몬스터정보 = new 오크전사(Integer.toString(6));
        this.몬스터어레이.add(몬스터정보);
        몬스터정보 = new 오크전사(Integer.toString(7));
        this.몬스터어레이.add(몬스터정보);
        몬스터정보 = new 오크전사(Integer.toString(8));
        this.몬스터어레이.add(몬스터정보);
    }
    public void 보스전생성2() throws InterruptedException {
        this.몬스터어레이.clear();
//        this.몬스터머릿수 = rd.nextInt(9) + 1;
        this.몬스터머릿수 = 6;
        Thread.sleep(1000);
        System.out.println("오크 로드의 병사를 모두 물리치자,");
        Thread.sleep(1500);
        System.out.println("오크 로드가 직접 병사들을 이끌고 나타났습니다!");
        Thread.sleep(1500);

        몬스터정보 = new 오크로드("");
        this.몬스터어레이.add(몬스터정보);
        몬스터정보 = new 오크주술사(Integer.toString(1));
        this.몬스터어레이.add(몬스터정보);
        몬스터정보 = new 오크주술사(Integer.toString(2));
        this.몬스터어레이.add(몬스터정보);
        몬스터정보 = new 오크전사(Integer.toString(3));
        this.몬스터어레이.add(몬스터정보);
        몬스터정보 = new 오크전사(Integer.toString(4));
        this.몬스터어레이.add(몬스터정보);
        몬스터정보 = new 오크전사(Integer.toString(5));
        this.몬스터어레이.add(몬스터정보);
    }
    public void 행동게이지() throws InterruptedException, CloneNotSupportedException {
        while (전투중 && !턴여부) {
//            System.out.println("턴여부: " + 턴여부 + " 행동중: "+ 행동중);
            if (플레이어.행동게이지 < 플레이어.행동) {
                플레이어.행동게이지 = 플레이어.행동게이지 + 플레이어.속도();
            }
            if (플레이어.행동게이지 > 플레이어.행동) {
                플레이어.행동게이지 = 플레이어.행동;
            }
            if(플레이어.행동게이지 == 플레이어.행동){
//                System.out.println("실행");
                턴타이머.타이머시작();
                턴여부 = true; //행게가 가득차면 턴을 on하고 기다림, 턴종료시 턴여부를 false하고 행게를 줄인뒤에 notify하기
            }
            if(플레이어.행동게이지<플레이어.행동) {
                for (int i = 0; i < 몬스터어레이.size(); i++) {
                    if (몬스터어레이.get(i).행동게이지 < 몬스터어레이.get(i).행동) {
                        몬스터어레이.get(i).행동게이지 = 몬스터어레이.get(i).행동게이지 + 몬스터어레이.get(i).속도();
//                        for(int j = 0 ; j < 몬스터어레이.get(i).지속딜.size() ; j++){
//                            몬스터어레이.get(i).지속딜.get(j).데미지적용();
//                        }
                    }
                    if (몬스터어레이.get(i).행동게이지 > 몬스터어레이.get(i).행동) {
                        몬스터어레이.get(i).행동게이지 = 몬스터어레이.get(i).행동;
                    }
                    if (몬스터어레이.get(i).행동게이지 == 몬스터어레이.get(i).행동) {
                        창갱신();
                        몬스터어레이.get(i).몬스터행동중=true;
                        몬스터어레이.get(i).몬스터행동(몬스터어레이, 몬스터머릿수 - 죽은몬스터수, 플레이어);
                        if(몬스터어레이.get(i).도망침) {
                            몬스터어레이.remove(i);
                            죽은몬스터수++;
//                            this.몬스터삭제(true);
                            Thread.sleep(500);
                            if(this.전투종료판정(몬스터어레이,보스전,보스전초전)){
                                전투중=false;
                                this.전투정산(true,플레이어);
                            }
                        }
                        else {
                            몬스터어레이.get(i).행동게이지 = 0;
                        }
                    }
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
            창갱신();
        }
    }
    public void 전투(boolean 보스전, boolean 보스전초전) throws InterruptedException, CloneNotSupportedException {
//        boolean 전투시작선택중;
        플레이어.행동게이지=10000; //전투 시작시 플레이어의 행동게이지
        창보이기();
//        타이머 타이머;
//        몬스터창 = new 전투_몬스터창(몬스터어레이);
//        캐릭터창 = new 전투_캐릭터창(플레이어);
//        전투_행동게이지 = new 전투_행동게이지();
//        몬스터창.start();
//        캐릭터창.start();
//        전투_행동게이지.start();

        while(전투중){
//            System.out.println("사냥터.전투| 전투중1: " + 전투중);
            this.행동게이지(); //플레이어가 턴을 잡은 상태가 아니라면 행동게이지를 계속 증가시킴
//            System.out.println("사냥터.전투()| 전투중: "+전투중 + ", 턴여부: " + 턴여부);
            전투시작:
            while(전투중&&턴여부) {
//                if(턴타이머 ==null) {
////                    System.out.println("사냥터.전투| 타이머null");
//                    턴타이머 = new 턴타이머();
//                    턴타이머.start();
////                    System.out.println("사냥터.전투| 타이머.getState: " + 타이머.getState());
//                }else if(!턴타이머.타이머진행중){
//                    턴타이머 = new 턴타이머();
//                    턴타이머.start();
////                    System.out.println("사냥터.전투| 타이머살아있음");
////                    System.out.println("사냥터.전투| 타이머.getState: " + 타이머.getState());
//                }


//                전투시작선택중=true;
                행동중=true;
                메인.능력치창();
                사냥터출력.몬스터목록();
                사냥터출력.사냥터행동(보스전);
                synchronized (사냥터입력) {
                    사냥터입력.notify();
                }
//                Thread.sleep(50);
                입력대기=true;
                while(입력대기){
                    Thread.sleep(50);
                }

//                if(전투중&&턴여부 && 전투시작선택중){//
                if(전투중&&턴여부&&행동중){//
                    switch (사냥터입력값){
                        case 1: //공격
                            행동중=true;
                            공격여부=true;
                            플레이어.행동();
                            break;
                        case 2: //스킬
                            행동중=true;
                            스킬여부=true;
                            플레이어.행동();
                            break;
                        case 3: //아이템
                            행동중=true;
                            아이템여부=true;
                            플레이어.행동();
                            break;
                        case 4: //살펴보기
                            행동중=true;
                            살펴보기여부=true;
                            플레이어.행동();
                            break;
                        case 5: //도망치기(보스전이 아닐때만)
                            행동중=true;
                            도망치기여부=true;
                            플레이어.행동();
                            break;
                    }
                }else{//전투중이 아니거나 턴이 아니면
                    break;
                }
            }
//            System.out.println("50ms 슬립");
            Thread.sleep(50);
        }
    }
    public void 몬스터삭제(boolean 몬스터삭제) throws InterruptedException, CloneNotSupportedException {
        while (몬스터삭제) {
//                    System.out.println("몬스터삭제 while문 시작");
//                    System.out.println(몬스터어레이.size());
            if(몬스터어레이.size()==0){ //몬스터어레이의 크기가 0이면 바로 나감
                몬스터삭제=false;
            }
            else{ //몬스터어레이의 크기가 0이 아니면 몬스터 삭제 시작
                for (int i = 0; i < 몬스터어레이.size(); i++) {//전체공격에 대응하기 위해 for문을 사용하여 체력이 0이 된 몬스터들을 한마리씩 찾아서 없앰
//                            System.out.println("몬스터어레이의 " + i + "번째 몬스터 이름 : " + 몬스터어레이.get(i).이름 + ", 체력 : " + 몬스터어레이.get(i).현재체력 + "어레이 길이 : " + 몬스터어레이.size());
//                                System.out.println("몬스터삭제 실행");
                    if (몬스터어레이.get(i).현재체력 <= 0) { //몬스터어레이에 체력이 0이하인 몬스터가 있으면
                        //이 아래에 몬스터가 죽었을 경우 일어나는 일을 코딩

                        //아이템 드랍 시작
                        for(int j = 0 ; j < 몬스터어레이.get(i).드랍테이블.size() ; j++){ //해당 몬스터의 드랍테이블의 사이즈만큼 반복
                            몬스터난수 = rd.nextInt(100); //0~99
//                                        System.out.println("난수 : " + 몬스터난수 + ", 드랍테이블의 드랍률 : "+몬스터어레이.get(i).드랍테이블.get(j).드랍률);
                            if(몬스터난수<몬스터어레이.get(i).드랍테이블.get(j).드랍률){ //드랍률이 10이면 0~9까지가 성공
                                System.out.println("" + 몬스터어레이.get(i).이름 + "이(가) 쓰러지며 " + 몬스터어레이.get(i).드랍테이블.get(j).아이템이름 + "을(를) 남겼다.");
                                드랍아이템 = (아이템)몬스터어레이.get(i).드랍테이블.get(j).clone(); //난수판정이 성공한 아이템과 동일한 아이템을 새로운 객체로 생성 //복제
                                드랍템.add(드랍아이템); //생성한 아이템을 드랍템 어레이에 넣음
                            }
                        }
                        //아이템 드랍 끝
                        플레이어.획득경험치=플레이어.획득경험치+경험치허브;
//                        System.out.println("사냥터.몬스터삭제| 플레이어.획득경험치 : " + 플레이어.획득경험치);
                        경험치허브 = 경험치허브 + 몬스터어레이.get(i).경험치;
                        소지금허브 = 소지금허브 + 몬스터어레이.get(i).소지금;
                        System.out.println(몬스터어레이.get(i).이름+"이(가)"+몬스터어레이.get(i).소지금+"골드를 떨어뜨렸다.");
                        System.out.println("전투 승리 시 받을 경험치가 " + 몬스터어레이.get(i).경험치 + " 늘어 " + 경험치허브 + "이(가) 되었다.");
                        Thread.sleep(1000);
                        System.out.println("");
//                        System.out.println("사냥터.몬스터삭제| 여기서 몬스터어레이 리무브함");
//                        몬스터어레이.get(i).interrupt();
                        몬스터어레이.remove(i); //몬스터어레이에서 몬스터를 삭제
//                        몹사망=true;
                        죽은몬스터수 = 죽은몬스터수 + 1; //전투종료를 위해 죽은몬스터수를 늘림(근데 그냥 전투종료 조건을 몬스터어레이가 0이면으로 바꾸는 것도 고려해보기)
                        break;
                    }
                    if(i==몬스터어레이.size()-1){ //몬스터어레이에 체력이 0이하인 몬스터가 없으면
//                                System.out.println("몬스터어레이와 i의 값이 같아졌으므로 몬스터삭제를 false로 함.");
                        몬스터삭제=false;
                    }
                }
            }
//            아이템정보 = null; //다른데서 쓰던 변수를 가져온거라 밖에서 널참조를 하면 에러가 날 수도 있으니 안에서 실행(선언도 안에서하고 안에서만 사용함)
        }
    }
    public boolean 전투종료판정(ArrayList<몬스터> 몬스터어레이, boolean 보스전, boolean 보스전초전){
        boolean 전투승리 = false;
        if(!보스전) {//보스전이 아닐경우 살아남은 몬스터가 0마리면 전투승리를 리턴함
            if (몬스터머릿수 - 죽은몬스터수 == 0) {
//            System.out.println("this.전투종료판정 | 전투승리 : " + 전투승리);
                for(int i = 0 ; i < 몬스터어레이.size() ; i++){
//                    몬스터어레이.get(i).interrupt();
                }
                몬스터어레이.clear();
                if(보스전초전){
                    전초전승리 =true;
                }
                몬스터머릿수 = 0;
                죽은몬스터수 = 0;
                플레이어.전투승리횟수++;
                return true;
            }
        }
        else{//보스전일경우 보스가 죽을 경우 전투승리를 리턴함
            for(int i = 0; i<몬스터어레이.size() ; i++){
                if(몬스터어레이.get(i).이름.equals("오크 로드")){//몬스터어레이에 이름이 오크 로드인 몬스터가 존재하면
//                    System.out.println("사냥터.전투종료판정 | 오크로드살아있음");
                    return false;
                }
            }
            //여기까지 왔다면 오크로드가 죽은거임
//            System.out.println("사냥터.전투종료판정 | 오크로드죽음");
            보스토벌=true;
            플레이어.전투승리횟수++;
            return true;
        }
        return 전투승리;
    }
    public void 전투정산(boolean 승리, java4.캐릭터.플레이어 플레이어) throws InterruptedException, CloneNotSupportedException { //만약 드랍템 어레이가 겹치게 바뀐다면 이것도 바꿔야함(안겹칠걸 전제로 스택이 있는 아이템들은 스택수가 1개씩 오르게 해놨음)
        창숨기기();
        ArrayList<아이템> 버린템 = new ArrayList<>();
        아이템 아이템;
        int 입력;
        Scanner sc = new Scanner(System.in);
        boolean 버림=false;
//        몬스터창.interrupt();
//        캐릭터창.interrupt();
        몬스터어레이.clear();
        플레이어.사용중.clear();
        if(승리) { //전투 승리 시에만 아이템 루팅이 가능함.
            System.out.println("전투에서 승리했습니다!");
            Thread.sleep(1000);
            재시작:
            while (true) {
//                System.out.println("정산 재시작 루프");
//                System.out.println("재시작 이후 인벤토리 크기 비교용 : " + this.소지품.size());
                if (드랍템.size() != 0) { //드랍템이 존재하면
//                    System.out.println("드랍템의 아이템이름 : "+드랍템.get(0).아이템이름 + ", 드랍템의 고유번호 : "+드랍템.get(0).고유번호);
                    for (int i = 0; i < 드랍템.size(); i++) { //드랍템의 개수만큼 반복
                        if (드랍템.get(i).고유번호 < 0) { //포션이면
                            for (int j = 0; j < 플레이어.회복물약가방.size(); j++) { //회복물약가방 사이즈만큼 반복
                                if (플레이어.회복물약가방.get(j).고유번호 == 드랍템.get(i).고유번호) {//그중에 아이템과 일치하는걸 찾아서 수치를 1올려줌
                                    System.out.println(드랍템.get(i).아이템이름 + "을(를) 획득했다!");
                                    플레이어.회복물약가방.get(j).스택수++;
                                    드랍템.remove(i);
                                    continue 재시작;
                                }
                            }
                        } else { //포션이 아니면
                            if (드랍템.get(i).스택가능여부) { //스택가능하면
                                for (int j = 0; j < 플레이어.소지품.size(); j++) { //소지품가방 사이즈만큼 반복
//                                    System.out.println("선택템의 아이템이름 : "+this.소지품.get(j).아이템이름 + ", 선택템의 고유번호 : "+this.소지품.get(j).고유번호);
                                    if (플레이어.소지품.get(j).고유번호 == 드랍템.get(i).고유번호) { //소지품창에 일치하는게 있으면 수치를 1올려줌
                                        System.out.println(드랍템.get(i).아이템이름 + "을(를) 획득했다!");
                                        플레이어.소지품.get(j).스택수++;
                                        드랍템.remove(i);
                                        continue 재시작;
                                    }
                                }
                            }
                            //여기에 도달했다는건 스택가능한 템이지만 소지품창에 일치하는게 없었다는 소리임.
                            if (플레이어.소지품.size() < 20) { //가진 소지품이 20종류 미만이면
                                아이템 = (아이템)드랍템.get(i).clone(); //복제
                                플레이어.소지품.add(아이템); //드랍템을 소지품에 추가함
                                System.out.println(드랍템.get(i).아이템이름 + "을(를) 획득했다!");
                            } else { //가진 소지품이 20종류 이상이면
                                버린템.add(드랍템.get(i)); //아이템을 버린템 어레이에 추가함
                                버림 = true;
                            }
                            드랍템.remove(i);
                            continue 재시작;
                        }
                    } //아이템드랍 for문 종료
//                    System.out.println("아이템정산(추가) 완료");
                    Thread.sleep(1000);
                } //아이템드랍 제일 밖 if문 종료
                else { //드랍템이 존재하지 않거나 정산이 끝났다면
                    if (버림) { //버린템이 존재한다면
                        for (int i = 0; i < 버린템.size(); i++) { //버린템의 개수만큼 반복
                            System.out.println("인벤토리가 부족해 " + 버린템.get(i).아이템이름 + "을(를) 들고갈 수 없다.");
                        }
                    }
                }
                Thread.sleep(1000);
                플레이어.소지금 = 플레이어.소지금+소지금허브;
                System.out.println("몬스터가 떨어뜨린 " + 소지금허브 + "골드를 주웠다!");
                break;
            } //아이템드랍 제일 밖 while문 종료
        }//승리판정 끝
        플레이어.캐릭터현재경험치 = 플레이어.캐릭터현재경험치+경험치허브;
        System.out.println("경험치가 " + 경험치허브 + " 올라 " + 플레이어.캐릭터현재경험치 + "이(가) 되었다!");
        경험치허브 = 0;
        Thread.sleep(1000);
        while(true){
//            System.out.println("경험치 while문 시작");
            if(플레이어.캐릭터현재경험치>=플레이어.캐릭터최대경험치){ //현재경험치가 최대경험치보다 많을경우
                플레이어.레벨업();
                System.out.print("" +
                        "계속하려면 아무 숫자나 입력하세요." +
                        "\n→");
                입력 = sc.nextInt();
            }
            else{
                break;
            }
        }
        플레이어.최종능력치적용();
    }
    public void 턴종료() throws InterruptedException, CloneNotSupportedException {
        플레이어.행동게이지=0;
        플레이어.능력치적용();
        플레이어.턴넘김();
        this.몬스터삭제(true);
        if(this.전투종료판정(몬스터어레이,보스전,보스전초전)){
            전투중=false;
            this.전투정산(true,플레이어);
        }
//        synchronized (전투_행동게이지){
//            전투_행동게이지.notify();
//        }
    }
    public class 전투_몬스터창{
        ArrayList<JLabel> 라벨리스트 = new ArrayList<>();
        JLabel 라벨;
        몬스터 타겟;
        몬스터스킬 스킬;
        지속피해 지속피해;
        JFrame 몬스터;

        public 전투_몬스터창(){

//        JLabel[] 라벨 = new JLabel[10];

            //레이아웃 설정
            몬스터 = new JFrame("몬스터");
//        몬스터.setBounds(800,600,800,몬스터어레이.size()*40+20);
            몬스터.setBounds(800,600,800,420);
            몬스터.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
            몬스터.setLayout(new GridLayout(10,1,10,3)); //행, 열, 좌우간격, 상하간격
//        몬스터.add(panel);
            몬스터.setAlwaysOnTop(true);
            몬스터.setVisible(false);//출력하기

            //처음 라벨 초기화(일회성)
            for (int i = 0; i < 10; i++) {
                라벨 = new JLabel("");
                라벨리스트.add(라벨);
                몬스터.add(라벨리스트.get(i));
            }
        }
        public void 갱신(){
            for (int i = 0; i < 10; i++) {
                라벨리스트.get(i).setText("");
            }
            for (int i = 0; i < 몬스터어레이.size(); i++) {
                타겟 = 몬스터어레이.get(i);
                라벨리스트.get(i).setText(타겟.이름 + " (체력:" + 타겟.현재체력 + "/" + 타겟.최대체력 + ") │ 공격력: " + 타겟.공격력 + "+" + 타겟.추가공격력 + " │ 방어력: " + 타겟.방어력 + "+" + 타겟.추가방어력 + " | 속도: " + 타겟.속도 + ", 행동게이지: " + (int) Math.ceil(타겟.행동게이지 / 100) + "%");
                if (타겟.지속스킬.size() > 0) {
                    라벨리스트.get(i).setText(라벨리스트.get(i).getText() + " 지속중: ");
                    for (int j = 0; j < 타겟.지속스킬.size(); j++) {
                        스킬 = 타겟.지속스킬.get(j);
                        라벨리스트.get(i).setText(라벨리스트.get(i).getText() + 스킬.스킬명 + "(" + (스킬.지속시간) + "턴) ");
                    }
                }
                if (타겟.지속딜.size() > 0) {
                    라벨리스트.get(i).setText(라벨리스트.get(i).getText() + " 상태이상: ");
                    for (int j = 0; j < 타겟.지속딜.size(); j++) {
                        지속피해 = 타겟.지속딜.get(j);
                        라벨리스트.get(i).setText(라벨리스트.get(i).getText() + 지속피해.이름 + "(" + (지속피해.지속시간/10) + "초) ");
                    }
                }
                라벨리스트.get(i).setText(라벨리스트.get(i).getText() + ")\n");
            }
        }
        public void 창숨기기(){
            몬스터.setVisible(false);//출력하기
        }
        public void 창보이기(){
            몬스터.setVisible(true);//출력하기
        }
    }
    public class 전투_캐릭터창{
        int 사용중사이즈;
        JLabel 라벨;
        JPanel 패널 = new JPanel();
        JLabel 라벨2;
        boolean 변경됨;
        JFrame 캐릭터;

        public 전투_캐릭터창(){

            //레이아웃 설정
            캐릭터 = new JFrame("캐릭터"); //인자는 창의 제목을 지정
            캐릭터.setBounds(800, 100, 300, 500); //창의 크기와 위치를 지정
            캐릭터.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); //창의 종료버튼이 동작하지 않게 설정함.
            캐릭터.setLayout(new GridLayout(0, 1, 10, 0)); //행, 열, 좌우간격, 상하간격
            캐릭터.setAlwaysOnTop(true); //창이 항상위로 가게 설정함.

            라벨 = new JLabel("<html>" +
                    "<br>┌──────────────────" +
                    "<br>│레벨: " + 플레이어.캐릭터레벨 + " (" + 플레이어.캐릭터현재경험치 + "/" + 플레이어.캐릭터최대경험치 + ")" +
                    "<br>│소지금: " + 플레이어.소지금 + "골드" +
                    "<br>│체력: " + 플레이어.캐릭터현재체력 + "/" + 플레이어.캐릭터최종체력 +
                    "<br>│마나: " + 플레이어.캐릭터현재마나 + "/" + 플레이어.캐릭터최종마나 +
                    "<br>│공격력: " + 플레이어.캐릭터공격력 + " +" + 플레이어.캐릭터추가공격력 +
                    "<br>│방어력: " + 플레이어.캐릭터방어력 + " +" + 플레이어.캐릭터추가방어력 +
                    "<br>│치명확률: " + (플레이어.캐릭터치명확률 + 플레이어.레벨업추가치확) + "% + " + 플레이어.캐릭터추가치확 + "%" +
                    "<br>│치명피해: " + (플레이어.캐릭터치명피해 + 플레이어.레벨업추가치피) + "% + " + 플레이어.캐릭터추가치피 + "%" +
                    "<br>│회피율: " + 플레이어.캐릭터회피 + "% + " + 플레이어.캐릭터추가회피 + "%" +
                    "<br>│속도: " + (플레이어.캐릭터속도 + 플레이어.레벨업추가속도) + " +" + 플레이어.캐릭터추가속도 +
                    "<br>└────────────────── " +
                    "<br>행동게이지 : " + (int) Math.ceil(플레이어.행동게이지 / 100) + "%" +
                    "</html>");
            라벨2 = new JLabel("" +
                    "<html>적용 중인 효과:" +
                    "<br> </html>");
            패널.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 10));
            패널.add(라벨2);
            변경됨 = true;
            사용중사이즈 = 플레이어.사용중.size();
            캐릭터.add(라벨);
            캐릭터.add(패널);
            캐릭터.setVisible(false); //출력하기
        }

        public void 갱신(){
            라벨.setText("<html>" +
                    "<br>┌──────────────────" +
                    "<br>│레벨: " + 플레이어.캐릭터레벨 + " (" + 플레이어.캐릭터현재경험치 + "/" + 플레이어.캐릭터최대경험치 + ")" +
                    "<br>│소지금: " + 플레이어.소지금 + "골드" +
                    "<br>│체력: " + 플레이어.캐릭터현재체력 + "/" + 플레이어.캐릭터최종체력 +
                    "<br>│마나: " + 플레이어.캐릭터현재마나 + "/" + 플레이어.캐릭터최종마나 +
                    "<br>│공격력: " + 플레이어.캐릭터공격력 + " +" + 플레이어.캐릭터추가공격력 +
                    "<br>│방어력: " + 플레이어.캐릭터방어력 + " +" + 플레이어.캐릭터추가방어력 +
                    "<br>│치명확률: " + (플레이어.캐릭터치명확률 + 플레이어.레벨업추가치확) + "% + " + 플레이어.캐릭터추가치확 + "%" +
                    "<br>│치명피해: " + (플레이어.캐릭터치명피해 + 플레이어.레벨업추가치피) + "% + " + 플레이어.캐릭터추가치피 + "%" +
                    "<br>│회피율: " + 플레이어.캐릭터회피 + "% + " + 플레이어.캐릭터추가회피 + "%" +
                    "<br>│속도: " + (플레이어.캐릭터속도 + 플레이어.레벨업추가속도) + " +" + 플레이어.캐릭터추가속도 +
                    "<br>└────────────────── " +
                    "<br>행동게이지 : " + (int) Math.ceil(플레이어.행동게이지 / 100) + "%" +
                    "</html>");
            if (사용중사이즈 != 플레이어.사용중.size()) {
                사용중사이즈 = 플레이어.사용중.size();
                변경됨 = true;
            }
            if (변경됨) {
                변경됨 = false;
                if (!(플레이어.사용중.size() == 0)) {
                    라벨2.setText("<html>" +
                            "적용 중인 효과: ");
                    for (int i = 0; i < 플레이어.사용중.size(); i++) {
//                        System.out.println("전투_캐릭터창 | 적용");
                        라벨2.setText(라벨2.getText() + "<br>" + 플레이어.사용중.get(i).아이템이름 + "(" + 플레이어.사용중.get(i).사용중 + ")");
//                        System.out.println(라벨2);
                    }
                }
            }
            라벨2.setText(라벨2.getText() + "</html>");

        }

        public void 창숨기기(){
            캐릭터.setVisible(false);//출력하기
        }
        public void 창보이기(){
            캐릭터.setVisible(true);//출력하기
        }
    }

    public void 창갱신(){
        몬스터창.갱신();
        캐릭터창.갱신();
    }
    public void 창보이기(){
        몬스터창.창보이기();
        캐릭터창.창보이기();
    }
    public void 창숨기기(){
        몬스터창.창숨기기();
        캐릭터창.창숨기기();
    }
}
