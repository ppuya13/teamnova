package java4.스킬.광역스킬;

import java4.사냥터.몬스터.몬스터;
import java4.사냥터.사냥터출력;
import java4.스킬.스킬;
import java4.캐릭터.캐릭터;

import java.util.ArrayList;

import static java4.사냥터.사냥터출력.*;

public abstract class 광역스킬 extends 스킬 {

    public 광역스킬(){
        this.타입=3;
    }

    @Override
    public boolean 사용확인(ArrayList<몬스터> 몬스터어레이, 캐릭터 캐릭터, 사냥터출력 출력) throws InterruptedException {
        while (true) {
            System.out.print("\n" + this.스킬명 + "(마나 " + this.소모량 + ") : " + this.효과);
            System.out.println(출력.몬스터목록());
            System.out.print("" +
                    this.스킬명 + "을(를) 사용하시겠습니까?" +
                    "\n0.취소한다." +
                    "\n1.사용한다." +
                    "\n→");
            while(입력대기) {
                Thread.sleep(100);
            }
            if (턴여부) {
                행동중 = true;
                if (전투입력 == 0) {
                    행동중 = false;
                    return true;
                } else if (전투입력 == 1) {
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
    }
}
