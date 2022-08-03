package java4.아이템.소모;

import java4.아이템.아이템;
import java4.캐릭터.캐릭터;

public abstract class 소모아이템 extends 아이템 {
    public 소모아이템(){
        this.아이템분류=2;
        this.착용가능여부=false;
        this.스택가능여부=true;
        this.상점판매여부 = true;
        this.사용가능여부 = true;
    }
}
