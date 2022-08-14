package java4.대장간;

import java4.아이템.아이템;
import java4.출력;

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
    public static 대장간슬롯 슬롯1;
    public static 대장간슬롯 슬롯2;
    public static 대장간슬롯 슬롯3;


    public void 대장간() throws InterruptedException {
        this.강화리스트생성(플레이어);
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
                        System.out.println(메인.능력치창());
                        System.out.println(메인.제작슬롯());
                        System.out.print(""+
                                "\n여기서는 무료로 아이템을 제작할 수 있습니다.(30초 소요)" +
                                "\n슬롯을 선택해주세요." +
                                "\n→");
                        입력 = sc.nextInt();
                        if(입력==0){
                            continue 대장간;
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

    public void 강화리스트생성(java4.캐릭터.플레이어 플레이어){
//        System.out.println("강화리스트생성");
        플레이어.강화목록.clear();
        for(int i=0 ; i<=플레이어.소지품.size()-1 ; i++){
            if(플레이어.소지품.get(i).착용가능여부){ //착용가능하면(현재는 착용가능한템이 전부 강화가 가능함)
                플레이어.강화목록.add(플레이어.소지품.get(i));
            }
        }
    }


}
