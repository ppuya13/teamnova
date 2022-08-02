package java4.사냥터.몬스터.오크;

public class 오크전사 extends 오크 {

    public 오크전사(String 이름) {
        this.번호 = 이름;
        this.이름 = "오크 전사 " + 번호;
        this.공격력 = rd.nextInt(10) + 35; //35~45
        this.최종공격력 = this.공격력;
        this.방어력 = rd.nextInt(3) + 4; //4~7
        this.최종방어력 = this.방어력;
        this.최대체력 = rd.nextInt(20) + 200; //200~220
        this.현재체력 = this.최대체력;
        this.경험치 = rd.nextInt(10) + 60; //60~70
        this.소지금 = rd.nextInt(10) + 30; //30~40
        this.정보 = "강인한 육체를 가진 오크 전사입니다.";
    }
}
