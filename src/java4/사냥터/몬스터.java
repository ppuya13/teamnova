package java4.사냥터;

import java4.아이템.아이템;
import java4.캐릭터.캐릭터;

import java.util.ArrayList;
import java.util.Random;

public class 몬스터 { //몬스터 정보와 전투는 이곳에
    //몬스터 상속으로 처리하기
    public String 이름;
    public int 공격력;
    public int 방어력;
    public int 최대체력;
    public int 현재체력;
    public int 경험치;
    public int 소지금;
    public String 정보;
    public String 번호;
    public 아이템 드랍템;
    public ArrayList<아이템> 드랍테이블 = new ArrayList<>();
    public ArrayList<아이템> 공용드랍테이블 = new ArrayList<>();
    Random rd = new Random();
    static Random rd2 = new Random();

//    public String 랜덤몬스터(){
//        String 랜덤몬스터결과 = 몬스터뽑기[num];
//        return 랜덤몬스터결과;
//    }

    public 몬스터(){}
    public 몬스터(String 이름, String 몬스터종류) {
        공용드랍테이블();
        this.이름 = 이름;
        if(몬스터종류=="슬라임") {
            this.슬라임();
        }
        if(몬스터종류=="고블린"){
            this.고블린();
        }
        if(몬스터종류=="오크"){
            this.오크();
        }
    }
    public void 공용드랍테이블(){
//        System.out.println("공용드랍테이블 사이즈 : "+공용드랍테이블.size());
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
//            System.out.println("공용드랍테이블 사이즈 : "+공용드랍테이블.size());
        }
    }
    public void 슬라임(){
        this.번호 = 이름;
        this.이름 = "슬라임" + 이름;
        this.공격력 = rd.nextInt(1)+5; //5~6
        this.방어력 = rd.nextInt(2)+1; //1~3
        this.최대체력 = rd.nextInt(10)+25; //25~35
        this.현재체력 = this.최대체력;
        this.경험치 = rd.nextInt(1)+10; //10~11
        this.소지금 = rd.nextInt(4)+1;
        this.정보 = "굉장히 약한 슬라임입니다. 일반인도 무리없이 사냥할 수 있습니다.";

        this.드랍테이블.addAll(공용드랍테이블);
        드랍템 = new 아이템(300);
        this.드랍테이블.add(드랍템);
    }
    public void 고블린(){
        this.번호 = 이름;
        this.이름 = "고블린" + 이름;
        this.공격력 = rd.nextInt(5)+10;
        this.방어력 = rd.nextInt(3)+2;
        this.최대체력 = rd.nextInt(25)+50;
        this.현재체력 = this.최대체력;
        this.경험치 = rd.nextInt(5)+30;
        this.소지금 = rd.nextInt(5)+5;
        this.정보 = "약한 고블린입니다. 약간 지성이 있으며 무리를 짓고 있으면 굉장히 위협적입니다.";

        this.드랍테이블.addAll(공용드랍테이블);
        드랍템 = new 아이템(302);
        this.드랍테이블.add(드랍템);
    }
    public void 오크(){
        this.번호 = 이름;
        this.이름 = "오크" + 이름;
        this.공격력 = rd.nextInt(20)+30;
        this.방어력 = rd.nextInt(5)+10;
        this.최대체력 = rd.nextInt(40)+180;
        this.현재체력 = this.최대체력;
        this.경험치 = rd.nextInt(20)+90;
        this.소지금 = rd.nextInt(10)+10;
        this.정보 = "오크는 호전적이며 강력합니다. 대부분 부족사회를 이루고 있으며, 단일 개체의 신체능력은 인간을 상회합니다.";

        this.드랍테이블.addAll(공용드랍테이블);
        드랍템 = new 아이템(301);
        this.드랍테이블.add(드랍템);
    }

//    public void 시체(){
//        this.번호 = "1000";
//        this.이름 = "시신";
//        this.현재체력 = -1;
//    }


    //전투방식 갈아엎음. 현재 사용되지 않는 메소드.
    public static int 공격(ArrayList<몬스터> 몬스터어레이, int 타겟, 캐릭터 캐릭터) throws InterruptedException {
        int 몬스터사망=0;
        몬스터 타겟몬스터=몬스터어레이.get(타겟-1);
        타겟몬스터.현재체력 = 타겟몬스터.현재체력-(캐릭터.캐릭터최종공격력-타겟몬스터.방어력);
        System.out.println(타겟몬스터.이름 + "을(를) 공격합니다.");
        Thread.sleep(1000);
        System.out.println(타겟몬스터.이름+"에게 "+(캐릭터.캐릭터최종공격력-타겟몬스터.방어력)+"의 데미지!");
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


    public void 몬스터생성(){

    }
    public static boolean 몬스터공격(ArrayList<몬스터> 몬스터어레이, int 몬스터수, 캐릭터 캐릭터) throws InterruptedException {
        boolean 캐릭터사망 = false;
        for (int i=0; i < 몬스터수; i++){
            if(캐릭터.캐릭터현재체력>=1){ //캐릭터가 살아있으면
                if(rd2.nextInt(100)+캐릭터.캐릭터최종회피>99) {//회피판정 성공시
                    System.out.println("\n" + 몬스터어레이.get(i).이름 + "의 공격!" +
                            "\n플레이어는 회피했다!");
                    Thread.sleep(500);
                }
                else {
                    if (몬스터어레이.get(i).공격력 - 캐릭터.캐릭터최종방어력 >= 1) {
                        System.out.println("\n" + 몬스터어레이.get(i).이름 + "의 공격!");
                        System.out.println((몬스터어레이.get(i).공격력 - 캐릭터.캐릭터최종방어력) + "의 데미지를 입었다!");
                        Thread.sleep(500);
                        캐릭터.캐릭터현재체력 = 캐릭터.캐릭터현재체력 - (몬스터어레이.get(i).공격력 - 캐릭터.캐릭터최종방어력);
                    } else {
                        System.out.println("\n" + 몬스터어레이.get(i).이름 + "의 공격!");
                        System.out.println("1의 데미지를 입었다!");
                        Thread.sleep(500);
                        캐릭터.캐릭터현재체력 = 캐릭터.캐릭터현재체력 - 1;
                    }
                }
            }
            else{
                break;
            }
        }
        if (캐릭터.캐릭터현재체력<=0){
            System.out.println("플레이어는 쓰러졌다.");
            캐릭터사망=true;
            Thread.sleep(1000);
        }
        return 캐릭터사망;
    }

}
















