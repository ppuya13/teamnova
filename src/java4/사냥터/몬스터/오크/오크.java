package java4.사냥터.몬스터.오크;

import java4.사냥터.몬스터.몬스터;
import java4.사냥터.몬스터.스킬.기본공격;
import java4.사냥터.몬스터.스킬.몬스터스킬;
import java4.사냥터.몬스터.스킬.오크.전투의포효;
import java4.아이템.아이템;

public class 오크 extends 몬스터{

    기본공격 기본공격 = new 기본공격();
    전투의포효 전투의포효 = new 전투의포효();
    오크(){
        드랍템 = new 아이템(301);
        this.드랍테이블.add(드랍템);
        this.스킬리스트.add(전투의포효);
    }
}
