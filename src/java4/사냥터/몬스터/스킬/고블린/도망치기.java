package java4.사냥터.몬스터.스킬.고블린;

import java4.사냥터.몬스터.몬스터;
import java4.사냥터.몬스터.스킬.몬스터스킬;
import java4.캐릭터.캐릭터;

import java.util.ArrayList;

public class 도망치기 extends 몬스터스킬 {
    int 카운트;
    도망치기(){
        this.스킬명 = "도망치기";
        this.효과 = "보물고블린이 도망치려 합니다.";
        this.카운트 = 0;
    }

    @Override
    public boolean 사용효과(몬스터 몬스터, 캐릭터 플레이어, ArrayList<몬스터> 몬스터어레이) throws InterruptedException {
        if(this.카운트==0) {
            System.out.println(몬스터.이름+"이(가) 도망을 준비중이다!");
            this.카운트=this.카운트+1;
        }else if(this.카운트==1){
            System.out.println(몬스터.이름+"이(가) 도망치려 한다!");
            this.카운트=this.카운트+1;
        }else if(this.카운트==2){
            System.out.println(몬스터.이름+"이(가) 도망쳤다!");
            for(int i = 0 ; i < 몬스터어레이.size() ; i++){
                if(몬스터어레이.get(i).이름.equals(몬스터.이름)){//몬스터어레이의 이름과 본인의 이름이 같으면
                    몬스터어레이.remove(i);
                    break;
                }
            }
        }
        Thread.sleep(500);
        return false;
    }
}
