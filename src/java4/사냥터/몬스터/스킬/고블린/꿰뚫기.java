package java4.사냥터.몬스터.스킬.고블린;

import java4.사냥터.몬스터.몬스터;
import java4.사냥터.몬스터.스킬.몬스터스킬;
import java4.캐릭터.캐릭터;

import java.util.ArrayList;
import java.util.Random;

public class 꿰뚫기 extends 몬스터스킬 {
    public 꿰뚫기(){
        this.스킬명 = "꿰뚫기";
        this.효과 = "강력한 화살을 한 발 쏩니다. 방어력을 약간 관통합니다.";
    }

    @Override
    public boolean 효과(몬스터 몬스터, 캐릭터 플레이어, ArrayList<몬스터> 몬스터어레이) throws InterruptedException {
        Random rd = new Random();
        int 데미지 = (int) Math.ceil(몬스터.공격력(몬스터.공격력) * 1.2);
        if(플레이어.캐릭터최종방어력>=10) {
            데미지=데미지+10;
        }
        else{
            데미지=데미지+플레이어.캐릭터최종방어력;
        }
        if (플레이어.캐릭터현재체력 >= 1) { //캐릭터가 살아있으면
            if (rd.nextInt(100) + 플레이어.캐릭터최종회피 > 99) {//회피판정 성공시
                System.out.println("\n플레이어는 회피했다!");
                Thread.sleep(250);
            } else {
                if (데미지 - 플레이어.캐릭터최종방어력 >= 1) {
                    System.out.println((데미지 - 플레이어.캐릭터최종방어력) + "의 데미지를 입었다!");
                    Thread.sleep(250);
                    플레이어.캐릭터현재체력 = 플레이어.캐릭터현재체력 - (데미지 - 플레이어.캐릭터최종방어력);
                } else {
                    System.out.println("1의 데미지를 입었다!");
                    Thread.sleep(250);
                    플레이어.캐릭터현재체력 = 플레이어.캐릭터현재체력 - 1;
                }
            }
        }
        return false;
    }
}
