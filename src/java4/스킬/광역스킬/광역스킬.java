package java4.스킬.광역스킬;

import java4.사냥터.몬스터.몬스터;
import java4.사냥터.구사냥터코드.구사냥터출력;
import java4.스킬.스킬;
import java4.캐릭터.캐릭터;

import java.util.ArrayList;

import static java4.사냥터.구사냥터코드.구사냥터출력.*;

public abstract class 광역스킬 extends 스킬 {

    public 광역스킬(){
        this.타입=3;
    }

    @Override
    public boolean 사용확인(ArrayList<몬스터> 몬스터어레이, 캐릭터 캐릭터, 구사냥터출력 출력) throws InterruptedException {
        while (true) {
            System.out.print("\n" + this.스킬명 + "(마나 " + this.소모량 + ") : " + this.효과);
            System.out.println(출력.몬스터목록());
            System.out.print("" +
                    this.스킬명 + "을(를) 사용하시겠습니까?" +
                    "\n0.취소한다." +
                    "\n1.사용한다." +
                    "\n→");
            입력대기=true;
            입력대기:
            while(턴여부&&입력대기) {
                Thread.sleep(100);
//                System.out.println("광역스킬.사용확인| 입력대기중");
            }
//            System.out.println("입력받음");
            System.out.println("사용효과발동됨1");
            if (턴여부) {
                System.out.println("사용효과발동됨2");
                System.out.println("광역스킬.사용확인| 전투입력: " + 전투입력);
                행동중 = true;
                if (전투입력 == 0) {
                    행동중 = false;
                    return true;
                } else if (전투입력 == 1) {
                    System.out.println("사용효과발동됨3");
                    if (캐릭터.캐릭터현재마나 < this.소모량) {
                        System.out.println("마나가 부족합니다.");
                        Thread.sleep(1000);
                        return true;
                    }
                    System.out.println("사용효과발동됨4");
                    몬스터 타겟 = 몬스터어레이.get(0);
                    this.사용효과(몬스터어레이, 캐릭터, 타겟);
                    System.out.println("사용효과발동됨5");
                    return false;
                }
            }
        }
    }
}
