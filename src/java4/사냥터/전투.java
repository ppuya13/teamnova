package java4.사냥터;

import static java4.Main.플레이어;
import static java4.사냥터.사냥터출력.*;
import static java4.캐릭터.캐릭터.공격여부;
import static java4.캐릭터.캐릭터.스킬여부;
import static java4.캐릭터.캐릭터.아이템여부;

public class 전투 extends Thread{
    사냥터출력 메소드용;
    boolean 보스전;
    boolean 전투승리;
    boolean 전투종료 = false;
    boolean 반복 = false;
    전투_몬스터창 몬스터창;
    전투_캐릭터창 캐릭터창;

    public 전투(사냥터출력 사냥터출력, boolean 보스전, 전투_몬스터창 전투_몬스터창, 전투_캐릭터창 전투_캐릭터창){
        this.메소드용=사냥터출력;
        this.보스전 = 보스전;
        this.몬스터창 = 전투_몬스터창;
        this.캐릭터창 = 전투_캐릭터창;
    }
    public void run(){
        while(true) {
            try {
                synchronized (this) {
                    this.wait();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (!스킬여부 && !공격여부 && !아이템여부 && 턴여부 && !전투메뉴) {
                switch (전투입력) {
                    case 1: //공격
                        공격여부 = true;
                        synchronized (플레이어) {
                            플레이어.notify();
                        }
                        if (턴여부) {
                            몬스터삭제 = true;
                            턴넘김 = true;
                        }
                        break;
                    case 2: //스킬
                        스킬여부 = true;
                        synchronized (플레이어) {
                            플레이어.notify();
                        }
                        break;
                    case 3: //아이템
                        아이템여부 = true;
                        synchronized (플레이어) {
                            플레이어.notify();
                        }
                        break;
                    case 4: //살펴보기
                        this.메소드용.살펴보기();
                        break;
                    case 5: //도망치기
                        if (!this.보스전) {
                            while (턴여부) {
                                System.out.println("" +
                                        "정말 도망치시겠습니까?" +
                                        "\n0.취소한다." +
                                        "\n1.도망친다.");
                                try {
                                    synchronized (this) {
                                        this.wait();
                                    }
                                } catch (InterruptedException e) {
                                    throw new RuntimeException(e);
                                }

                                if (턴여부) {
                                    switch (전투입력) {
                                        case 0:
                                            break;
                                        case 1:
                                            System.out.println("도망쳤습니다.");
                                            플레이어.사용중.clear();
                                            전투종료 = true;
                                            반복 = false;
                                            try {
                                                Thread.sleep(1000);
                                            } catch (InterruptedException e) {
                                                throw new RuntimeException(e);
                                            }
                                            break;
                                    }
                                }
                            }
                            break;
                        }
                        break;
                }
            }
            플레이어.능력치적용();

            //플레이어의 행동이 끝난 뒤
            try {
                메소드용.몬스터삭제(메소드용.몬스터삭제);
            } catch (InterruptedException | CloneNotSupportedException e) {
                throw new RuntimeException(e);
            }
            전투승리 = 메소드용.전투종료판정(몬스터어레이, 보스전);


            if (전투승리) {
                턴넘김 = false;
                전투종료 = true;
                플레이어.사용중.clear();
            }
            if (턴넘김) {
                플레이어.행동게이지 = 0;
                행동중 = false;
                synchronized (플레이어) {
                    try {
                        플레이어.턴넘김();
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    플레이어.notify();
//                        System.out.println(플레이어.getState());
                }
                try {
                    메소드용.몬스터삭제(몬스터삭제);
                } catch (InterruptedException | CloneNotSupportedException e) {
                    throw new RuntimeException(e);
                }
                턴넘김 = false;
//                    if (사망) {
//                        System.exit(0);
//                    }
            }
            if (전투종료) {//전투가 종료됐다면
                몬스터창.interrupt();
                캐릭터창.interrupt();
                try {
                    this.메소드용.전투정산(전투승리, 플레이어);
                } catch (InterruptedException | CloneNotSupportedException e) {
                    throw new RuntimeException(e);
                }
                반복 = true;
                전투승리 = false;
                전투종료 = false;
                전투 = false;
                return;
            }
            반복 = true;
//            전투메뉴=true;
        }
    }//run 종료

}
