package java4.사냥터.구사냥터코드;

import java4.사냥터.전투_몬스터창;
import java4.사냥터.전투_캐릭터창;
import java4.사냥터.몬스터.몬스터;
import java4.사냥터.몬스터.스킬.몬스터스킬;

import static java4.Main.플레이어;


public class 구사냥터출력 extends 구사냥터 {
    public static boolean 전투 = false; //true이면 전투중
    public static boolean 행동중 = false; //공격을 시작하는 순간 true되고 행동이 완전히 끝나고 행동게이지가 줄어든 뒤에 false로 바뀜
    public static boolean 턴넘김 = false; //true이면 턴넘김(전투 클래스에서 처리)
    public static boolean 턴여부 = false; //턴이 시작되면 true;
    public static boolean 입력대기 = true; //스킬사용시 입력대기가 false이면 다음으로 넘어감
    public static boolean 몬스터삭제 = false;
    public static boolean 전투메뉴 = true; //true이면 전투 최상위 선택지를 출력함.
    public static int 전투입력;
    //    public static boolean 몹사망 = false;
    public void 사냥터() throws InterruptedException, CloneNotSupportedException {
        사냥터:
        while (반복) {
            입력 = -1;
            System.out.println(메인.능력치창());
            this.사냥터메인();
            입력 = sc.nextInt();
            switch (입력) {
                case 0: //나가기
                    return;
                case 1: //탐색(전투시작)
                    반복 = true;
                    전투 = true;
                    보스전=false;
                    플레이어.전투횟수++;
                    this.몬스터생성();
                    this.전투(보스전);
                    break;
                case 2: //탐색 인벤토리
                    인벤토리출력.인벤토리();
                    break;
                case 3: //휴식
                    플레이어.휴식();
                    break;
                case 4: //보스전
                    반복=true;
                    while(반복){
                        System.out.print("" +
                                "\n보스는 매우 강하며 도망칠 수 없는 전투가 포함되어 있습니다." +
                                "\n정말 보스전을 시작하시겠습니까?" +
                                "\n0.취소한다." +
                                "\n1.보스전을 시작한다." +
                                "\n→");
                        입력=sc.nextInt();
                        switch (입력){
                            case 0:
                                continue 사냥터;
                            case 1:
                                플레이어.전투횟수++;
                                보스전=false;
                                this.보스전생성1();
                                this.전투(보스전);

                                플레이어.전투횟수++;
                                보스전=true;
                                this.보스전생성2();
                                this.전투(보스전);
                                if(보스토벌){//오크로드를 잡았다면
                                    Thread.sleep(1000);
                                    System.out.println("" +
                                            "\n사투 끝에 오크 로드는 쓰러졌고" +
                                            "\n마을의 평화는 지켜졌습니다.");
                                    메인.엔딩();
                                }
                                continue 사냥터;
                        }
                    }
                    break;
//                case 5: //디버그용
//                    몬스터 몬스터 = new 빨간슬라임("1");
            }
        }//사냥터 while문 끝
    }


    public void 사냥터메인() {
        System.out.print(""+
                "\n몬스터를 사냥하러 왔습니다. 무엇을 하시겠습니까?"+
                "\n0.마을로 돌아가기"+
                "\n1.몬스터 탐색"+
                "\n2.인벤토리"+
                "\n3.휴식" +
                "\n4.보스전"+
                "\n→");
    }
    public void 사냥터행동(boolean 보스전){
        if(!보스전) { //보스전이 아닐경우 도망치기가 있음
            System.out.print("" +
//                        몬스터머릿수+죽은몬스터수 +"\n"+
                    몬스터어레이.size() + "마리의 몬스터가 살아있습니다." +
                    "\n무엇을 하시겠습니까?" +
                    "\n1.공격" +
                    "\n2.스킬" +
                    "\n3.아이템" +
                    "\n4.살펴보기" +
                    "\n5.도망치기" +
                    "\n→");
        }else{ //보스전일경우 도망치기가 없음
            System.out.print("" +
                    "오크 로드가 살아있습니다." +
                    "\n무엇을 하시겠습니까?" +
                    "\n1.공격" +
                    "\n2.스킬" +
                    "\n3.아이템" +
                    "\n4.살펴보기" +
                    "\n→");
        }
    }
    public void 전투(boolean 보스전) throws InterruptedException {
        전투_몬스터창 몬스터창 = new 전투_몬스터창(몬스터어레이);
        전투_캐릭터창 캐릭터창 = new 전투_캐릭터창(플레이어);
        구전투 구전투2 = new 구전투(this,보스전, 몬스터창, 캐릭터창);
        구행동게이지 행동게이지 = new 구행동게이지(구전투2);
        몬스터창.start();
        캐릭터창.start();
        구전투2.start();
        행동게이지.start();
        while(전투) {
            while (턴여부) {
                if(전투메뉴) {
                    System.out.println(메인.능력치창());
                    System.out.println(this.몬스터목록());
                    this.사냥터행동(보스전);
                }
                System.out.println("사냥터출력.전투|전투입력: " + 전투입력);
                전투입력 = sc.nextInt();
                System.out.println("사냥터출력.전투|전투입력: " + 전투입력);
                입력대기=false;
                System.out.println("사냥터출력.전투| 전투메뉴: "+전투메뉴);

                if(전투입력>0 && 전투입력<6){
                    전투메뉴 = false;
                    synchronized (구전투2) {
                        구전투2.notify();
                    }
                    synchronized (플레이어) {
                        플레이어.notify();
                    }
                }
                Thread.sleep(200);
            }
            Thread.sleep(100);
        }
        구전투2.interrupt();
        행동게이지.interrupt();
    }
    public void 살펴보기(){
        while (true) {
            System.out.println(메인.능력치창());
            System.out.println("\n살펴볼 몬스터를 선택하세요.");
            System.out.println(this.행동몬스터목록());
            System.out.print("\n→");
            if (입력 == 0) {
                break;
            } else if (입력 > 0 && 입력 <= this.몬스터어레이.size()) {
                몬스터타겟 = this.몬스터어레이.get(입력 - 1);
                System.out.println(메인.정보출력(몬스터타겟));
                for(int i = 0 ; i < this.몬스터어레이.get(입력-1).스킬리스트.size() ; i++){
                    System.out.println(this.몬스터어레이.get(입력-1).이름+"의 스킬 " + i + ": " + this.몬스터어레이.get(입력-1).스킬리스트.get(i).스킬명);
                }
                System.out.print("" +
                        "\n계속하려면 아무 숫자나 입력하세요." +
                        "\n→");
                입력 = sc.nextInt();
                break;
            }
        }
    }

    public StringBuilder 몬스터목록(){
        StringBuilder 몬스터목록 = new StringBuilder();
        StringBuilder 몬스터목록2 = new StringBuilder();
        몬스터 타겟;
        몬스터스킬 스킬;
//        System.out.println("몬스터머릿수 : " + this.몬스터머릿수 + ", 죽은몬스터수 : " + this.죽은몬스터수);
        for(int i=1 ; i <= 몬스터어레이.size() ; i++) {
            타겟 = this.몬스터어레이.get(i-1);
//            System.out.println(this.몬스터머릿수 + "-" + this.죽은몬스터수 + "i : " +i);
//            System.out.println("this.몬스터어레이.size() : " + this.몬스터어레이.size());
            if (this.몬스터어레이.get(i-1).현재체력 > 0) {
                몬스터목록2.append("│ "+타겟.이름+" (체력:" + 타겟.현재체력 + "/" + 타겟.최대체력 + ") │ 공격력: " + 타겟.공격력 + "+" + 타겟.추가공격력 + " │ 방어력: " + 타겟.방어력 + "+" + 타겟.추가방어력);
                if(this.몬스터어레이.get(i-1).지속스킬.size()>0){
                    몬스터목록2.append(" 지속중: ");
                    for(int j = 0; j < 타겟.지속스킬.size();j++) {
                        스킬 = 타겟.지속스킬.get(j);
                        몬스터목록2.append(스킬.스킬명+"("+(스킬.지속시간)+"턴) ");
                    }
                }
                몬스터목록2.append("\n");
            }
        }
        몬스터목록.append("\n┌────────────────────────────────────\n" ).append(몬스터목록2).append("└────────────────────────────────────\n");
        return 몬스터목록;
    }

    public StringBuilder 행동몬스터목록(){
        StringBuilder 몬스터목록 = new StringBuilder();
        StringBuilder 몬스터목록2 = new StringBuilder();
        몬스터 타겟;
        몬스터스킬 스킬;
        for(int i=1 ; i <= 몬스터어레이.size() ; i++) {
            타겟 = this.몬스터어레이.get(i-1);
            if (몬스터어레이.get(i-1).현재체력 > 0) {
                몬스터목록2.append("│ "+i+ ". " +타겟.이름+" (체력:" + 타겟.현재체력 + "/" + 타겟.최대체력 + ") │ 공격력: " + 타겟.공격력 + "+" + 타겟.추가공격력 + " │ 방어력: " + 타겟.방어력 + "+" + 타겟.추가방어력);
                if(this.몬스터어레이.get(i-1).지속스킬.size()>0){
                    몬스터목록2.append(" 지속중: ");
                    for(int j = 0; j < 타겟.지속스킬.size();j++) {
                        스킬 = 타겟.지속스킬.get(j);
                        몬스터목록2.append(스킬.스킬명+"("+(스킬.지속시간)+"턴) ");
                    }
                }
                몬스터목록2.append("\n");
            }
        }
        몬스터목록.append("\n┌────────────────────────────────────\n" ).append("│ 0. 취소\n").append(몬스터목록2).append("└────────────────────────────────────\n");
        return 몬스터목록;
    }
}
