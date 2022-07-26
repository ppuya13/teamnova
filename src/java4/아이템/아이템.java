package java4.아이템;

import java4.캐릭터.플레이어;

public abstract class 아이템 implements Cloneable{ //아이템 정보는 이곳에

    public String 아이템이름;
    public String 임시이름; //장비아이템 : 강화횟수+임시이름 = 아이템이름
    public int 고유번호 = 0; //100~장비, 200~소모, 300~재료, 0~회복
    public int 아이템분류 = 0; // 0:없음, 1:장비, 2:소모, 3:재료, 4:회복
    public boolean 착용가능여부 = false; //해당 아이템이 착용이 가능한 아이템인지 지정
    public boolean 착용여부; //true이면 인벤토리 상에서 (착용중) 으로 표시
    public boolean 스택가능여부 = false; //true이면 인벤토리상에서 몇개인지 표시
    public int 스택수 = 0; //스택가능여부가 true이면 스택수를 이용해 몇개인지 표시
    public boolean 상점판매여부 = false; //true이면 상점에서 판매함
    public int 구매가격 = 0;
    public int 판매가격 = 0;
    public int 장비부위 = 0; //1:무기 2:방패 3:갑옷 4:각반 5:장갑//같은 부위 중복 착용을 막기 위함.
    public boolean 사용가능여부 = false; //사용이 가능한 아이템인지 지정
    public String 아이템효과 = ""; //인벤토리의 살펴보기에 출력될 메시지
    public int 지속시간 = 0; //지속시간이 존재하는 아이템에만 적용
    public String 사용중; //지속형 소모아이템이 적용중일 때 상태창에 표시될 문구
    public boolean 선적용; //지속형 소모아이템이 사용하자마자 발동되는지 사용한 다음턴부터 효과가 시작되는지 지정
    public boolean 적용; //처음엔 true이고 지속형 소모아이템 사용 시 처음 아이템 효과가 적용된 뒤 false로 바뀜;

    public int 드랍률 = 0; //해당 아이템의 드랍률을 결정
    public int 강화 = 0;
    public int 기본공격력 = 0;
    public int 기본방어력 = 0;
    public int 기본체력 = 0;
    public int 기본마나 = 0;
    public int 기본치확 = 0;
    public int 기본치피 = 0;
    public int 기본속도 = 0;
    public int 추가능력치 = 0;
    public int 추가공격력 = 0;
    public int 추가방어력 = 0;
    public int 추가체력 = 0;
    public int 추가마나 = 0;
    public int 추가치확 = 0;
    public int 추가치피 = 0;
    public int 추가회피 = 0;
    public int 추가속도 = 0;


    //장비 아이템 효과, 사용 아이템 효과 적용할 방법 생각해보기
    //새로운 아이템 추가시 : 아이템 메소드 만들고, 생성자에 링크시킨뒤, 상점에 파는물건이면 상점에 추가하고, 몬스터 드랍테이블에 추가하기.
    //소모품일경우 : 능력치.소모템적용 메소드에 추가

    public 아이템(){
        this.착용여부 = false;
        this.스택수 = 1; //겹쳐있는 개수
    }

    public void 강화수치(){
        this.추가공격력=0;
        this.추가방어력=0;
        this.추가체력=0;
        this.추가마나=0;
        this.추가치확=0;
        this.추가치피=0;
        this.추가회피=0;
        this.추가속도=0;
    }
    public abstract boolean 사용효과(플레이어 플레이어) throws InterruptedException, CloneNotSupportedException;
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
