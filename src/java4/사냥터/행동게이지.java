package java4.사냥터;


import static java4.Main.플레이어;
import static java4.사냥터.사냥터.몬스터어레이;
import static java4.사냥터.사냥터출력.*;

public class 행동게이지 extends Thread {
    전투 전투2;
    public 행동게이지(전투 전투2){
        this.전투2 = 전투2;
    }
    boolean 전투 = true;

    public void run() {
        플레이어.행동게이지 =10000;
        전투:
        while (전투) {
//            System.out.println("턴여부: " + 턴여부 + " 행동중: "+ 행동중);
            if (플레이어.행동게이지 < 플레이어.행동) {
                플레이어.행동게이지 = 플레이어.행동게이지 + 플레이어.속도();
            } else if (플레이어.행동게이지 > 플레이어.행동) {
                플레이어.행동게이지 = 플레이어.행동;
            } else if (플레이어.행동게이지 == 플레이어.행동 && !턴여부 && !행동중) {
//                System.out.println("실행");
                타이머 타이머 = new 타이머(전투2);
                타이머.start();
                턴여부 = true;
            }
            if(플레이어.행동게이지<플레이어.행동) {
                for (int i = 0; i < 몬스터어레이.size(); i++) {
                    if (몬스터어레이.get(i).행동게이지 < 몬스터어레이.get(i).행동) {
                        몬스터어레이.get(i).행동게이지 = 몬스터어레이.get(i).행동게이지 + 몬스터어레이.get(i).속도();
                    }
                    if (몬스터어레이.get(i).행동게이지 > 몬스터어레이.get(i).행동) {
                        몬스터어레이.get(i).행동게이지 = 몬스터어레이.get(i).행동;
                    }
                    if (몬스터어레이.get(i).행동게이지 == 몬스터어레이.get(i).행동) {
                        try {
                            몬스터어레이.get(i).몬스터행동(몬스터어레이, 몬스터머릿수 - 죽은몬스터수, 플레이어);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        몬스터어레이.get(i).행동게이지 = 0;
                    }
                }
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                break;
            }
        }


    }
}