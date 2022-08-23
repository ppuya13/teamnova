package java4.스킬.광역스킬;

import java4.사냥터.몬스터.몬스터;
import java4.사냥터.사냥터;
import java4.스킬.스킬;
import java4.캐릭터.캐릭터;

import java.util.ArrayList;

import static java4.사냥터.사냥터.*;
//import static java4.사냥터.사냥터.사냥터입력.사냥터입력값;
import static java4.사냥터.사냥터.입력대기;
import static java4.사냥터.전투.턴타이머;
//import static java4.사냥터.사냥터.턴타이머;

public abstract class 광역스킬 extends 스킬 {

    public 광역스킬(){
        this.타입=3;
    }

    @Override
    public boolean 사용확인(ArrayList<몬스터> 몬스터어레이, 캐릭터 캐릭터, 사냥터 출력) throws InterruptedException {
        while (턴여부) {
            System.out.print("\n" + this.스킬명 + "(마나 " + this.소모량 + ") : " + this.효과);
//            System.out.println(출력.몬스터목록());
            System.out.print("" +
                    this.스킬명 + "을(를) 사용하시겠습니까?" +
                    "\n0.취소한다." +
                    "\n1.사용한다." +
                    "\n→");
//            synchronized (사냥터입력) {
//                사냥터입력.notify();
//            }
            입력대기=true;
            while(입력대기){
                Thread.sleep(50);
            }
            if (턴여부) {
//                System.out.println("광역스킬.사용확인| 전투입력: " + 사냥터입력값);
//                행동중 = true;
                if (입력 == 0) {
//                    행동중 = false;
                    return true;
                } else if (입력 == 1) {
                    턴타이머.타이머종료();
                    if (캐릭터.캐릭터현재마나 < this.소모량) {
                        System.out.println("마나가 부족합니다.");
                        Thread.sleep(1000);
                        return true;
                    }
                    몬스터 타겟 = 몬스터어레이.get(0);
                    this.사용효과(몬스터어레이, 캐릭터, 타겟);
                    return false;
                }
            }
        }
        return true;
    }
}
