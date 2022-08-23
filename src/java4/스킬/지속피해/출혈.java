package java4.스킬.지속피해;

import java4.사냥터.몬스터.몬스터;
import java4.캐릭터.캐릭터;

import static java4.Main.사냥터;
import static java4.Main.플레이어;
import static java4.사냥터.사냥터.*;

public class 출혈 extends 지속피해{

    public 출혈(캐릭터 캐릭터, int 지속시간, 몬스터 타겟){
        this.이름 = "출혈";
        this.시전자 = 캐릭터;
        this.효과 = (int)Math.ceil(시전자.캐릭터최종공격력*0.03);
        this.지속시간 = 지속시간;
        this.타겟 = 타겟;
    }
    public void run(){
        while(true) {
            //대상에게 걸린 출혈이 지속시간이 다 됐으면 삭제하는 부분
            if (this.지속시간 == 0) {
                for(int i = 0; i < 타겟.지속딜.size() ; i++){
                    if(타겟.지속딜.get(i).이름.equals(this.이름)){
                        타겟.지속딜.remove(i);
                        break;
                    }
                }
                break;
            }
            //대상의 체력을 깎고 체력이 0이 됐다면 삭제하는 부분
//            if(플레이어.행동게이지<플레이어.행동) { //플레이어가 턴중일때는 작동하지 않게 하려면 이곳을 주석해제
            if (타겟.현재체력 > 0) {
                타겟.현재체력 = 타겟.현재체력 - this.효과;
            } else {
                try {
                    전투.몬스터삭제(true);
                    if (전투.전투종료판정(몬스터어레이, 보스전,보스전초전)) {
                        전투중 = false;
                        전투.전투정산(true, 플레이어);
                    }
                } catch (InterruptedException | CloneNotSupportedException e) {
                    throw new RuntimeException(e);
                }
            }

            //지속시간을 깎고 상태창을 갱신한 뒤 0.1초 대기하는 부분
            this.지속시간--;
//            } //플레이어가 턴중일때는 작동하지 않게 하려면 이곳을 주석해제
            전투.창갱신();
            try {
                sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void 적용(){
        int 동일스킬 = 0;
        boolean 같은스킬없음 = true;
        //대상이 동일한 디버프를 가지고 있는지 비교하는 부분
        if(!(타겟.지속딜.size()==0)){ //지속딜이 비어있지 않으면
            for(int i = 0 ; i < 타겟.지속딜.size() ; i++){
                if(타겟.지속딜.get(i).이름.equals(this.이름)){
                    같은스킬없음=false;
                    동일스킬=i;
                }
            }
        }

        //실제 적용하는 부분
        if(같은스킬없음){ //대상의 지속딜 어레이에 같은 스킬이 없거나 지속딜 어레이가 비어있으면
            타겟.지속딜.add(this);
            this.start();
        }else{ //같은 스킬이 있으면
            if(this.지속시간>타겟.지속딜.get(동일스킬).지속시간){ //이 객체의 지속시간이 현재 적용중인 지속시간보다 높으면
                타겟.지속딜.get(동일스킬).지속시간=this.지속시간;
            }
            if(this.효과>타겟.지속딜.get(동일스킬).효과){ //이 객체의 데미지가 현재 적용중인 효과보다 높으면
                타겟.지속딜.get(동일스킬).효과=this.효과;
            }
        }
    }
}
