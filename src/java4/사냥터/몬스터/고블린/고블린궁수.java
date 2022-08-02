package java4.사냥터.몬스터.고블린;

import java4.사냥터.몬스터.스킬.몬스터스킬;
import java4.사냥터.몬스터.스킬.고블린.꿰뚫기;

public class 고블린궁수 extends 고블린{
    몬스터스킬 꿰뚫기 = new 꿰뚫기();
    public 고블린궁수(String 이름){
        this.번호 = 이름;
        this.이름 = "고블린 궁수 " + 번호;
        this.공격력 = rd.nextInt(8) + 6; //6~14
        this.최종공격력 = this.공격력;
        this.방어력 = rd.nextInt(2) + 2; //2~4
        this.최종방어력 = this.방어력;
        this.최대체력 = rd.nextInt(15) + 50; //50~65
        this.현재체력 = this.최대체력;
        this.경험치 = rd.nextInt(5) + 25; //25~30
        this.소지금 = rd.nextInt(5) + 10; //10~15
        this.정보 = "활로 무장한 고블린입니다. 공격력이 강하지만 체력이 낮습니다.";
        this.스킬리스트.add(꿰뚫기);
    }
}
