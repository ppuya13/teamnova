package java4.사냥터.몬스터.스킬.오크;

import java4.사냥터.몬스터.몬스터;
import java4.사냥터.몬스터.스킬.몬스터스킬;
import java4.사냥터.몬스터.오크.*;

import java.util.ArrayList;
import java.util.Random;

public class 병력보충 extends 몬스터스킬 {

    public 병력보충(){
        this.스킬명 = "병력보충";
        this.효과 = "오크 로드가 병력을 보충합니다.";
    }


    @Override
    public boolean 사용효과(몬스터 몬스터, ArrayList<몬스터> 몬스터어레이) throws InterruptedException {
        Random rd = new Random();
        System.out.println("\n" + 몬스터.이름 + "의 "+ this.스킬명 +"!");
        int 난수;
        if(몬스터어레이.size()>=4){//몬스터어레이의 크기가 4이상이면
//            System.out.println("병력보충.사용효과 | 몹이 너무 많아서 리롤");
            return true;
        }
//        Thread.sleep(500);
        System.out.println("오크들이 더 몰려왔다!");
//        Thread.sleep(500);
        for(int i = 0 ; i < 3 ; i++) {
            난수 = rd.nextInt(10);
            if(난수<7){
                몬스터 = new 오크전사("(소환됨)");
            }
            else{
                몬스터 = new 오크주술사("(소환됨)");
            }
//            몬스터.start();
            몬스터어레이.add(몬스터);
        }
        Thread.sleep(500);
        return false;
    }
}
