package java4.아이템.소모.회복형;

import java4.캐릭터.캐릭터;

public class 마나물약 extends 회복형 {
    public 마나물약(String 이름) {
        this.아이템이름=이름;
        this.고유번호=-2;
        this.구매가격=10;
        this.판매가격=5;
        this.아이템효과="회복 아이템 : 사용시 마나를 30 회복시킵니다.";
        this.드랍률=10;
    }

    @Override
    public void 사용효과(캐릭터 캐릭터) throws InterruptedException {
        if(this.스택수>0) {
            if (캐릭터.캐릭터최종마나 - 캐릭터.캐릭터현재마나 >= 30) {
                캐릭터.캐릭터현재마나 = 캐릭터.캐릭터현재마나 + 30;
                System.out.print("\n마나가 30회복되어 " + 캐릭터.캐릭터현재마나 + "이 되었습니다.");
            } else {
                System.out.print("\n마나가 " + (캐릭터.캐릭터최종마나 - 캐릭터.캐릭터현재마나) + "회복되어 ");
                캐릭터.캐릭터현재마나 = 캐릭터.캐릭터최종마나;
                System.out.println(캐릭터.캐릭터현재마나 + "이(가) 되었습니다.");
            }
            this.스택수--;
        } else{
            System.out.println("물약을 모두 소모했습니다.");
        }
        Thread.sleep(1000);
    }
}


