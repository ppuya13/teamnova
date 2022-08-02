package java4.사냥터.몬스터;

import java4.사냥터.몬스터.스킬.기본공격;
import java4.사냥터.몬스터.스킬.몬스터스킬;
import java4.사냥터.몬스터.스킬.지속스킬;
import java4.아이템.아이템;
import java4.캐릭터.캐릭터;

import java.util.ArrayList;
import java.util.Random;

import static java4.Main.플레이어;

public abstract class 몬스터 { //몬스터 정보와 전투는 이곳에
    //몬스터 상속으로 처리하기
    public String 이름;
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
    static Random rd2 = new Random();

    public 몬스터(){
        몬스터스킬 기본공격 = new 기본공격();
        for(int i = 0; i < 1 ; i++) {
            this.스킬리스트.add(기본공격);
        }
        공용드랍테이블();
        this.드랍테이블.addAll(공용드랍테이블);
    }
    public void 공용드랍테이블(){
        if(공용드랍테이블.size() == 0) {
            드랍템 = new 아이템(-1);
            공용드랍테이블.add(드랍템);
            드랍템 = new 아이템(-2);
            공용드랍테이블.add(드랍템);
            드랍템 = new 아이템(100);
            공용드랍테이블.add(드랍템);
            드랍템 = new 아이템(101);
            공용드랍테이블.add(드랍템);
            드랍템 = new 아이템(102);
            공용드랍테이블.add(드랍템);
            드랍템 = new 아이템(103);
            공용드랍테이블.add(드랍템);
            드랍템 = new 아이템(200);
            공용드랍테이블.add(드랍템);
        }
    }

    public int 공격력(){
        int 공격력 = (int) Math.ceil(this.최종공격력*(Math.random()*0.2+0.9));
        return 공격력;
    }


    //전투방식 갈아엎음. 현재 사용되지 않는 메소드.
    public static int 공격(ArrayList<몬스터> 몬스터어레이, int 타겟, 캐릭터 캐릭터) throws InterruptedException {
        int 몬스터사망=0;
        몬스터 타겟몬스터=몬스터어레이.get(타겟-1);
        타겟몬스터.현재체력 = 타겟몬스터.현재체력-(캐릭터.캐릭터최종공격력-타겟몬스터.최종방어력);
        System.out.println(타겟몬스터.이름 + "을(를) 공격합니다.");
        Thread.sleep(1000);
        System.out.println(타겟몬스터.이름+"에게 "+(캐릭터.캐릭터최종공격력-타겟몬스터.최종방어력)+"의 데미지!");
        Thread.sleep(1000);

        if(몬스터어레이.get(타겟-1).현재체력<=0){
            몬스터사망=1;
            System.out.println(몬스터어레이.get(타겟-1).이름+"은(는) 쓰러졌다!");
            Thread.sleep(1000);
        }
        else{
            System.out.println(몬스터어레이.get(타겟-1).이름+"의 남은 체력은 "+몬스터어레이.get(타겟-1).현재체력+"이다.");
        }
        return 몬스터사망;
    }
    public boolean 몬스터행동(ArrayList<몬스터> 몬스터어레이, int 몬스터수, 캐릭터 캐릭터) throws InterruptedException {
        boolean 캐릭터사망 = false;
        boolean 리롤=true;
        while(리롤) {
            int 스킬선택 = rd.nextInt(this.스킬리스트.size());
            리롤 = this.스킬리스트.get(스킬선택).사용효과(this, 플레이어, 몬스터어레이);

            if (캐릭터.캐릭터현재체력 <= 0) {
                System.out.println("플레이어는 쓰러졌다.");
                캐릭터사망 = true;
                Thread.sleep(1000);
            }
        }
        if(this.지속스킬.size()>0){//적용중인 지속스킬이 있다면
//            System.out.println("몬스터.몬스터행동 | 지속스킬판정" + this.이름 + "은(는) 적용중인 지속스킬이 있음.");
            for(int i = 0 ; i < this.지속스킬.size() ; i++){ //지속스킬 수만큼 반복
                this.지속스킬.get(i).지속효과(this,플레이어,몬스터어레이);
            }
        }
//        System.out.println("몬스터.몬스터행동 | 지속스킬판정");
        return 캐릭터사망;
    }

}
















