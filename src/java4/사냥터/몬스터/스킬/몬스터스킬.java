package java4.사냥터.몬스터.스킬;

import java4.사냥터.몬스터.몬스터;
import java4.캐릭터.캐릭터;

import java.util.ArrayList;

public abstract class 몬스터스킬{

    public String 스킬명;
    public String 효과;
    public int 지속시간;
    public boolean 적용 = true;


    public abstract boolean 사용효과(몬스터 몬스터, 캐릭터 플레이어, ArrayList<몬스터> 몬스터어레이) throws InterruptedException ;
}
