package java4;

import jdk.swing.interop.SwingInterOpUtils;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;



public class Assignment4 {

    public static void main(String[] args) throws InterruptedException {

        //캐릭터 초기화

        능력치 캐릭터 = new 능력치(1,100,0,1000,1000,100,100,500,0,10,0,20,150,10,1000);
        캐릭터.인벤토리초기화();

        //캐릭터 초기화

        //상점 초기화

        상점 상점=new 상점();//상점에 물건들을 진열하기 위한 코드

        ArrayList<String> 상점판매개수 = new ArrayList<>();
        for(int i = 0 ; i<=상점.리스트.size()-1;i++){
            if(상점.리스트.get(i).상점판매여부) {
                상점판매개수.add(상점.리스트.get(i).아이템이름);
            }
        } //진열된 물건들의 종류가 몇 개인지 알기 위한 코드

        //상점 초기화

        boolean 첫시작=true;
        String pause;

        //장면 제어 변수
        int 화면=1; //1:메인화면, 2:사냥터, 3:상점, 4:대장간, 5:전투
        int 세부1=0;
        int 세부2=0;
        boolean 패스 = false;
        int 상점구매=0; //상점창에서 뭘 선택했는지 들어감, 구매완료 또는 취소 후에 0으로 초기화
        String 상점구매이름 = new String();
        boolean 상점구매확인1=false; //
        int 상점판매=0;
        boolean 상점판매확인1=false; //
        int 강화선택=0; //대장간에서 뭘 선택했는지 들어감, 강화 완료 또는 취소 후에 0으로 초기화
        boolean 강화확인=false;
        boolean 턴=false;
        boolean 사망=false;
        메인화면 메인=new 메인화면();
        int 스택가능=0;
        int 구매개수=0;
        int 판매개수=0;
        int 물약여부=0;
        아이템 아이템정보;
        int 회복물약가방크기=0;
        int 인벤토리크기=0;
        int 전체가방크기=0;
        boolean 아이템사용=false;
        int 사용선택=-1;
        StringBuilder 강화능력치표시 = new StringBuilder();

        int 몬스터발견확률=3;
        int 탐색결과=0;
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        int a = 0; // 디폴트 입력값
        int b = -1; //0번 입력이 필요할 때 또는 전투 페이즈에서 쓰는 입력값


        //몬스터변수
        String[] 몬스터종류배열 = {"슬라임","고블린","오크"};
        double 몬스터생성난수;
        int num;
        String 랜덤몬스터결과;

        ArrayList<몬스터> 몬스터어레이 = new ArrayList<>();
        String 몬스터번호; // 각 몬스터마다 고유 번호
        몬스터 몬스터정보; // 몬스터의 이름과 능력치가 들어있음
        int 몬스터머릿수 = 0; // 몬스터 생성시 1~5까지 난수로 생성
        int 죽은몬스터수 = 0; // 몬스터 사망 시 1 상승
        int 죽은몬스터수2= 0; // 몬스터 사망 시 1 상승(이후 초기화)
        //몬스터변수

//        몬스터 몬스터a = new 몬스터("a");
//        몬스터 몬스터b = new 몬스터("b");
//        몬스터 몬스터c = new 몬스터("c");
//        몬스터 몬스터d = new 몬스터("d");
//        몬스터 몬스터e = new 몬스터("e");


        while(true) { //메인 반복문
            인벤토리크기=캐릭터.소지품.size();
            회복물약가방크기=캐릭터.회복물약가방.size();
            전체가방크기=인벤토리크기+회복물약가방크기;
            //화면출력 시작
            {
                if (화면 == 1 && 세부1 == 0 && 세부2 == 0) {
                    System.out.println(메인.능력치창(캐릭터));
                    System.out.print(
                            "\n이곳은 마을입니다. 무엇을 하시겠습니까?" +
                                    "\n1.사냥터" +
                                    "\n2.인벤토리" +
                                    "\n3.상점" +
                                    "\n4.대장간" +
                                    "\n5.휴식" +
                                    "\n→");
                } else if (화면 == 1 && 세부1 == 2 && 세부2 == 0) {
                    System.out.println(메인.능력치창(캐릭터));
                    System.out.println("인벤토리를 열어봅니다." +
                            "\n체력, 마나물약을 제외한 아이템은 20종류까지만 보관 가능합니다.");
                    System.out.println(메인.인벤토리(캐릭터));
                    System.out.print("" +
                            "무엇을 하시겠습니까?" +
                            "\n1.사용하기 / 장착하기 / 장착 해제하기" +
                            "\n2.버리기" +
                            "\n3.살펴보기" +
                            "\n4.나가기" +
                            "\n→");
//                for(int i=1 ; i <= 인벤토리크기-1 ; i++) {
//                    System.out.print(i);
//                    System.out.println(" " + 캐릭터.소지품.get(i).아이템이름);
//                }
                } else if (화면 == 1 && 세부1 == 2 && 세부2 == 1) {
                    System.out.println(메인.능력치창(캐릭터));
                    System.out.println("\n사용하기 / 장착하기 / 장착 해제하기");
                    System.out.println(메인.행동인벤토리(캐릭터));
                    System.out.print("" +
                            "아이템을 선택해주세요." +
                            "\n→");
                } else if (화면 == 2 && 세부1 == 0 && 세부2 == 0) {
                    System.out.println(메인.능력치창(캐릭터));
                    System.out.print("" +
                            "\n몬스터를 사냥하러 왔습니다. 무엇을 하시겠습니까?" +
                            "\n1.탐색" +
                            "\n2.인벤토리" +
                            "\n3.휴식" +
                            "\n4.돌아가기" +
                            "\n→");
                } else if (화면 == 2 && 세부1 == 1 && 세부2 == 0) {
                    탐색결과 = rd.nextInt(몬스터발견확률);
                    if (탐색결과 <= 1) {
                        탐색결과 = 0;
//                    System.out.println("System : 몬스터 어레이를 초기화합니다.");
                        몬스터어레이.clear();
                        몬스터머릿수 = rd.nextInt(9) + 1;
                        System.out.println(몬스터머릿수 + "마리의 몬스터를 발견했다!!!");
                        Thread.sleep(1000);

                        for (int i = 1; i <= 몬스터머릿수; i++) {
                            몬스터생성난수 = Math.random();
                            num = (int) Math.floor(몬스터생성난수 * 몬스터종류배열.length);
                            랜덤몬스터결과 = 몬스터종류배열[num];

                            몬스터번호 = Integer.toString(i);
                            몬스터정보 = new 몬스터(몬스터번호, 랜덤몬스터결과);
                            몬스터어레이.add(몬스터정보);
                        }
                        //여기서 몬스터 정보를 생성한 뒤 몬스터 클래스로 보내서 객체로 만듦

                        패스 = true;
                        화면 = 5;
                        세부1 = 0;
                    } else {
                        System.out.println("아이템을 발견했다!!!");
                    }
                } else if (화면 == 2 && 세부1 == 2 && 세부2 == 0) {
                    System.out.println(메인.능력치창(캐릭터));
                    System.out.println("인벤토리를 열어봅니다." +
                            "\n체력, 마나물약을 제외한 아이템은 20종류까지만 보관 가능합니다.");
                    System.out.println(메인.인벤토리(캐릭터));
                    System.out.print("" +
                            "무엇을 하시겠습니까?" +
                            "\n1.사용하기 / 장착하기 / 장착 해제하기" +
                            "\n2.버리기" +
                            "\n3.살펴보기" +
                            "\n4.나가기" +
                            "\n→");
                } else if (화면 == 2 && 세부1 == 2 && 세부2 == 1) {
                    System.out.println(메인.능력치창(캐릭터));
                    System.out.println("\n사용하기 / 장착하기 / 장착 해제하기");
                    System.out.println(메인.행동인벤토리(캐릭터));
                    System.out.print("" +
                            "아이템을 선택해주세요." +
                            "\n→");
                } else if (화면 == 3 && 세부1 == 0 && 세부2 == 0) {
                    System.out.println(메인.능력치창(캐릭터));
                    System.out.println(메인.상점구매목록(캐릭터, 상점));
                    System.out.print("" +
                            "\n상점에서는 아이템을 구매하거나 판매할 수 있습니다." +
                            "\n1.구매하기" +
                            "\n2.판매하기(인벤토리)" +
                            "\n3.살펴보기" +
                            "\n4.나가기" +
                            "\n→");
                } else if (화면 == 3 && 세부1 == 1 && 세부2 == 0) {
                    System.out.println(메인.능력치창(캐릭터));
                    System.out.print(메인.행동상점구매목록(캐릭터, 상점));
                    System.out.print("" +
                            "\n└──────────────────" +
                            "\n구매할 아이템을 선택하세요." +
                            "\n→");
                } else if(화면 == 3 && 세부1 == 1 && 세부2 == 1 && 스택가능==1) { //선택한 아이템이 스택가능일경우
                    System.out.print("" +
                            상점.상점구매타겟(상점구매) +
                            "을(를) 몇 개 구매하시겠습니까?\n(0개: 취소)" +//변수 '상점구매' 값에 따라 품목 이름을 바꿔넣기 //구현완료
                            "\n→");
                } else if (화면 == 3 && 세부1 == 1 && 세부2 == 1 && 스택가능==2) { //선택한 아이템이 스택불가능일경우
                    System.out.print("" +
                            상점.상점구매타겟(상점구매) +
                            "을(를) "+ 상점.리스트.get(상점구매-1).구매가격+"골드에 구매하시겠습니까?" +//변수 '상점구매' 값에 따라 품목 이름을 바꿔넣기 //구현완료
                            "\n0.취소" +
                            "\n1.확인" +
                            "\n→");
                } else if (화면 == 3 && 세부1 == 2 && 세부2 == 0) {
                    System.out.println(메인.능력치창(캐릭터));
                    System.out.print(메인.행동상점판매목록(캐릭터, 상점));
                } else if (화면 == 3 && 세부1 == 2 && 세부2 == 1 && 스택가능==1) {
                    if(상점판매<=2){ //상점판매가 2이하면
                        System.out.println(캐릭터.회복물약가방.get(상점판매-1).아이템이름+
                                "(보유량: " + 캐릭터.회복물약가방.get(상점판매-1).스택수+"개)"+
                                "을(를) 몇 개 판매하시겠습니까?\n(0개: 취소)" +
                                "\n→");
                    } else { //상점판매가 3이상이면
                        System.out.print("" +
                                캐릭터.소지품.get(상점판매-3).아이템이름 +
                                "(보유량: " + 캐릭터.소지품.get(상점판매-3).스택수+"개)"+
                                "을(를) 몇 개 판매하시겠습니까?\n(0개: 취소)" +
                                "\n→");
                    }
                } else if (화면 == 3 && 세부1 == 2 && 세부2 == 1 && 스택가능==2) {
                    System.out.print("" +
                            캐릭터.소지품.get(상점판매-3).아이템이름 +
                            "을(를) "+캐릭터.소지품.get(상점판매-3).판매가격+"골드에 판매하시겠습니까?" +//변수 '상점구매' 값에 따라 품목 이름을 바꿔넣기
                            "\n0.취소" +
                            "\n1.확인" +
                            "\n→");

                } else if (화면 == 3 && 세부1 == 3 && 세부2 == 0) {
                    System.out.println(메인.능력치창(캐릭터));
                    System.out.print(메인.행동상점구매목록(캐릭터, 상점));
                    System.out.print("" +
                            "\n└──────────────────" +
                            "\n살펴볼 아이템을 선택하세요." +
                            "\n→");
                } else if (화면 == 4 && 세부1 == 0 && 세부2 == 0) {
                    System.out.println(메인.능력치창(캐릭터));
                    System.out.print("" +
                            "\n대장간에 들어왔습니다. 아이템을 강화할 수 있습니다." +
                            "\n1.강화하기" +
                            "\n2.나가기" +
                            "\n→");
                } else if (화면 == 4 && 세부1 == 1 && 세부2 == 0) { // 대장간 강화할거 선택하는창
                    System.out.println(메인.능력치창(캐릭터));
                    System.out.println(메인.행동강화목록(캐릭터));
                } else if (화면 == 4 && 세부1 == 1 && 세부2 == 1) {
                    아이템정보 = 캐릭터.강화목록.get(강화선택-1);
                    강화능력치표시.append("\n" + 아이템정보.아이템이름 + "\n");
                    if(아이템정보.추가체력>=1){ //선택한 아이템이 추가체력이 1 이상일 때
                        강화능력치표시.append("추가 체력: " + 아이템정보.추가체력 + "\n");
                    }
                    if(아이템정보.추가마나>=1){
                        강화능력치표시.append("추가 마나: " + 아이템정보.추가마나 + "\n");
                    }
                    if(아이템정보.추가공격력>=1){
                        강화능력치표시.append("추가 공격력: " + 아이템정보.추가공격력 + "\n");
                    }
                    if(아이템정보.추가방어력>=1){
                        강화능력치표시.append("추가 방어력: " + 아이템정보.추가방어력 + "\n");
                    }
                    if(아이템정보.추가치확>=1){
                        강화능력치표시.append("추가 치명확률: " + 아이템정보.추가치확 + "\n");
                    }
                    if(아이템정보.추가치피>=1){
                        강화능력치표시.append("추가 치명피해: " + 아이템정보.추가치피 + "\n");
                    }
                    강화능력치표시.append("위 아이템을 강화하시겠습니까?" +
                            "\n1.강화하기" +
                            "\n2.취소하기" +
                            "\n→");
                    System.out.print(강화능력치표시);
                } else if (화면 == 5 && 세부1 == 0 && 세부2 == 0 && 몬스터머릿수 - 죽은몬스터수 >= 1) {
                    System.out.println(메인.능력치창(캐릭터));
                    System.out.println(메인.몬스터목록(몬스터머릿수, 몬스터어레이, 죽은몬스터수));
                    System.out.print("" +
//                        몬스터머릿수+죽은몬스터수 +"\n"+
                            (몬스터머릿수 - 죽은몬스터수) + "마리의 몬스터가 살아있습니다." +
                            "\n무엇을 하시겠습니까?" +
                            "\n1.공격" +
                            "\n2.스킬" +
                            "\n3.아이템" +
                            "\n4.살펴보기" +
                            "\n5.도망치기" +
                            "\n→");
                } else if (화면 == 5 && 세부1 == 1 && 세부2 == 0) {
                    System.out.println(메인.능력치창(캐릭터));
                    System.out.println("\n공격할 몬스터를 선택하세요.");
                    System.out.println(메인.행동몬스터목록(몬스터머릿수, 몬스터어레이, 죽은몬스터수));
                    System.out.print("\n→");
                } else if (화면 == 5 && 세부1 == 5 && 세부2 == 0) {
                    System.out.print("" +
                            "\n정말 도망치겠습니까?" +
                            "\n1.도망친다" +
                            "\n2.취소한다" +
                            "\n→");
                } else if (화면 == 5 && 세부1 == 0 && 세부2 == 0 && 몬스터머릿수 - 죽은몬스터수 == 0) {
                    System.out.print("\n전투에서 승리했습니다." +
                            "\n계속하려면 아무 숫자나 입력하세요." +
                            "\n→");
                    a = sc.nextInt();
                    몬스터머릿수 = 0;
                    죽은몬스터수 = 0;
                    몬스터어레이.clear();
                    화면 = 2;
                    패스 = true;
                    턴 = false;
                    a = 0;
                }
            }
            //화면출력 끝


//            if(화면==5){
//                전투.main(몬스터머릿수, 몬스터어레이, 죽은몬스터수);
//            }

            //입력값 받기 시작
            {
                if (!패스) {
                    if (화면 != 5) {
                        a = sc.nextInt();
                    } else if (화면 == 5) {
                        b = sc.nextInt();
                    }
                    if (화면 == 1 && 세부1 == 2 && 세부2 == 1 && a >= 0) { //1-2-1이며 a가 0이상일 때
                        b = a;
                        a = 0;
                    } else if (화면 == 2 && 세부1 == 2 && 세부2 == 1 && a >= 0) { //2-2-1이며 a가 0이상일 때
                        b = a;
                        a = 0;
                    } else if (화면 == 3 && 세부1 == 1 && 세부2 == 0 && a >= 0) { //3-1-0이며 a가 0이상일 때
                        b = a;
                        a = 0;
                    } else if (화면 == 3 && 세부1 == 1 && 세부2 == 1 && a >= 0) { //3-1-1이며 a가 0이상일 때
                         b = a;
                         a = 0;
                    } else if (화면 == 3 && 세부1 == 2 && 세부2 == 0 && a >= 0) { //3-2-0이며 a가 0이상일 때
                         b = a;
                         a = 0;
                    } else if (화면 == 3 && 세부1 == 2 && 세부2 == 1 && a >= 0) { //3-2-1이며 a가 0이상일 때
                        b = a;
                        a = 0;
                    } else if (화면 == 3 && 세부1 == 3 && 세부2 == 0 && a >= 0) { //3-3-0이며 a가 0이상일 때
                        b = a;
                        a = 0;
                    } else if (화면 == 4 && 세부1 == 1 && 세부2 == 0 && a >= 0) { //4-1-0이며 a가 0이상일 때
                        b = a;
                        a = 0;
                    }
                }
                패스 = false;
            }
            //입력값 받기 끝


            //1-0-0 시작
            {
                if (화면 == 1 && 세부1 == 0 && 세부2 == 0 && a == 1) {
                    화면 = 2;
                    a = 0;
                }
                if (화면 == 1 && 세부1 == 0 && 세부2 == 0 && a == 2) {
                    화면 = 1;
                    세부1 = 2;
                    a = 0;
                }
                if (화면 == 1 && 세부1 == 0 && 세부2 == 0 && a == 3) {
                    화면 = 3;
                    a = 0;
                }
                if (화면 == 1 && 세부1 == 0 && 세부2 == 0 && a == 4) {
                    화면 = 4;
                    a = 0;
                }
                if (화면 == 1 && 세부1 == 0 && 세부2 == 0 && a == 5) {
                    화면 = 2;
                    세부1 = 3;
                    세부2 = 1; //세부2가 1이면 마을에서 휴식, 2면 사냥터에서 휴식
                    a = 0;
                }
                //1-1-0은 없음
                if (화면 == 1 && 세부1 == 2 && 세부2 == 0 && a == 1) {
                    세부2=1;
                    a=0;
                }
                if (화면 == 1 && 세부1 == 2 && 세부2 == 0 && a == 4) {
                    세부1 = 0;
                    a = 0;
                }
                if (화면 == 1 && 세부1 == 2 && 세부2 == 1 && b == 0) { //1-2-1일땐 0입력이 필요하므로 b를 사용
                    세부2 = 0;
                    b = -1;
                }
                if (화면 == 1 && 세부1 == 2 && 세부2 == 1 && b>=1 && b<=전체가방크기) {//1-2-1일땐 0입력이 필요하므로 b를 사용
                    아이템사용=true; //아이템 사용 스크립트 실행용
                    //이 아래는 버리기와 장착하기 에도 동일하게 쓰임
                    if(b<=회복물약가방크기){ //회복물약 내용물을 선택했다면
                        사용선택=b-1;
                        물약여부=1;
                        if(캐릭터.회복물약가방.get(사용선택).스택수==0){ //선택한 물약의 스택수가 0개라면
                            System.out.println("스택수0개");
                            아이템사용=false;
                            System.out.println("\n"+캐릭터.회복물약가방.get(사용선택).아이템이름+"이 부족합니다.");
                            Thread.sleep(1000);
                            세부2=1;
                            물약여부=0;
                            사용선택=-1;
                        } //회복물약 이외의 아이템들은 0개가 되는 순간 인벤정리 메소드에 의해 삭제됨.
                    }
                    else{ //회복물약가방 내용물이 아닌것을 선택했다면
                        사용선택 = b-(회복물약가방크기+1);
                        if(캐릭터.소지품.get(사용선택).사용가능여부) { //사용가능한 물건이라면
                            물약여부 = 2;
                        }
                        else{ // 사용 불가능한 물건이라면
                            아이템사용=false;
                            System.out.println("\n사용할 수 없는 아이템입니다.");
                            Thread.sleep(1000);
                            세부2=1;
                            물약여부=0;
                            사용선택=-1;
                        }
                    }
                    //이 위는 버리기와 장착하기에도 동일하게 쓰임
                    b = -1;
                    System.out.println("아이템사용 : " + 아이템사용);
                    System.out.println("사용선택 : " + 사용선택);
                    System.out.println("물약여부 : " + 물약여부);

                }
            }
            //1-0-0 끝

            //2-0-0 시작
            {
                if (화면 == 2 && 세부1 == 0 && 세부2 == 0 && a == 1) {
                    세부1 = 1;
                    a = 0;
                }
                if (화면 == 2 && 세부1 == 0 && 세부2 == 0 && a == 2) {
                    세부1 = 2;
                    a = 0;
                }
                if (화면 == 2 && 세부1 == 0 && 세부2 == 0 && a == 3) {
                    세부1 = 3;
                    세부2 = 2; //세부2가 1이면 마을에서 휴식, 2면 사냥터에서 휴식
                    a = 0;
                }
                if (화면 == 2 && 세부1 == 0 && 세부2 == 0 && a == 4) {
                    화면 = 1;
                    a = 0;
                }
                if (화면 == 2 && 세부1 == 2 && 세부2 == 0 && a == 1) {
                    화면 = 2;
                    세부2 = 1;
                    a = 0;
                }
                if (화면 == 2 && 세부1 == 2 && 세부2 == 0 && a == 4) {
                    화면 = 2;
                    세부1 = 0;
                    a = 0;
                }
                if (화면 == 2 && 세부1 == 2 && 세부2 == 1 && b == 0) { //2-2-1일땐 0입력이 필요하므로 b를 사용
                    세부2 = 0;
                    b = -1;
                }
                if (화면 == 2 && 세부1 == 2 && 세부2 == 1 && b >= 1) {//2-2-1일땐 0입력이 필요하므로 b를 사용
                    System.out.printf("아이템 사용 메소드 만들기");
                    b = -1;
                }
            }
            //2-0-0 끝

            //3-0-0 시작 / 나가기 조건은 현재 7번이지만 상점 품목들을 배열로 놓고 length를 써서 적용해보기.
            {
                if (화면 == 3 && 세부1 == 0 && 세부2 == 0 && a == 1) { // 300에서 1(구매하기)를 선택
                    세부1 = 1;
                    a = 0;
                }
                if (화면 == 3 && 세부1 == 0 && 세부2 == 0 && a == 2) { // 300에서 2(판매하기)를 선택
                    세부1 = 2;
                    a = 0;
                }
                if (화면 == 3 && 세부1 == 0 && 세부2 == 0 && a == 3) { // 300에서 3(살펴보기)를 선택
                    세부1 = 3;
                    a = 0;
                }
                if (화면 == 3 && 세부1 == 0 && 세부2 == 0 && a == 4) { // 300에서 4(나가기)를 선택
                    화면 = 1;
                    a = 0;
                }
                if (화면 == 3 && 세부1 == 1 && 세부2 == 0 && b == 0) { // 310에서 0(취소)를 선택
                    세부1 = 0;
                    b = -1;
                }
                if (화면 == 3 && 세부1 == 1 && 세부2 == 0 && b >= 1 && b <= 상점판매개수.size()) { // 310에서 입력값이 1이상이며 상점리스트개수 이하일때
                    세부2 = 1;
                    상점구매 = b; //뭘 눌러서 구매확인창이 떴는지 확인
                    b = -1;
                    if(상점.리스트.get(상점구매-1).스택가능여부){
                        스택가능=1; //선택한 아이템의 스택가능여부가 true일 경우 스택가능을 1로
                    }
                    else{
                        스택가능=2; //선택한 아이템의 스택가능여부가 false일 경우 스택가능을 2로
                    }
                }
//                if (화면 == 3 && 세부1 == 1 && 세부2 == 1 && 상점구매 <= 2 && b == 1) { //상점 구매확인창에서 구매하기를 누를 경우
//                    System.out.println(상점.상점구매타겟(상점구매)+"을(를) 구매했습니다.");//변수 '상점구매' 값에 따라 품목명을 다르게 넣기
                if (화면 == 3 && 세부1 == 1 && 세부2 == 1 && 스택가능==1 && b==0) { // 스택가능한 아이템을 선택했을 때, 0을 입력했을 경우
                    세부2 = 0;
                    상점구매 = 0;
                    스택가능=0;
                    b = -1;
                }
                if (화면 == 3 && 세부1 == 1 && 세부2 == 1 && 스택가능==1 && b>=1) { // (구매 개수 선택창)스택가능한 아이템을 선택했을 때, 1이상의 숫자를 입력했을 때
                    System.out.println(상점.리스트.size());
                    세부2 = 0;
                    구매개수 = b;
                    상점구매확인1 = true;
                    b = -1;
                }
                if (화면 == 3 && 세부1 == 1 && 세부2 == 1 && 스택가능==2 && b==0) { //스택 불가능한 아이템을 선택했을 때, 0을 입력했을 경우
                    세부2 = 0;
                    상점구매 = 0;
                    스택가능=0;
                    b = -1;
                }
                if (화면 == 3 && 세부1 == 1 && 세부2 == 1 && 스택가능==2 && b==1) { //스택 불가능한 아이템을 선택했을 때 1(구매하기)을 입력했을 경우
                    세부2 = 0;
                    구매개수=b;
                    상점구매확인1=true;
                    b = -1;
                }
                if (화면 == 3 && 세부1 == 2 && 세부2 == 0 && b == 0) { //320에서 0(취소)를 선택
                    세부1 = 0;
                    b = -1;
                }
                if (화면 == 3 && 세부1 == 2 && 세부2 == 0 && b >= 1 && b <= 전체가방크기) { // 320에서 입력값이 1이상이며 소지품 개수 이하일 때
                    세부2 = 1;
                    상점판매 = b; //뭘 눌러서 구매확인창이 떴는지 확인
                    b = -1;
                    if(상점판매<=회복물약가방크기){ //상점판매 값이 1이상이고 회복물약가방의 사이즈 이하면(회복물약가방의 내용물이면)
                        System.out.println("회복물약가방 이프문 진입");
                        물약여부=1;
                        스택가능=1; //선택한 아이템의 스택가능여부가 true일 경우 스택가능을 1로
                    }
                    else {//상점판매 값이 3이상이고 소지품 사이즈 이하면
                        System.out.println("상점판매 : "+상점판매 + ", 상점구매 : "+상점구매 + ", 회복물약가방크기 : " + 회복물약가방크기 + ", 인벤토리크기 : "+인벤토리크기);
                        System.out.println("@@@@@@@@@@캐릭터.소지품.get(상점판매-3)는 " + 캐릭터.소지품.get(상점판매-3).아이템이름);
                        if(캐릭터.소지품.get(상점판매-3).스택가능여부){ //스택가능여부가 true면
                            스택가능=1;
                            물약여부=2;
                        }
                        else{
                            스택가능=2;
                            물약여부=2;
                        }
                    }
                } //
                if (화면 == 3 && 세부1 == 2 && 세부2 == 1 && 스택가능==1 && b == 0) { //상점 판매개수 확인창에서 0을 입력할경우
                    세부2 = 0;
                    상점판매 = 0;
                    스택가능=0;
                    b = -1;
                }
                if (화면 == 3 && 세부1 == 2 && 세부2 == 1 && 스택가능==1 && b >=1 && 물약여부==1) { //321이고 스택가능한 아이템이고 b가 1이상이고 물약일때
                    System.out.println("@@@@@"+캐릭터.회복물약가방.get(상점판매-1).스택수);
                    if(b<=캐릭터.회복물약가방.get(상점판매-1).스택수) {//스택수 이하의 숫자를 입력했을 때
                        세부2 = 0;
                        판매개수 = b;
                        상점판매확인1 = true;
                        b = -1;
                    }
                    else{
                        System.out.println("\n보유량 이하의 값을 입력해주세요.");
                    }
                }
                if (화면 == 3 && 세부1 == 2 && 세부2 == 1 && 스택가능==1 && b >=1 && 물약여부==2) { //321이고 스택가능한 아이템이고 b가 1이상이고 물약이 아닐때
                    System.out.println("@@@@@"+캐릭터.소지품.get(상점판매-3).스택수);
                    if(b<=캐릭터.소지품.get(상점판매-3).스택수) {
                        세부2 = 0;
                        판매개수 = b;
                        상점판매확인1 = true;
                        b = -1;
                    }
                    else{
                        System.out.println("\n보유량 이하의 값을 입력해주세요.");
                    }
                }
                if (화면 == 3 && 세부1 == 2 && 세부2 == 1 && 스택가능==2 && b == 0) { //상점 판매확인창(스택불가능)에서 0(취소) 를 입력했을 경우
                    세부2 = 0;
                    상점판매 = 0;
                    스택가능=0;
                    b = -1;
                }
                if (화면 == 3 && 세부1 == 2 && 세부2 == 1 && 스택가능==2 && b == 1) { //상점 판매확인창(스택불가능)에서 1(확인) 을 입력했을 경우
                    세부2 = 0;
                    판매개수= 1;
                    상점판매확인1=true;
                    b = -1;
                }
                if (화면 == 3 && 세부1 == 3 && 세부2 == 0 && b == 0) { //330에서 0(취소)를 선택
                    세부1 = 0;
                    b = -1;
                }
                //상점에 구매수량제한을 넣어야 할 것 같음. 고민해보기.
                //포션의 경우엔 구매 수량을 입력할 수 있게 해보기.
            }
            //3-0-0 끝 / 나가기 조건은 현재 7번이지만 상점 품목들을 배열로 놓고 length를 써서 적용해보기.

            //4-0-0 시작
            {
                if (화면 == 4 && 세부1 == 0 && 세부2 == 0 && a == 1) {
                    세부1 = 1;
                    a = 0;
                }
                if (화면 == 4 && 세부1 == 0 && 세부2 == 0 && a == 2) {//400에서 2(나가기)를 선택
                    화면 = 1;
                    a = 0;
                }
                if (화면 == 4 && 세부1 == 1 && 세부2 == 0 && b == 0) { //뭐 강화할지 선택하는 창(410)에서 나가기 누를시
                    세부1 = 0;
                    b = -1;
                }
                if (화면 == 4 && 세부1 == 1 && 세부2 == 0 && b >= 1 && b<=캐릭터.강화목록.size()) { // 입력값이 2이상, 9이하일때 이지만 length를 적용해보기
                    세부2 = 1;
                    강화선택 = b; //뭘 눌러서 강화확인창이 떴는지 확인
                    b = 0;
                }
                if (화면 == 4 && 세부1 == 1 && 세부2 == 1 && a == 1) { //411에서 1(강화하기)를 선택
                    System.out.println("방패을(를) 강화합니다.");
                    세부2 = 0;
                    강화확인 = true;
                    a = 0;
                }
                if (화면 == 4 && 세부1 == 1 && 세부2 == 1 && a == 2) { //강화확인창(411)에서 2(취소)를 누를경우
                    세부2 = 0;
                    강화선택 = 0;
                    a = 0;
                }
            }
            //4-0-0 끝

            //5-0-0(전투화면) 시작
            {
                if (화면 == 5 && 세부1 == 0 && 세부2 == 0 && b == 1) {
                    세부1 = 1;
                    b = -1;
                }
                if (화면 == 5 && 세부1 == 0 && 세부2 == 0 && b == 2) {
                    b = -1;
                }
                if (화면 == 5 && 세부1 == 0 && 세부2 == 0 && b == 3) {
                    b = -1;
                }
                if (화면 == 5 && 세부1 == 0 && 세부2 == 0 && b == 4) {
                    b = -1;
                }
                if (화면 == 5 && 세부1 == 0 && 세부2 == 0 && b == 5) {
                    세부1 = 5;
                    b = -1;
                }
                if (화면 == 5 && 세부1 == 1 && 세부2 == 0 && b == 0) {
                    세부1 = 0;
                    b = -1;
                }
                if (화면 == 5 && 세부1 == 1 && 세부2 == 0 && b > 0 && b <= 몬스터머릿수 - 죽은몬스터수) { //공격실행
                    죽은몬스터수2 = 몬스터.공격(몬스터어레이, b, 캐릭터);
                    죽은몬스터수 = 죽은몬스터수 + 죽은몬스터수2;
                    if (죽은몬스터수2 >= 1) {
                        몬스터어레이.remove(b - 1);
//                    몬스터어레이.add(new 몬스터(""+b,"시체"));
                    }
                    ;
                    죽은몬스터수2 = 0;
                    세부1 = 0;
                    b = -1;
                    턴 = true;
                }

                if (화면 == 5 && 세부1 == 5 && 세부2 == 0 && b == 1) {
                    System.out.println("도망쳤습니다.");
                    몬스터머릿수 = 0;
                    죽은몬스터수 = 0;
                    몬스터어레이.clear();
                    화면 = 2;
                    세부1 = 0;
                    b = -1;
                }
                if (화면 == 5 && 세부1 == 5 && 세부2 == 0 && b == 2) {
                    세부1 = 0;
                    b = -1;
                }
            }
            //5-0-0(전투화면) 끝

            //6-0-0(전투결과화면) 시작
            //6-0-0(전투결과화면) 끝

            //더미아이템생성 시작
            if(a==456 || b==456){
                a=0;
                b=-1;
            }
            //더미아이템생성 끝

            //특수스크립트 시작(뒤에 입력을 받지 않는 스크립트들)
            {
                //상점 구매시작
                if (상점구매 != 0 && 상점구매확인1) {
//                        System.out.println("상점구매스크립트 발동");
                    상점구매확인1 = false;
                    //변수 '상점구매' 값에 따라 인벤토리에 아이템을 추가하는 줄
                    //구매가격에 따라 소지금에서 차감
//                        System.out.println(상점.상점구매타겟(상점구매)); //구매할 아이템의 이름을 임시로 표시
                    캐릭터.상점구매(상점구매,상점,스택가능,구매개수);
                    상점구매 = 0;
                    스택가능=0;
                    구매개수=0;
                }
                //상점 구매 끝

                //상점 판매시작
                if (상점판매 != 0 && 상점판매확인1) {
                    System.out.println("상점판매스크립트 발동");
                    상점판매확인1 = false;
                    //변수 '상점판매' 값에 따라 인벤토리에서 아이템을 추가하는 줄
                    //판매가격에 따라 소지금에 가산
                    캐릭터.상점판매(상점판매,스택가능,판매개수,물약여부);
                    캐릭터.인벤정리();
                    물약여부 = 0;
                    상점판매 = 0;
                    스택가능 = 0;
                    판매개수 = 0;
                }
                //상점 판매 끝

                //강화리스트생성 시작(추후에 대장간에 진입할때만 작동하도록 위치를 옮기던가 조치하기)
                캐릭터.강화리스트생성();
                //강화리스트생성 끝(추후에 대장간에 진입할때만 작동하도록 위치를 옮기던가 조치하기)

                //장비 강화시작
                if (강화선택 != 0 && 강화확인) {
                    System.out.println("강화스크립트 발동");
                    강화확인 = false;
                    //변수 '강화선택' 값에 해당하는 아이템에 강화를 시도
                    //실패와 성공 난수로 처리 후 결과 출력
                    강화선택 = 0;
                }
                //장비 강화끝

                //아이템 사용 시작
                if (사용선택+1 != 0 && 아이템사용){ //여기에 온 시점에 이미 사용 가능한 아이템임.
                    아이템사용=false;
                    if(물약여부==1){ //물약이면
                        System.out.println("물약사용메소드 호출");
                        캐릭터.아이템사용(물약여부, 사용선택);
                    }
                    else{ //물약이 아니면
                        System.out.println("아이템장착메소드 호출");
                        if(캐릭터.소지품.get(사용선택).착용가능여부){ //착용가능하면
                            캐릭터.아이템장착(사용선택);
                        }
                        else{ //사용 가능하지만 물약도 아니고 착용도 불가능하면(소거법에 의해 소모아이템으로 판정)
                            System.out.println("소모아이템사용메소드 호출");
                            캐릭터.아이템사용(물약여부, 사용선택);
                        }
                    }
                    캐릭터.인벤정리();
                    물약여부=0;
                    사용선택=-1;
                }
                //아이템 사용 끝

                //휴식 시작
                else if (화면 == 2 && 세부1 == 3) {
                    System.out.println("\n휴식합니다.");
                    Thread.sleep(1000);
                    if (캐릭터.캐릭터최종체력 - 캐릭터.캐릭터현재체력 >= 300) {
                        캐릭터.캐릭터현재체력 = 캐릭터.캐릭터현재체력 + 300;
                        System.out.print("\n체력이 300회복되어 " + 캐릭터.캐릭터현재체력 + "이(가) 되었습니다." +
                                "\n계속하려면 아무 숫자나 입력하세요." +
                                "\n→");
                        a = sc.nextInt();

                    } else {
                        System.out.print("\n체력이 " + (캐릭터.캐릭터최종체력 - 캐릭터.캐릭터현재체력) + "회복되어 ");
                        캐릭터.캐릭터현재체력 = 캐릭터.캐릭터최종체력;
                        System.out.println(캐릭터.캐릭터현재체력 + "이(가) 되었습니다." +
                                "\n계속하려면 아무 숫자나 입력하세요." +
                                "\n→");
                        a = sc.nextInt();
                    }
                    if (세부2 == 1) {
                        화면 = 1;
                    }
                    세부1 = 0;
                    세부2 = 0;
                    a = 0;
                }
                //휴식 끝

                //전투턴넘기기 시작
                if (화면 == 5 && 턴 && 몬스터머릿수 - 죽은몬스터수 >= 1) {
                    사망 = 몬스터.몬스터공격(몬스터어레이, 몬스터머릿수 - 죽은몬스터수, 캐릭터);
                    턴 = false;
                }
                //전투턴넘기기 끝

                //장비능력치적용 시작
                캐릭터.장비능력치적용();
                //장비능력치적용 끝

                //혹시모르니 한번더 입력값초기화
                a=0;
                b=-1;
            }
            //특수스크립트 끝(뒤에 입력을 받지 않는 스크립트들)
            if(사망){
                System.exit(0);
            }
            //
            System.out.print("\n화면 : "+화면);
            System.out.print("\n세부1: "+세부1);
            System.out.print("\n세부2: "+세부2+"\n");


        }//제일바깥쪽 while문 닫힘
    }//psvm 닫힘

}//class 닫힘

//
//───────────────────────────
//레벨: 1 (100/0)
//체력: 1000/1000
//마나: 100/100
//공격력: 50
//방어력: 10
//치명확률: 20%
//치명피해: 150%
//회피율: 10%
//───────────────────────────
//1. 사냥터
//2. 상점/인벤토리
//3. 대장간
//4. 휴식
//───────────────────────────
//레벨: 1 (100/0)
//체력: 1000/1000
//마나: 100/100
//공격력: 50
//방어력: 10
//치명확률: 20%
//치명피해: 150%
//회피율: 10%
//───────────────────────────
//인벤토리를 열어봅니다.
//체력물약 : 0개
//마나물약 : 0개
//검
//방패
//
//───────────────────────────
//레벨: 1 (100/0)
//체력: 1000/1000
//마나: 100/100
//공격력: 50
//방어력: 10
//치명확률: 20%
//치명피해: 150%
//회피율: 10%
//───────────────────────────
//상점에 들어왔습니다.
//
//체력포션 10골드
//마나포션 10골드
//검 100골드
//방패 100골드
//갑옷 100골드
//각반 100골드
//
//몬스터를 발견했다!!!
//5-0-0으로 이동
//
//
//고블린1, 고블린2, 오크1 이(가) 나타났다!!(몬스터 수는 랜덤1~3마리, 종류도 랜덤)
//계속하려면 아무 숫자나 입력하세요.
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//
//





