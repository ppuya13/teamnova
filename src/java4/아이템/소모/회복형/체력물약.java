package java4.아이템.소모.회복형;

import java4.캐릭터.플레이어;

//import static java4.사냥터.사냥터.턴타이머;

//import static java4.사냥터.사냥터.턴타이머;
import static java4.사냥터.전투.턴타이머;

public class 체력물약 extends 회복형 {
    public 체력물약(String 이름) {
        this.아이템이름=이름;
        this.고유번호=-1;
        this.구매가격=10;
        this.판매가격=5;
        this.아이템효과="회복 아이템 : 사용시 체력을 300 회복시킵니다.";
        this.드랍률=10;
    }

    @Override
    public boolean 사용효과(플레이어 플레이어) throws InterruptedException {
        if(this.스택수>0) {
            턴타이머.타이머종료();
            if (플레이어.캐릭터최종체력 - 플레이어.캐릭터현재체력 >= 300) {
                플레이어.캐릭터현재체력 = 플레이어.캐릭터현재체력 + 300;
                System.out.print("\n체력이 300회복되어 " + 플레이어.캐릭터현재체력 + "이 되었습니다.");
            } else {
                System.out.print("\n체력이 " + (플레이어.캐릭터최종체력 - 플레이어.캐릭터현재체력) + "회복되어 ");
                플레이어.캐릭터현재체력 = 플레이어.캐릭터최종체력;
                System.out.println(플레이어.캐릭터현재체력 + "이(가) 되었습니다.");
            }
            this.스택수--;
            Thread.sleep(1000);
            return false;
        } else{
            System.out.println("물약을 모두 소모했습니다.");
            Thread.sleep(1000);
            return true;
        }
    }
}
