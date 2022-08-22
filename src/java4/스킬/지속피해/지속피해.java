package java4.스킬.지속피해;

import java4.사냥터.몬스터.몬스터;
import java4.캐릭터.캐릭터;

public abstract class 지속피해 extends Thread{
    int 효과;
    public int 지속시간; //10당 1초
    public String 이름;
    몬스터 타겟;
    java4.캐릭터.캐릭터 시전자;
    public abstract void 적용();
}
