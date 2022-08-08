package java4.사냥터.몬스터.오크;

import java4.사냥터.몬스터.스킬.오크.대규모광란;
import java4.사냥터.몬스터.스킬.오크.즉석치료;

public class 오크주술사 extends 오크{
    대규모광란 대규모광란 = new 대규모광란();
    즉석치료 즉석치료 = new 즉석치료();

    public 오크주술사(String 이름) {
        this.이름 = "오크 주술사 " + 이름;
        this.공격력 = rd.nextInt(11) + 20; //20~30
        this.최종공격력 = this.공격력;
        this.방어력 = rd.nextInt(3) + 2; //2~4
        this.최종방어력 = this.방어력;
        this.최대체력 = rd.nextInt(11) + 190; //190~200
        this.현재체력 = this.최대체력;
        this.경험치 = rd.nextInt(21) + 90; //90~110
        this.소지금 = rd.nextInt(21) + 80; //80~100
        this.정보 = "오크 주술사는 주변 몬스터를 강화할 수 있습니다.";
        this.스킬리스트.add(대규모광란);
        this.스킬리스트.add(대규모광란);
        this.스킬리스트.add(대규모광란);
        this.스킬리스트.add(즉석치료);
        this.스킬리스트.add(즉석치료);
        this.스킬리스트.add(즉석치료);
    }
}
