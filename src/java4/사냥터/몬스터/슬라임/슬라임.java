package java4.사냥터.몬스터.슬라임;

import java4.사냥터.몬스터.몬스터;
import java4.사냥터.몬스터.스킬.슬라임.*;
import java4.사냥터.몬스터.스킬.몬스터스킬;
import java4.아이템.기타.슬라임젤리;
import java4.아이템.아이템;

public class 슬라임 extends 몬스터 {
    몬스터스킬 자가치유 = new 자가치유();
    몬스터스킬 몸통박치기 = new 몸통박치기();
    슬라임(){
        this.스킬리스트.add(자가치유);
        this.스킬리스트.add(몸통박치기);
        드랍템 = new 슬라임젤리("슬라임젤리");
        this.드랍테이블.add(드랍템);
    }
}
