package java4.스킬.단일스킬;

import java4.사냥터.몬스터.몬스터;
import java4.사냥터.사냥터출력;
import java4.스킬.스킬;
import java4.캐릭터.캐릭터;

import java.util.ArrayList;

public abstract class 단일스킬 extends 스킬 {

    public 단일스킬(){
        this.타입=1;
    }
    @Override
    public boolean 사용확인(ArrayList<몬스터> 몬스터어레이, 캐릭터 캐릭터, 사냥터출력 출력) throws InterruptedException {
        while (true) {
            System.out.print("\n" + this.스킬명 + "(마나 " + this.소모량 + ") : " + this.효과);
            System.out.println(출력.행동몬스터목록());
            System.out.print("" +
                    this.스킬명 + "을(를) 사용할 대상을 선택하세요." +
                    "\n→");
            입력 = sc.nextInt();
            if (입력 == 0) {
                return true;
            } else if (입력 > 0 && 입력 <= 출력.몬스터어레이.size()) {
                if(캐릭터.캐릭터현재마나<this.소모량){
                    System.out.println("마나가 부족합니다.");
                    Thread.sleep(1000);
                    return true;
                }
                몬스터 타겟 = 몬스터어레이.get(입력-1);
                this.사용효과(몬스터어레이,캐릭터,타겟);
                return false;
            }
        }
    }
}
