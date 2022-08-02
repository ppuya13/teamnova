package java4.사냥터.몬스터.고블린;

import java4.사냥터.몬스터.몬스터;
import java4.사냥터.몬스터.스킬.기본공격;
import java4.사냥터.몬스터.스킬.몬스터스킬;
import java4.아이템.아이템;

public class 고블린 extends 몬스터 {

    고블린(){
        드랍템 = new 아이템(302);
        this.드랍테이블.add(드랍템);
    }
}
