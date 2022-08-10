package java4.아이템.장비;

import java4.아이템.아이템;

public class 검 extends 장비아이템{
    public 검(String 이름) {
        super(이름);
        this.고유번호=100;
        this.장비부위 = 1;
        this.구매가격=100;
        this.판매가격=50;
        this.아이템효과="장비 아이템(무기): 장착시 공격력을 10 증가시킵니다.";
        this.드랍률=10;
        this.기본공격력=10;
        this.기본방어력=0;
        this.기본체력=0;
        this.기본마나=0;
        this.기본치확=0;
        this.기본치피=0;
        this.기본속도=0;
    }

}
