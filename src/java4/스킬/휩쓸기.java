package java4.스킬;


import java4.사냥터.몬스터.몬스터;

import static java4.Main.플레이어;

public class 휩쓸기 extends 스킬 {
    public 휩쓸기(){
        this.고유번호=300;
        this.스킬명="휩쓸기";
        this.효과="모든 적을 공격하여 공격력에 비례한 데미지를 입힙니다.";
        this.타입=3;
        this.소모량=10;
    }
    @Override
    public int 공격(몬스터 타겟) throws InterruptedException {
        int 공격력 = (int) Math.ceil(플레이어.캐릭터최종공격력*(Math.random()*0.2+0.9));;
        int 데미지 = (int)Math.ceil(공격력*0.7)-타겟.방어력;

        if(rd.nextInt(100)+플레이어.캐릭터최종치확>99){
            공격력=(int)Math.ceil(공격력*플레이어.캐릭터최종치피/100);
            System.out.println("치명타!");
            Thread.sleep(200);
        }
        return 데미지;
    }
}
