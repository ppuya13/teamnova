package java4.스킬.지속피해;

import java4.사냥터.몬스터.몬스터;
import java4.캐릭터.캐릭터;

import static java4.Main.사냥터;
import static java4.Main.플레이어;
import static java4.사냥터.사냥터.*;
import static java4.사냥터.사냥터.전투중;

public abstract class 지속피해 extends Thread{
//public abstract class 지속피해{
    int 효과;
    public int 지속시간; //10당 1초
    public String 이름;
    몬스터 타겟;
    java4.캐릭터.캐릭터 시전자;
    public abstract void 적용();

//    public void 데미지적용(){
//        if (this.지속시간 == 0) {
//            for(int i = 0; i < 타겟.지속딜.size() ; i++){
//                if(타겟.지속딜.get(i).이름.equals(this.이름)){
//                    타겟.지속딜.remove(i);
//                    break;
//                }
//            }
//            return;
//        }
//        //대상의 체력을 깎고 체력이 0이 됐다면 삭제하는 부분
////            if(플레이어.행동게이지<플레이어.행동) { //플레이어가 턴중일때는 작동하지 않게 하려면 이곳을 주석해제
//        if (타겟.현재체력 > 0) {
//            타겟.현재체력 = 타겟.현재체력 - this.효과;
//        } else {
//            try {
//                사냥터.몬스터삭제(true);
//                if (사냥터.전투종료판정(몬스터어레이, 보스전,보스전초전)) {
//                    전투중 = false;
//                    사냥터.전투정산(true, 플레이어);
//                }
//            } catch (InterruptedException | CloneNotSupportedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        //지속시간을 깎고 상태창을 갱신한 뒤 0.1초 대기하는 부분
//        this.지속시간--;
////            } //플레이어가 턴중일때는 작동하지 않게 하려면 이곳을 주석해제
//        사냥터.창갱신();
//    }
}
