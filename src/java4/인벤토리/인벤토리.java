package java4.인벤토리;

import java4.아이템.아이템;
import java4.출력;

import java.util.Scanner;

import static java4.Main.플레이어;

public class 인벤토리 {
    출력 메인 = new 출력();
    boolean 반복;
    int 입력;
    Scanner sc = new Scanner(System.in);
    아이템 아이템정보;

    public boolean 인벤토리() throws InterruptedException {
        boolean 뒤로가기 = false;
        반복 = true;
        while (반복) {
            System.out.println(메인.능력치창());
            System.out.println("인벤토리를 열어봅니다." +
                    "\n체력, 마나물약을 제외한 아이템은 20종류까지만 보관 가능합니다.");
            System.out.println(메인.인벤토리());
            System.out.print("" +
                    "무엇을 하시겠습니까?" +
                    "\n0.뒤로가기" +
                    "\n1.사용하기 / 장착하기 / 장착 해제하기" +
                    "\n2.버리기" +
                    "\n3.살펴보기" +
                    "\n→");
            입력 = sc.nextInt();
            switch (입력) {
                case 0:
                    뒤로가기 = true;
                    반복=false;
                    break;
                case 1: //탐색 인벤토리 사용, 장착, 해제
                    반복 = true;
                    while (반복) {
                        System.out.println(메인.능력치창());
                        System.out.println("\n사용하기 / 장착하기 / 장착 해제하기");
                        System.out.println(메인.행동인벤토리());
                        System.out.print("" +
                                "아이템을 선택해주세요." +
                                "\n→");
                        입력 = sc.nextInt();
                        if (입력 == 0) {
                            break;
                        } else if (입력 > 0 && 입력 <= 플레이어.회복물약가방.size() + 플레이어.소지품.size()) {
                            아이템정보 = 플레이어.아이템사용2(입력);
                            if (아이템정보.착용가능여부) { //선택한 아이템이 착용가능하면
                                플레이어.아이템장착(아이템정보);
                                플레이어.능력치적용();
                            } else {//착용불가능하면
                                반복 = 플레이어.전투외아이템사용(플레이어.아이템사용(입력), 아이템정보);
                            }
                        }
                    }
                    break;
                case 2: //탐색 인벤토리 버리기
                    반복 = true;
                    while (반복) {
                        System.out.println(메인.능력치창());
                        System.out.println("\n아이템 버리기");
                        System.out.println(메인.행동인벤토리());
                        System.out.print("" +
                                "버릴 아이템을 선택해주세요." +
                                "\n→");
                        입력 = sc.nextInt();
                        if (입력 == 0) {
                            break;
                        } else if (입력 > 0 && 입력 <= 플레이어.소지품.size() + 플레이어.회복물약가방.size()) {
                            //처음 하나로 버릴 수 있는 아이템인지만 판별하고 버릴 수 있는지 여부랑 물약여부만 한꺼번에 boolean으로 남김
                            //아이템버리기 : 고른게 버릴 수 있는템인지 확인(회복물약여부와 장착여부를 확인)후 결과를 돌려줌
                            //아이템버리기2 : 버릴수있는템이라면 몇개를 버릴지 확인후 결과를 돌려줌
                            //아이템버리기실행 : 몇개를 버릴지 여부를 받아서 버려줌(0개라면 버리지 않음)
                            플레이어.아이템버리기실행(플레이어.아이템버리기2(플레이어.아이템버리기(입력), 입력), 입력);
                            플레이어.인벤정리();
                        }

                    }
                    break;
                case 3: //탐색 인벤토리 살펴보기
                    반복 = true;
                    while (반복) {
                        System.out.println(메인.능력치창());
                        System.out.println(메인.행동상점판매목록());
                        System.out.print("" +
                                "\n확인할 아이템을 선택해주세요." +
                                "\n→");
                        입력 = sc.nextInt();
                        if (입력 == 0) {
                            break;
                        } else if (입력 > 0 && 입력 <= 플레이어.회복물약가방.size()) {
                            System.out.println(메인.살펴보기(플레이어.회복물약가방.get(입력 - 1)));
                            System.out.print("넘기려면 아무 숫자나 입력하세요." +
                                    "\n→");
                            입력 = sc.nextInt();
                        } else if (입력 > 플레이어.회복물약가방.size() && 입력 <= 플레이어.소지품.size() + 플레이어.회복물약가방.size()) {
                            System.out.println(메인.살펴보기(플레이어.소지품.get(입력 - 3)));
                            System.out.print("넘기려면 아무 숫자나 입력하세요." +
                                    "\n→");
                            입력 = sc.nextInt();
                        }
                    }
                    break;
            }
        }
        return 뒤로가기;
    }
}
