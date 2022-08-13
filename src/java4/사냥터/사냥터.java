package java4.사냥터;

import java4.사냥터.몬스터.고블린.고블린궁수;
import java4.사냥터.몬스터.고블린.고블린전사;
import java4.사냥터.몬스터.고블린.보물고블린;
import java4.사냥터.몬스터.몬스터;
import java4.사냥터.몬스터.슬라임.빨간슬라임;
import java4.사냥터.몬스터.슬라임.초록슬라임;
import java4.사냥터.몬스터.오크.오크전사;
import java4.사냥터.몬스터.오크.오크주술사;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import static java4.Main.메인;
import static java4.Main.플레이어;
import static java4.사냥터.사냥터.사냥터입력.사냥터입력값;

public class 사냥터{

    static ArrayList<몬스터> 몬스터어레이;
    static int 몬스터머릿수;
    static int 죽은몬스터수;
    public static boolean 사냥터; //사냥터 안에 있다면 true, 사냥터 밖이라면 false(입력받는 방식이 달라서 필요함)
    public static 사냥터입력 사냥터입력 = new 사냥터입력();
    public static 사냥터출력 사냥터출력 = new 사냥터출력();
    public static 전투 전투;
    public static boolean 전투중=false; //전투중일때만 전투관련 선택지가 출력되게 함


    public void 사냥터() throws InterruptedException {
        boolean 보스전;
        사냥터입력.start(); //일단 입력을 start함.(wait상태)
        전투.start(); //전투도 마찬가지
        while(true) {
            메인.능력치창();
            사냥터출력.사냥터메인();
            synchronized (사냥터입력) {
                사냥터입력.notify(); //입력을 깨움(입력받음)
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
                    this.전투(보스전);//전투메소드 실행
                    break;
                case 2: //인벤토리
                    break;
                case 3: //휴식
                    break;
                case 4: //보스전
                    전투중=true;
                    보스전=true;
                    플레이어.전투횟수++;
                    this.몬스터생성();//몬스터어레이 셋팅
                    this.전투(보스전);//전투메소드 실행
                    break;
            }
        }//while문 끝
    }


    public static class 사냥터입력 extends Thread{
        Scanner sc = new Scanner(System.in);
        public static int 사냥터입력값;
        public void run(){
            int 입력;

            while(true) {
                synchronized (this){//첫 시작시와 입력 한번 받은 뒤엔 무조건 기다림, 입력을 받고싶으면 깨워야함
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                while (사냥터) { //사냥터 안에 있을땐 입력을 받음
                    System.out.print("→");
                    입력 = sc.nextInt();
                    사냥터입력값 =입력;
                }
            }
        }
    }
    public void 몬스터생성() throws InterruptedException {
//        for(int i = 0 ; i < 몬스터어레이.size() ; i++){
//            몬스터어레이.get(i).interrupt();
//        }
        String 몬스터번호;
        double 몬스터생성난수;
        int num;
        String[] 몬스터종류배열 = {"슬라임","고블린","오크"};
        String 랜덤몬스터결과;
        Random rd = new Random();
        몬스터 몬스터정보;

        몬스터어레이.clear();
//        this.몬스터머릿수 = rd.nextInt(9) + 1;
        몬스터머릿수 = rd.nextInt(9) + 2;
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
    public void 전투(boolean 보스전){
        전투_몬스터창 몬스터창 = new 전투_몬스터창(몬스터어레이);
        전투_캐릭터창 캐릭터창 = new 전투_캐릭터창(플레이어);
        전투_행동게이지 전투_행동게이지 = new 전투_행동게이지();
        몬스터창.start();
        캐릭터창.start();
        전투_행동게이지.start();

        while(전투중){
            전투시작:
            while(true) {
                메인.능력치창();
                사냥터출력.몬스터목록();
                사냥터출력.사냥터행동(보스전);
                synchronized (사냥터입력) {
                    사냥터입력.notify();
                }
            }
        }

    }


}
