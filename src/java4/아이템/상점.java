package java4.아이템;

import java4.출력;

import java.util.ArrayList;
import java.util.Scanner;

import static java4.Main.플레이어;

public class 상점 { // 상점에 관련된 정보는 여기에
    public ArrayList<아이템> 리스트 = new ArrayList<>();

    //물약
    아이템 체력물약 = new 아이템(-1);
    아이템 마나물약 = new 아이템(-2);

    //장비템
    아이템 검= new 아이템(100);
    아이템 방패= new 아이템(101);
    아이템 갑옷 = new 아이템(102);
    아이템 각반 = new 아이템(103);

    //소모템
    아이템 공격력물약 = new 아이템(200);
    아이템 방어력물약 = new 아이템(201);

    //기타템
    아이템 슬라임젤리 = new 아이템(300);
    아이템 오크이빨 = new 아이템(301);

    //
    아이템 치트1 = new 아이템(456456);

    public 상점(){
        리스트.add(체력물약);
        리스트.add(마나물약);

        리스트.add(검);
        리스트.add(방패);
        리스트.add(갑옷);
        리스트.add(각반);

        리스트.add(공격력물약);
        리스트.add(방어력물약);

        리스트.add(슬라임젤리);
        리스트.add(오크이빨);

        리스트.add(치트1);

        this.리스트 = 리스트;
    }

    public void 상점() throws InterruptedException {

        ArrayList<String> 상점판매개수 = new ArrayList<>();
        for (int i = 0; i <= this.리스트.size() - 1; i++) {
            if (this.리스트.get(i).상점판매여부) {
                상점판매개수.add(this.리스트.get(i).아이템이름);
            }
        }
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
                                        플레이어.상점구매(타겟, this, 입력);
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
                                    플레이어.상점구매(타겟, this, 입력);
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
                            플레이어.상점판매(아이템정보, 개수);
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
                            플레이어.상점판매(아이템정보, 개수);
                            플레이어.인벤정리();
                            continue 판매하기;
                        }
                    }
            }
        }
    }
}
