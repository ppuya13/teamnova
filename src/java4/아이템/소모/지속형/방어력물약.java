package java4.아이템.소모.지속형;

import java4.아이템.소모.소모아이템;
import java4.캐릭터.캐릭터;

public class 방어력물약 extends 지속형 {
    public 방어력물약(String 이름) {
        this.아이템이름=이름;
        this.고유번호=201;
        this.선적용=true; //방어관련처럼 쓴 즉시 적용되면 true;
        this.구매가격=50;
        this.판매가격=25;
        this.아이템효과="사용 아이템 : 사용시 사용한 턴을 포함해 5턴간 방어력을 10 증가시킵니다.";
        this.추가능력치=10;
        this.사용중="방어력 10 증가 적용중";
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
