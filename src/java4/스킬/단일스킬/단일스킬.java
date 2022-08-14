package java4.스킬.단일스킬;

import java4.사냥터.몬스터.몬스터;
import java4.사냥터.사냥터;
import java4.스킬.스킬;
import java4.캐릭터.캐릭터;

import java.util.ArrayList;

import static java4.사냥터.사냥터.*;
import static java4.사냥터.사냥터.사냥터입력.사냥터입력값;
import static java4.사냥터.사냥터.입력대기;

public abstract class 단일스킬 extends 스킬 {

    public 단일스킬(){
        this.타입=1;
    }
    @Override
    public boolean 사용확인(ArrayList<몬스터> 몬스터어레이, 캐릭터 캐릭터, 사냥터 출력) throws InterruptedException {
        while (턴여부) {
            System.out.print("\n" + this.스킬명 + "(마나 " + this.소모량 + ") : " + this.효과);
            System.out.println(사냥터출력.행동몬스터목록());
            System.out.print("" +
                    this.스킬명 + "을(를) 사용할 대상을 선택하세요." +
                    "\n→");

            synchronized (사냥터입력) {
                사냥터입력.notify();
            }
            입력대기=true;
            while(입력대기){
                Thread.sleep(50);
            }
//            System.out.println("단일스킬.사용효과| 턴여부: " + 턴여부);

            if (턴여부) {
//                System.out.println("단일스킬.사용효과| if문 진입");
//                System.out.println("단일스킬.사용효과| 출력.몬스터어레이: " + 출력.몬스터어레이.size());
//                행동중 = true;
                if (사냥터입력값 == 0) {
                    return true;
                } else if (사냥터입력값 > 0 && 사냥터입력값 <= 출력.몬스터어레이.size()) {
                    if (캐릭터.캐릭터현재마나 < this.소모량) {
                        System.out.println("마나가 부족합니다.");
                        Thread.sleep(1000);
                        return true;
                    }
                    타이머.타이머종료();
//                    System.out.println("단일스킬.사용효과| 플레이어선택중: " + 플레이어선택중);
                    System.out.println("단일스킬.사용효과| 사용직전");
                    몬스터 타겟 = 몬스터어레이.get(사냥터입력값 - 1);
                    this.사용효과(몬스터어레이, 캐릭터, 타겟);
                    System.out.println("단일스킬.사용확인| 끝");
                    return false;
                }
            }
        }
        return true;
    }
}
