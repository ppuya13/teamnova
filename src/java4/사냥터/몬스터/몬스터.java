package java4.사냥터.몬스터;

import java4.Main;
import java4.사냥터.몬스터.스킬.기본공격;
import java4.사냥터.몬스터.스킬.몬스터스킬;
import java4.사냥터.몬스터.스킬.지속스킬;
import java4.아이템.소모.지속형.*;
import java4.아이템.소모.회복형.*;
import java4.아이템.아이템;
import java4.아이템.장비.*;
import java4.캐릭터.캐릭터;
import java4.캐릭터.플레이어;
import static java4.Main.플레이어;
import static java4.사냥터.사냥터.*;

import java.util.ArrayList;
import java.util.Random;

public abstract class 몬스터 {

    public String 이름;
    public final int 행동 = 10000; //행동게이지가 행동보다 높아지면 0으로 초기화하고 행동함
    public int 행동난수; //속도값에 따라 랜덤하게 행동난수값을 설정함
    public int 행동게이지 = 0;
    //    public boolean 소환됨; //소환된 턴엔 행동하지 못하게 하기 위함.
    public int 속도; //행동게이지가 차는 속도, 대충 (1000/속도)초당 1회 행동함
    public int 공격력;
    public int 추가공격력 = 0;
    public int 최종공격력;
    public int 방어력;
    public int 추가방어력 = 0;
    public int 최종방어력;
    public int 최대체력;
    public int 현재체력;
    public int 경험치;
    public int 소지금;
    public String 정보;
    public String 번호;
    public 아이템 드랍템;
    public ArrayList<몬스터스킬> 스킬리스트 = new ArrayList<>();
    public ArrayList<지속스킬> 지속스킬 = new ArrayList<>();
    public ArrayList<아이템> 드랍테이블 = new ArrayList<>();
    public ArrayList<아이템> 공용드랍테이블 = new ArrayList<>();
    public Random rd = new Random();

    public 몬스터(){
//        this.소환됨 = false;
        몬스터스킬 기본공격 = new 기본공격();
        for(int i = 0; i < 10 ; i++) {
            this.스킬리스트.add(기본공격);
        }
        공용드랍테이블();
        this.드랍테이블.addAll(공용드랍테이블);
    }

//    public void run(){
//        while (true) {
//
//            if (플레이어.행동게이지 >= 플레이어.행동){
//                try {
//                    Thread.sleep(100);
//                } catch (InterruptedException e) {
//                    break;
//                }
//            }
//            else {
//                try {
//                    Thread.sleep(100);
//                    this.행동게이지 = this.행동게이지 + 속도();
//                } catch (InterruptedException e) {
//                    break;
//                }
//                if (this.행동게이지 > 행동) {
//                    this.행동게이지 = 행동;
//                }
//                if (this.행동게이지 == 행동) {
//                    try {
////                        System.out.println("몬스터.run | 몬스터어레이.size() : " + 몬스터어레이.size());
//                        this.몬스터행동(몬스터어레이, 몬스터머릿수 - 죽은몬스터수, 플레이어);
//                        this.행동게이지 = 0;
//                    } catch (InterruptedException e) {
//                        break;
//                    }
//                }
//            }
//        }
//    }


    public void 공용드랍테이블(){
        if(공용드랍테이블.size() == 0) {
            드랍템 = new 체력물약("체력물약");
            공용드랍테이블.add(드랍템);
            드랍템 = new 마나물약("마나물약");
            공용드랍테이블.add(드랍템);
            드랍템 = new 검("검");
            공용드랍테이블.add(드랍템);
            드랍템 = new 방패("방패");
            공용드랍테이블.add(드랍템);
            드랍템 = new 갑옷("갑옷");
            공용드랍테이블.add(드랍템);
            드랍템 = new 각반("각반");
            공용드랍테이블.add(드랍템);
            드랍템 = new 장갑("장갑");
            공용드랍테이블.add(드랍템);
            드랍템 = new 공격력물약("공격력물약");
            공용드랍테이블.add(드랍템);
            드랍템 = new 방어력물약("방어력물약");
            공용드랍테이블.add(드랍템);
        }
    }


    public void 행동게이지() throws InterruptedException {
        if (!(플레이어.행동게이지 >= 플레이어.행동)){
            this.행동게이지 = this.행동게이지 + 속도();
        }
    }
    public int 공격력(){
        int 공격력 = (int) Math.ceil(this.최종공격력*(Math.random()*0.2+0.9));
        return 공격력;
    }
    public int 속도(){
        int 속도 = (int) Math.ceil(this.속도*(Math.random()*0.2+0.9));
        return 속도;
    }

    public void 몬스터행동(ArrayList<몬스터> 몬스터어레이, int 몬스터수, 캐릭터 플레이어) throws InterruptedException {
//        boolean 캐릭터사망 = false;
        boolean 리롤=true;
        while(리롤) {
            int 스킬선택 = rd.nextInt(this.스킬리스트.size());
            리롤 = this.스킬리스트.get(스킬선택).사용효과(this, Main.플레이어, 몬스터어레이);

            if (플레이어.캐릭터현재체력 <= 0) {
                System.out.println("플레이어는 쓰러졌다.");
                플레이어.사망횟수++;
//                캐릭터사망 = true;
                Thread.sleep(1000);
            }
        }
        if(this.지속스킬.size()>0){//적용중인 지속스킬이 있다면
//            System.out.println("몬스터.몬스터행동 | 지속스킬판정" + this.이름 + "은(는) 적용중인 지속스킬이 있음.");
            for(int i = 0 ; i < this.지속스킬.size() ; i++){ //지속스킬 수만큼 반복
                this.지속스킬.get(i).지속효과(this, Main.플레이어,몬스터어레이);
            }
            재시작:
            while(true){
                if(this.지속스킬.size()>0) {//계속 지워줘야하기 때문에 지속스킬 개수 판정을 다시함
                    for (int i = 0; i < this.지속스킬.size(); i++) {
                        if(this.지속스킬.get(i).지속효과삭제(this)){//스킬을 하나 지웠으면
                            continue 재시작; //재시작함
                        }
                    }
                }
                //지속스킬이 더이상 없거나 지울 스킬이 없다면
                break;
            }
        }
//        System.out.println("몬스터.몬스터행동 | 지속스킬판정");
//        return 캐릭터사망;
    }
}
















