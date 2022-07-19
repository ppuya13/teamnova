package java4;

public class 아이템 { //아이템 정보는 이곳에

    String 아이템이름;
    int 고유번호 = 0;
    int 아이템분류 = 0; // 0:없음, 1:장비, 2:소모, 3:재료, 4:회복
    boolean 착용가능여부 = false;
    boolean 착용여부 = false; //true이면 인벤토리 상에서 (착용중) 으로 표시
    boolean 스택가능여부 = false; //true이면 인벤토리상에서 몇개인지 표시
    int 스택수 = 0; //스택가능여부가 true이면 스택수를 이용해 몇개인지 표시
    int 구매가격 = 0;
    int 판매가격 = 0;
    String 아이템효과 = "";

    아이템(int 고유번호, String 아이템이름, 능력치 캐릭터){
        if(고유번호==0){
            this.아이템이름="빈 아이템";
            this.빈아이템();
        }
        else if(아이템이름 == "체력물약"){
            this.아이템이름=아이템이름;
            this.체력물약();
        }
        else if(아이템이름=="마나물약"){
            this.아이템이름=아이템이름;
            this.마나물약();
        }
        else if(아이템이름=="검"){
            this.아이템이름=아이템이름;
            this.검(고유번호);
        }
        else if(아이템이름=="방패"){
            this.아이템이름=아이템이름;
            this.방패(고유번호);
        }
        else if(아이템이름=="갑옷"){
            this.아이템이름=아이템이름;
            this.갑옷(고유번호);
        }
        else if(아이템이름=="각반"){
            this.아이템이름=아이템이름;
            this.각반(고유번호);
        }
        else if(아이템이름=="슬라임젤리"){
            this.아이템이름=아이템이름;
            this.슬라임젤리(고유번호);
        }
        else if(아이템이름=="오크이빨"){
            this.아이템이름=아이템이름;
            this.오크이빨(고유번호);
        }
    }


    public void 빈아이템(){
        this.아이템분류=0;
        this.착용가능여부=false;
        this.스택가능여부=false;
        this.스택수=0;
    }

    public void 체력물약(){
        this.고유번호=-1;
        this.아이템분류=4;
        this.착용가능여부=false;
        this.착용여부=false;
        this.스택가능여부=true;
        this.스택수=this.스택수+1;
    }
    public void 마나물약(){
        this.고유번호=-2;
        this.아이템분류=4;
        this.착용가능여부=false;
        this.착용여부=false;
        this.스택가능여부=true;
        this.스택수=this.스택수+1;
    }
    public void 검(int 고유번호){
        this.고유번호=고유번호;
        this.아이템분류=1;
        this.착용가능여부=true;
        this.착용여부=false;
        this.스택가능여부=false;
        this.스택수=1;
        this.구매가격=100;
        this.판매가격=50;
        this.아이템효과="장착시 공격력을 10 증가시킵니다.";
    }
    public void 방패(int 고유번호){
        this.고유번호=고유번호;
        this.아이템분류=1;
        this.착용가능여부=true;
        this.착용여부=false;
        this.스택가능여부=false;
        this.스택수=1;
        this.구매가격=100;
        this.판매가격=50;
        this.아이템효과="장착시 방어력을 10 증가시킵니다.";
    }
    public void 갑옷(int 고유번호){
        this.고유번호=고유번호;
        this.아이템분류=1;
        this.착용가능여부=true;
        this.착용여부=false;
        this.스택가능여부=false;
        this.스택수=1;
        this.구매가격=100;
        this.판매가격=50;
        this.아이템효과="장착시 방어력을 10 증가시킵니다.";
    }
    public void 각반(int 고유번호){
        this.고유번호=고유번호;
        this.아이템분류=1;
        this.착용가능여부=true;
        this.착용여부=false;
        this.스택가능여부=false;
        this.스택수=1;
        this.구매가격=100;
        this.판매가격=50;
        this.아이템효과="장착시 방어력을 10 증가시킵니다.";
    }
    public void 슬라임젤리(int 고유번호){
        this.고유번호=고유번호;
        this.아이템분류=1;
        this.착용가능여부=false;
        this.착용여부=false;
        this.스택가능여부=true;
        this.스택수=1;
        this.구매가격=0;
        this.판매가격=5;
        this.아이템효과="죽은 슬라임의 파편입니다. 상점에 팔 수 있을 것 같습니다.";
    }
    public void 오크이빨(int 고유번호){
        this.고유번호=고유번호;
        this.아이템분류=1;
        this.착용가능여부=false;
        this.착용여부=false;
        this.스택가능여부=true;
        this.스택수=1;
        this.구매가격=0;
        this.판매가격=30;
        this.아이템효과="죽은 오크의 이빨입니다. 상점에 팔 수 있을 것 같습니다.";
    }}
