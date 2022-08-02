package java4.사냥터.몬스터.슬라임;

public class 초록슬라임 extends 슬라임{
    public 초록슬라임(String 이름) {
        this.번호 = 이름;
        this.이름 = "초록슬라임 " + 번호;
        this.공격력 = rd.nextInt(1) + 5; //5~6
        this.최종공격력 = this.공격력;
        this.방어력 = rd.nextInt(2) + 1; //1~3
        this.최종방어력 = this.방어력;
        this.최대체력 = rd.nextInt(10) + 25; //25~35
        this.현재체력 = this.최대체력;
        this.경험치 = rd.nextInt(1) + 10; //10~11
        this.소지금 = rd.nextInt(4) + 1;
        this.정보 = "굉장히 약한 슬라임입니다. 일반인도 무리없이 사냥할 수 있습니다.";
    }
}
