package java4.사냥터.몬스터.스킬.슬라임;

import java4.사냥터.몬스터.몬스터;
import java4.사냥터.몬스터.스킬.몬스터스킬;
import java4.캐릭터.캐릭터;

import java.util.ArrayList;

public class 자가치유 extends 몬스터스킬 {
    public 자가치유(){
        this.스킬명 = "자가치유";
        this.효과 = "슬라임들은 살아만 있다면 얼마든지 재생할 수 있습니다.";
    }

    @Override
    public boolean 효과(몬스터 몬스터, 캐릭터 플레이어, ArrayList<몬스터> 몬스터어레이) throws InterruptedException {
        int 효과 = (int)Math.ceil(몬스터.최대체력*0.3);
        if (몬스터.현재체력 == 몬스터.최대체력) {
            System.out.println("최대체력이라 리롤");
            return true;
        }
        if(몬스터.현재체력+효과 > 몬스터.최대체력){
            효과 = 몬스터.최대체력-몬스터.현재체력;
        }
        System.out.println(몬스터.이름 + "의 자가치유!" +
                "\n"+몬스터.이름+"의 체력이 "+효과+"만큼 치유되어 "+몬스터.현재체력+"이 되었다!");
        Thread.sleep(500);

        return false;
    }
}
