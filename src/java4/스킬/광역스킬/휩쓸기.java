package java4.스킬.광역스킬;


import java4.사냥터.몬스터.몬스터;
import java4.사냥터.사냥터출력;
import java4.캐릭터.캐릭터;

import java.util.ArrayList;

import static java4.Main.플레이어;

public class 휩쓸기 extends 광역스킬 {
    public 휩쓸기(){
        this.고유번호=300;
        this.스킬명="휩쓸기";
        this.효과="모든 적을 공격하여 공격력에 비례한 데미지를 입힙니다.";
        this.타입=3;
        this.소모량=10;
    }

    @Override
    public void 사용효과(ArrayList<몬스터> 몬스터어레이, 캐릭터 캐릭터, 몬스터 타겟) throws InterruptedException {
        int 공격력;
        int 입힌데미지;
        boolean 치명타;
        캐릭터.캐릭터현재마나=캐릭터.캐릭터현재마나-this.소모량;
        System.out.println(this.스킬명 + "을(를) 사용합니다. (마나 " +this.소모량+ " 소모)" +
                "\n"+캐릭터.이름+"의 "+this.스킬명+"!");
        Thread.sleep(1000);

        for(int i = 0 ; i <몬스터어레이.size() ; i++){
            치명타=false;
            //데미지 공식 시작
            공격력 = (int) Math.ceil(this.공격력(캐릭터)*0.6);
            if(rd.nextInt(100)+캐릭터.캐릭터최종치확>99){
                공격력=(int)Math.ceil(공격력*캐릭터.캐릭터최종치피/100);
                치명타=true;
            }
            타겟 = 몬스터어레이.get(i);
            입힌데미지 = 공격력-타겟.최종방어력;

            if(입힌데미지<=0){
                입힌데미지=1;
            }
            //데미지 공식 끝

            타겟.현재체력 = 타겟.현재체력 - 입힌데미지;
            if(치명타){
                System.out.println("치명타!");
                Thread.sleep(400);
            }
            System.out.println("" +
                    타겟.이름 + "에게 " + 입힌데미지 + "만큼의 데미지를 입혔다!");
            Thread.sleep(200);
            if (타겟.현재체력 <= 0) { //공격받은 뒤 타겟의 현재체력이 0이하면
                System.out.println("" +
                        "" + 타겟.이름 + "은(는) 쓰러졌다!");
                Thread.sleep(400);
            } else { //공격받은 뒤 타겟의 체력이 남아있으면
                System.out.println("" +
                        "" + 타겟.이름 + "의 체력이" + 타겟.현재체력 + " 남았다!");
                Thread.sleep(400);
            }
        }
        System.out.println("");
    }
}
