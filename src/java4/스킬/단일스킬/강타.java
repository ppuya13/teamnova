package java4.스킬.단일스킬;


import java4.사냥터.몬스터.몬스터;
import java4.사냥터.사냥터출력;
import java4.캐릭터.캐릭터;

import java.util.ArrayList;

public class 강타 extends 단일스킬 {
    public 강타(){
        this.고유번호=100;
        this.스킬명="강타";
        this.효과="적 하나를 강하게 타격하여 공격력에 비례한 데미지를 입힙니다. 대상의 방어력을 무시합니다.";
        this.소모량=5;
    }
    @Override
    public void 사용효과(ArrayList<몬스터> 몬스터어레이, 캐릭터 캐릭터, 몬스터 타겟) throws InterruptedException {
        //데미지 공식 시작
        int 입힌데미지 = this.공격력(캐릭터)+50;
        boolean 치명타=false;

        if(rd.nextInt(100)+캐릭터.캐릭터최종치확>99){
            입힌데미지=(int)Math.ceil(입힌데미지*캐릭터.캐릭터최종치피/100);
            치명타=true;
        }

        if(입힌데미지<=0){
            입힌데미지=1;
        }
        //데미지 공식 끝


        캐릭터.캐릭터현재마나=캐릭터.캐릭터현재마나-this.소모량;
        System.out.println("\n" + 타겟.이름 + "을(를) 공격합니다. (마나 " +this.소모량+ " 소모)" +
                "\n"+캐릭터.이름+"의 "+this.스킬명+"!");
        타겟.현재체력 = 타겟.현재체력 - 입힌데미지;
        Thread.sleep(500);
        if(치명타){
            System.out.println("치명타!");
            Thread.sleep(500);
        }
        System.out.println("" +
                타겟.이름 + "에게 " + 입힌데미지 + "만큼의 데미지를 입혔다!");
        Thread.sleep(500);
        if (타겟.현재체력 <= 0) { //공격받은 뒤 타겟의 현재체력이 0이하면
            System.out.println("" +
                    "" + 타겟.이름 + "은(는) 쓰러졌다!");
            Thread.sleep(1000);
        } else { //공격받은 뒤 타겟의 체력이 남아있으면
            System.out.println("" +
                    "" + 타겟.이름 + "의 체력이" + 타겟.현재체력 + " 남았다!");
            Thread.sleep(1000);
        }
    }
}
