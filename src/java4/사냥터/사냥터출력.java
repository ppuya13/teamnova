package java4.사냥터;

import java4.사냥터.몬스터.몬스터;
import java4.사냥터.몬스터.스킬.몬스터스킬;
import java4.아이템.소모.지속형.지속형;

import static java4.Main.플레이어;


public class 사냥터출력 extends 사냥터{
    public static boolean 턴넘김 = false;
    public static boolean 몹사망 = false;
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
    public void 전투(boolean 보스전) throws InterruptedException, CloneNotSupportedException {
        전투_몬스터창 몬스터창 = new 전투_몬스터창(몬스터어레이);
        전투_캐릭터창 캐릭터창 = new 전투_캐릭터창(플레이어);
        몬스터창.start();
        캐릭터창.start();
        플레이어.행동게이지=10000;
        for(int i = 0 ; i < 몬스터어레이.size() ; i++) {
            몬스터어레이.get(i).start();
        }

        boolean 전투 = true;
        전투:
        while (전투) {
            while (플레이어.행동게이지 == 플레이어.행동) {
                입력 = -1;
                System.out.println(메인.능력치창());
                System.out.println(this.몬스터목록());
                this.사냥터행동(보스전);
                입력 = sc.nextInt();
                switch (입력) {
                    case 1: //공격
                        if (플레이어.캐릭터공격(몬스터어레이, this)) {
                            continue 전투;
                        }
                        몬스터삭제 = true;
                        턴넘김 = true;
                        break;
                    case 2: //스킬
                        this.스킬();
                        break;
                    case 3: //아이템
                        this.아이템();
                        break;
                    case 4: //살펴보기
                        this.살펴보기();
                        break;
                    case 5: //도망치기
                        if (!보스전) {
                            반복 = true;
                            while (반복) {
                                System.out.println("" +
                                        "정말 도망치시겠습니까?" +
                                        "\n0.취소한다." +
                                        "\n1.도망친다.");
                                입력 = sc.nextInt();
                                switch (입력) {
                                    case 0:
                                        continue 전투;
                                    case 1:
                                        System.out.println("도망쳤습니다.");
                                        플레이어.사용중.clear();
                                        전투종료 = true;
                                        반복 = false;
                                        Thread.sleep(1000);
                                        break;
                                }
                            }
                            break;
                        }
                        break;
                }
                if (턴넘김) {
//                            플레이어.소모템적용(); //소모템 지속시간도 여기서 감소시킴
                    if (플레이어.사용중.size() > 0) {//적용중인 지속스킬이 있다면
                        for (int i = 0; i < 플레이어.사용중.size(); i++) { //지속스킬 수만큼 반복
                            ((지속형) 플레이어.사용중.get(i)).효과적용(플레이어);
                        }
                        재시작:
                        while (true) {
                            if (플레이어.사용중.size() > 0) {//계속 지워줘야하기 때문에 지속스킬 개수 판정을 다시함
                                for (int i = 0; i < 플레이어.사용중.size(); i++) {
                                    if (((지속형) 플레이어.사용중.get(i)).효과삭제(플레이어)) {//스킬을 하나 지웠으면
                                        continue 재시작; //재시작함
                                    }
                                }
                            }
                            //지속스킬이 더이상 없거나 지울 스킬이 없다면
                            break;
                        }
                    }
                }
                플레이어.능력치적용();

                //플레이어의 행동이 끝난 뒤
                this.몬스터삭제(this.몬스터삭제);
                전투승리 = this.전투종료판정(몬스터어레이, 보스전);


                if (전투승리) {
                    턴넘김 = false;
                    전투종료 = true;
                    플레이어.사용중.clear();
                }
                if (턴넘김) {
                    플레이어.행동게이지=0;
                    synchronized (플레이어){
                        Thread.sleep(100);
                        플레이어.notify();
//                        System.out.println(플레이어.getState());
                    }
                    this.몬스터삭제(몬스터삭제);
                    턴넘김 = false;
//                    if (사망) {
//                        System.exit(0);
//                    }
                }
                if (전투종료) {//전투가 종료됐다면
                    몬스터창.interrupt();
                    캐릭터창.interrupt();
                    this.전투정산(전투승리, 플레이어);
                    반복 = true;
                    전투승리 = false;
                    전투종료 = false;
                    return;
                }
                반복 = true;
            }
            Thread.sleep(50);
        }
    }
    public void 스킬() throws InterruptedException {
        boolean 스킬반복 = true;
        스킬:
        while (스킬반복) {
            System.out.println(메인.능력치창());
            System.out.println("\n보유 중인 스킬 리스트");
            System.out.println(메인.스킬창());
            System.out.print("" +
                    "사용할 스킬을 선택해주세요. " +
                    "\n→");
            입력 = sc.nextInt();
            if (입력 == 0) {
                break;
            } else if (입력 > 0 && 입력 <= 플레이어.스킬목록.size()) {
                스킬 = 플레이어.스킬목록.get(입력 - 1);
                if(스킬.사용확인(몬스터어레이,플레이어,this)){
                    continue 스킬; //true면 취소했다는 뜻이기 때문에 스킬선택창으로 돌아감
                }
                몬스터삭제 = true;
                턴넘김 = true;
                스킬반복=false;
            }
        }
    }
    public void 아이템() throws InterruptedException, CloneNotSupportedException {
        아이템:
        while (true) {
            System.out.println(메인.능력치창());
            System.out.println("\n아이템 사용하기");
            System.out.println(메인.행동인벤토리());
            System.out.print("" +
                    "아이템을 선택해주세요. " +
                    "\n소모품만을 사용할 수 있으며, 아이템 사용 시 턴을 넘기게됩니다." +
                    "\n→");
            입력 = sc.nextInt();
            if (입력 == 0) {
                break;
            } else if (입력 > 0 && 입력 <= 플레이어.소지품.size() + 플레이어.회복물약가방.size()) {
                아이템정보 = 플레이어.아이템사용(입력);
                if (아이템정보.착용가능여부) { //선택한 아이템이 착용가능하면
                    System.out.println("전투중엔 아이템 장착/해제를 할 수 없습니다.");
                    Thread.sleep(1000);
                } else {
                    if(아이템정보.사용효과(플레이어)){
                        continue 아이템;
                    }
                    플레이어.인벤정리();
                    턴넘김 = true;
                    break;
                }
            }

        }
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
