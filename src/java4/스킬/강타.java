package java4.스킬;


import java4.몬스터;

import static java4.Main.플레이어;

public class 강타 extends 스킬 {
    public 강타(){
        this.고유번호=100;
        this.스킬명="강타";
        this.효과="적 하나를 강하게 타격하여 공격력에 비례한 데미지를 입힙니다. 대상의 방어력을 무시합니다.";
        this.타입=1;
        this.소모량=5;
    }

    public int 공격(몬스터 타겟) throws InterruptedException {
        int 공격력 = (int) Math.ceil(플레이어.캐릭터최종공격력*(Math.random()*0.2+0.9));
        int 데미지 = 공격력+50;

        if(rd.nextInt(100)+플레이어.캐릭터최종치확>99){
            공격력=(int)Math.ceil(공격력*플레이어.캐릭터최종치피/100);
            System.out.println("치명타!");
            Thread.sleep(200);
        }

        return 데미지;
    }
}
