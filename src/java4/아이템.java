package java4;

import java.util.ArrayList;

public class 아이템 { //아이템 정보는 이곳에

    String 아이템이름;
    String 임시이름;
    int 고유번호 = 0; //100~장비, 200~소모, 300~재료, 0~회복
    int 아이템분류 = 0; // 0:없음, 1:장비, 2:소모, 3:재료, 4:회복
    boolean 착용가능여부 = false;
    boolean 착용여부 = false; //true이면 인벤토리 상에서 (착용중) 으로 표시
    boolean 스택가능여부 = false; //true이면 인벤토리상에서 몇개인지 표시
    int 스택수 = 0; //스택가능여부가 true이면 스택수를 이용해 몇개인지 표시
    boolean 상점판매여부 = false; //true이면 상점에서 판매함
    int 구매가격 = 0;
    int 판매가격 = 0;
    int 장비부위 = 0; //1:무기 2:방패 3:갑옷 4:각반
    boolean 사용가능여부=false;
    String 아이템효과 = "";
    int 지속시간=0;

    int 기본공격력=0;
    int 기본방어력=0;
    int 기본체력=0;
    int 기본마나=0;
    double 기본치확=0;
    double 기본치피=0;
    int 추가공격력=0;
    int 추가방어력=0;
    int 추가체력=0;
    int 추가마나=0;
    double 추가치확=0;
    double 추가치피=0;
    double 추가회피=0;
    int 강화=0;
    int 드랍률=0;


    //장비 아이템 효과, 사용 아이템 효과 적용할 방법 생각해보기

    아이템(int 고유번호){
        if(고유번호==0){
            this.아이템이름="더미 아이템";
            this.더미아이템();
        }
        else if(고유번호 == -1){
            this.아이템이름="체력물약";
            this.체력물약();
        }
        else if(고유번호 == -2){
            this.아이템이름="마나물약";
            this.마나물약();
        }
        else if(고유번호 == 100){
            this.임시이름="검";
            this.검();
        }
        else if(고유번호 == 101){
            this.임시이름="방패";
            this.방패();
        }
        else if(고유번호 == 102){
            this.임시이름="갑옷";
            this.갑옷();
        }
        else if(고유번호 == 103){
            this.임시이름="각반";
            this.각반();
        }
        else if(고유번호 == 200){
            this.아이템이름="공격력 물약";
            this.공격력물약();
        }
        else if(고유번호 == 300){
            this.아이템이름="슬라임젤리";
            this.슬라임젤리();
        }
        else if(고유번호 == 301){
            this.아이템이름="오크이빨";
            this.오크이빨();
        }
        else if(고유번호 == 302){
            this.아이템이름="고블린 귀";
            this.고블린귀();
        }
        else if(고유번호 == 456456){
            this.아이템이름="착용불가능스택불가능";
            this.착용불가능스택불가능();
        }
    }

    public void 더미아이템(){
        this.아이템분류=0;
        this.착용가능여부=false;
        this.스택가능여부=false;
        this.스택수=1;
    }
    public void 체력물약(){
        this.고유번호=-1;
        this.아이템분류=4;
        this.착용가능여부=false;
        this.착용여부=false;
        this.스택가능여부=true;
        this.스택수=1;
        this.상점판매여부 = true;
        this.사용가능여부 = true;
        this.구매가격=10;
        this.판매가격=5;
        this.아이템효과="회복 아이템 : 사용시 체력을 300 회복시킵니다.";
        this.드랍률=10;
    }

    public void 마나물약(){
        this.고유번호=-2;
        this.아이템분류=4;
        this.착용가능여부=false;
        this.착용여부=false;
        this.스택가능여부=true;
        this.스택수=1;
        this.상점판매여부 = true;
        this.사용가능여부 = true;
        this.구매가격=10;
        this.판매가격=5;
        this.아이템효과="회복 아이템 : 사용시 마나를 30 회복시킵니다.";
        this.드랍률=10;
    }

    public void 검(){
        this.고유번호=100;
        this.아이템분류=1;
        this.착용가능여부=true;
        this.착용여부=false;
        this.스택가능여부=false;
        this.스택수=1;
        this.상점판매여부 = true;
        this.사용가능여부 = true;
        this.장비부위 = 1;
        this.구매가격=100;
        this.판매가격=50;
        this.아이템효과="장비 아이템(무기): 장착시 공격력을 20 증가시킵니다.";
        this.기본공격력=20;
        this.기본방어력=0;
        this.기본체력=0;
        this.기본마나=0;
        this.기본치확=0;
        this.기본치피=0;
        this.강화수치();
        this.강화=0;
        this.아이템이름="+" + this.강화 + " " + this.임시이름;
        this.드랍률=10;
    }
    public void 방패(){
        this.고유번호=101;
        this.아이템분류=1;
        this.착용가능여부=true;
        this.착용여부=false;
        this.스택가능여부=false;
        this.스택수=1;
        this.상점판매여부 = true;
        this.사용가능여부 = true;
        this.장비부위 = 2;
        this.구매가격=100;
        this.판매가격=50;
        this.아이템효과="장비 아이템(보조장비): 장착시 방어력을 3 증가시킵니다.";
        this.기본공격력=0;
        this.기본방어력=3;
        this.기본체력=0;
        this.기본마나=0;
        this.기본치확=0;
        this.기본치피=0;
        this.강화수치();
        this.강화=0;
        this.아이템이름="+" + this.강화 + " " + this.임시이름;
        this.드랍률=10;
    }
    public void 갑옷(){
        this.고유번호=102;
        this.아이템분류=1;
        this.착용가능여부=true;
        this.착용여부=false;
        this.스택가능여부=false;
        this.스택수=1;
        this.상점판매여부 = true;
        this.사용가능여부 = true;
        this.장비부위 = 3;
        this.구매가격=100;
        this.판매가격=50;
        this.아이템효과="장비 아이템(갑옷): 장착시 체력을 100 증가시킵니다.";
        this.기본공격력=0;
        this.기본방어력=0;
        this.기본체력=100;
        this.기본마나=0;
        this.기본치확=0;
        this.기본치피=0;
        this.강화수치();
        this.강화=0;
        this.아이템이름="+" + this.강화 + " " + this.임시이름;
        this.드랍률=10;
    }
    public void 각반(){
        this.고유번호=103;
        this.아이템분류=1;
        this.착용가능여부=true;
        this.착용여부=false;
        this.스택가능여부=false;
        this.스택수=1;
        this.상점판매여부 = true;
        this.사용가능여부 = true;
        this.장비부위 = 4;
        this.구매가격=100;
        this.판매가격=50;
        this.아이템효과="장비 아이템(각반) : 장착시 방어력을 3 증가시킵니다.";
        this.기본공격력=0;
        this.기본방어력=3;
        this.기본체력=0;
        this.기본마나=0;
        this.기본치확=0;
        this.기본치피=0;
        this.강화수치();
        this.강화=0;
        this.아이템이름="+" + this.강화 + " " + this.임시이름;
        this.드랍률=10;
    }

    public void 공격력물약(){
        this.고유번호=200;
        this.아이템분류=2;
        this.착용가능여부=false;
        this.착용여부=false;
        this.스택가능여부=true;
        this.스택수=1;
        this.상점판매여부 = true;
        this.사용가능여부 = true;
        this.구매가격=50;
        this.판매가격=25;
        this.아이템효과="사용 아이템 : 사용시 공격력을 30 증가시킵니다.";
        this.추가공격력=30;
        this.지속시간=5;
        this.드랍률=10;
    }
    public void 슬라임젤리(){
        this.고유번호=300;
        this.아이템분류=3;
        this.착용가능여부=false;
        this.착용여부=false;
        this.스택가능여부=true;
        this.스택수=1;
        this.상점판매여부 = false;
        this.사용가능여부 = false;
        this.구매가격=0;
        this.판매가격=5;
        this.아이템효과="죽은 슬라임의 파편입니다. 상점에 팔 수 있을 것 같습니다.";
        this.드랍률=50;
    }
    public void 오크이빨(){
        this.고유번호=301;
        this.아이템분류=3;
        this.착용가능여부=false;
        this.착용여부=false;
        this.스택가능여부=true;
        this.스택수=1;
        this.상점판매여부 = false;
        this.사용가능여부 = false;
        this.구매가격=0;
        this.판매가격=30;
        this.아이템효과="오크를 토벌한 전리품입니다. 상점에 팔 수 있을 것 같습니다.";
        this.드랍률=50;
    }
    public void 고블린귀(){
        this.고유번호=302;
        this.아이템분류=3;
        this.착용가능여부=false;
        this.착용여부=false;
        this.스택가능여부=true;
        this.스택수=1;
        this.상점판매여부 = false;
        this.사용가능여부 = false;
        this.구매가격=0;
        this.판매가격=10;
        this.아이템효과="고블린을 토벌한 전리품입니다. 상점에 팔 수 있을 것 같습니다.";
        this.드랍률=50;
    }
    public void 착용불가능스택불가능(){
        this.고유번호=456456;
        this.아이템분류=1;
        this.착용가능여부=false;
        this.착용여부=false;
        this.스택가능여부=false;
        this.스택수=1;
        this.상점판매여부 = false;
        this.사용가능여부 = false;
        this.구매가격=255;
        this.판매가격=505;
        this.아이템효과="착용 불가능하고 스택도 불가능한 테스트용 아이템.";
    }

    public void 강화수치(){
        this.추가공격력=0;
        this.추가방어력=0;
        this.추가체력=0;
        this.추가마나=0;
        this.추가치확=0;
        this.추가치피=0;
        this.추가회피=0;
    }

    //==================================================================================================//
    //=============================================사용 메소드============================================//
    //==================================================================================================//

    public void 물약사용(능력치 캐릭터) throws InterruptedException {
        System.out.println("this.고유번호" + this.고유번호);
        if(this.고유번호==-1) { //고유번호가 -1이면(회복물약이면)
            if (캐릭터.캐릭터최종체력 - 캐릭터.캐릭터현재체력 >= 300) {
                캐릭터.캐릭터현재체력 = 캐릭터.캐릭터현재체력 + 300;
                System.out.print("\n체력이 300회복되어 " + 캐릭터.캐릭터현재체력 + "이 되었습니다.");
                this.스택수=this.스택수-1;
            } else {
                System.out.print("\n체력이 " + (캐릭터.캐릭터최종체력 - 캐릭터.캐릭터현재체력) + "회복되어 ");
                캐릭터.캐릭터현재체력 = 캐릭터.캐릭터최종체력;
                System.out.println(캐릭터.캐릭터현재체력 + "이(가) 되었습니다.");
                this.스택수=this.스택수-1;
            }
        }else if(this.고유번호==-2){//고유번호가 -2이면(마나물약이면)
            if (캐릭터.캐릭터최종마나 - 캐릭터.캐릭터현재마나 >= 30) {
                캐릭터.캐릭터현재마나 = 캐릭터.캐릭터현재마나 + 30;
                System.out.print("\n마나가 30회복되어 " + 캐릭터.캐릭터현재마나 + "이 되었습니다.");
                this.스택수=this.스택수-1;
            } else {
                System.out.print("\n마나가 " + (캐릭터.캐릭터최종마나 - 캐릭터.캐릭터현재마나) + "회복되어 ");
                캐릭터.캐릭터현재마나 = 캐릭터.캐릭터최종마나;
                System.out.println(캐릭터.캐릭터현재마나 + "이(가) 되었습니다.");
                this.스택수=this.스택수-1;
            }
        }
        Thread.sleep(1000);
    }
    public 아이템 야스(){
        아이템 아이템야스;

        아이템야스 = new 아이템(100);

        return 아이템야스;
    }

//    public void 소모품사용(능력치 캐릭터) throws InterruptedException {
//        if(this.고유번호==200){ //고유번호가 200이면(공격력물약이면)
//
//        }
//    }

}
