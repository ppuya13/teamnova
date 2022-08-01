package java4.사냥터.몬스터.슬라임;

public class 빨간슬라임 extends 슬라임{
    public 빨간슬라임(String 이름) {

        System.out.println("다음");
        this.번호 = 이름;
        this.이름 = "빨간슬라임" + 번호;
        this.공격력 = rd.nextInt(3) + 6; //6~9
        this.방어력 = rd.nextInt(2) + 2; //2~4
        this.최대체력 = rd.nextInt(10) + 35; //35~45
        this.현재체력 = this.최대체력;
        this.경험치 = rd.nextInt(2) + 12; //12~14
        this.소지금 = rd.nextInt(5) + 2; //2~7
        this.정보 = "비교적 강한 슬라임입니다. 은은한 딸기맛이 난다는 소문이 있습니다.";
    }
}
