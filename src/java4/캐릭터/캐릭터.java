package java4.캐릭터;

import java4.사냥터.몬스터.몬스터;
import java4.사냥터.사냥터;
import java4.스킬.단일스킬.기본공격;
import java4.스킬.스킬;
import java4.아이템.소모.지속형.지속형;
import java4.아이템.아이템;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java4.Main.*;
import static java4.Main.사냥터;
import static java4.사냥터.사냥터.*;
import static java4.사냥터.사냥터.사냥터입력.사냥터입력값;
import static java4.사냥터.사냥터.입력대기;
import static java4.사냥터.사냥터.몬스터어레이;
import static java4.사냥터.사냥터.턴타이머;

public abstract class 캐릭터 extends Thread{


    public int 전투횟수;
    public int 전투승리횟수;
    public ArrayList<아이템> 회복물약가방;
    public ArrayList<아이템> 소지품;
    public ArrayList<아이템> 강화목록;
    public ArrayList<아이템> 드랍템;
    public ArrayList<아이템> 사용중;
    public ArrayList<스킬> 스킬목록;
    public int 사망횟수 = 0;
    public int 획득경험치; //몬스터를 잡은 경험치는 전투 종료 시 획득경험치에 누적된다.
    public int 강화용경험치; //획득경험치는 사망 시 일정 비율 강화용경험치로 바뀜
    public int 소지금;
    public String 이름;
    public int 캐릭터레벨;
    public int 캐릭터최대경험치;
    public int 캐릭터현재경험치;
    public int 캐릭터최종체력;
    public int 캐릭터최대체력;
    public int 캐릭터추가체력;
    public int 레벨업추가체력;
    public int 영구체력;
    public int 캐릭터현재체력;
    public int 캐릭터최종마나;
    public int 캐릭터최대마나;
    public int 캐릭터추가마나;
    public int 레벨업추가마나;
    public int 영구마나;
    public int 캐릭터현재마나;
    public int 캐릭터최종공격력;
    public int 캐릭터공격력;
    public int 캐릭터추가공격력;
    public int 레벨업추가공격력;
    public int 영구공격력;
    public int 소모품추가공격력;
    public int 캐릭터최종방어력;
    public int 캐릭터방어력;
    public int 캐릭터추가방어력;
    public int 레벨업추가방어력;
    public int 영구방어력;
    public int 소모품추가방어력;
    public int 캐릭터최종치확;
    public int 캐릭터치명확률;
    public int 캐릭터추가치확;
    public int 레벨업추가치확;
    public int 캐릭터최종치피;
    public int 캐릭터치명피해;
    public int 캐릭터추가치피;
    public int 레벨업추가치피;
    public int 영구치피;
    public int 캐릭터최종회피;
    public int 캐릭터회피;
    public int 캐릭터추가회피;

    public int 캐릭터최종속도;
    public int 캐릭터속도;
    public int 캐릭터추가속도;
    public int 레벨업추가속도;
    public int 영구속도;
    public int 소모품추가속도;

    public int 활력;
    public int 활력최대;
    public int 명상;
    public int 명상최대;
    public int 완력강화;
    public int 완력강화최대;
    public int 두꺼운피부;
    public int 두꺼운피부최대;
    public int 기회포착;
    public int 기회포착최대;
    public int 상업의재능;
    public int 상업의재능최대;
    public int 장비다루기;
    public int 장비다루기최대;
    public int 대기만성;
    public int 대기만성최대;
    public int 소매치기;
    public int 소매치기최대;
    public int 불굴;
    public int 불굴최대;
    Random rd = new Random();
    Scanner sc = new Scanner(System.in);
    //    int 입력;
    int 정수강화;
    public final int 행동 = 10000; //행동게이지가 행동보다 높아지면 0으로 초기화하고 행동함
    public int 행동난수; //속도값에 따라 랜덤하게 행동난수값을 설정함
    public int 행동게이지 = 0;
    public static boolean 공격여부 = false;
    public static boolean 스킬여부 = false;
    public static boolean 아이템여부 = false;
    public static boolean 살펴보기여부 = false;
    public static boolean 도망치기여부 = false;

    public void run(){

        while(true) {
//            System.out.println("캐릭터.run | 캐릭터깨어남, 턴여부: "+java4.사냥터.사냥터.턴여부);
            if(턴여부){
//                System.out.println("캐릭터.run| 턴여부 들어옴");
//                플레이어선택중=true;
                if(공격여부){
//                    System.out.println("캐릭터.run| 공격여부 들어옴");
                    공격여부 =false;
                    try {
                        System.out.println("캐릭터.run| 캐릭터공격발동");
//                        System.out.println("캐릭터.run| 트라이 들어옴");
                        if(!(this.캐릭터공격(몬스터어레이, 사냥터))){
                            //결과가 false면(공격을 했으면)
                            this.행동게이지 = 0;
                            턴여부=false;
                            this.능력치적용();
                            사냥터.몬스터삭제(true);
                            this.턴넘김();
                            if(사냥터.전투종료판정(몬스터어레이,보스전)){
                                사냥터.전투정산(true,플레이어);
                            }
                            synchronized (전투_행동게이지){
                                전투_행동게이지.notify();
                            }
                        }
                    } catch (InterruptedException | CloneNotSupportedException e) {
                        throw new RuntimeException(e);
                    }
                }
                else if(스킬여부){
                    스킬여부 = false;
                    try {
                        this.스킬();
                    } catch (InterruptedException | CloneNotSupportedException e) {
                        throw new RuntimeException(e);
                    }
                }
                else if(아이템여부){
                    아이템여부 = false;
                    try {
                        this.아이템();
                    } catch (InterruptedException | CloneNotSupportedException e) {
                        throw new RuntimeException(e);
                    }
                }
                else if (살펴보기여부) {
                    살펴보기여부 = false;
                    try {
                        this.살펴보기();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                else if (도망치기여부) {
                    도망치기여부 = false;
                    try {
                        this.도망치기();
                    } catch (InterruptedException | CloneNotSupportedException e) {
                        throw new RuntimeException(e);
                    }
                }
                행동중=false;
            }
            System.out.println("캐릭터.run| 행동중: "+행동중);
            System.out.println("캐릭터.run| wait()");
            try {
                synchronized (this) {
                    this.wait();
                }
            } catch (InterruptedException e) {
                System.out.println("캐릭터| notify됨");
            }

        }//while문 종료
    }
    public void 스킬() throws InterruptedException, CloneNotSupportedException {
//        출력 메인 = new 출력();
        스킬 타겟스킬;
        boolean 스킬반복 = true;
        스킬:
        while (스킬반복 && 턴여부) {
            System.out.println("캐릭터.스킬()|스킬반복: "+스킬반복);
            System.out.println(메인.능력치창());
            System.out.println("\n보유 중인 스킬 리스트");
            System.out.println(메인.스킬창());
            System.out.print("" +
                    "사용할 스킬을 선택해주세요. " +
                    "\n→");
            synchronized (사냥터입력) {
                사냥터입력.notify();
            }
//            Thread.sleep(50);
            입력대기=true;
            while(입력대기){
                Thread.sleep(50);
            }
            System.out.println("캐릭터.스킬()|사냥터입력값: "+사냥터입력값 + ", 턴여부: "+턴여부);
            if(턴여부) {
                if (사냥터입력값 == 0) {
                    break;
                } else if (사냥터입력값 > 0 && 사냥터입력값 <= this.스킬목록.size()) {
                    System.out.println("캐릭터.스킬()|스킬발동");
                    타겟스킬 = this.스킬목록.get(사냥터입력값 - 1);
                    if (!타겟스킬.사용확인(몬스터어레이, 플레이어, 사냥터)) {
                        //결과가 false면(스킬을 사용했으면)
                        this.행동게이지 = 0;
                        턴여부=false;
                        this.능력치적용();
                        사냥터.몬스터삭제(true);
                        this.턴넘김();
                        if(사냥터.전투종료판정(몬스터어레이,보스전)){
                            사냥터.전투정산(true,(플레이어)this);
                        }
                        synchronized (전투_행동게이지){
                            전투_행동게이지.notify();
                        }
                    }
                    continue 스킬;
                }
            }
        }
    }
    public void 아이템() throws InterruptedException, CloneNotSupportedException {
//        출력 메인 = new 출력();
        아이템 아이템정보;
        아이템:
        while (턴여부) {
            System.out.println(메인.능력치창());
            System.out.println("\n아이템 사용하기");
            System.out.println(메인.행동인벤토리());
            System.out.print("" +
                    "아이템을 선택해주세요. " +
                    "\n소모품만을 사용할 수 있으며, 아이템 사용 시 턴을 넘기게됩니다." +
                    "\n→");
            synchronized (사냥터입력) {
                사냥터입력.notify();
            }
            입력대기=true;
            while(입력대기){
                Thread.sleep(50);
            }
            if(턴여부) {
                if (사냥터입력값 == 0) {
                    break;
                } else if (사냥터입력값 > 0 && 사냥터입력값 <= this.소지품.size() + this.회복물약가방.size()) {
                    아이템정보 = this.아이템사용(사냥터입력값);
                    if (아이템정보.착용가능여부) { //선택한 아이템이 착용가능하면
                        System.out.println("전투중엔 아이템 장착/해제를 할 수 없습니다.");
                        Thread.sleep(1000);
                    } else {
                        if (!아이템정보.사용효과((플레이어)this)) {
                            this.행동게이지 = 0;
                            턴여부=false;
                            this.능력치적용();
                            사냥터.몬스터삭제(true);
                            this.인벤정리();
                            this.턴넘김();
                            if(사냥터.전투종료판정(몬스터어레이,보스전)){
                                사냥터.전투정산(true,(플레이어)this);
                            }
                            synchronized (전투_행동게이지){
                                전투_행동게이지.notify();
                            }
                        }
                        continue 아이템;
                    }
                }
            }
        }
    }
    public void 살펴보기() throws InterruptedException {
        몬스터 몬스터타겟;
        while (턴여부) {
            System.out.println(메인.능력치창());
            System.out.println("\n살펴볼 몬스터를 선택하세요.");
            System.out.println(사냥터출력.행동몬스터목록());
            System.out.print("\n→");
            synchronized (사냥터입력) {
                사냥터입력.notify();
            }
            입력대기=true;
            while(입력대기){
                Thread.sleep(50);
            }
            if (사냥터입력값 == 0) {
                break;
            }
            else if (사냥터입력값 > 0 && 사냥터입력값 <= 몬스터어레이.size()) {
                System.out.println("캐릭터.살펴보기()| 몬스터어레이.size(): " + 몬스터어레이.size());
                몬스터타겟 = 몬스터어레이.get(사냥터입력값 - 1);
                System.out.println(메인.정보출력(몬스터타겟));
                for(int i = 0 ; i < 몬스터어레이.get(사냥터입력값-1).스킬리스트.size() ; i++){
                    System.out.println(몬스터어레이.get(사냥터입력값-1).이름+"의 스킬 " + i + ": " + 몬스터어레이.get(사냥터입력값-1).스킬리스트.get(i).스킬명);
                }
                System.out.print("" +
                        "\n계속하려면 아무 숫자나 입력하세요." +
                        "\n→");
                synchronized (사냥터입력) {
                    사냥터입력.notify();
                }
                입력대기=true;
                while(입력대기){
                    Thread.sleep(50);
                }
                break;
            }
        }
    }
    public void 도망치기() throws InterruptedException, CloneNotSupportedException {
        if (!보스전) {
            while (턴여부) {
                System.out.println("" +
                        "정말 도망치시겠습니까?" +
                        "\n0.취소한다." +
                        "\n1.도망친다.");
                synchronized (사냥터입력) {
                    사냥터입력.notify();
                }
                입력대기=true;
                while(입력대기){
                    Thread.sleep(50);
                }

                if (턴여부) {
                    switch (사냥터입력값) {
                        case 0:
                            return;
                        case 1:
                            턴여부=false;
                            행동중=false;
                            턴타이머.타이머종료();
                            System.out.println("도망쳤습니다.");
                            Thread.sleep(1000);
                            사냥터.전투정산(false,플레이어);
                            synchronized (전투_행동게이지){
                                전투_행동게이지.notify();
                            }
                            return;
                    }
                }
            }
        }
    }
    public int 속도(){
        int 속도 = (int) Math.ceil(this.캐릭터최종속도 *(Math.random()*0.2+0.9));
        return 속도;
    }
    public void 턴넘김() throws InterruptedException {
//        System.out.println("캐릭터.턴넘김| 턴넘기기 실행");
//        if (턴넘김) {
        if (this.사용중.size() > 0) {//적용중인 지속스킬이 있다면
            for (int i = 0; i < this.사용중.size(); i++) { //지속스킬 수만큼 반복
                ((지속형) this.사용중.get(i)).효과적용((플레이어)this);
            }
            재시작:
            while (true) {
                if (this.사용중.size() > 0) {//계속 지워줘야하기 때문에 지속스킬 개수 판정을 다시함
                    for (int i = 0; i < this.사용중.size(); i++) {
                        if (((지속형) this.사용중.get(i)).효과삭제((플레이어)this)) {//스킬을 하나 지웠으면
                            continue 재시작; //재시작함
                        }
                    }
                }
                //지속스킬이 더이상 없거나 지울 스킬이 없다면
                break;
            }
        }
//        }
        this.능력치적용();
    }
    public abstract void 스킬초기화();
    public abstract void 인벤토리초기화();
    public void 능력치적용(){
        this.장비능력치적용();
        this.최종능력치적용();
    }
    public void 장비능력치적용(){
        this.캐릭터추가체력=0;
        this.캐릭터추가마나=0;
        this.캐릭터추가공격력=0;
        this.캐릭터추가방어력=0;
        this.캐릭터추가치확=0;
        this.캐릭터추가치피=0;
        this.캐릭터추가회피=0;
        this.캐릭터추가속도=0;
        ArrayList<아이템> 소지품 = this.소지품;
        아이템 타겟;
        for(int i=0 ; i<=소지품.size()-1 ; i++){
            타겟 = 소지품.get(i);
            if(타겟.착용여부){ //i번째 장비템이 착용중이면
                this.캐릭터추가체력=this.캐릭터추가체력+타겟.기본체력+타겟.추가체력;
//                System.out.println("추가체력적용 "+this.캐릭터추가체력);
                this.캐릭터추가마나=this.캐릭터추가마나+타겟.기본마나+타겟.추가마나;
//                System.out.println("추가마나적용 "+this.캐릭터추가마나);
                this.캐릭터추가공격력=this.캐릭터추가공격력+타겟.기본공격력+타겟.추가공격력;
//                System.out.println("추가공격적용 "+this.캐릭터추가공격력);
                this.캐릭터추가방어력= this.캐릭터추가방어력+타겟.기본방어력+타겟.추가방어력;
//                System.out.println("추가방어적용 "+this.캐릭터추가방어력);
                this.캐릭터추가치확=this.캐릭터추가치확+타겟.기본치확+타겟.추가치확;
//                System.out.println("추가치확적용 "+this.캐릭터추가치확);
                this.캐릭터추가치피=this.캐릭터추가치피+타겟.기본치피+타겟.추가치피;
//                System.out.println("추가치피적용 "+this.캐릭터추가치피);
                this.캐릭터추가회피=this.캐릭터추가회피+타겟.추가회피; //기본회피를 제공하는 아이템이 현재 없음.
                this.캐릭터추가속도=this.캐릭터추가속도+타겟.기본속도+타겟.추가속도;
            }
        }
    }
    public void 최종능력치적용(){
        this.캐릭터최종체력=1000+this.캐릭터추가체력+this.레벨업추가체력+this.영구체력;
        this.캐릭터최종마나=100+this.캐릭터추가마나+this.레벨업추가마나+this.영구마나;
        this.캐릭터최종공격력=this.캐릭터공격력+this.캐릭터추가공격력+this.레벨업추가공격력+this.소모품추가공격력+this.영구공격력;
        this.캐릭터최종방어력=this.캐릭터방어력+this.캐릭터추가방어력+this.레벨업추가방어력+this.소모품추가방어력+this.영구방어력;
        this.캐릭터최종치확=this.캐릭터치명확률+this.캐릭터추가치확+this.레벨업추가치확;
        this.캐릭터최종치피=this.캐릭터치명피해+this.캐릭터추가치피+this.레벨업추가치피+this.영구치피;
        this.캐릭터최종회피=this.캐릭터회피+this.캐릭터추가회피;
        this.캐릭터최종속도=this.캐릭터속도+this.캐릭터추가속도+this.레벨업추가속도+this.소모품추가속도+this.영구속도;
        if(this.캐릭터최종체력<캐릭터현재체력){//최종체력보다 현재체력이 클경우
            this.캐릭터현재체력=this.캐릭터최종체력;
        }
        if(this.캐릭터최종마나<캐릭터현재마나){//최종마나보다 현재마나가 클경우
            this.캐릭터현재마나=this.캐릭터최종마나;
        }
    }
    public void 레벨업() throws InterruptedException {
        System.out.println("\n레벨업!");
        this.캐릭터레벨++;
        System.out.println("레벨이 "+this.캐릭터레벨 + "이(가) 되었다!");
        this.캐릭터현재경험치 = this.캐릭터현재경험치 -this.캐릭터최대경험치;
        this.캐릭터최대경험치 = this.캐릭터최대경험치 + 100;
        Thread.sleep(1000);
        int 랜덤값;
        int 상승횟수=0;
        while(상승횟수 <= 4){
            랜덤값 = rd.nextInt(60); //0~9체력 | 10~19마나 | 20~29공격력 | 30~39방어력 | 40~49치피 |50~59속도
            if(랜덤값<=9){ //0~9체력
                정수강화=rd.nextInt(11)+20; //20~30 상승
                System.out.println("체력이 "+정수강화+" 만큼 성장했다!");
                this.레벨업추가체력=this.레벨업추가체력+정수강화;
                상승횟수++;
                Thread.sleep(200);
            }
            else if(랜덤값<=19){ //10~19마나
                정수강화=rd.nextInt(6)+5;
                System.out.println("마나가 "+정수강화+" 만큼 성장했다!");
                this.레벨업추가마나=this.레벨업추가마나+정수강화;
                상승횟수++;
                Thread.sleep(200);
            }
            else if(랜덤값<=29){ //20~29공격력
                정수강화=rd.nextInt(6)+5;
                System.out.println("공격력이 "+정수강화+" 만큼 성장했다!");
//                this.캐릭터공격력=this.캐릭터공격력+정수강화;
                this.캐릭터공격력=this.캐릭터공격력+정수강화;
                상승횟수++;
                Thread.sleep(200);
            }
            else if(랜덤값<=39){ //30~39방어력
                정수강화=rd.nextInt(3)+1;
                System.out.println("방어력이 "+정수강화+" 만큼 성장했다!");
//                this.캐릭터방어력=this.캐릭터방어력+정수강화;
                this.캐릭터방어력=this.캐릭터방어력+정수강화;
                상승횟수++;
                Thread.sleep(200);
            }
            else if(랜덤값<=49){ //40~49치피
                정수강화=rd.nextInt(6)+5;
                System.out.println("치명타 피해량이 "+정수강화+" 만큼 상승했다!");
                this.레벨업추가치피=this.레벨업추가치피+정수강화;
                상승횟수++;
                Thread.sleep(200);
            }
            else if(랜덤값<=59){ //50~59속도
                정수강화=rd.nextInt(3)+1;
                System.out.println("속도가 "+정수강화+" 만큼 상승했다!");
                this.레벨업추가속도=this.레벨업추가속도+정수강화;
                상승횟수++;
                Thread.sleep(200);
            }
        }
        this.캐릭터현재체력=this.캐릭터최대체력+this.레벨업추가체력;
        this.캐릭터현재마나=this.캐릭터최대마나+this.레벨업추가마나;
    }
    public void 휴식() throws InterruptedException {
        System.out.println("\n휴식합니다.");
        Thread.sleep(1000);
        if (this.캐릭터최종체력 - this.캐릭터현재체력 >= 300) {
            this.캐릭터현재체력 = this.캐릭터현재체력 + 300;
            System.out.print("\n체력이 300회복되어 " + this.캐릭터현재체력 + "이(가) 되었습니다.");

        } else {
            System.out.print("\n체력이 " + (this.캐릭터최종체력 - this.캐릭터현재체력) + "회복되어 ");
            this.캐릭터현재체력 = this.캐릭터최종체력;
            System.out.print(this.캐릭터현재체력 + "이(가) 되었습니다.");
        }
        if (this.캐릭터최종마나 - this.캐릭터현재마나 >= 30) {
            this.캐릭터현재마나 = this.캐릭터현재마나 + 30;
            System.out.print("\n체력이 30회복되어 " + this.캐릭터현재마나 + "이(가) 되었습니다.");

        } else {
            System.out.print("\n체력이 " + (this.캐릭터최종마나 - this.캐릭터현재마나) + "회복되어 ");
            this.캐릭터현재마나 = this.캐릭터최종마나;
            System.out.print(this.캐릭터현재마나 + "이(가) 되었습니다.");
        }
        System.out.print("" +
                "\n계속하려면 아무 숫자나 입력하세요." +
                "\n→");
        int 입력 = sc.nextInt();
    }
    public boolean 캐릭터공격(ArrayList<몬스터> 몬스터어레이, 사냥터 출력) throws InterruptedException {
        기본공격 기본공격 = new 기본공격();
        System.out.println("캐릭터.캐릭터공격| 발동");
        return 기본공격.사용확인(몬스터어레이,this,출력); //true면 사용실패or취소, false면 사용성공
    }
    public 아이템 아이템사용(int 입력){
        아이템 타겟;
//        int 회복물약가방크기= Main.플레이어.회복물약가방.size();
        int 회복물약가방크기= this.회복물약가방.size();
        if(입력 <=회복물약가방크기){ //회복물약 내용물을 선택했다면
            타겟= this.회복물약가방.get(입력 -1);
        }

        else{ //회복물약가방 내용물이 아닌것을 선택했다면
            타겟 = this.소지품.get(입력 -(회복물약가방크기+1));
        }
        return 타겟;
    }
    public void 인벤정리(){
        for(int i = 0; i<= this.소지품.size()-1 ; i++){
            if(this.소지품.get(i).스택수 == 0){
//                System.out.println(this.소지품.size()-1);
                this.소지품.remove(i);
                break;
            }
        }
    }
    public int 아이템버리기(int 입력) throws InterruptedException {
        int 물약여부=2; //1:물약이거나 버릴수없음, 2:물약아님
        int 회복물약가방크기= this.회복물약가방.size();
        int 사용선택;
        아이템 아이템정보;
        if (입력 <= 회복물약가방크기) { //회복물약 내용물을 선택했다면
            System.out.println("\n회복물약은 버릴 수 없습니다.");
            Thread.sleep(1000);
            물약여부 = 1;
        } else { //회복물약가방 내용물이 아닌것을 선택했다면
            사용선택 = 입력 - (회복물약가방크기 + 1);
            아이템정보 = this.소지품.get(사용선택);
            if (아이템정보.착용여부) { //착용중이라면
                System.out.println("\n우선 장착을 해제해주세요.");
                Thread.sleep(1000);
                물약여부 = 1;
            }
        }
        return 물약여부;
    }
    public int 아이템버리기2(int 물약여부, int 입력) throws InterruptedException {
        int 개수 = 1;
        boolean 진행 = true;
        if(물약여부 == 2) {//물약도 아니고 장착중도 아닐경우
            아이템 타겟 = this.소지품.get(입력-(this.회복물약가방.size() + 1));
            if (타겟.스택가능여부) {//스택가능이면
                while (true) {
                    System.out.print("" +
                            "\n버릴 개수를 입력해주세요. (0개: 취소)" +
                            "\n→");
                    입력 = sc.nextInt();
                    if (입력 == 0) { //버릴 개수를 0개로 입력한다면
                        개수 = 0;
                        break;
                    } else if (입력 >= 1 && 입력 <= 타겟.스택수) { //버릴 개수를 1이상, 스택수 이하로 입력했다면
                        개수 = 입력;
                        break;
                    } else if (입력 > 타겟.스택수) { //버릴 개수를 스택수 보다 많게 입력했다면
                        System.out.println("" +
                                "\n가진 양보다 많은 양을 버릴 수는 없습니다.");
                        Thread.sleep(1000);
                        개수 = 0;
                        break;
                    }
                }
                if (개수 > 0) { //개수가 0보다 많다면 선택한 아이템을 선택한 만큼 버릴건지 최종 확인
                    while (true) { // 0과 1 이외의 숫자를 입력할 경우 무한루프함
                        System.out.println("" +
                                "\n정말 " + 타겟.아이템이름 + " " + 개수 + " 개를 버리겠습니까?" +
                                "\n0.취소한다." +
                                "\n1.버린다.");
                        입력 = sc.nextInt();
                        if (입력 == 0) {
                            개수 = 0;
                            break;
                        } else if (입력 == 1) {
                            break;
                        }
                    }
                }
            } else { //스택이 불가능하다면
                개수 = 1;
                while (true) { // 0과 1 이외의 숫자를 입력할 경우 무한루프함
                    System.out.println("" +
                            "\n정말 " + 타겟.아이템이름 + "을(를) 버리겠습니까?" +
                            "\n0.취소한다." +
                            "\n1.버린다.");
                    입력 = sc.nextInt();
                    if (입력 == 0) {
                        개수 = 0;
                        break;
                    } else if (입력 == 1) {
                        break;
                    }
                }
            }
        }else{ //물약여부가 1이면
            개수=0;
        }
        return 개수;
    }
    public void 아이템버리기실행(int 개수, int 입력) throws InterruptedException {
//        System.out.println("버리기전 아이템.스택수 : "+ 아이템.스택수 + ", 개수 : "+개수);
        if (개수 != 0) {
            아이템 아이템 = this.소지품.get(입력-(this.회복물약가방.size() + 1));
            if(개수>1) {
                System.out.println(아이템.아이템이름 + "을 " + 개수 + "개 버립니다.");
            }
            else if(개수==1){
                System.out.println(아이템.아이템이름 + "을 버립니다.");
            }
            Thread.sleep(1000);
            아이템.스택수 = 아이템.스택수-개수;
        }
//        System.out.println("버린후 아이템.스택수 : "+ 아이템.스택수 + ", 개수 : "+개수);
    }
}
