package java4.아이템.장비;

public class 방패 extends 장비아이템{
    public 방패(String 이름) {
        super(이름);
        this.고유번호=101;
        this.장비부위 = 2;
        this.구매가격=100;
        this.판매가격=50;
        this.아이템효과="장비 아이템(보조장비): 장착시 방어력을 3 증가시킵니다.";
        this.드랍률=10;
        this.기본공격력=0;
        this.기본방어력=3;
        this.기본체력=0;
        this.기본마나=0;
        this.기본치확=0;
        this.기본치피=0;
        this.기본속도=0;
    }
}
