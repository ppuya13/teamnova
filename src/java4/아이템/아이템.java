package java4.아이템;

import java4.캐릭터.캐릭터;

public abstract class 아이템 implements Cloneable{ //아이템 정보는 이곳에

    public String 아이템이름;
    public String 임시이름;
    public int 고유번호 = 0; //100~장비, 200~소모, 300~재료, 0~회복
    public int 아이템분류 = 0; // 0:없음, 1:장비, 2:소모, 3:재료, 4:회복
    public boolean 착용가능여부 = false;
    public boolean 착용여부 = false; //true이면 인벤토리 상에서 (착용중) 으로 표시
    public boolean 스택가능여부 = false; //true이면 인벤토리상에서 몇개인지 표시
    public int 스택수 = 0; //스택가능여부가 true이면 스택수를 이용해 몇개인지 표시
    public boolean 상점판매여부 = false; //true이면 상점에서 판매함
    public int 구매가격 = 0;
    public int 판매가격 = 0;
    public int 장비부위 = 0; //1:무기 2:방패 3:갑옷 4:각반
    public boolean 사용가능여부 = false;
    public String 아이템효과 = "";
    public int 지속시간 = 0;
    public String 사용중; //지속시간이 존재하는 아이템에만 적용
    public boolean 선적용;
    public boolean 적용;

    public int 기본공격력 = 0;
    public int 기본방어력 = 0;
    public int 기본체력 = 0;
    public int 기본마나 = 0;
    public int 기본치확 = 0;
    public int 기본치피 = 0;
    public int 추가능력치 = 0;
    public int 추가공격력 = 0;
    public int 추가방어력 = 0;
    public int 추가체력 = 0;
    public int 추가마나 = 0;
    public int 추가치확 = 0;
    public int 추가치피 = 0;
    public int 추가회피 = 0;
    public int 강화 = 0;
    public int 드랍률 = 0;


    //장비 아이템 효과, 사용 아이템 효과 적용할 방법 생각해보기
    //새로운 아이템 추가시 : 아이템 메소드 만들고, 생성자에 링크시킨뒤, 상점에 파는물건이면 상점에 추가하고, 몬스터 드랍테이블에 추가하기.
    //소모품일경우 : 능력치.소모템적용 메소드에 추가

    //아이템 사용을 눌렀을 때
    //착용가능여부 = true이면 (장비아이템)아이템.장착();
    //else 사용가능여부 = true이면 (소모아이템)아이템.사용효과();

    public 아이템(){
        this.착용여부 = false;
        this.스택수 = 1;
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

    public void 물약사용(캐릭터 캐릭터) throws InterruptedException {
//        System.out.println("this.고유번호" + this.고유번호);
        if(this.고유번호==-1) { //고유번호가 -1이면(회복물약이면)
            if (캐릭터.캐릭터최종체력 - 캐릭터.캐릭터현재체력 >= 300) {
                캐릭터.캐릭터현재체력 = 캐릭터.캐릭터현재체력 + 300;
                System.out.print("\n체력이 300회복되어 " + 캐릭터.캐릭터현재체력 + "이 되었습니다.");
            } else {
                System.out.print("\n체력이 " + (캐릭터.캐릭터최종체력 - 캐릭터.캐릭터현재체력) + "회복되어 ");
                캐릭터.캐릭터현재체력 = 캐릭터.캐릭터최종체력;
                System.out.println(캐릭터.캐릭터현재체력 + "이(가) 되었습니다.");
            }
            this.스택수--;
        }else if(this.고유번호==-2){//고유번호가 -2이면(마나물약이면)
            if (캐릭터.캐릭터최종마나 - 캐릭터.캐릭터현재마나 >= 30) {
                캐릭터.캐릭터현재마나 = 캐릭터.캐릭터현재마나 + 30;
                System.out.print("\n마나가 30회복되어 " + 캐릭터.캐릭터현재마나 + "이 되었습니다.");
            } else {
                System.out.print("\n마나가 " + (캐릭터.캐릭터최종마나 - 캐릭터.캐릭터현재마나) + "회복되어 ");
                캐릭터.캐릭터현재마나 = 캐릭터.캐릭터최종마나;
                System.out.println(캐릭터.캐릭터현재마나 + "이(가) 되었습니다.");
            }
            this.스택수--;
        }
        Thread.sleep(1000);
    }
    public abstract boolean 사용효과(캐릭터 캐릭터) throws InterruptedException, CloneNotSupportedException;
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


//    public void 소모품사용(능력치 캐릭터) throws InterruptedException {
//        if(this.고유번호==200){ //고유번호가 200이면(공격력물약이면)
//
//        }
//    }

}
