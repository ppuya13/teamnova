package java4.사냥터.몬스터.스킬;

import java4.사냥터.몬스터.몬스터;

import java.util.ArrayList;
import java.util.Random;

import static java4.Main.플레이어;

public class 기본공격 extends 몬스터스킬{
    public 기본공격(){
        this.스킬명 = "기본공격";
        this.효과 = "기본공격입니다.";
    }

    @Override
    public boolean 사용효과(몬스터 몬스터, ArrayList<몬스터> 몬스터어레이) throws InterruptedException {
        if(플레이어.캐릭터현재체력>=1){ //캐릭터가 살아있으면
            Random rd = new Random();
            if(rd.nextInt(100)+플레이어.캐릭터최종회피>99) {//회피판정 성공시
                System.out.println("\n" + 몬스터.이름 + "의 기본공격!" +
                        "\n플레이어는 회피했다!");
                Thread.sleep(500);
            }
            else {
                if (몬스터.최종공격력 - 플레이어.캐릭터최종방어력 >= 1) {
                    System.out.println("\n" + 몬스터.이름 + "의 기본공격!");
                    System.out.println((몬스터.최종공격력 - 플레이어.캐릭터최종방어력) + "의 데미지를 입었다!");
                    Thread.sleep(500);
                    플레이어.캐릭터현재체력 = 플레이어.캐릭터현재체력 - (몬스터.최종공격력 - 플레이어.캐릭터최종방어력);
                } else {
                    System.out.println("\n" + 몬스터.이름 + "의 기본공격!");
                    System.out.println("1의 데미지를 입었다!");
                    Thread.sleep(500);
                    플레이어.캐릭터현재체력 = 플레이어.캐릭터현재체력 - 1;
                }
            }
        }

        return false;
    }
}
