package java4.사냥터.몬스터.스킬;

import java4.사냥터.몬스터.몬스터;
import java4.캐릭터.캐릭터;

import java.util.ArrayList;

public abstract class 지속스킬 extends 몬스터스킬{
    public abstract void 지속효과(몬스터 몬스터, 캐릭터 플레이어, ArrayList<몬스터> 몬스터어레이);
}
