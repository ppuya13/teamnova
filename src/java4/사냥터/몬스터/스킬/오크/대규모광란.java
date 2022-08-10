package java4.사냥터.몬스터.스킬.오크;
import java4.사냥터.몬스터.몬스터;
import java4.사냥터.몬스터.스킬.지속스킬;
import java4.캐릭터.캐릭터;

import java.util.ArrayList;

public class 대규모광란 extends 지속스킬{
    public 대규모광란(){
        this.스킬명="대규모 광란";
        this.효과="오크 주술사가 주술적인 힘으로 주변 몬스터의 야성을 일깨웁니다.";
        this.지속시간=4;
    }



    @Override
    public boolean 사용효과(몬스터 몬스터, 캐릭터 플레이어, ArrayList<몬스터> 몬스터어레이) throws InterruptedException {
        몬스터 대상;
        대규모광란 대규모광란;
        boolean 같은스킬없음 = false;
        System.out.println("\n" + 몬스터.이름 + "는 대규모 광란을 사용했다!");
//        Thread.sleep(250);
        System.out.println("몬스터들의 능력치가 상승했다!");
//        Thread.sleep(500);
        for(int i = 0 ; i < 몬스터어레이.size() ; i++) {
            대규모광란 = new 대규모광란();
            같은스킬없음=false;
            대상=몬스터어레이.get(i);
//            System.out.println("대규모광란.사용효과 | 대상.이름 : " + 대상.이름);
            if (대상.지속스킬.size() > 0) {//지속중인 스킬이 있으면
                for (int j = 0; j < 대상.지속스킬.size(); j++) {
                    if (대상.지속스킬.get(j).스킬명.equals(this.스킬명)) {//지속중인 스킬이 있고 그 스킬 중 이 스킬과 같은 스킬이 있으면
                        대상.지속스킬.get(j).지속시간 = this.지속시간-1; //지속시간을 초기화
                        대규모광란.적용 = false;
                        같은스킬없음 = true;
                        break;
                    }
                }
                if (!같은스킬없음) {
                    대상.지속스킬.add(대규모광란);
                    대규모광란.지속효과(대상, 플레이어, 몬스터어레이);
                }
            } else {
                대상.지속스킬.add(대규모광란);
                대규모광란.지속효과(대상, 플레이어, 몬스터어레이);
            }
        }
        Thread.sleep(500);
        return false;
    }

    @Override
    public void 지속효과(몬스터 몬스터, 캐릭터 플레이어, ArrayList<몬스터> 몬스터어레이) {
        if(this.적용){ //지속 첫턴에 일어나는 일
//            System.out.println("대규모광란.지속효과 | (대규모광란 적용전)대상의 이름과 추가공격력 : " +몬스터.이름 + 몬스터.추가공격력);
            this.적용 = false;
            몬스터.추가공격력 = 몬스터.추가공격력+30;
            몬스터.최종공격력 = 몬스터.공격력+몬스터.추가공격력;
            몬스터.추가방어력 = 몬스터.추가방어력+5;
            몬스터.최종방어력 = 몬스터.방어력+몬스터.추가방어력;
//            System.out.println("대규모광란.지속효과 | (적용후)대상의 이름과 추가공격력 : " +몬스터.이름 + 몬스터.추가공격력);
//            System.out.println("대규모광란 | this.지속시간 : " + this.지속시간);
        }
        this.지속시간--;
    }
    @Override
    public boolean 지속효과삭제(몬스터 몬스터){
        if(this.지속시간==0){ //남은 지속시간이 0일 때 일어나는 일
            몬스터.추가공격력 = 몬스터.추가공격력-30;
            몬스터.최종공격력 = 몬스터.공격력+몬스터.추가공격력;
            몬스터.추가방어력 = 몬스터.추가방어력-5;
            몬스터.최종방어력 = 몬스터.방어력+몬스터.추가방어력;
            for(int i = 0 ; i < 몬스터.지속스킬.size() ; i++){
                if(몬스터.지속스킬.get(i).스킬명.equals(this.스킬명)){
                    몬스터.지속스킬.remove(i);
                    return true;
                }
            }
        }

        return false;
    }
}
