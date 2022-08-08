package java4.사냥터;

import java4.사냥터.몬스터.고블린.고블린궁수;
import java4.사냥터.몬스터.고블린.고블린전사;
import java4.사냥터.몬스터.고블린.보물고블린;
import java4.사냥터.몬스터.몬스터;
import java4.사냥터.몬스터.슬라임.빨간슬라임;
import java4.사냥터.몬스터.슬라임.초록슬라임;
import java4.사냥터.몬스터.오크.오크로드;
import java4.사냥터.몬스터.오크.오크전사;
import java4.사냥터.몬스터.오크.오크주술사;
import java4.아이템.아이템;
import java4.인벤토리.인벤토리출력;
import java4.출력;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import static java4.Main.플레이어;

public class 사냥터{

    public ArrayList<몬스터> 몬스터어레이;
    public int 몬스터머릿수;
    public int 죽은몬스터수;
    boolean 보스전;
    boolean 보스토벌;
    String 몬스터번호; // 각 몬스터마다 고유 번호
    몬스터 몬스터정보; // 몬스터의 이름과 능력치가 들어있음
    String[] 몬스터종류배열 = {"슬라임","고블린", "오크"};
    double 몬스터생성난수;
    ArrayList<아이템> 드랍템 = new ArrayList<>();
    아이템 드랍아이템;
    int num;
    int 몬스터난수;
    int 경험치허브 = 0;
    int 소지금허브 = 0;
    String 랜덤몬스터결과;
    Random rd = new Random();
    출력 메인 = new 출력();
    boolean 반복 = true;
    boolean 몬스터삭제 = false;
    boolean 턴 = false;
    boolean 전투승리 = false;
    boolean 전투종료 = false;
    boolean 사망 = false;
    int 입력;
    Scanner sc = new Scanner(System.in);
    몬스터 몬스터타겟;
    아이템 아이템정보;
    java4.스킬.스킬 스킬;
    java4.인벤토리.인벤토리출력 인벤토리출력 = new 인벤토리출력();

    public 사냥터(){
        this.몬스터어레이 = new ArrayList<>();
        this.몬스터머릿수 = 0;
        this.죽은몬스터수 = 0;
    }

    public void 몬스터생성() throws InterruptedException {
        this.몬스터어레이.clear();
//        this.몬스터머릿수 = rd.nextInt(9) + 1;
        this.몬스터머릿수 = rd.nextInt(9) + 2;
        System.out.println(this.몬스터머릿수 + "마리의 몬스터를 발견했다!!!");
        Thread.sleep(1000);

        for (int i = 1; i <= 몬스터머릿수; i++) {
            몬스터번호 = Integer.toString(i);
            몬스터생성난수 = Math.random();
            num = (int) Math.floor(몬스터생성난수 * 몬스터종류배열.length);
            랜덤몬스터결과 = 몬스터종류배열[num];
            if (랜덤몬스터결과.equals("슬라임")) {
                num = rd.nextInt(5) + 1;
                if (num <= 2) {
                    몬스터정보 = new 빨간슬라임(몬스터번호);
                } else {
                    몬스터정보 = new 초록슬라임(몬스터번호);
                }
            } else if (랜덤몬스터결과.equals("고블린")) {
                num = rd.nextInt(10) + 1; //1~10
                if (num <= 4) {
                    몬스터정보 = new 고블린궁수(몬스터번호);
                } else if (num <= 8) {
                    몬스터정보 = new 고블린전사(몬스터번호);
                } else {
                    몬스터정보 = new 보물고블린(몬스터번호);
                }
            } else if (랜덤몬스터결과.equals("오크")) {
                num = rd.nextInt(10) + 1; //1~10
                if(num<=4){
                    몬스터정보 = new 오크전사(몬스터번호);
                }else if(num<=8){
                    몬스터정보 = new 오크전사(몬스터번호);
                }else{
                    몬스터정보 = new 오크주술사(몬스터번호);
                }
            }
            this.몬스터어레이.add(몬스터정보);
        }
    }
    public void 보스전생성1() throws InterruptedException {
        this.몬스터어레이.clear();
//        this.몬스터머릿수 = rd.nextInt(9) + 1;
        this.몬스터머릿수 = 8;
        System.out.println("오크 로드를 토벌하러 출발합니다.");
        Thread.sleep(1500);
        System.out.println("오크 로드의 병사가 나타났습니다!");
        Thread.sleep(1500);

        몬스터정보 = new 오크주술사(Integer.toString(1));
        this.몬스터어레이.add(몬스터정보);
        몬스터정보 = new 오크주술사(Integer.toString(2));
        this.몬스터어레이.add(몬스터정보);
        몬스터정보 = new 오크전사(Integer.toString(3));
        this.몬스터어레이.add(몬스터정보);
        몬스터정보 = new 오크전사(Integer.toString(4));
        this.몬스터어레이.add(몬스터정보);
        몬스터정보 = new 오크전사(Integer.toString(5));
        this.몬스터어레이.add(몬스터정보);
        몬스터정보 = new 오크전사(Integer.toString(6));
        this.몬스터어레이.add(몬스터정보);
        몬스터정보 = new 오크전사(Integer.toString(7));
        this.몬스터어레이.add(몬스터정보);
        몬스터정보 = new 오크전사(Integer.toString(8));
        this.몬스터어레이.add(몬스터정보);
    }
    public void 보스전생성2() throws InterruptedException {
        this.몬스터어레이.clear();
//        this.몬스터머릿수 = rd.nextInt(9) + 1;
        this.몬스터머릿수 = 6;
        Thread.sleep(1000);
        System.out.println("오크 로드의 병사를 모두 물리치자,");
        Thread.sleep(1500);
        System.out.println("오크 로드가 직접 병사들을 이끌고 나타났습니다!");
        Thread.sleep(1500);

        몬스터정보 = new 오크로드("");
        this.몬스터어레이.add(몬스터정보);
        몬스터정보 = new 오크주술사(Integer.toString(1));
        this.몬스터어레이.add(몬스터정보);
        몬스터정보 = new 오크주술사(Integer.toString(2));
        this.몬스터어레이.add(몬스터정보);
        몬스터정보 = new 오크전사(Integer.toString(3));
        this.몬스터어레이.add(몬스터정보);
        몬스터정보 = new 오크전사(Integer.toString(4));
        this.몬스터어레이.add(몬스터정보);
        몬스터정보 = new 오크전사(Integer.toString(5));
        this.몬스터어레이.add(몬스터정보);
    }
    public void 몬스터삭제(boolean 몬스터삭제) throws InterruptedException, CloneNotSupportedException {
        while (몬스터삭제) {
//                    System.out.println("몬스터삭제 while문 시작");
//                    System.out.println(몬스터어레이.size());
            if(몬스터어레이.size()==0){ //몬스터어레이의 크기가 0이면 바로 나감
                몬스터삭제=false;
            }
            else{ //몬스터어레이의 크기가 0이 아니면 몬스터 삭제 시작
                for (int i = 0; i < 몬스터어레이.size(); i++) {//전체공격에 대응하기 위해 for문을 사용하여 체력이 0이 된 몬스터들을 한마리씩 찾아서 없앰
//                            System.out.println("몬스터어레이의 " + i + "번째 몬스터 이름 : " + 몬스터어레이.get(i).이름 + ", 체력 : " + 몬스터어레이.get(i).현재체력 + "어레이 길이 : " + 몬스터어레이.size());
//                                System.out.println("몬스터삭제 실행");
                    if (몬스터어레이.get(i).현재체력 <= 0) { //몬스터어레이에 체력이 0이하인 몬스터가 있으면
                        //이 아래에 몬스터가 죽었을 경우 일어나는 일을 코딩

                        //아이템 드랍 시작
                        for(int j = 0 ; j < 몬스터어레이.get(i).드랍테이블.size() ; j++){ //해당 몬스터의 드랍테이블의 사이즈만큼 반복
                            몬스터난수 = rd.nextInt(100); //0~99
//                                        System.out.println("난수 : " + 몬스터난수 + ", 드랍테이블의 드랍률 : "+몬스터어레이.get(i).드랍테이블.get(j).드랍률);
                            if(몬스터난수<몬스터어레이.get(i).드랍테이블.get(j).드랍률){ //드랍률이 10이면 0~9까지가 성공
                                System.out.println("" + 몬스터어레이.get(i).이름 + "이(가) 쓰러지며 " + 몬스터어레이.get(i).드랍테이블.get(j).아이템이름 + "을(를) 남겼다.");
                                드랍아이템 = (아이템)몬스터어레이.get(i).드랍테이블.get(j).clone(); //난수판정이 성공한 아이템과 동일한 아이템을 새로운 객체로 생성 //복제
                                드랍템.add(드랍아이템); //생성한 아이템을 드랍템 어레이에 넣음
                            }
                        }
                        //아이템 드랍 끝
                        플레이어.획득경험치=플레이어.획득경험치+경험치허브;
//                        System.out.println("사냥터.몬스터삭제| 플레이어.획득경험치 : " + 플레이어.획득경험치);
                        경험치허브 = 경험치허브 + 몬스터어레이.get(i).경험치;
                        소지금허브 = 소지금허브 + 몬스터어레이.get(i).소지금;
                        System.out.println(몬스터어레이.get(i).이름+"이(가)"+몬스터어레이.get(i).소지금+"골드를 떨어뜨렸다.");
                        System.out.println("전투 승리 시 받을 경험치가 " + 몬스터어레이.get(i).경험치 + " 늘어 " + 경험치허브 + "이(가) 되었다.");
                        Thread.sleep(1000);
                        System.out.println("");
                        몬스터어레이.remove(i); //몬스터어레이에서 몬스터를 삭제
                        죽은몬스터수 = 죽은몬스터수 + 1; //전투종료를 위해 죽은몬스터수를 늘림(근데 그냥 전투종료 조건을 몬스터어레이가 0이면으로 바꾸는 것도 고려해보기)
                        break;
                    }
                    if(i==몬스터어레이.size()-1){ //몬스터어레이에 체력이 0이하인 몬스터가 없으면
//                                System.out.println("몬스터어레이와 i의 값이 같아졌으므로 몬스터삭제를 false로 함.");
                        몬스터삭제=false;
                    }
                }
            }
//            아이템정보 = null; //다른데서 쓰던 변수를 가져온거라 밖에서 널참조를 하면 에러가 날 수도 있으니 안에서 실행(선언도 안에서하고 안에서만 사용함)
        }
    }
    public boolean 전투종료판정(ArrayList<몬스터> 몬스터어레이, boolean 보스전){
        boolean 전투승리 = false;
        if(!보스전) {//보스전이 아닐경우 살아남은 몬스터가 0마리면 전투승리를 리턴함
            if (몬스터머릿수 - 죽은몬스터수 == 0) {
//            System.out.println("this.전투종료판정 | 전투승리 : " + 전투승리);
                몬스터어레이.clear();
                몬스터머릿수 = 0;
                죽은몬스터수 = 0;
                플레이어.전투승리횟수++;
                return true;
            }
        }
        else{//보스전일경우 보스가 죽을 경우 전투승리를 리턴함
            for(int i = 0; i<몬스터어레이.size() ; i++){
                if(몬스터어레이.get(i).이름.equals("오크 로드")){//몬스터어레이에 이름이 오크 로드인 몬스터가 존재하면
//                    System.out.println("사냥터.전투종료판정 | 오크로드살아있음");
                    return false;
                }
            }
            //여기까지 왔다면 오크로드가 죽은거임
//            System.out.println("사냥터.전투종료판정 | 오크로드죽음");
            보스토벌=true;
            플레이어.전투승리횟수++;
            return true;
        }
        return 전투승리;
    }
    public void 전투정산(boolean 승리, java4.캐릭터.플레이어 플레이어) throws InterruptedException, CloneNotSupportedException { //만약 드랍템 어레이가 겹치게 바뀐다면 이것도 바꿔야함(안겹칠걸 전제로 스택이 있는 아이템들은 스택수가 1개씩 오르게 해놨음)
        ArrayList<아이템> 버린템 = new ArrayList<>();
        아이템 아이템;
        int 입력;
        Scanner sc = new Scanner(System.in);
        boolean 버림=false;
        if(승리) { //전투 승리 시에만 아이템 루팅이 가능함.
            System.out.println("전투에서 승리했습니다!");
            Thread.sleep(1000);
            재시작:
            while (true) {
//                System.out.println("정산 재시작 루프");
//                System.out.println("재시작 이후 인벤토리 크기 비교용 : " + this.소지품.size());
                if (드랍템.size() != 0) { //드랍템이 존재하면
//                    System.out.println("드랍템의 아이템이름 : "+드랍템.get(0).아이템이름 + ", 드랍템의 고유번호 : "+드랍템.get(0).고유번호);
                    for (int i = 0; i < 드랍템.size(); i++) { //드랍템의 개수만큼 반복
                        if (드랍템.get(i).고유번호 < 0) { //포션이면
                            for (int j = 0; j < 플레이어.회복물약가방.size(); j++) { //회복물약가방 사이즈만큼 반복
                                if (플레이어.회복물약가방.get(j).고유번호 == 드랍템.get(i).고유번호) {//그중에 아이템과 일치하는걸 찾아서 수치를 1올려줌
                                    System.out.println(드랍템.get(i).아이템이름 + "을(를) 획득했다!");
                                    플레이어.회복물약가방.get(j).스택수++;
                                    드랍템.remove(i);
                                    continue 재시작;
                                }
                            }
                        } else { //포션이 아니면
                            if (드랍템.get(i).스택가능여부) { //스택가능하면
                                for (int j = 0; j < 플레이어.소지품.size(); j++) { //소지품가방 사이즈만큼 반복
//                                    System.out.println("선택템의 아이템이름 : "+this.소지품.get(j).아이템이름 + ", 선택템의 고유번호 : "+this.소지품.get(j).고유번호);
                                    if (플레이어.소지품.get(j).고유번호 == 드랍템.get(i).고유번호) { //소지품창에 일치하는게 있으면 수치를 1올려줌
                                        System.out.println(드랍템.get(i).아이템이름 + "을(를) 획득했다!");
                                        플레이어.소지품.get(j).스택수++;
                                        드랍템.remove(i);
                                        continue 재시작;
                                    }
                                }
                            }
                            //여기에 도달했다는건 스택가능한 템이지만 소지품창에 일치하는게 없었다는 소리임.
                            if (플레이어.소지품.size() < 20) { //가진 소지품이 20종류 미만이면
                                아이템 = (아이템)드랍템.get(i).clone(); //복제
                                플레이어.소지품.add(아이템); //드랍템을 소지품에 추가함
                                System.out.println(드랍템.get(i).아이템이름 + "을(를) 획득했다!");
                            } else { //가진 소지품이 20종류 이상이면
                                버린템.add(드랍템.get(i)); //아이템을 버린템 어레이에 추가함
                                버림 = true;
                            }
                            드랍템.remove(i);
                            continue 재시작;
                        }
                    } //아이템드랍 for문 종료
//                    System.out.println("아이템정산(추가) 완료");
                    Thread.sleep(1000);
                } //아이템드랍 제일 밖 if문 종료
                else { //드랍템이 존재하지 않거나 정산이 끝났다면
                    if (버림) { //버린템이 존재한다면
                        for (int i = 0; i < 버린템.size(); i++) { //버린템의 개수만큼 반복
                            System.out.println("인벤토리가 부족해 " + 버린템.get(i).아이템이름 + "을(를) 들고갈 수 없다.");
                        }
                    }
                }
                Thread.sleep(1000);
                플레이어.소지금 = 플레이어.소지금+소지금허브;
                System.out.println("몬스터가 떨어뜨린 " + 소지금허브 + "골드를 주웠다!");
                break;
            } //아이템드랍 제일 밖 while문 종료
        }//승리판정 끝
        플레이어.캐릭터현재경험치 = 플레이어.캐릭터현재경험치+경험치허브;
        System.out.println("경험치가 " + 경험치허브 + " 올라 " + 플레이어.캐릭터현재경험치 + "이(가) 되었다!");
        경험치허브 = 0;
        Thread.sleep(1000);
        while(true){
//            System.out.println("경험치 while문 시작");
            if(플레이어.캐릭터현재경험치>=플레이어.캐릭터최대경험치){ //현재경험치가 최대경험치보다 많을경우
                플레이어.레벨업();
                System.out.print("" +
                        "계속하려면 아무 숫자나 입력하세요." +
                        "\n→");
                입력 = sc.nextInt();
            }
            else{
                break;
            }
        }
        플레이어.최종능력치적용();
    }
}
