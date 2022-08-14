package java4.사냥터.몬스터.스킬.오크;

import java4.사냥터.몬스터.몬스터;
import java4.사냥터.몬스터.스킬.몬스터스킬;

import java.util.ArrayList;
import java.util.Random;

public class 즉석치료 extends 몬스터스킬{

    public 즉석치료(){
        this.스킬명="즉석 치료";
        this.효과="다친 아군을 치료합니다.";
    }

    @Override
    public boolean 사용효과(몬스터 몬스터, ArrayList<몬스터> 몬스터어레이) throws InterruptedException {
        int 회복량 = (int)Math.ceil(몬스터.최대체력*0.15);
        boolean 사용가능 = false;
        ArrayList<몬스터> 대상리스트 = new ArrayList<>();
        Random rd = new Random();
        몬스터 대상;
        for(int i = 0 ; i < 몬스터어레이.size() ; i++){
            if(몬스터어레이.get(i).현재체력<몬스터어레이.get(i).최대체력){//체력이 깎인 몹이 있으면
                사용가능=true;
                break;
            }
        }//체력이 깎인 몹이 있으면 발동하게 하고 체력이 깎인 몹이 없으면 리롤함
        if(사용가능){
            for(int i = 0 ; i < 몬스터어레이.size() ; i++){
                if(몬스터어레이.get(i).현재체력<몬스터어레이.get(i).최대체력){
                    대상리스트.add(몬스터어레이.get(i));
                }
            }//몬스터어레이에서 체력이 깎인 몹들을 전부 대상에 넣음
            대상 = 대상리스트.get(rd.nextInt(대상리스트.size()));
            if(대상.최대체력-대상.현재체력<회복량){ //대상의 최대체력-현재체력이 회복량보다 적으면
                회복량=대상.최대체력-대상.현재체력;
            }
            System.out.println(몬스터.이름 + "이(가) " + 대상.이름 + "에게 즉석치료를 사용했다!");
            대상.현재체력 = 대상.현재체력+회복량;
//            Thread.sleep(500);
            System.out.println(대상.이름 + "의 체력이 " + 회복량 + " 회복되어 " + 대상.현재체력 + "이(가) 되었다!");
//            Thread.sleep(500);

            대상리스트.clear();
        }
        Thread.sleep(500);
        return !사용가능;
    }
}