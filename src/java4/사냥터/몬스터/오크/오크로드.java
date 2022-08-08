package java4.사냥터.몬스터.오크;

import java4.사냥터.몬스터.스킬.오크.전투의포효;
import java4.사냥터.몬스터.스킬.오크.짓이기기;
import java4.사냥터.몬스터.스킬.오크.병력보충;

public class 오크로드 extends 오크{
    짓이기기 짓이기기 = new 짓이기기();
    병력보충 병력보충 = new 병력보충();
    public 오크로드(String 이름) {
        this.이름 = "오크 로드";
        this.공격력 = 80;
        this.최종공격력 = this.공격력;
        this.방어력 = 10;
        this.최종방어력 = this.방어력;
        this.최대체력 = 2000;
        this.현재체력 = this.최대체력;
        this.경험치 = 500;
        this.소지금 = 1000;
        this.정보 = "일대의 오크들을 규합해 로드를 자칭한 오크로드입니다. 최상의 위험도를 가지고 있습니다.";
        this.스킬리스트.add(전투의포효);
        this.스킬리스트.add(전투의포효);
        this.스킬리스트.add(전투의포효);
        this.스킬리스트.add(짓이기기);
        this.스킬리스트.add(짓이기기);
        this.스킬리스트.add(짓이기기);
        this.스킬리스트.add(짓이기기);
        this.스킬리스트.add(짓이기기);
        this.스킬리스트.add(병력보충);
        this.스킬리스트.add(병력보충);
        this.스킬리스트.add(병력보충);
        this.스킬리스트.add(병력보충);
        this.스킬리스트.add(병력보충);
        //소환스킬 하나
        //아군버프스킬 하나
    }
}
