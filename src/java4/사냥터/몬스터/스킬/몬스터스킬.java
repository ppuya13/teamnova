package java4.사냥터.몬스터.스킬;

import java4.사냥터.몬스터.몬스터;
import java4.캐릭터.캐릭터;

import java.util.ArrayList;
import java.util.Random;

public abstract class 몬스터스킬 extends 몬스터{

    public String 스킬명;
    public String 효과;


    public abstract boolean 효과(몬스터 몬스터, 캐릭터 플레이어, ArrayList<몬스터> 몬스터어레이) throws InterruptedException ;
}
