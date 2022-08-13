package java4.사냥터;

import static java4.Main.플레이어;
import static java4.사냥터.사냥터.*;

public class 전투_행동게이지 extends Thread{
    public void run() {
        전투:
        while (전투중) {
//            System.out.println("턴여부: " + 턴여부 + " 행동중: "+ 행동중);
            if (플레이어.행동게이지 < 플레이어.행동) {
                플레이어.행동게이지 = 플레이어.행동게이지 + 플레이어.속도();
            } else if (플레이어.행동게이지 > 플레이어.행동) {
                플레이어.행동게이지 = 플레이어.행동;
            } else if (플레이어.행동게이지 == 플레이어.행동 && !턴여부) {
//                System.out.println("실행");
//                구타이머 구타이머 = new 구타이머(구전투2);
//                구타이머.start();
                턴여부 = true; //행게가 가득차면 턴을 on하고 기다림, 턴종료시 턴여부를 false하고 행게를 줄인뒤에 notify하기
                try {
                    synchronized (this) {
                        this.wait();
                    }
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
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
