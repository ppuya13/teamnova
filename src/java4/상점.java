package java4;

import java.util.ArrayList;

public class 상점 { // 상점에 관련된 정보는 여기에
    ArrayList<아이템> 리스트 = new ArrayList<>();

    아이템 체력물약 = new 아이템(-1);
    아이템 마나물약 = new 아이템(-2);

    아이템 검= new 아이템(100);
    아이템 방패= new 아이템(101);
    아이템 갑옷 = new 아이템(102);
    아이템 각반 = new 아이템(103);

    아이템 공격력물약 = new 아이템(200);
    아이템 방어력물약 = new 아이템(201);

    아이템 슬라임젤리 = new 아이템(300);
    아이템 오크이빨 = new 아이템(301);

    아이템 치트1 = new 아이템(456456);

    상점(){
        리스트.add(체력물약);
        리스트.add(마나물약);

        리스트.add(검);
        리스트.add(방패);
        리스트.add(갑옷);
        리스트.add(각반);

        리스트.add(공격력물약);
        리스트.add(방어력물약);

        리스트.add(슬라임젤리);
        리스트.add(오크이빨);

        리스트.add(치트1);

        this.리스트 = 리스트;
    }

    public String 상점구매타겟(int 타겟){
        String 구매한템이름=this.리스트.get(타겟-1).아이템이름;
        return 구매한템이름;
    }
}
