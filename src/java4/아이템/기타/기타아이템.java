package java4.아이템.기타;

import java4.아이템.아이템;
import java4.캐릭터.캐릭터;

public abstract class 기타아이템 extends 아이템 {
    public 기타아이템(){
        this.아이템분류=3;
        this.착용가능여부=false;
        this.스택가능여부=true;
        this.상점판매여부 = false;
        this.사용가능여부 = false;
    }
    @Override
    public boolean 사용효과(캐릭터 캐릭터) throws InterruptedException {
        System.out.println("사용할 수 없는 아이템입니다.");
        Thread.sleep(1000);
        return true;
    }
}
