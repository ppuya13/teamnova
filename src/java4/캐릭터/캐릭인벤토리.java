package java4.캐릭터;

import java4.아이템.소모.소모아이템;
import java4.아이템.소모.지속형.*;
import java4.아이템.소모.회복형.*;
import java4.아이템.아이템;

public abstract class 캐릭인벤토리 extends 능력치 {

    public void 인벤토리초기화 () { //프로그램 시작 시 가방에 물약을 넣어주는 일회성 메소드
        체력물약 체력물약 = new 체력물약("체력물약");
        체력물약.스택수 = 300;
        마나물약 마나물약 = new 마나물약("마나물약");
        마나물약.스택수 = 300;
        this.회복물약가방.add(체력물약);
        this.회복물약가방.add(마나물약);

//        //이 아래로는 테스트용 아이템생성. 나중에 지우기
        아이템 아이템;
        아이템 = new 공격력물약("공격력물약");
        아이템.스택수=1000;
        this.소지품.add(아이템);
        아이템 = new 방어력물약("방어력물약");
        아이템.스택수=1000;
        this.소지품.add(아이템);
//        아이템 = new 아이템(300);
//        아이템.스택수=1000;
//        this.소지품.add(아이템);
//        아이템= new 아이템(200);
//        아이템.스택수=1000;
//        this.소지품.add(아이템);
//        아이템= new 아이템(201);
//        아이템.스택수=1000;
//        this.소지품.add(아이템);
//
//        아이템 검 = new 아이템(100);
//        아이템 방패 = new 아이템(101);
//        아이템 갑옷 = new 아이템(102);
//        this.소지품.add(검);
//        this.소지품.add(방패);
//        this.소지품.add(갑옷);
//        System.out.println("첫번째검 : " + this.소지품.get(1).착용여부 + ", 두번째검 : " + this. 소지품. get(2).착용여부);
//        //더미아이템 20개 생성
//        for (int i = 0; i <= 14; i++) { //0부터 14까지 총 15번 반복
//            this.소지품.add(아이템);
//        }//더미아이템 15개를 캐릭터의 소지품에 넣음
    }

    public int 아이템사용(int 입력) throws InterruptedException {
        int 물약여부;
        int 사용선택;
        아이템 아이템정보;
        int 회복물약가방크기= this.회복물약가방.size();
        if(입력 <=회복물약가방크기){ //회복물약 내용물을 선택했다면
            사용선택= 입력 -1;
            물약여부=1;
            아이템정보 = this.회복물약가방.get(사용선택);
            if(아이템정보.스택수==0){ //선택한 물약의 스택수가 0개라면
//                            System.out.println("스택수0개");
                System.out.println("\n"+아이템정보.아이템이름+"이 부족합니다.");
                Thread.sleep(1000);
//                            세부2=1;
                물약여부=0;
                사용선택=-1;
            } //회복물약 이외의 아이템들은 0개가 되는 순간 인벤정리 메소드에 의해 삭제됨.
        }
        else{ //회복물약가방 내용물이 아닌것을 선택했다면
            사용선택 = 입력 -(회복물약가방크기+1);
            아이템정보 = this.소지품.get(사용선택);
            if(아이템정보.사용가능여부) { //사용가능한 물건이라면
                물약여부=2;
            }
            else{ // 사용 불가능한 물건이라면
                System.out.println("\n사용할 수 없는 아이템입니다.");
                Thread.sleep(1000);
                물약여부=0;
            }
        }
        return 물약여부;
    }

    public 아이템 아이템사용2(int 입력){
        아이템 타겟;
        int 회복물약가방크기= this.회복물약가방.size();
        if(입력 <=회복물약가방크기){ //회복물약 내용물을 선택했다면
            타겟= this.회복물약가방.get(입력 -1);
        }

        else{ //회복물약가방 내용물이 아닌것을 선택했다면
            타겟 = this.소지품.get(입력 -(회복물약가방크기+1));
        }
        return 타겟;
    }

    public void 인벤정리(){
        for(int i = 0; i<=this.소지품.size()-1 ; i++){
            if(this.소지품.get(i).스택수 == 0){
//                System.out.println(this.소지품.size()-1);
                this.소지품.remove(i);
                break;
            }
        }
    }

    public boolean 전투외아이템사용(int 물약여부, 아이템 타겟) throws InterruptedException {
        boolean 반복=true;
        if(물약여부==1){ //물약이면
            타겟.물약사용((캐릭터) this);
            반복 = false;
        }
        else if(물약여부==2){
            System.out.println("\n소모 아이템은 전투중에만 사용할 수 있습니다.");
            Thread.sleep(1000);
            반복 = true;
        }
        System.out.println(반복);
        return 반복;
    }

//    public void 전투아이템사용(int 물약여부, 아이템 타겟) throws InterruptedException{
//
//        if(물약여부==0){
//        }
//        else if(물약여부==1){ //물약이면
//            타겟.물약사용((캐릭터) this);
//        }
//        else{ //
//            타겟.지속템사용((캐릭터) this);
//        }
//    }

    public int 아이템버리기(int 입력) throws InterruptedException {
        int 물약여부=2; //1:물약이거나 버릴수없음, 2:물약아님
        int 회복물약가방크기= this.회복물약가방.size();
        int 사용선택;
        아이템 아이템정보;
        if (입력 <= 회복물약가방크기) { //회복물약 내용물을 선택했다면
            System.out.println("\n회복물약은 버릴 수 없습니다.");
            Thread.sleep(1000);
            물약여부 = 1;
        } else { //회복물약가방 내용물이 아닌것을 선택했다면
            사용선택 = 입력 - (회복물약가방크기 + 1);
            아이템정보 = this.소지품.get(사용선택);
            if (아이템정보.착용여부) { //착용중이라면
                System.out.println("\n우선 장착을 해제해주세요.");
                Thread.sleep(1000);
                물약여부 = 1;
            }
        }
        return 물약여부;
    }

    public int 아이템버리기2(int 물약여부, int 입력) throws InterruptedException {
        int 개수 = 1;
        boolean 진행 = true;
        if(물약여부 == 2) {//물약도 아니고 장착중도 아닐경우
            아이템 타겟 = this.소지품.get(입력-(this.회복물약가방.size() + 1));
            if (타겟.스택가능여부) {//스택가능이면
                while (true) {
                    System.out.print("" +
                            "\n버릴 개수를 입력해주세요. (0개: 취소)" +
                            "\n→");
                    입력 = sc.nextInt();
                    if (입력 == 0) { //버릴 개수를 0개로 입력한다면
                        개수 = 0;
                        break;
                    } else if (입력 >= 1 && 입력 <= 타겟.스택수) { //버릴 개수를 1이상, 스택수 이하로 입력했다면
                        개수 = 입력;
                        break;
                    } else if (입력 > 타겟.스택수) { //버릴 개수를 스택수 보다 많게 입력했다면
                        System.out.println("" +
                                "\n가진 양보다 많은 양을 버릴 수는 없습니다.");
                        Thread.sleep(1000);
                        개수 = 0;
                        break;
                    }
                }
                if (개수 > 0) { //개수가 0보다 많다면 선택한 아이템을 선택한 만큼 버릴건지 최종 확인
                    while (true) { // 0과 1 이외의 숫자를 입력할 경우 무한루프함
                        System.out.println("" +
                                "\n정말 " + 타겟.아이템이름 + " " + 개수 + " 개를 버리겠습니까?" +
                                "\n0.취소한다." +
                                "\n1.버린다.");
                        입력 = sc.nextInt();
                        if (입력 == 0) {
                            개수 = 0;
                            break;
                        } else if (입력 == 1) {
                            break;
                        }
                    }
                }
            } else { //스택이 불가능하다면
                개수 = 1;
                while (true) { // 0과 1 이외의 숫자를 입력할 경우 무한루프함
                    System.out.println("" +
                            "\n정말 " + 타겟.아이템이름 + "을(를) 버리겠습니까?" +
                            "\n0.취소한다." +
                            "\n1.버린다.");
                    입력 = sc.nextInt();
                    if (입력 == 0) {
                        개수 = 0;
                        break;
                    } else if (입력 == 1) {
                        break;
                    }
                }
            }
        }else{ //물약여부가 1이면
            개수=0;
        }
        return 개수;
    }

    public void 아이템버리기실행(int 개수, int 입력) throws InterruptedException {
//        System.out.println("버리기전 아이템.스택수 : "+ 아이템.스택수 + ", 개수 : "+개수);
        if (개수 != 0) {
            아이템 아이템 = this.소지품.get(입력-(this.회복물약가방.size() + 1));
            if(개수>1) {
                System.out.println(아이템.아이템이름 + "을 " + 개수 + "개 버립니다.");
            }
            else if(개수==1){
                System.out.println(아이템.아이템이름 + "을 버립니다.");
            }
            Thread.sleep(1000);
            아이템.스택수 = 아이템.스택수-개수;
        }
//        System.out.println("버린후 아이템.스택수 : "+ 아이템.스택수 + ", 개수 : "+개수);
    }

//    public void 아이템장착(아이템 타겟) throws InterruptedException {
//        int 인벤토리크기=this.소지품.size()-1;
//        boolean 속행=true;
//        if(타겟.착용여부){//착용중이면
//            타겟.착용여부=false;
//            System.out.println("\n"+타겟.아이템이름+"을(를) 착용 해제했습니다.");
//            Thread.sleep(1000);
//        }
//        else { //착용중이 아니면
//            for(int i=0 ; i <= 인벤토리크기 ; i++){
//                if(this.소지품.get(i).장비부위==타겟.장비부위 && this.소지품.get(i).착용여부){ //인벤토리에 장비부위가 같고 착용중인 아이템이 있으면
//                    System.out.println("\n같은 부위의 착용중인 아이템을 우선 착용 해제하세요.");
//                    Thread.sleep(1000);
//                    속행=false;
//                    break;
//                }
//            }
//            if(속행){ //속행이 true면(장비부위가 같고 착용중인 아이템이 없으면)
//                타겟.착용여부=true;
//                System.out.println("\n"+타겟.아이템이름+"을(를) 착용했습니다.");
//                Thread.sleep(1000);
//            }
//        }
//    }


}
