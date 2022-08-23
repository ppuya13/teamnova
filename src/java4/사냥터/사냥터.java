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
//import static java4.사냥터.사냥터.사냥터입력.사냥터입력값;
import static java4.캐릭터.캐릭터.*;

public class 사냥터 {

    public static ArrayList<몬스터> 몬스터어레이 = new ArrayList<>();
    static int 몬스터머릿수;
    static int 죽은몬스터수;
    public static boolean 사냥터; //사냥터 안에 있다면 true, 사냥터 밖이라면 false(입력받는 방식이 달라서 필요함)
    //    public static 사냥터입력 사냥터입력 = new 사냥터입력();
//    public static 사냥터입력 사냥터입력 = new 사냥터입력();
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
    public static boolean 보스토벌;

    public static int 입력;
    public static 전투 전투;
    java4.인벤토리.인벤토리출력 인벤토리출력 = new 인벤토리출력();
    String 몬스터번호;
    double 몬스터생성난수;
    int num;
    String[] 몬스터종류배열 = {"슬라임","고블린","오크"};
    String 랜덤몬스터결과;
    Random rd = new Random();
    Scanner sc = new Scanner(System.in);
    몬스터 몬스터정보;

    public void 사냥터() throws InterruptedException, CloneNotSupportedException {

//        Thread.sleep(1000);
//        System.out.println("사냥터.사냥터()| 전투.getState(): "+전투.getState());
        while(true) {
//            System.out.println("사냥터.사냥터()|발동1");
            메인.능력치창();
            사냥터출력.사냥터메인();
//            synchronized (사냥터입력) {
//                사냥터입력.notify();
//            }
//            입력대기=true;
//            while(입력대기){
//                Thread.sleep(50);
//            }
            while(true) {
                입력 = sc.nextInt();
                if(입력>=0 && 입력<5){
                    break;
                }
            }
            switch (입력) {
                case 0: //마을로 돌아가기
                    사냥터=false;
                    return;
                case 1: //몬스터 탐색(전투시작)
                    전투중=true;
                    보스전=false;
                    플레이어.전투횟수++;
                    this.몬스터생성();//몬스터어레이 셋팅
                    전투 = new 전투(보스전,보스전초전);
                    전투.start();
                    while(전투중){
                        입력=sc.nextInt();
                        입력대기=false;
                    }
                    break;
                case 2: //인벤토리
                    인벤토리출력.인벤토리();
                    break;
                case 3: //휴식
                    플레이어.휴식();
                    break;
                case 4: //보스전
                    사냥터출력.보스전확인();
                    while(true) {
                        입력 = sc.nextInt();
                        if(입력>=0 && 입력<2){
                            break;
                        }
                    }
                    switch (입력) {
                        case 0:
                            break;
                        case 1:
                            전투중=true;
                            플레이어.전투횟수++;
                            보스전=false;
                            보스전초전=true;
                            this.보스전생성1();
                            전투 = new 전투(보스전,보스전초전);
                            전투.start();
                            while(전투중){
                                입력=sc.nextInt();
                                입력대기=false;
                            }

                            보스전초전=false;
                            if(전초전승리) {
                                전투중=true;
                                플레이어.전투횟수++;
                                보스전 = true;
                                this.보스전생성2();
                                전투 = new 전투(보스전,보스전초전);
                                전투.start();
                                while(전투중){
                                    입력=sc.nextInt();
                                    입력대기=false;
                                }
//                                this.전투(보스전,보스전초전);
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
    //    public static class 사냥터입력 extends Thread{
//        Scanner sc = new Scanner(System.in);
//        public static int 사냥터입력값;
//        public void run(){
//            while(true) {
//                synchronized (this) {//첫 시작시나 사냥터에서 나올경우 기다림
//                    try {
//                        this.wait();
//                    } catch (InterruptedException e) {
//                        throw new RuntimeException(e);
//                    }
//                }
//                while (사냥터) { //사냥터 안에 있을땐 입력을 받음
//                    System.out.print("→");
//                    사냥터입력값 = sc.nextInt();
//                    입력대기 = false;
//                    synchronized (this) {//입력을 받은 후엔 기다림
//                        try {
//                            this.wait();
//                        } catch (InterruptedException e) {
//                            throw new RuntimeException(e);
//                        }
//                    }
//                }
//            }
//        }
//    }
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
}
