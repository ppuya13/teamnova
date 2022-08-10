package java4.상점;

import java4.아이템.기타.*;
import java4.아이템.소모.지속형.*;
import java4.아이템.소모.회복형.마나물약;
import java4.아이템.소모.회복형.체력물약;
import java4.아이템.아이템;
import java4.아이템.장비.*;
import java4.출력;

import java.util.ArrayList;
import java.util.Scanner;

import static java4.Main.플레이어;

public class 상점 { // 상점에 관련된 정보는 여기에

    int 입력;
    Scanner sc = new Scanner(System.in);
    public ArrayList<아이템> 리스트 = new ArrayList<>();

    //물약
    java4.아이템.소모.회복형.체력물약 체력물약 = new 체력물약("체력물약");
    java4.아이템.소모.회복형.마나물약 마나물약 = new 마나물약("마나물약");

    //장비템
    검 검= new 검("검");
    방패 방패= new 방패("방패");
    갑옷 갑옷 = new 갑옷("갑옷");
    각반 각반 = new 각반("각반");
    장갑 장갑 = new 장갑("장갑");

    //소모템
    공격력물약 공격력물약 = new 공격력물약("공격력물약");
    방어력물약 방어력물약 = new 방어력물약("방어력물약");

    //기타템
    슬라임젤리 슬라임젤리 = new 슬라임젤리("슬라임젤리");
    오크이빨 오크이빨 = new 오크이빨("오크이빨");
    고블린귀 고블린귀 = new 고블린귀("고블린귀");

    //
//    아이템 치트1 = new 아이템(456456);

    public 상점(){
        리스트.add(체력물약);
        리스트.add(마나물약);

        리스트.add(검);
        리스트.add(방패);
        리스트.add(갑옷);
        리스트.add(각반);
        리스트.add(장갑);

        리스트.add(공격력물약);
        리스트.add(방어력물약);

        리스트.add(슬라임젤리);
        리스트.add(오크이빨);
        리스트.add(고블린귀);

//        리스트.add(치트1);

        this.리스트 = 리스트;
    }

    public void 상점() throws InterruptedException, CloneNotSupportedException {

        ArrayList<String> 상점판매개수 = new ArrayList<>();
        for (int i = 0; i <= this.리스트.size() - 1; i++) {
            if (this.리스트.get(i).상점판매여부) {
                상점판매개수.add(this.리스트.get(i).아이템이름);
            }
        } //상점에서 판매하는 물건의 리스트를 만들기 위한 작업

        아이템 아이템정보;
        int 타겟;
        Scanner sc = new Scanner(System.in);
        출력 메인 = new 출력();
        int 입력;
        int 개수;
        boolean 마을 = false;


        상점:
        while (!마을) {
            System.out.println(메인.능력치창());
            System.out.println(메인.상점구매목록(this));
            System.out.print("" +
                    "\n상점에서는 아이템을 구매하거나 판매할 수 있습니다." +
                    "\n0.나가기" +
                    "\n1.구매하기" +
                    "\n2.판매하기(인벤토리)" +
                    "\n→");
            입력 = sc.nextInt();
            switch (입력) {
                case 0: //나가기
                    마을=true;
                    break;
                case 1: //구매하기
                    구매하기:
                    while (true) {
                        System.out.println(메인.능력치창());
                        System.out.print(메인.행동상점구매목록(this));
                        System.out.print("" +
                                "\n└──────────────────" +
                                "\n구매할 아이템을 선택하세요." +
                                "\n→");
                        입력 = sc.nextInt();
                        if (입력 == 0) {
                            continue 상점;
                        } else if (입력 > 0 && 입력 <= 상점판매개수.size()) {
                            타겟 = 입력;
                            아이템정보 = this.리스트.get(입력 - 1);
                            if (아이템정보.스택가능여부) { //선택한 템이 스택가능하면
                                while (true) {
                                    System.out.print("" +
                                            아이템정보.아이템이름 +
                                            "을(를) 몇 개 구매하시겠습니까?\n(0개: 취소)" +//변수 '상점구매' 값에 따라 품목 이름을 바꿔넣기 //구현완료
                                            "\n→");
                                    입력 = sc.nextInt();
                                    if (입력 == 0) {
                                        continue 구매하기;
                                    } else if (입력 > 0) {
                                        this.상점구매(플레이어, 타겟, 입력);
                                        continue 구매하기;
                                    }
                                }
                            } else { //선택한 템이 스택불가능하면
                                System.out.print("" +
                                        아이템정보.아이템이름 +
                                        "을(를) " + 아이템정보.구매가격 + "골드에 구매하시겠습니까?" +//변수 '상점구매' 값에 따라 품목 이름을 바꿔넣기 //구현완료
                                        "\n0.취소" +
                                        "\n1.확인" +
                                        "\n→");
                                입력 = sc.nextInt();
                                if (입력 == 0) {
                                    continue 구매하기;
                                } else if (입력 > 0) {
                                    this.상점구매(플레이어, 타겟, 입력);
                                    continue 구매하기;
                                }
                            }
                        }
                    }
                case 2: //판매하기
                    판매하기:
                    while (true) {
                        System.out.println(메인.능력치창());
                        System.out.println(메인.행동상점판매목록());
                        System.out.print("" +
                                "\n판매할 아이템을 선택해주세요." +
                                "\n→");
                        입력 = sc.nextInt();
                        타겟 = 입력;
                        if (입력 == 0) {
                            continue 상점;
                        } else if (입력 > 0 && 입력 <= 플레이어.회복물약가방.size()) {
                            //선택한 아이템이 회복물약가방 내용물일경우
                            아이템정보 = 플레이어.회복물약가방.get(입력 - 1);
                            System.out.print(아이템정보.아이템이름 +
                                    "(보유량: " + 아이템정보.스택수 + "개)" +
                                    "을(를) 몇 개 판매하시겠습니까?\n(0개: 취소)" +
                                    "\n→");
                            개수 = sc.nextInt();

                            //여기서 입력은 판매할 개수
                            this.상점판매(플레이어, 아이템정보, 개수);
                            플레이어.인벤정리();
                            continue 판매하기;
                        } else if (입력 > 플레이어.회복물약가방.size() && 입력 <= 플레이어.소지품.size() + 플레이어.회복물약가방.size()) {
                            //선택한 아이템이 회복물약가방 내용물이 아닌경우
                            아이템정보 = 플레이어.소지품.get(입력 - (플레이어.회복물약가방.size() + 1));
                            if (아이템정보.스택가능여부) {//아이템이 회복물약가방 내용물이 아니고 스택가능할경우
                                System.out.print(아이템정보.아이템이름 +
                                        "(보유량: " + 아이템정보.스택수 + "개)" +
                                        "을(를) 몇 개 판매하시겠습니까?\n(0개: 취소)" +
                                        "\n→");
                                개수 = sc.nextInt();
                            } else {
                                개수 = 1;
                            }
                            this.상점판매(플레이어, 아이템정보, 개수);
                            플레이어.인벤정리();
                            continue 판매하기;
                        }
                    }
            }
        }

    }


    public void 상점구매(java4.캐릭터.플레이어 플레이어, int 타겟, int 구매개수) throws InterruptedException, CloneNotSupportedException {
        boolean 구매진행=true;
        아이템 구매;
        String 상점구매결과="";
        구매 = (아이템) this.리스트.get(타겟-1).clone();  // 선택한 아이템을 객체로 새로 생성한다. //복제
//        구매 = new 아이템(this.리스트.get(타겟-1).고유번호);

        if(구매.스택가능여부){ //선택한 타겟이 스택가능이면
            if(구매개수>=1 && 구매진행) {
                System.out.print(구매.아이템이름 + "을 " + 구매개수 + "개 구매하시겠습니까?" +
                        "\n(총 " +(구매.구매가격*구매개수)+"골드)" +
                        "\n0.취소한다."+
                        "\n1.구매한다."+
                        "\n→");
                입력=sc.nextInt();
            }//구매갯수만큼 구매가격을 띄워주고 진짜 구매할건지 물은 뒤 입력받음.
            if (입력 == 0) {
                System.out.println("취소합니다.");
                Thread.sleep(1000);
                상점구매결과 = "구매취소함";
                구매진행 = false;
            }
            if(입력==1 &&구매진행 && (타겟==1 || 타겟==2)){//진짜구매한다고 했을때(인벤토리안에 고유번호가 같은 아이템이 존재하는지 확인)(체력물약과 마나물약은 같은 아이템이 항상 존재하므로 따로 확인 안하게 하기)
                //타겟이 체력물약이거나 마나물약일 경우
                if(플레이어.소지금>=구매.구매가격*구매개수 && 구매진행){//소지금이 구매금액 이상인지 확인
                    //이상이면
                    for(int i=0;i<=플레이어.회복물약가방.size()-1;i++) { //회복물약가방의 내용물 갯수만큼 반복
                        if(플레이어.회복물약가방.get(i).고유번호==구매.고유번호){ //회복물약가방의 i번째 아이템의 고유번호가 타겟의 고유번호와 같으면
                            플레이어.회복물약가방.get(i).스택수 = 플레이어.회복물약가방.get(i).스택수+구매개수; //회복물약가방의 i번째 아이템의 스택수를 구매개수만큼 늘린다.
                            플레이어.소지금=플레이어.소지금-(구매.구매가격*구매개수); // 소지금을 구매가격만큼 차감한다.
                            구매진행=false;
                            System.out.println("구매에 성공했습니다.");
                            Thread.sleep(1000);
                        }
                    } //for문끝
                }
                else if(플레이어.소지금<구매.구매가격*구매개수 && 구매진행){//소지금이 구매금액보다 적으면
                    System.out.println("소지금이 부족합니다.");
                    Thread.sleep(1000);
                    상점구매결과="돈모자름";
                    구매진행=false;
                }
            }//타겟이 체력물약이거나 마나물약일경우 끝
            //타겟이 물약이 아닐경우
            else if(입력==1 && 구매진행 && 타겟>=3){
                //타겟이 체력물약, 마나물약이 아닌경우
                if(플레이어.소지금>=구매.구매가격*구매개수 &&구매진행) { //소지금이 구매금액 이상인지 확인
                    //이상이면
                    for (int i = 0; i <= 플레이어.소지품.size() - 1; i++) { //소지품의 내용물 갯수만큼 반복
                        if (플레이어.소지품.get(i).고유번호 == 구매.고유번호) { //소지품의 i번째 아이템의 고유번호가 타겟의 고유번호와 같으면(같은 아이템이 존재하면)
                            플레이어.소지품.get(i).스택수 = 플레이어.소지품.get(i).스택수+구매개수; //소지품방의 i번째 아이템의 스택수를 구매개수만큼 늘린다.
                            플레이어.소지금=플레이어.소지금-(구매.구매가격*구매개수);// 소지금을 구매가격만큼 차감한다.
                            System.out.println("구매에 성공했습니다.");
                            Thread.sleep(1000);
                            구매진행=false;
                            break; //스택 늘린 뒤에 for문 나감
                        }
                    }
                    //if문 다돌았는데도 구매진행이 true이면 (고유번호와 같은 아이템이 존재하지 않는다면)
                    if(구매진행==true){
                        if(플레이어.소지품.size()>=20){ //또한 소지품의 개수가 20개 이상이라면
//                            System.out.println("this.소지품.size() = "+this.소지품.size());
                            System.out.println("인벤토리 공간이 부족합니다.");
                        }
                        else{ //소지품의 개수가 19개 이하라면
                            구매.스택수=구매개수; //
                            플레이어.소지품.add(구매); // 상점에서 선택한 아이템을 소지품의 제일 뒤에 추가한다.
                            플레이어.소지금=플레이어.소지금-구매.구매가격*구매개수;// 소지금을 구매가격만큼 차감한다.
                            System.out.println("구매에 성공했습니다.");
                            상점구매결과="구매완료";
                        }
                        Thread.sleep(1000);
                        구매진행=false;
                    }
                }
                else if(플레이어.소지금<구매.구매가격*구매개수 &&구매진행){ // 소지금이 구매금액보다 적다면
                    System.out.println("소지금이 부족합니다.");
                    Thread.sleep(1000);
                    상점구매결과="돈모자름";
                    구매진행=false;
                }
            }
        }
        else{ //스택불가능 아이템이면
            if(플레이어.소지금>=구매.구매가격 &&구매진행) { //소지금이 구매금액 이상인지 확인
                //이상이면
                if(플레이어.소지품.size()>=20){ //또한 소지품의 개수가 20개 이상이라면
//                    System.out.println("this.소지품.size() = "+this.소지품.size());
                    System.out.println("인벤토리 공간이 부족합니다.");
                    Thread.sleep(1000);
                }
                else{ //소지품의 개수가 19개 이하라면
                    플레이어.소지품.add(구매); // 상점에서 선택한 아이템을 소지품의 제일 뒤에 추가한다.
                    플레이어.소지금=플레이어.소지금-(구매.구매가격);// 소지금을 구매가격만큼 차감한다.
                    System.out.println("구매에 성공했습니다.");
                    Thread.sleep(1000);
                    상점구매결과="구매완료";
                }
                구매진행=false;
            }
            else if(플레이어.소지금<구매.구매가격 && 구매진행){//소지금이 구매금액보다 적으면
                System.out.println("소지금이 부족합니다.");
                Thread.sleep(1000);
                상점구매결과="돈모자름";
                구매진행=false;
            }
        }//구매 메소드 완성.
    }
    public void 상점판매(java4.캐릭터.플레이어 플레이어, 아이템 타겟, int 판매개수) throws InterruptedException {
        if(타겟.아이템분류==4){//물약이면
            if(판매개수>타겟.스택수) { //판매개수가 스택수보다 많으면
                System.out.println("소지 개수 이상을 판매할 수는 없습니다.");
                Thread.sleep(1000);
            }
            else{
                타겟.스택수 = 타겟.스택수 - 판매개수;
                플레이어.소지금 = 플레이어.소지금 + (타겟.판매가격 * 판매개수);
                System.out.println(타겟.아이템이름 + "을(를) " +
                        판매개수 + "개 판매하여 " + (타겟.판매가격 * 판매개수) +
                        "골드를 받았습니다.");
                Thread.sleep(1000);
            }
        }
        else if(타겟.스택가능여부) {//물약이 아니고 스택가능하면
            if(판매개수>타겟.스택수) { //판매개수가 스택수보다 많으면
                System.out.println("소지 개수 이상을 판매할 수는 없습니다.");
                Thread.sleep(1000);
            }
            else {
                타겟.스택수 = 타겟.스택수 - 판매개수;
                플레이어.소지금 = 플레이어.소지금 + (타겟.판매가격 * 판매개수);
                System.out.println(타겟.아이템이름 + "을(를) " +
                        판매개수 + "개 판매하여 " + (타겟.판매가격 * 판매개수) +
                        "골드를 받았습니다.");
                Thread.sleep(1000);
            }
        }
        else { //물약이 아니고 스택불가능이면
            if (!타겟.착용여부) { //착용중이 아니면
                boolean 반복 = true;
                while (반복){
                    System.out.print("정말 " + 타겟.아이템이름 + "(판매가: " + 타겟.판매가격 + "골드) 을(를) 판매하시겠습니까?" +
                            "\n0.취소한다." +
                            "\n1.판매한다." +
                            "\n→");
                    입력 = sc.nextInt();
                    switch (입력) {
                        case 0:
                            반복=false;
                            break;
                        case 1:
                            타겟.스택수 = 0;
                            플레이어.소지금 = 플레이어.소지금 + 타겟.판매가격;
                            System.out.println(타겟.아이템이름 + "을(를) 판매하여 " +
                                    타겟.판매가격 + "골드를 받았습니다.");
                            Thread.sleep(1000);
                            반복=false;
                            break;
                    }
                }
            } else {
                System.out.println("착용 중인 아이템은 판매할 수 없습니다.");
                Thread.sleep(1000);
            }
        }
    }

    private 아이템 아이템생성(아이템 아이템) throws CloneNotSupportedException {
        아이템 복제 = (아이템) 아이템.clone();
        return 복제;
    }


}
