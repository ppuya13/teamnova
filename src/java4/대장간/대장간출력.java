package java4.대장간;

import java4.상점.상점;
import java4.아이템.아이템;
import java4.출력;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java4.Main.플레이어;

public class 대장간출력 {
    Random rd = new Random();
    int 정수강화;
    int 입력;
    Scanner sc = new Scanner(System.in);
    출력 메인 = new 출력();
    아이템 아이템정보;
    public 대장간슬롯 슬롯1;
    public 대장간슬롯 슬롯2;
    public 대장간슬롯 슬롯3;
    ArrayList<아이템> 제작템어레이 = new ArrayList<>();
    public 대장간출력(){
        슬롯1 = new 대장간슬롯("슬롯1");
        슬롯2 = new 대장간슬롯("슬롯2");
        슬롯3 = new 대장간슬롯("슬롯3");
        슬롯1.start();
        슬롯2.start();
        슬롯3.start();
    }

    public void 대장간() throws InterruptedException {
        this.강화리스트생성();
        아이템정보=null;
        StringBuilder 강화능력치표시 = new StringBuilder();
        boolean 마을=false;
        대장간:
        while(!마을){
            System.out.println(메인.능력치창());
            System.out.print("" +
                    "\n대장간에 들어왔습니다. " +
                    "\n대장간에서는 아이템을 강화할 수 있습니다." +
                    "\n0.나가기" +
                    "\n1.강화하기" +
                    "\n2.제작하기"+
                    "\n3.살펴보기(인벤토리)" +
                    "\n→");
            입력 = sc.nextInt();
            switch (입력){
                case 0: //나가기
                    마을=true;
                    break;
                case 1: //강화하기
                    강화하기:
                    while(true) {
                        System.out.println(메인.능력치창());
                        System.out.println(메인.행동강화목록());
                        System.out.print("" +
                                "\n강화는 1회에 100골드가 소모되며, 최대 10번까지 강화할 수 있습니다." +
                                "\n강화의 성공확률은 100%입니다." +
                                "\n강화시 해당 아이템의 랜덤한 능력치가 랜덤한 수치만큼 상승합니다." +
                                "\n강화할 아이템을 선택해주세요." +
                                "\n→");
                        입력 = sc.nextInt();
                        if(입력==0){
                            continue 대장간;
                        }else if(입력>0 && 입력<=플레이어.강화목록.size()){
                            아이템정보 = 플레이어.강화목록.get(입력-1);
                            강화능력치표시.setLength(0);
                            if(아이템정보.착용여부){ // 강화하려고 선택한 아이템이 착용중일 경우
                                System.out.println("\n착용 중인 아이템을 강화할 수 없습니다.");
                                Thread.sleep(1000);
                            }
                            else if(플레이어.소지금<100){ //캐릭터의 소지금이 100미만이라면
                                System.out.println("\n소지금이 부족합니다.");
                                Thread.sleep(1000);
                            }
                            else if(아이템정보.강화>=10) { //아이템이 10강이라면
                                System.out.println("\n더 이상 강화할 수 없습니다.");
                                Thread.sleep(1000);
                                System.out.println("해당 아이템의 추가능력치는");
                                강화능력치표시.append("\n" + 아이템정보.아이템이름 + "\n");
                                if (아이템정보.추가체력 >= 1) { //선택한 아이템이 추가체력이 1 이상일 때
                                    강화능력치표시.append("추가 체력: " + 아이템정보.추가체력 + "\n");
                                }
                                if (아이템정보.추가마나 >= 1) {
                                    강화능력치표시.append("추가 마나: " + 아이템정보.추가마나 + "\n");
                                }
                                if (아이템정보.추가공격력 >= 1) {
                                    강화능력치표시.append("추가 공격력: " + 아이템정보.추가공격력 + "\n");
                                }
                                if (아이템정보.추가방어력 >= 1) {
                                    강화능력치표시.append("추가 방어력: " + 아이템정보.추가방어력 + "\n");
                                }
                                if (아이템정보.추가치확 >= 1) {
                                    강화능력치표시.append("추가 치명확률: " + 아이템정보.추가치확 + "\n");
                                }
                                if (아이템정보.추가치피 >= 1) {
                                    강화능력치표시.append("추가 치명피해: " + 아이템정보.추가치피 + "\n");
                                }
                                if (아이템정보.추가회피 >= 1) {
                                    강화능력치표시.append("추가 회피율: " + 아이템정보.추가회피 + "\n");
                                }
                                System.out.print(강화능력치표시+"입니다. " +
                                        "\n계속하려면 아무 숫자나 입력하세요." +
                                        "\n→");
                                입력 =sc.nextInt();
                            }else{ //강화가능하다면
                                while(true) {//0과 1 이외의 것을 입력하면 무한반복
                                    강화능력치표시.setLength(0);
                                    강화능력치표시.append("\n" + 아이템정보.아이템이름 + "\n");
                                    if (아이템정보.추가체력 >= 1) { //선택한 아이템이 추가체력이 1 이상일 때
                                        강화능력치표시.append("추가 체력: " + 아이템정보.추가체력 + "\n");
                                    }
                                    if (아이템정보.추가마나 >= 1) {
                                        강화능력치표시.append("추가 마나: " + 아이템정보.추가마나 + "\n");
                                    }
                                    if (아이템정보.추가공격력 >= 1) {
                                        강화능력치표시.append("추가 공격력: " + 아이템정보.추가공격력 + "\n");
                                    }
                                    if (아이템정보.추가방어력 >= 1) {
                                        강화능력치표시.append("추가 방어력: " + 아이템정보.추가방어력 + "\n");
                                    }
                                    if (아이템정보.추가치확 >= 1) {
                                        강화능력치표시.append("추가 치명확률: " + 아이템정보.추가치확 + "\n");
                                    }
                                    if (아이템정보.추가치피 >= 1) {
                                        강화능력치표시.append("추가 치명피해: " + 아이템정보.추가치피 + "\n");
                                    }
                                    if (아이템정보.추가회피 >= 1) {
                                        강화능력치표시.append("추가 회피율: " + 아이템정보.추가회피 + "\n");
                                    }
                                    강화능력치표시.append("위 아이템을 강화하시겠습니까?" +
                                            "\n0.취소하기" +
                                            "\n1.강화하기" +
                                            "\n→");
                                    System.out.print(강화능력치표시);
                                    입력 = sc.nextInt();
                                    switch (입력) {
                                        case 0://취소하기
                                            continue 강화하기;
                                        case 1://강화하기
                                            아이템강화(아이템정보);
                                            continue 강화하기;
                                    }
                                }
                            }
                        }
                    }
                case 2: //제작하기
                    제작하기:
                    while(true){
                        System.out.println(""+
                                "\n제작하기" +
                                "\n아이템은 동시에 3개까지만 제작할 수 있으며 1회 제작에 100골드가 필요합니다.");
                        System.out.print(this.제작슬롯(슬롯1,슬롯2,슬롯3));
                        System.out.print(""+
                                "\n이용할 슬롯의 번호를 입력해주세요." +
                                "\n(0. 뒤로가기)" +
                                "\n→");
                        입력 = sc.nextInt();
                        if(입력==0){
                            continue 대장간;
                        }else if(입력==1){
                            슬롯1.선택();
                        }else if(입력==2){
                            슬롯2.선택();
                        }else if(입력==3){
                            슬롯3.선택();
                        }
                    }


                case 3: //강화살펴보기
                    살펴보기:
                    while(true){
                        System.out.println(메인.능력치창());
                        System.out.print(메인.행동강화목록());
                        System.out.print(""+
                                "\n강화하기 전 아이템의 능력치를 확인해볼 수 있습니다." +
                                "\n확인할 아이템을 선택해주세요." +
                                "\n→");
                        입력 = sc.nextInt();
                        if(입력==0){
                            continue 대장간;
                        }
                        else if(입력>0 && 입력<=플레이어.강화목록.size()){
                            아이템정보=플레이어.강화목록.get(입력-1);
                            System.out.println(메인.장비살펴보기(아이템정보));
                            System.out.print("넘기려면 아무 숫자나 입력하세요." +
                                    "\n→");
                            입력 =sc.nextInt();
                        }
                    }
            }
        }
    }

    public class 대장간슬롯 extends Thread{

        final int 제작시간=60;
        public int 남은시간;
        public int 상태; //0:비어있음, 1:제작중, 2:제작완료
        public 아이템 제작아이템;
        public String 아이템이름;
        public String 이름;
        int 제작난수;
        int 강화수치;
        int 반복횟수;
        Random rd = new Random();

        상점 상점 = new 상점();

        대장간슬롯(String 이름){
            this.이름 = 이름;
            this.상태 = 0;
            this.아이템이름 = "비어있음";
        }
        public void run(){
            while(true) {
                synchronized (this) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                if(this.상태==0){//비어있을때 깨어났다면
                    this.상태=1;
                    try {
                        this.제작아이템 = (아이템) 제작템어레이.get(입력-1).clone();
                    } catch (CloneNotSupportedException e) {
                        throw new RuntimeException(e);
                    }
                    this.아이템이름 = this.제작아이템.아이템이름;
                    for(남은시간 = 제작시간 ; 남은시간 > 0 ; 남은시간--){
//                        System.out.println("대장간출력(대장간슬롯.run)| 제작 남은시간 " + 남은시간 + "초 남음");
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println(this.이름 +"에서 아이템 제작이 완료되었습니다.");
                    this.상태=2;
                }
            }//while문 끝
        }

        public void 선택() throws InterruptedException {
            if(this.상태==0){ //슬롯이 비어있으면
                System.out.println(제작리스트출력(상점, this)); //뭘 만들지 물어봄
                System.out.print("→");
                입력 = sc.nextInt();
                if(입력==0){
                    return;
                }
                else if(입력 > 0 && 입력 <= 제작템어레이.size());{//입력+1이 선택된아이템
                    if(플레이어.소지금>=100){//돈이 충분하다면
                        플레이어.소지금=플레이어.소지금-100;
                        System.out.println("100골드를 지불하여 " + this.이름 + "에서 " + 제작템어레이.get(입력-1).아이템이름 + "을(를) 제작합니다.");
                        Thread.sleep(1000);
                        synchronized (this){
                            this.notify();
                        }
                    }
                }
            }
            else if(this.상태==1){ //슬롯이 제작중이면
                System.out.println("" +
                        "이 슬롯은 현재 "+ this.제작아이템.아이템이름 +" 을(를) 제작중입니다. (완료까지 약 " + this.남은시간 + "초)");
                Thread.sleep(1000);
            }
            else{ //슬롯이 제작완료라면
                if(플레이어.소지품.size()>=20){
                    System.out.println("인벤토리가 꽉찼습니다. 인벤토리를 비우고 오세요.");
                    Thread.sleep(1000);
                }else {
                    this.반복횟수 = 0;
                    this.강화수치 = 0;
                    while (this.반복횟수 < 10) { // 0~4강은 40%, 5~9강은 20%로 각각 성공.)
                        if (this.강화수치 < 5) { //제작아이템이 5강 미만이면
                            if (rd.nextInt(100) + 40 > 99) {
                                this.강화수치++;
                            }
                        } else { //제작아이템이 5강 이상이면
                            if (rd.nextInt(100) + 20 > 99) {
                                this.강화수치++;
                            }
                        }
                        this.반복횟수++;
                    }
                    for(int i = 0 ; i < this.강화수치 ; i++) {
                        int 랜덤값 = rd.nextInt(70); //0~9체력 | 10~19마나 | 20~29공격력 | 30~39방어력 | 40~49치확 | 50~59치피 | 60~69회피
                        if (랜덤값 <= 9) { //0~9체력
                            정수강화 = rd.nextInt(11) + 20; //20~30 상승
                            this.제작아이템.추가체력 = this.제작아이템.추가체력 + 정수강화;
                        } else if (랜덤값 <= 19) { //10~19마나
                            정수강화 = rd.nextInt(6) + 5; //5~10 상승
                            this.제작아이템.추가마나 = this.제작아이템.추가마나 + 정수강화;
                        } else if (랜덤값 <= 29) { //20~29공격력
                            정수강화 = rd.nextInt(6) + 5;
                            this.제작아이템.추가공격력 = this.제작아이템.추가공격력 + 정수강화;
                        } else if (랜덤값 <= 39) { //30~39방어력
                            정수강화 = rd.nextInt(3) + 1;
                            this.제작아이템.추가방어력 = this.제작아이템.추가방어력 + 정수강화;
                        } else if (랜덤값 <= 49) { //40~49치확
                            정수강화 = rd.nextInt(3) + 1;
                            this.제작아이템.추가치확 = this.제작아이템.추가치확 + 정수강화;
                        } else if (랜덤값 <= 59) { //50~59치피
                            정수강화 = rd.nextInt(6) + 5;
                            this.제작아이템.추가치피 = this.제작아이템.추가치피 + 정수강화;
                        } else if (랜덤값 <= 69) { //60~69회피
                            정수강화 = rd.nextInt(3) + 1;
                            this.제작아이템.추가회피 = this.제작아이템.추가회피 + 정수강화;
                        }
                        this.제작아이템.강화++;
                    }
                    this.제작아이템.아이템이름="+" + this.제작아이템.강화 + " " + this.제작아이템.임시이름;
                    System.out.println("아이템이 완성됐습니다.");
                    Thread.sleep(500);
                    System.out.println(메인.장비살펴보기(this.제작아이템));
                    System.out.println("" +
                            "아이템을 획득하려면 아무 숫자나 입력하세요." +
                            "→");
                    입력 = sc.nextInt();
                    플레이어.소지품.add(this.제작아이템);
                    this.상태=0;
                    강화리스트생성();
                    this.아이템이름="비어있음";
                }
            }
        }
    }

    public void 아이템강화(아이템 아이템) throws InterruptedException {
        int 랜덤값=rd.nextInt(70); //0~9체력 | 10~19마나 | 20~29공격력 | 30~39방어력 | 40~49치확 | 50~59치피 | 60~69회피
        if(랜덤값<=9){ //0~9체력
            정수강화=rd.nextInt(11)+20; //20~30 상승
            System.out.println(아이템.아이템이름+"을(를) 강화하여 체력이 "+정수강화+" 상승하였습니다.");
            아이템.추가체력=아이템.추가체력+정수강화;
        }
        else if(랜덤값<=19){ //10~19마나
            정수강화=rd.nextInt(6)+5; //5~10 상승
            System.out.println(아이템.아이템이름+"을(를) 강화하여 마나가 "+정수강화+" 상승하였습니다.");
            아이템.추가마나=아이템.추가마나+정수강화;
        }
        else if(랜덤값<=29){ //20~29공격력
            정수강화=rd.nextInt(6)+5;
            System.out.println(아이템.아이템이름+"을(를) 강화하여 공격력이 "+정수강화+" 상승하였습니다.");
            아이템.추가공격력=아이템.추가공격력+정수강화;
        }
        else if(랜덤값<=39){ //30~39방어력
            정수강화=rd.nextInt(3)+1;
            System.out.println(아이템.아이템이름+"을(를) 강화하여 방어력이 "+정수강화+" 상승하였습니다.");
            아이템.추가방어력=아이템.추가방어력+정수강화;
        }
        else if(랜덤값<=49){ //40~49치확
            정수강화=rd.nextInt(3)+1;
            System.out.println(아이템.아이템이름+"을(를) 강화하여 치명확률이 "+정수강화+" 상승하였습니다.");
            아이템.추가치확=아이템.추가치확+정수강화;
        }
        else if(랜덤값<=59){ //50~59치피
            정수강화=rd.nextInt(6)+5;
            System.out.println(아이템.아이템이름+"을(를) 강화하여 치명피해가 "+정수강화+" 상승하였습니다.");
            아이템.추가치피=아이템.추가치피+정수강화;
        }
        else if(랜덤값<=69){ //60~69회피
            정수강화=rd.nextInt(3)+1;
            System.out.println(아이템.아이템이름+"을(를) 강화하여 회피율이 "+정수강화+" 상승하였습니다.");
            아이템.추가회피=아이템.추가회피+정수강화;
        }
        아이템.강화=아이템.강화+1;
        플레이어.소지금=플레이어.소지금-100;
        아이템.아이템이름="+" + 아이템.강화 + " " + 아이템.임시이름;
        Thread.sleep(1000);
    }

    public void 강화리스트생성(){
//        System.out.println("강화리스트생성");
        플레이어.강화목록.clear();
        for(int i=0 ; i<=플레이어.소지품.size()-1 ; i++){
            if(플레이어.소지품.get(i).착용가능여부){ //착용가능하면(현재는 착용가능한템이 전부 강화가 가능함)
                플레이어.강화목록.add(플레이어.소지품.get(i));
            }
        }
    }

    public StringBuilder 제작슬롯(대장간슬롯 슬롯1, 대장간슬롯 슬롯2, 대장간슬롯 슬롯3){
        StringBuilder 제작슬롯 = new StringBuilder();
        제작슬롯.append("" +
                "\n┌──소지금: " + 플레이어.소지금 + "골드──" +
                "\n│슬롯1:" +
                "\n│" + 슬롯1.아이템이름);
        if(슬롯1.상태==1){
            제작슬롯.append(" 제작중 (약 " + 슬롯1.남은시간 + "초뒤 제작 완료)");
        }else if(슬롯1.상태==2){
            제작슬롯.append(" 제작완료");
        }
        제작슬롯.append("" +
                "\n│" +
                "\n│슬롯2:" +
                "\n│" + 슬롯2.아이템이름);
        if(슬롯2.상태==1){
            제작슬롯.append(" 제작중 (약 " + 슬롯2.남은시간 + "초뒤 제작 완료)");
        }else if(슬롯2.상태==2){
            제작슬롯.append(" 제작완료");
        }
        제작슬롯.append("" +
                "\n│" +
                "\n│슬롯3:" +
                "\n│" + 슬롯3.아이템이름);
        if(슬롯3.상태==1){
            제작슬롯.append(" 제작중 (약 " + 슬롯3.남은시간 + "초뒤 제작 완료)");
        }else if(슬롯3.상태==2){
            제작슬롯.append(" 제작완료");
        }
        제작슬롯.append("\n└──────────────────");
        return 제작슬롯;
    }

    public StringBuilder 제작리스트출력(상점 상점, 대장간슬롯 슬롯){
        StringBuilder 리스트 = new StringBuilder();
        if(슬롯.상태==0){
            리스트.append("\n\n"+슬롯.이름 + " 에서 제작할 아이템을 선택하세요." +
                    "\n0. 취소");
            if(제작템어레이.size()==0) {
                for (int i = 0; i < 상점.리스트.size(); i++) {
                    if (상점.리스트.get(i).착용가능여부) { //착용가능하면(현재는 착용가능한템이 전부 강화가 가능함)
                        제작템어레이.add(상점.리스트.get(i));
                    }
                }
            }
            for(int i = 0 ; i < 제작템어레이.size() ; i++){
                리스트.append("\n" + (i+1) + ". " + 제작템어레이.get(i).아이템이름 + " (" + 제작템어레이.get(i).아이템효과 + ")");
            }
        }
        return 리스트;
    }

}
