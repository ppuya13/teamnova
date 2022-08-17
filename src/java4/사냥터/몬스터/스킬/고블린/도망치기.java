package java4.사냥터.몬스터.스킬.고블린;

import java4.사냥터.몬스터.몬스터;
import java4.사냥터.몬스터.스킬.몬스터스킬;

import java.util.ArrayList;

import static java4.Main.사냥터;
import static java4.Main.플레이어;
import static java4.사냥터.사냥터.보스전;

public class 도망치기 extends 몬스터스킬 {
    int 카운트;
    public 도망치기(){
        this.스킬명 = "도망치기";
        this.효과 = "보물고블린이 도망치려 합니다.";
        this.카운트 = 0;
    }

    @Override
    public boolean 사용효과(몬스터 몬스터, ArrayList<몬스터> 몬스터어레이) throws InterruptedException, CloneNotSupportedException {
        if(this.카운트==0) {
            System.out.println(몬스터.이름+"이(가) 도망을 준비중이다!");
            this.카운트++;
        }else if(this.카운트==1){
            System.out.println(몬스터.이름+"이(가) 도망치려 한다!");
            this.카운트++;
        }else if(this.카운트==2){
            System.out.println(몬스터.이름+"이(가) 도망쳤다!");
            for(int i = 0 ; i < 몬스터어레이.size() ; i++){
                if(몬스터어레이.get(i).이름.equals(몬스터.이름)){//몬스터어레이의 이름과 본인의 이름이 같으면
//                    몬스터어레이.remove(i); //여기서 지워버리면 행동게이지에서 문제가 발생하므로 주석처리
                    몬스터어레이.get(i).도망침 = true;
                    break;
                }
            }
        }
        if(카운트!=2){
            Thread.sleep(500);
        }
        return false;
    }
}
