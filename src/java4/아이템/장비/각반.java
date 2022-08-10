package java4.아이템.장비;

public class 각반 extends 장비아이템{
    public 각반(String 이름) {
        super(이름);
        this.고유번호=103;
        this.장비부위 = 4;
        this.구매가격=100;
        this.판매가격=50;
        this.아이템효과="장비 아이템(각반) : 장착시 속도를 5 증가시킵니다.";
        this.드랍률=10;
        this.기본공격력=0;
        this.기본방어력=0;
        this.기본체력=0;
        this.기본마나=0;
        this.기본치확=0;
        this.기본치피=0;
        this.기본속도=5;
    }
}
