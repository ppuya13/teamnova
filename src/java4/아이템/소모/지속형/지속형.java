package java4.아이템.소모.지속형;

import java4.아이템.소모.소모아이템;
import java4.캐릭터.캐릭터;

public abstract class 지속형 extends 소모아이템 {
    public 지속형() {
    }


    public abstract void 효과적용(캐릭터 캐릭터) throws InterruptedException;
}
