package java4.사냥터.몬스터.고블린;

import java4.사냥터.몬스터.스킬.몬스터스킬;
import java4.사냥터.몬스터.스킬.고블린.연속공격;

public class 고블린전사 extends 고블린{
        몬스터스킬 연속공격 = new 연속공격();
        public 고블린전사(String 이름) {
                this.번호 = 이름;
                this.이름 = "고블린 전사 " + 번호;
                this.공격력 = rd.nextInt(3) + 7; //7~10
                this.최종공격력 = this.공격력;
                this.방어력 = rd.nextInt(2) + 4; //4~6
                this.최종방어력 = this.방어력;
                this.최대체력 = rd.nextInt(10) + 100; //100~110
                this.현재체력 = this.최대체력;
                this.경험치 = rd.nextInt(5) + 25; //25~30
                this.소지금 = rd.nextInt(5) + 10; //10~15
                this.정보 = "근접 무기를 든 고블린입니다. 가벼운 갑옷으로 무장해 쓰러뜨리기 쉽지 않습니다.";
                this.스킬리스트.add(연속공격);
        }
}
