package java4.캐릭터;


import java4.몬스터;
import java4.스킬.강타;
import java4.스킬.스킬;
import java4.스킬.휩쓸기;
import java4.아이템;
import java4.출력.상점;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class 캐릭터 { //캐릭터의 능력치나 소지품에 영향을 미치는 메소드는 이곳에

    public ArrayList<아이템> 회복물약가방;
    public ArrayList<아이템> 소지품;
    public ArrayList<아이템> 강화목록;
    public ArrayList<아이템> 드랍템;
    public ArrayList<아이템> 사용중;
    public ArrayList<스킬> 스킬목록;
    public int 획득경험치;
    public int 소지금;
    public int 캐릭터레벨;
    public int 캐릭터최대경험치;
    public int 캐릭터현재경험치;
    public int 캐릭터최종체력;
    public int 캐릭터최대체력;
    public int 캐릭터추가체력;
    public int 레벨업추가체력;
    public int 캐릭터현재체력;
    public int 캐릭터최종마나;
    public int 캐릭터최대마나;
    public int 캐릭터추가마나;
    public int 레벨업추가마나;
    public int 캐릭터현재마나;
    public int 캐릭터최종공격력;
    public int 캐릭터공격력;
    public int 캐릭터추가공격력;
    public int 레벨업추가공격력;
    public int 소모품추가공격력;
    public int 캐릭터최종방어력;
    public int 캐릭터방어력;
    public int 캐릭터추가방어력;
    public int 레벨업추가방어력;
    public int 소모품추가방어력;
    public int 캐릭터최종치확;
    public int 캐릭터치명확률;
    public int 캐릭터추가치확;
    public int 레벨업추가치확;
    public int 캐릭터최종치피;
    public int 캐릭터치명피해;
    public int 캐릭터추가치피;
    public int 레벨업추가치피;
    public int 캐릭터최종회피;
    public int 캐릭터회피;
    public int 캐릭터추가회피;

    Random rd = new Random();
    int 정수강화;
    //    double 실수강화;
    boolean 치명타=false;

    Scanner sc = new Scanner(System.in);
    int 구매개수=0;
    int 입력 = 0;




    public 캐릭터()
    {
        this.캐릭터레벨 = 1;
        this.캐릭터최대경험치 = 100;
        this.캐릭터현재경험치 = 0;
        this.캐릭터최대체력 = 1000;
        this.캐릭터최종체력 = this.캐릭터최대체력;
        this.캐릭터현재체력 = this.캐릭터최대체력;
        this.캐릭터최대마나 = 100;
        this.캐릭터최종마나 = this.캐릭터최대마나;
        this.캐릭터현재마나 = this.캐릭터최대마나;
        this.캐릭터공격력 = 300;
        this.캐릭터최종공격력=30;
        this.캐릭터방어력 = 10;
        this.캐릭터최종방어력=0;
        this.캐릭터치명확률 = 20;
        this.캐릭터최종치확 = 20;
        this.캐릭터치명피해 = 150;
        this.캐릭터최종치피 = 150;
        this.캐릭터회피 = 10;
        this.소지금=1000;
        this.회복물약가방 = new ArrayList<>();
        this.소지품 = new ArrayList<>();
        this.강화목록 = new ArrayList<>();
        this.드랍템 = new ArrayList<>();
        this.사용중 = new ArrayList<>();
        this.스킬목록 = new ArrayList<>();
    }


    public void 인벤토리초기화 (){
        아이템 체력물약 = new 아이템(-1);
        체력물약.스택수=3;
        아이템 마나물약 = new 아이템(-2);
        마나물약.스택수=3;
        this.회복물약가방.add(체력물약);
        this.회복물약가방.add(마나물약);

//        //이 아래로는 테스트용 아이템생성. 나중에 지우기
        아이템 아이템;
        아이템 = new 아이템(300);
        아이템.스택수=1000;
        this.소지품.add(아이템);
        아이템= new 아이템(200);
        아이템.스택수=1000;
        this.소지품.add(아이템);
        아이템= new 아이템(201);
        아이템.스택수=1000;
        this.소지품.add(아이템);
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
    public void 스킬초기화(){
        스킬 스킬 = new 강타();
        this.스킬목록.add(스킬);
        스킬 = new 휩쓸기();
        this.스킬목록.add(스킬);
    }
    public void 강화리스트생성(){
//        System.out.println("강화리스트생성");
        this.강화목록.clear();
        for(int i=0 ; i<=this.소지품.size()-1 ; i++){
            if(this.소지품.get(i).착용가능여부){ //착용가능하면(현재는 착용가능한템이 전부 강화가 가능함)
                this.강화목록.add(this.소지품.get(i));
            }
        }
    }


    public void 상점구매(int 타겟, 상점 상점, int 스택가능, int 구매개수) throws InterruptedException {
        boolean 구매진행=true;
        아이템 구매;
        String 상점구매결과="";
        구매 = new 아이템(상점.리스트.get(타겟-1).고유번호); // 선택한 아이템을 객체로 새로 생성한다.
        if(스택가능==1){ //선택한 타겟이 스택가능이면
            if(구매개수>=1 && 구매진행) {
                System.out.print(구매.아이템이름 + "을 " + 구매개수 + "개 구매하시겠습니까?" +
                        "\n(총 " +(구매.구매가격*구매개수)+"골드)" +
                        "\n1.구매한다" +
                        "\n2.취소한다"+
                        "\n→");
                입력=sc.nextInt();
            }//구매갯수만큼 구매가격을 띄워주고 진짜 구매할건지 물은 뒤 입력받음.
            else{
                System.out.println("취소합니다.");
                Thread.sleep(1000);
                상점구매결과="구매취소함";
                구매진행=false;
            }
            if(입력==1 &&구매진행 && (타겟==1 || 타겟==2)){//진짜구매한다고 했을때(인벤토리안에 고유번호가 같은 아이템이 존재하는지 확인)(체력물약과 마나물약은 같은 아이템이 항상 존재하므로 따로 확인 안하게 하기)
                //타겟이 체력물약이거나 마나물약일 경우
                if(this.소지금>=구매.구매가격*구매개수 && 구매진행){//소지금이 구매금액 이상인지 확인
                    //이상이면
                    for(int i=0;i<=this.회복물약가방.size()-1;i++) { //회복물약가방의 내용물 갯수만큼 반복
                        if(this.회복물약가방.get(i).고유번호==구매.고유번호){ //회복물약가방의 i번째 아이템의 고유번호가 타겟의 고유번호와 같으면
                            this.회복물약가방.get(i).스택수 = this.회복물약가방.get(i).스택수+구매개수; //회복물약가방의 i번째 아이템의 스택수를 구매개수만큼 늘린다.
                            this.소지금=this.소지금-(구매.구매가격*구매개수); // 소지금을 구매가격만큼 차감한다.
                            구매진행=false;
                            System.out.println("구매에 성공했습니다.");
                            Thread.sleep(1000);
                        }
                    } //for문끝
                }
                else if(this.소지금<구매.구매가격*구매개수 && 구매진행){//소지금이 구매금액보다 적으면
                    System.out.println("소지금이 부족합니다.");
                    Thread.sleep(1000);
                    상점구매결과="돈모자름";
                    구매진행=false;
                }
            }//타겟이 체력물약이거나 마나물약일경우 끝
            //타겟이 물약이 아닐경우
            else if(입력==1 && 구매진행 && 타겟>=3){
                //타겟이 체력물약, 마나물약이 아닌경우
                if(this.소지금>=구매.구매가격*구매개수 &&구매진행) { //소지금이 구매금액 이상인지 확인
                    //이상이면
                    for (int i = 0; i <= this.소지품.size() - 1; i++) { //소지품의 내용물 갯수만큼 반복
                        if (this.소지품.get(i).고유번호 == 구매.고유번호) { //소지품의 i번째 아이템의 고유번호가 타겟의 고유번호와 같으면(같은 아이템이 존재하면)
                            this.소지품.get(i).스택수 = this.소지품.get(i).스택수+구매개수; //소지품방의 i번째 아이템의 스택수를 구매개수만큼 늘린다.
                            this.소지금=this.소지금-(구매.구매가격*구매개수);// 소지금을 구매가격만큼 차감한다.
                            System.out.println("구매에 성공했습니다.");
                            Thread.sleep(1000);
                            구매진행=false;
                            break; //스택 늘린 뒤에 for문 나감
                        }
                    }
                    //if문 다돌았는데도 구매진행이 true이면 (고유번호와 같은 아이템이 존재하지 않는다면)
                    if(구매진행==true){
                        if(this.소지품.size()>=20){ //또한 소지품의 개수가 20개 이상이라면
//                            System.out.println("this.소지품.size() = "+this.소지품.size());
                            System.out.println("인벤토리 공간이 부족합니다.");
                            Thread.sleep(1000);
                            구매진행=false;
                        }
                        else{ //소지품의 개수가 19개 이하라면
                            구매.스택수=구매개수; //
                            this.소지품.add(구매); // 상점에서 선택한 아이템을 소지품의 제일 뒤에 추가한다.
                            this.소지금=this.소지금-구매.구매가격*구매개수;// 소지금을 구매가격만큼 차감한다.
                            System.out.println("구매에 성공했습니다.");
                            Thread.sleep(1000);
                            상점구매결과="구매완료";
                            구매진행=false;
                        }
                    }
                }
                else if(this.소지금<구매.구매가격*구매개수 &&구매진행){ // 소지금이 구매금액보다 적다면
                    System.out.println("소지금이 부족합니다.");
                    Thread.sleep(1000);
                    상점구매결과="돈모자름";
                    구매진행=false;
                }
            }
        }
        else if(스택가능==2){ //스택불가능 아이템이면
            if(this.소지금>=구매.구매가격 &&구매진행) { //소지금이 구매금액 이상인지 확인
                //이상이면
                if(this.소지품.size()>=20){ //또한 소지품의 개수가 20개 이상이라면
//                    System.out.println("this.소지품.size() = "+this.소지품.size());
                    System.out.println("인벤토리 공간이 부족합니다.");
                    Thread.sleep(1000);
                }
                else{ //소지품의 개수가 19개 이하라면
                    this.소지품.add(구매); // 상점에서 선택한 아이템을 소지품의 제일 뒤에 추가한다.
                    this.소지금=this.소지금-(구매.구매가격);// 소지금을 구매가격만큼 차감한다.
                    System.out.println("구매에 성공했습니다.");
                    Thread.sleep(1000);
                    상점구매결과="구매완료";
                }
                구매진행=false;
            }
            else if(this.소지금<구매.구매가격 && 구매진행){//소지금이 구매금액보다 적으면
                System.out.println("소지금이 부족합니다.");
                Thread.sleep(1000);
                상점구매결과="돈모자름";
                구매진행=false;
            }
        }//구매 메소드 완성.
    }
    public void 상점판매(int 타겟,int 스택가능, int 판매개수, int 물약여부) throws InterruptedException {
        String 상점판매결과="";
        if(물약여부 == 1){ //물약이면
            this.회복물약가방.get(타겟-1).스택수=this.회복물약가방.get(타겟-1).스택수-판매개수;
            this.소지금=this.소지금+(this.회복물약가방.get(타겟-1).판매가격*판매개수);
            System.out.println(this.회복물약가방.get(타겟-1).아이템이름+"을(를) "+
                    판매개수+"개 판매하여 "+(this.회복물약가방.get(타겟-1).판매가격*판매개수) +
                    "골드를 받았습니다.");
            Thread.sleep(1000);
        }
        else if(스택가능==1) {//물약이 아니고 스택가능하면
            this.소지품.get(타겟-3).스택수=this.소지품.get(타겟-3).스택수-판매개수;
            this.소지금=this.소지금+(this.소지품.get(타겟-3).판매가격*판매개수);
            System.out.println(this.소지품.get(타겟-3).아이템이름+"을(를) "+
                    판매개수+"개 판매하여 "+(this.소지품.get(타겟-3).판매가격*판매개수) +
                    "골드를 받았습니다.");
            Thread.sleep(1000);
        }
        else if(스택가능==2) { //물약이 아니고 스택불가능이면
            if(!this.소지품.get(타겟-3).착용여부) { //착용중이 아니면
                this.소지품.get(타겟 - 3).스택수 = 0;
                this.소지금 = this.소지금 + this.소지품.get(타겟 - 3).판매가격;
                System.out.println(this.소지품.get(타겟 - 3).아이템이름 + "을(를) 판매하여 " +
                        this.소지품.get(타겟 - 3).판매가격 + "골드를 받았습니다.");
                Thread.sleep(1000);
            }
            else{
                System.out.println("착용 중인 아이템은 판매할 수 없습니다.");
                Thread.sleep(1000);
            }
        }
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
                if(아이템정보.착용가능여부){ //착용가능하면
                    System.out.println("전투중엔 아이템 장비/해제가 불가능합니다.");
                    Thread.sleep(1000);
                    물약여부=0;
                    사용선택=-1;
                }
                else {
                    물약여부 = 2;
                }
            }
            else{ // 사용 불가능한 물건이라면
                System.out.println("\n사용할 수 없는 아이템입니다.");
                Thread.sleep(1000);
                물약여부=0;
                사용선택=-1;
            }
        }
        return 물약여부;
    }
    public int 아이템사용2(int 입력){
        int 사용선택;
        int 회복물약가방크기= this.회복물약가방.size();
        if(입력 <=회복물약가방크기){ //회복물약 내용물을 선택했다면
            사용선택= 입력 -1;
        }

        else{ //회복물약가방 내용물이 아닌것을 선택했다면
            사용선택 = 입력 -(회복물약가방크기+1);
        }
        return 사용선택;
    }
    public boolean 전투외아이템사용(int 물약여부, int 사용선택) throws InterruptedException {
        아이템 타겟;
        boolean 반복=true;
        if(물약여부==1){ //물약이면
            타겟=this.회복물약가방.get(사용선택);
            타겟.물약사용(this);
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
    public void 전투아이템사용(int 물약여부, int 사용선택) throws InterruptedException{
        if(물약여부==0){
        }
        else if(물약여부==1){ //물약이면
            아이템 타겟=this.회복물약가방.get(사용선택);;
            타겟.물약사용(this);
        }
        else{ //
            아이템 타겟=this.소지품.get(사용선택);;
            타겟.소모템사용(this);
        }
    }

    public int 아이템버리기(int 입력) throws InterruptedException {
        boolean 아이템버리기=true;
        int 물약여부=1; //1:물약이거나 버릴수없음, 2:물약아님
        int 인벤토리크기= this.소지품.size();
        int 회복물약가방크기= this.회복물약가방.size();
        int 사용선택;
        int 개수;
        아이템 아이템정보;
        if (입력 <= 회복물약가방크기) { //회복물약 내용물을 선택했다면
            System.out.println("\n회복물약은 버릴 수 없습니다.");
            Thread.sleep(1000);
            아이템버리기 = false;
            물약여부 = 1;
        } else { //회복물약가방 내용물이 아닌것을 선택했다면
            사용선택 = 입력 - (회복물약가방크기 + 1);
            아이템정보 = this.소지품.get(사용선택);
            사용선택 = -1;
            if (아이템정보.착용여부) { //착용중이라면
                System.out.println("\n우선 장착을 해제해주세요.");
                아이템버리기 = false;
                Thread.sleep(1000);
                물약여부 = 1;
            } else if (아이템정보.스택가능여부) { //스택이 가능하다면
                while (true) {
                    System.out.print("" +
                            "\n버릴 개수를 입력해주세요. (0개: 취소)" +
                            "\n→");
                    입력 = sc.nextInt();
                    if (입력 == 0) { //버릴 개수를 0개로 입력한다면
                        아이템버리기 = false;
                        break;
                    } else if (입력 >= 1 && 입력 <= 아이템정보.스택수) { //버릴 개수를 1이상, 스택수 이하로 입력했다면
                        개수 = 입력;
                        break;
                    } else if (입력 > 아이템정보.스택수) { //버릴 개수를 스택수 보다 많게 입력했다면
                        System.out.println("" +
                                "\n가진 양보다 많은 양을 버릴 수는 없습니다.");
                        Thread.sleep(1000);
                        아이템버리기 = false;
                        break;
                    }
                }
                if (아이템버리기) { //선택한 아이템을 선택한 만큼 버릴건지 최종 확인
                    while (true) { // 0과 1 이외의 숫자를 입력할 경우 무한루프함
                        System.out.println("" +
                                "\n정말 " + 아이템정보.아이템이름 + " " + 개수 + " 개를 버리겠습니까?" +
                                "\n0.취소한다." +
                                "\n1.버린다.");
                        입력 = sc.nextInt();
                        if (입력 == 0) {
                            아이템버리기 = false;
                            break;
                        } else if (입력 == 1) {
                            break;
                        }
                    }
                }
            }
        }
        return 물약여부;
    }
    /////////////////////////
    public boolean 아이템버리기0(int 입력) throws InterruptedException {
        int 인벤토리크기= this.소지품.size();
        int 회복물약가방크기= this.회복물약가방.size();
        int 전체가방크기=인벤토리크기+회복물약가방크기;
        int 사용선택;
        boolean 아이템버리기 = false; //아이템 버리기 스크립트 실행용
        if (입력 <= 회복물약가방크기) { //회복물약 내용물을 선택했다면
            System.out.println("\n회복물약은 버릴 수 없습니다.");
            Thread.sleep(1000);
            아이템버리기 = false;
            사용선택 = -1;
        } else { //회복물약가방 내용물이 아닌것을 선택했다면
            사용선택 = 입력 - (회복물약가방크기 + 1);
            아이템정보 = 캐릭터.소지품.get(사용선택);
            사용선택 = -1;
            if (아이템정보.착용여부) { //착용중이라면
                System.out.println("\n우선 장착을 해제해주세요.");
                아이템버리기 = false;
                Thread.sleep(1000);
                물약여부 = 0;
            } else if (아이템정보.스택가능여부) { //스택이 가능하다면
                while (true) {
                    System.out.print("" +
                            "\n버릴 개수를 입력해주세요. (0개: 취소)" +
                            "\n→");
                    입력 = sc.nextInt();
                    if (입력 == 0) { //버릴 개수를 0개로 입력한다면
                        아이템버리기 = false;
                        break;
                    } else if (입력 >= 1 && 입력 <= 아이템정보.스택수) { //버릴 개수를 1이상, 스택수 이하로 입력했다면
                        개수 = 입력;
                        break;
                    } else if (입력 > 아이템정보.스택수) { //버릴 개수를 스택수 보다 많게 입력했다면
                        System.out.println("" +
                                "\n가진 양보다 많은 양을 버릴 수는 없습니다.");
                        Thread.sleep(1000);
                        아이템버리기 = false;
                        break;
                    }
                }
                if (아이템버리기) { //선택한 아이템을 선택한 만큼 버릴건지 최종 확인
                    while (true) { // 0과 1 이외의 숫자를 입력할 경우 무한루프함
                        System.out.println("" +
                                "\n정말 " + 아이템정보.아이템이름 + " " + 개수 + " 개를 버리겠습니까?" +
                                "\n0.취소한다." +
                                "\n1.버린다.");
                        입력 = sc.nextInt();
                        if (입력 == 0) {
                            아이템버리기 = false;
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
                            "\n정말 " + 아이템정보.아이템이름 + "을(를) 버리겠습니까?" +
                            "\n0.취소한다." +
                            "\n1.버린다.");
                    입력 = sc.nextInt();
                    if (입력 == 0) {
                        아이템버리기 = false;
                        break;
                    } else if (입력 == 1) {
                        break;
                    }
                }
            }
//            a = -1;
        }
        return 아이템버리기;
    }
    public void 아이템버리기실행(int 개수, 아이템 아이템) throws InterruptedException {
//        System.out.println("버리기전 아이템.스택수 : "+ 아이템.스택수 + ", 개수 : "+개수);
        if(개수>1) {
            System.out.println(아이템.아이템이름 + "을 " + 개수 + "개 버립니다.");
        }
        else{
            System.out.println(아이템.아이템이름 + "을 버립니다.");
        }
        Thread.sleep(1000);
        아이템.스택수 = 아이템.스택수-개수;
//        System.out.println("버린후 아이템.스택수 : "+ 아이템.스택수 + ", 개수 : "+개수);
    }
    public void 아이템장착(int 사용선택) throws InterruptedException {
        아이템 타겟 = this.소지품.get(사용선택);
        int 인벤토리크기=this.소지품.size()-1;
        boolean 속행=true;
        if(타겟.착용여부){//착용중이면
            타겟.착용여부=false;
            System.out.println("\n"+타겟.아이템이름+"을(를) 착용 해제했습니다.");
            Thread.sleep(1000);
        }
        else { //착용중이 아니면
            for(int i=0 ; i <= 인벤토리크기 ; i++){
                if(this.소지품.get(i).장비부위==타겟.장비부위 && this.소지품.get(i).착용여부){ //인벤토리에 장비부위가 같고 착용중인 아이템이 있으면
                    System.out.println("\n같은 부위의 착용중인 아이템을 우선 착용 해제하세요.");
                    Thread.sleep(1000);
                    속행=false;
                    break;
                }
            }
            if(속행){ //속행이 true면(장비부위가 같고 착용중인 아이템이 없으면)
                타겟.착용여부=true;
                System.out.println("\n"+타겟.아이템이름+"을(를) 착용했습니다.");
                Thread.sleep(1000);
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
        this.소지금=this.소지금-100;
        아이템.아이템이름="+" + 아이템.강화 + " " + 아이템.임시이름;
        Thread.sleep(1000);
//        System.out.println("아이템 강화수치 : " + 아이템.강화 + ", 강화수치 + 이름 : " +아이템.아이템이름);
    }

    public void 능력치적용(){
        this.장비능력치적용();
        this.최종능력치적용();
    }
    public void 장비능력치적용(){
        this.캐릭터추가체력=0;
        this.캐릭터추가마나=0;
        this.캐릭터추가공격력=0;
        this.캐릭터추가방어력=0;
        this.캐릭터추가치확=0;
        this.캐릭터추가치피=0;
        this.캐릭터추가회피=0;
        ArrayList<아이템> 소지품 = this.소지품;
        아이템 타겟;
        for(int i=0 ; i<=소지품.size()-1 ; i++){
            타겟 = 소지품.get(i);
            if(타겟.착용여부){ //i번째 장비템이 착용중이면
                this.캐릭터추가체력=this.캐릭터추가체력+타겟.기본체력+타겟.추가체력;
//                System.out.println("추가체력적용 "+this.캐릭터추가체력);
                this.캐릭터추가마나=this.캐릭터추가마나+타겟.기본마나+타겟.추가마나;
//                System.out.println("추가마나적용 "+this.캐릭터추가마나);
                this.캐릭터추가공격력=this.캐릭터추가공격력+타겟.기본공격력+타겟.추가공격력;
//                System.out.println("추가공격적용 "+this.캐릭터추가공격력);
                this.캐릭터추가방어력= this.캐릭터추가방어력+타겟.기본방어력+타겟.추가방어력;
//                System.out.println("추가방어적용 "+this.캐릭터추가방어력);
                this.캐릭터추가치확=this.캐릭터추가치확+타겟.기본치확+타겟.추가치확;
//                System.out.println("추가치확적용 "+this.캐릭터추가치확);
                this.캐릭터추가치피=this.캐릭터추가치피+타겟.기본치피+타겟.추가치피;
//                System.out.println("추가치피적용 "+this.캐릭터추가치피);
                this.캐릭터추가회피=this.캐릭터추가회피+타겟.추가회피; //기본회피를 제공하는 아이템이 현재 없음.
            }
        }
    }
    public void 소모템적용(){
//        System.out.println("능력치.소모템적용 | 소모템적용 시작");
        this.소모품추가공격력=0;
        this.소모품추가방어력=0;
        아이템 타겟;
        재시작:
        while (true) {//지속시간이 0인 아이템 전부 삭제
            if(this.사용중.size()>=1) {
                for (int i = 0; i < this.사용중.size(); i++) {
                    타겟 = this.사용중.get(i);
                    if (타겟.지속시간 == 0) {
                        this.사용중.remove(i);
                        System.out.printf("지속시간 0인 아이템 있음(" + 타겟.아이템이름 + ")");
                        continue 재시작;
                    }
                }
            }
//            System.out.printf("지속시간 0인 아이템 없음");
            break;
        }
        //소모품 어레이에 남은 아이템들은 모두 지속시간이 1이상인 아이템
        if(this.사용중.size()>=1) { //남은 아이템이 있다면
            for (int i = 0; i < this.사용중.size(); i++) {
                타겟 = this.사용중.get(i);
                if (타겟.고유번호 == 200) { //공격력물약을 발견했다면
//                    System.out.println("능력치.소모템적용 | 공격력물약 적용");
                    this.소모품추가공격력=this.소모품추가공격력+타겟.추가능력치;
                }
                else if (타겟.고유번호 == 201) { //방어력물약을 발견했다면
//                    System.out.println("능력치.소모템적용 | 방어력물약 적용");
                    this.소모품추가방어력=this.소모품추가방어력+타겟.추가능력치;
                }
                타겟.지속시간--;
//                System.out.println("능력치.소모템적용 | 지속시간감소후 " + 타겟.지속시간);
            }
        }
    }
    public void 최종능력치적용(){
        this.캐릭터최종체력=1000+this.캐릭터추가체력+this.레벨업추가체력;
        this.캐릭터최종마나=100+this.캐릭터추가마나+this.레벨업추가마나;
        this.캐릭터최종공격력=this.캐릭터공격력+this.캐릭터추가공격력+this.레벨업추가공격력+this.소모품추가공격력;
        this.캐릭터최종방어력=this.캐릭터방어력+this.캐릭터추가방어력+this.레벨업추가방어력+this.소모품추가방어력;
        this.캐릭터최종치확=this.캐릭터치명확률+this.캐릭터추가치확+this.레벨업추가치확;
        this.캐릭터최종치피=this.캐릭터치명피해+this.캐릭터추가치피+this.레벨업추가치피;
        this.캐릭터최종회피=this.캐릭터회피+this.캐릭터추가회피;
        if(this.캐릭터최종체력<캐릭터현재체력){//최종체력보다 현재체력이 클경우
            this.캐릭터현재체력=this.캐릭터최종체력;
        }
        if(this.캐릭터최종마나<캐릭터현재마나){//최종마나보다 현재마나가 클경우
            this.캐릭터현재마나=this.캐릭터최종마나;
        }
    }
    public void 레벨업() throws InterruptedException {
        System.out.println("\n레벨업!");
        this.캐릭터레벨++;
        System.out.println("레벨이 "+this.캐릭터레벨 + "이(가) 되었다!");
        this.캐릭터현재경험치 = this.캐릭터현재경험치 -this.캐릭터최대경험치;
        this.캐릭터최대경험치 = this.캐릭터최대경험치 + 100;
        Thread.sleep(1000);
        int 랜덤값;
        int 상승횟수=0;
        while(상승횟수 <= 4){
            랜덤값 = rd.nextInt(50); //0~9체력 | 10~19마나 | 20~29공격력 | 30~39방어력 | 40~49치피
            if(랜덤값<=9){ //0~9체력
                정수강화=rd.nextInt(11)+20; //20~30 상승
                System.out.println("체력이 "+정수강화+" 만큼 성장했다!");
                this.레벨업추가체력=this.레벨업추가체력+정수강화;
                상승횟수++;
                Thread.sleep(200);
            }
            else if(랜덤값<=19){ //10~19마나
                정수강화=rd.nextInt(6)+5;
                System.out.println("마나가 "+정수강화+" 만큼 성장했다!");
                this.레벨업추가마나=this.레벨업추가마나+정수강화;
                상승횟수++;
                Thread.sleep(200);
            }
            else if(랜덤값<=29){ //20~29공격력
                정수강화=rd.nextInt(6)+5;
                System.out.println("공격력이 "+정수강화+" 만큼 성장했다!");
//                this.캐릭터공격력=this.캐릭터공격력+정수강화;
                this.캐릭터공격력=this.캐릭터공격력+정수강화;
                상승횟수++;
                Thread.sleep(200);
            }
            else if(랜덤값<=39){ //30~39방어력
                정수강화=rd.nextInt(3)+1;
                System.out.println("방어력이 "+정수강화+" 만큼 성장했다!");
//                this.캐릭터방어력=this.캐릭터방어력+정수강화;
                this.캐릭터방어력=this.캐릭터방어력+정수강화;
                상승횟수++;
                Thread.sleep(200);
            }
            else if(랜덤값<=49){ //40~49치피
                정수강화=rd.nextInt(6)+5;
                System.out.println("치명타 피해량이 "+정수강화+" 만큼 상승했다!");
                this.레벨업추가치피=this.레벨업추가치피+정수강화;
                상승횟수++;
                Thread.sleep(200);
            }
        }
        this.캐릭터현재체력=this.캐릭터최대체력+this.레벨업추가체력;
        this.캐릭터현재마나=this.캐릭터최대마나+this.레벨업추가마나;
    }

    public void 캐릭터공격(몬스터 타겟) throws InterruptedException {

        //데미지 공식 시작

        int 공격력 = (int) Math.ceil(this.캐릭터최종공격력*(Math.random()*0.2+0.9));
        if(rd.nextInt(100)+캐릭터최종치확>99){
            치명타=true;
            System.out.println("공격력 : " + 공격력 + ", 공격력*캐릭터최종치피 : " + (int)Math.ceil(공격력*캐릭터최종치피) + ", 100나누면 : " + (int)Math.ceil(공격력*캐릭터최종치피)/100);
            공격력=(int)Math.ceil(공격력*캐릭터최종치피/100);
        }
        System.out.println("캐릭터.캐릭터공격| 공격력 : " + 공격력 + ", 타겟.방어력 : " + 타겟.방어력);
        System.out.println("캐릭터.캐릭터공격| 캐릭터최종공격력 : " + this.캐릭터최종공격력);
        int 입힌데미지 = 공격력-타겟.방어력;
        if(입힌데미지<=0){
            입힌데미지=1;
        }
        //데미지 공식 끝

        System.out.println("\n"+타겟.이름 + "을(를) 공격합니다." +
                "\n플레이어의 기본공격!");
        타겟.현재체력 = 타겟.현재체력-입힌데미지;
        Thread.sleep(1000);
        if(치명타){
            System.out.println("치명타!");
            Thread.sleep(1000);
        }
        System.out.println("" +
                타겟.이름 + "에게 " + 입힌데미지 + "만큼의 데미지를 입혔다!");
        Thread.sleep(1000);
        if(타겟.현재체력<=0){ //공격받은 뒤 타겟의 현재체력이 0이하면
            System.out.println("" +
                    "" + 타겟.이름 + "은(는) 쓰러졌다!");
            Thread.sleep(1000);
        }
        else{ //공격받은 뒤 타겟의 체력이 남아있으면
            System.out.println("" +
                    "" + 타겟.이름 + "의 체력이" + 타겟.현재체력 + " 남았다!");
            Thread.sleep(1000);
        }
        치명타=false;
        System.out.println("");
//        return 타겟;
    }
    public void 단일스킬(몬스터 타겟, 스킬 스킬) throws InterruptedException {
        //여기까지 왔다면 무조건 발동함
        boolean 치명타 = false;
        System.out.println("");
        if(스킬.고유번호==100){ //사용한 스킬이 강타라면

            //데미지 공식 시작
            int 입힌데미지 = 스킬.공격(타겟);
            if(입힌데미지<=0){
                입힌데미지=1;
            }
            //데미지 공식 끝

            this.캐릭터현재마나=this.캐릭터현재마나-스킬.소모량;

            System.out.println("\n" + 타겟.이름 + "을(를) 공격합니다. (마나 " +스킬.소모량+ " 소모)" +
                    "\n플레이어의 강타!");
            타겟.현재체력 = 타겟.현재체력 - 입힌데미지;
            Thread.sleep(1000);
            if(치명타){
                System.out.println("치명타!");
                Thread.sleep(1000);
            }
            System.out.println("" +
                    타겟.이름 + "에게 " + 입힌데미지 + "만큼의 데미지를 입혔다!");
            Thread.sleep(1000);
            if (타겟.현재체력 <= 0) { //공격받은 뒤 타겟의 현재체력이 0이하면
                System.out.println("" +
                        "" + 타겟.이름 + "은(는) 쓰러졌다!");
                Thread.sleep(1000);
            } else { //공격받은 뒤 타겟의 체력이 남아있으면
                System.out.println("" +
                        "" + 타겟.이름 + "의 체력이" + 타겟.현재체력 + " 남았다!");
                Thread.sleep(1000);
            }
        }else if(스킬.고유번호 ==101){ //사용한 스킬이 강타가 아니라 고유번호 101이라면...

        }
        System.out.println("");
    }
    public void 다중스킬(ArrayList<몬스터> 몬스터어레이, 스킬 스킬, int 타겟) throws InterruptedException {
    }
    public void 광역스킬(ArrayList<몬스터> 몬스터어레이,스킬 스킬) throws InterruptedException {
        몬스터 타겟;
        int 입힌데미지;
        this.캐릭터현재마나=this.캐릭터현재마나-스킬.소모량;
        System.out.println(스킬.스킬명 + "을(를) 사용합니다. (마나 " +스킬.소모량+ " 소모)" +
                "\n플레이어의 "+스킬.스킬명+"!");
        Thread.sleep(1000);
        for(int i = 0 ; i <몬스터어레이.size() ; i++){
            타겟 = 몬스터어레이.get(i);

            //데미지 공식 시작
            입힌데미지 = 스킬.공격(타겟);
            if(입힌데미지<=0){
                입힌데미지=1;
            }
            //데미지 공식 끝

            타겟.현재체력 = 타겟.현재체력 - 입힌데미지;
            System.out.println("" +
                    타겟.이름 + "에게 " + 입힌데미지 + "만큼의 데미지를 입혔다!");
            Thread.sleep(200);
            if (타겟.현재체력 <= 0) { //공격받은 뒤 타겟의 현재체력이 0이하면
                System.out.println("" +
                        "" + 타겟.이름 + "은(는) 쓰러졌다!");
                Thread.sleep(200);
            } else { //공격받은 뒤 타겟의 체력이 남아있으면
                System.out.println("" +
                        "" + 타겟.이름 + "의 체력이" + 타겟.현재체력 + " 남았다!");
                Thread.sleep(200);
            }
        }
        System.out.println("");
    }


}

//모든 데미지는 1미만일경우 1로 판정, 공격력은 스탯의 0.9~1.1배까지 랜덤으로 곱한 뒤 올림
//기본공격 데미지 공식 : 공격력-적방어력
//강타 데미지공식 : 공격력+50 (방어력을 무시함)
//휩쓸기 데미지공식 : 공격력*0.6-적방어력

//랜덤 사용법
//rd.nextInt(a)+b //0~a의 난수를 메인(최댓값을 올려줌), b는 메인 범위의 최솟값과 최댓값을 동시에 올려줌(b : 최솟값, a+b : 최댓값)
//0.9~1.1을 출력하려면?
//Math.random(); //0~1사이의 double 난수를 메인
//Math.random()*0.2 //0~0.2사이의 double 난수를 메인
//Math.random()*0.2+0.9//0.9~1.1사이의 double 난수를 메인
//Math.random()*100 //0~100사이의 double 난수를 메인
//Math.random()*100+5 //5~105사이의 double 난수를 메인

//



//1. 선택한 템이 스택가능이면 몇개를 구매할건지 물어보기//
//1-1 구매개수를 1이상으로 입력 받으면 진짜 구매할건지 물어보기//
//1-1-1 구매한다고 했으면 인벤토리 안에 고유번호가 같은 아이템이 존재하는지 확인
//1-1-1-1 존재하면 돈이 충분한지 확인
//1-1-1-1-1 돈이 충분하다면 같은 아이템의 스택을 구매개수만큼 늘림
//1-1-1-1-2 돈이 부족하다면 돈이 부족하다는 문구를 띄우고 뒤로가기
//1-1-1-2 존재하지 않으면 인벤토리의 남은 공간이 있는지 확인
//1-1-1-2-1 남은 공간이 있다면 돈이 충분한지 확인
//1-1-1-2-1-1 돈이 충분하다면 인벤토리에 해당 아이템을 추가
//1-1-1-2-1-2 돈이 부족하다면 돈이 부족하다는 문구를 띄우고 뒤로가기
//1-1-1-2-2 남은 공간이 없다면 인벤토리가 꽉찼다는 문구를 띄우고 뒤로가기
//1-1-2 구매안한다고 했으면 뒤로가기
//1-2 0을 입력시 구매진행 false//

//2. 선택한 템이 스택불가능이면 그냥 구매할건지 물어보기
//2-1 구매한다고 했으면 돈이 충분한지 확인
//2-1-1 돈이 충분하면 공간이 충분한지 확인
//2-1-1-1 공간이 충분하면 인벤토리에 해당 아이템을 추가
//2-1-1-2 공간이 부족하다면 인벤토리가 꽉찼다는 문구를 띄우고 뒤로가기
//2-1-2 돈이 부족하다면 돈이 부족하다는 문구를 띄우고 뒤로가기
//2-2 구매안한다고 했으면 뒤로가기
//    public int 구매개수확인(){
//        System.out.print("" +
//                "\n구매할 개수를 입력해주세요." +
//                "\n→");
//        구매개수=sc.nextInt();
//        return 구매개수;
//    }



//        능력치.캐릭터레벨=1;
//                능력치.캐릭터최대경험치=100;
//                능력치.캐릭터현재경험치=0;
//                능력치.캐릭터최대체력=1000;
//                능력치.캐릭터현재체력=1000;
//                능력치.캐릭터최대마나=100;
//                능력치.캐릭터현재마나=100;
//                능력치.캐릭터공격력=50;
//                능력치.캐릭터추가공격력=0;
//                능력치.캐릭터방어력=10;
//                능력치.캐릭터추가방어력=0;
//                능력치.캐릭터치명확률=20;
//                능력치.캐릭터치명피해=150;
//                능력치.캐릭터회피=10;
//                능력치.캐릭터최종공격력=능력치.캐릭터공격력+능력치.캐릭터추가공격력;
//                능력치.캐릭터최종방어력=능력치.캐릭터방어력+능력치.캐릭터추가방어력;