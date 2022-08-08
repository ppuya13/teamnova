package java4.인벤토리;

import java4.아이템.아이템;
import java4.출력;

import java.util.Scanner;

import static java4.Main.플레이어;

public class 인벤토리출력 {
    출력 메인 = new 출력();
    int 입력;
    Scanner sc = new Scanner(System.in);
    아이템 아이템정보;

    public void 인벤토리() throws InterruptedException, CloneNotSupportedException {
        인벤토리:
        while (true) {
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
                    return;
                case 1: //탐색 인벤토리 사용, 장착, 해제
                    사용:
                    while (true) {
                        System.out.println(메인.능력치창());
                        System.out.println("\n사용하기 / 장착하기 / 장착 해제하기");
                        System.out.println(메인.행동인벤토리());
                        System.out.print("" +
                                "아이템을 선택해주세요." +
                                "\n→");
                        입력 = sc.nextInt();
                        if (입력 == 0) {
                            continue 인벤토리;
                        } else if (입력 > 0 && 입력 <= 플레이어.회복물약가방.size() + 플레이어.소지품.size()) {
                            아이템정보 = 플레이어.아이템사용(입력);
                            if (아이템정보.착용가능여부) { //선택한 아이템이 착용가능하면
                                if(아이템정보.사용효과(플레이어)){
                                    continue;
                                }
                                플레이어.능력치적용();
                            } else {//착용불가능하면
                                if(아이템정보.아이템분류==4){
                                    아이템정보.사용효과(플레이어);
                                }
                                else if(아이템정보.아이템분류==2) {
                                    System.out.println("\n소모 아이템은 전투중에만 사용할 수 있습니다.");
                                    Thread.sleep(1000);
                                }
                                else{
                                    System.out.println("\n사용할 수 없는 아이템입니다.");
                                    Thread.sleep(1000);
                                }
                            }
                        }
                    }
                case 2: //탐색 인벤토리 버리기
                    버리기:
                    while (true) {
                        System.out.println(메인.능력치창());
                        System.out.println("\n아이템 버리기");
                        System.out.println(메인.행동인벤토리());
                        System.out.print("" +
                                "버릴 아이템을 선택해주세요." +
                                "\n→");
                        입력 = sc.nextInt();
                        if (입력 == 0) {
                            continue 인벤토리;
                        } else if (입력 > 0 && 입력 <= 플레이어.소지품.size() + 플레이어.회복물약가방.size()) {
                            //처음 하나로 버릴 수 있는 아이템인지만 판별하고 버릴 수 있는지 여부랑 물약여부만 한꺼번에 boolean으로 남김
                            //아이템버리기 : 고른게 버릴 수 있는템인지 확인(회복물약여부와 장착여부를 확인)후 결과를 돌려줌
                            //아이템버리기2 : 버릴수있는템이라면 몇개를 버릴지 확인후 결과를 돌려줌
                            //아이템버리기실행 : 몇개를 버릴지 여부를 받아서 버려줌(0개라면 버리지 않음)
                            플레이어.아이템버리기실행(플레이어.아이템버리기2(플레이어.아이템버리기(입력), 입력), 입력);
                            플레이어.인벤정리();
                        }

                    }
                case 3: //탐색 인벤토리 살펴보기
                    살펴보기:
                    while (true) {
                        System.out.println(메인.능력치창());
                        System.out.println(메인.행동상점판매목록());
                        System.out.print("" +
                                "\n확인할 아이템을 선택해주세요." +
                                "\n→");
                        입력 = sc.nextInt();
                        if (입력 == 0) {
                            continue 인벤토리;
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
            }
        }
    }
}
