package java4.아이템.소모.지속형;

import java4.아이템.소모.소모아이템;
import java4.캐릭터.캐릭터;

public class 공격력물약 extends 지속형 {
    public 공격력물약(String 이름) {
        this.아이템이름=이름;
        this.고유번호=200;
        this.선적용=false; //공격관련처럼 다음턴부터 적용되면 false;
        this.구매가격=50;
        this.판매가격=25;
        this.아이템효과="사용 아이템 : 사용시 다음 턴부터 5턴간 공격력을 30 증가시킵니다.";
        this.추가능력치=10;
        this.사용중="공격력 30 증가 적용중";
        this.지속시간=5; //지속시간 그대로 적용
        this.드랍률=10;
    }

    @Override
    public void 사용효과(캐릭터 캐릭터) {

    }

    @Override
    public void 효과적용(캐릭터 캐릭터) throws InterruptedException {

    }
}
