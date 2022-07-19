package java4;

import java.util.ArrayList;

public class 몬스터 { //몬스터 정보와 전투는 이곳에
    String 이름;
    int 공격력;
    int 방어력;
    int 최대체력;
    int 현재체력;
    int 경험치;
    String 번호;

//    public String 랜덤몬스터(){
//        String 랜덤몬스터결과 = 몬스터뽑기[num];
//        return 랜덤몬스터결과;
//    }


    몬스터(String 이름, String 몬스터종류) { //공격력, 방어력, 이름 등의 이름은 그냥 변수명같은거라 자유임.
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

    public void 슬라임(){
        this.번호 = 이름;
        this.이름 = "슬라임" + 이름;
        this.공격력 = 5;
        this.방어력 = 0;
        this.최대체력 = 30;
        this.현재체력 = 30;
        this.경험치 = 10;
    }
    public void 고블린(){
        this.번호 = 이름;
        this.이름 = "고블린" + 이름;
        this.공격력 = 10;
        this.방어력 = 3;
        this.최대체력 = 50;
        this.현재체력 = 50;
        this.경험치 = 30;
    }
    public void 오크(){
        this.번호 = 이름;
        this.이름 = "오크" + 이름;
        this.공격력 = 300;
        this.방어력 = 10;
        this.최대체력 = 200;
        this.현재체력 = 200;
        this.경험치 = 100;
    }
//    public void 시체(){
//        this.번호 = "1000";
//        this.이름 = "시신";
//        this.현재체력 = -1;
//    }


    public static int 공격(ArrayList<몬스터> 몬스터어레이, int 타겟, 능력치 캐릭터) throws InterruptedException {
        int 몬스터사망=0;
        몬스터어레이.get(타겟-1).현재체력 = 몬스터어레이.get(타겟-1).현재체력-(캐릭터.캐릭터최종공격력-몬스터어레이.get(타겟-1).방어력);
        System.out.println(몬스터어레이.get(타겟-1).이름 + "을(를) 공격합니다.");
        Thread.sleep(1000);
        System.out.println(몬스터어레이.get(타겟-1).이름+"에게 "+(캐릭터.캐릭터최종공격력-몬스터어레이.get(타겟-1).방어력)+"의 데미지!");
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

    public static boolean 몬스터공격(ArrayList<몬스터> 몬스터어레이, int 몬스터수, 능력치 캐릭터) throws InterruptedException {
        boolean 캐릭터사망 = false;
        for (int i=0; i < 몬스터수; i++){
            if(캐릭터.캐릭터현재체력>=1){
                if(몬스터어레이.get(i).공격력-캐릭터.캐릭터최종방어력>=1) {
                    System.out.println("\n"+몬스터어레이.get(i).이름 + "의 공격!");
                    System.out.println((몬스터어레이.get(i).공격력 - 캐릭터.캐릭터최종방어력) + "의 데미지를 입었다!");
                    Thread.sleep(1000);
                    캐릭터.캐릭터현재체력 = 캐릭터.캐릭터현재체력 - (몬스터어레이.get(i).공격력 - 캐릭터.캐릭터최종방어력);
                }
                else{
                    System.out.println("\n"+몬스터어레이.get(i).이름 + "의 공격!");
                    System.out.println("1의 데미지를 입었다!");
                    Thread.sleep(1000);
                    캐릭터.캐릭터현재체력 = 캐릭터.캐릭터현재체력 - 1;
                }
            }
            else{
                break;
            }

        }
        if (캐릭터.캐릭터현재체력<=0){
            System.out.println("플레이어는 사망했다.");
            캐릭터사망=true;
            Thread.sleep(1000);
        }
        return 캐릭터사망;
    }

}
















