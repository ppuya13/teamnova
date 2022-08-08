package java4.아이템.장비;

import java4.아이템.아이템;
import java4.캐릭터.플레이어;

public abstract class 장비아이템 extends 아이템 {
    public 장비아이템(String 이름){
        this.임시이름 = 이름;
        this.아이템분류=1;
        this.착용가능여부=true;
        this.스택가능여부=false;
        this.상점판매여부 = true;
        this.사용가능여부 = true;
        this.강화수치();
        this.강화=0;
        this.아이템이름="+" + this.강화 + " " + this.임시이름;
    }

    @Override
    public boolean 사용효과(플레이어 플레이어) throws InterruptedException {
        int 인벤토리크기= 플레이어.소지품.size()-1;
        boolean 속행=true;
        if(this.착용여부){//착용중이면
            this.착용여부=false;
            System.out.println("\n"+this.아이템이름+"을(를) 착용 해제했습니다.");
            Thread.sleep(1000);
        }
        else { //착용중이 아니면
            for(int i=0 ; i <= 인벤토리크기 ; i++){
                if(플레이어.소지품.get(i).장비부위==this.장비부위 && 플레이어.소지품.get(i).착용여부){ //인벤토리에 장비부위가 같고 착용중인 아이템이 있으면
                    System.out.println("\n같은 부위의 착용중인 아이템을 우선 착용 해제하세요.");
                    Thread.sleep(1000);
                    속행=false;
                    break;
                }
            }
            if(속행){ //속행이 true면(장비부위가 같고 착용중인 아이템이 없으면)
                this.착용여부=true;
                System.out.println("\n"+this.아이템이름+"을(를) 착용했습니다.");
                Thread.sleep(1000);
            }
        }
        return false;
    }
}
