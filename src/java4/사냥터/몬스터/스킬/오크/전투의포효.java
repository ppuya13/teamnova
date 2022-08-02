package java4.사냥터.몬스터.스킬.오크;

import java4.사냥터.몬스터.몬스터;
import java4.사냥터.몬스터.스킬.지속스킬;
import java4.캐릭터.캐릭터;

import java.util.ArrayList;

public class 전투의포효 extends 지속스킬 {
    public 전투의포효(){
        this.스킬명="전투의 포효";
        this.효과="오크들은 소리를 질러 전투력을 상승시킬 수 있습니다.";
        this.지속시간=3;
    }

    @Override
    public boolean 사용효과(몬스터 몬스터, 캐릭터 플레이어, ArrayList<몬스터> 몬스터어레이) throws InterruptedException {
        전투의포효 전투의포효 = new 전투의포효();
        boolean 같은스킬없음 = false;
        System.out.println("\n" + 몬스터.이름 + "의 전투의 포효!");
        Thread.sleep(500);
        if(몬스터.지속스킬.size()>0) {//지속중인 스킬이 있으면
            for (int i = 0; i < 몬스터.지속스킬.size(); i++) {
                if (몬스터.지속스킬.get(i).스킬명.equals(this.스킬명)){//지속중인 스킬이 있고 그 스킬 중 이 스킬과 같은 스킬이 있으면
                    몬스터.지속스킬.get(i).지속시간=this.지속시간; //지속시간을 초기화
                    전투의포효.적용=false;
                    같은스킬없음=true;
                    break;
                }
            }
            if(!같은스킬없음){
                몬스터.지속스킬.add(전투의포효);
            }
        }else {
            몬스터.지속스킬.add(전투의포효);
        }
        전투의포효.지속효과(몬스터, 플레이어, 몬스터어레이);
        return false;
    }

    @Override
    public void 지속효과(몬스터 몬스터, 캐릭터 플레이어, ArrayList<몬스터> 몬스터어레이) {
        if(this.적용){ //지속 첫턴에 일어나는 일
//            System.out.println("전투의포효 | " + 몬스터.이름 + "의 지속스킬 첫턴 발동");
            this.적용 = false;
            몬스터.추가공격력 = 몬스터.추가공격력+100;
            몬스터.최종공격력 = 몬스터.공격력+몬스터.추가공격력;
            몬스터.추가방어력 = 몬스터.추가방어력+50;
            몬스터.최종방어력 = 몬스터.방어력+몬스터.추가방어력;
//            System.out.println("전투의포효 | this.지속시간 : " + this.지속시간);
        }else if(지속시간==0){ //남은 지속시간이 0일 때 일어나는 일
            몬스터.추가공격력 = 몬스터.추가공격력-100;
            몬스터.최종공격력 = 몬스터.공격력+몬스터.추가공격력;
            몬스터.추가방어력 = 몬스터.추가방어력-50;
            몬스터.최종방어력 = 몬스터.방어력+몬스터.추가방어력;
            for(int i = 0 ; i < 몬스터.지속스킬.size() ; i++){
//                System.out.println("몬스터.지속스킬.get(i).스킬명과 this.스킬명이 같으면 삭제하는 단계");
//                System.out.println("몬스터.지속스킬.get(i).스킬명 : "+몬스터.지속스킬.get(i).스킬명 + ", this.스킬명 : " + this.스킬명);
                if(몬스터.지속스킬.get(i).스킬명.equals(this.스킬명)){
                    몬스터.지속스킬.remove(i);
                    break;
                }
            }
        }
        this.지속시간--;
    }
}
