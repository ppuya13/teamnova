package java4.사냥터.몬스터.고블린;

import java4.아이템.아이템;

public class 보물고블린 extends 고블린{
    public 보물고블린(String 이름){
        this.번호 = 이름;
        this.이름 = "보물고블린" + 번호;
        this.공격력 = rd.nextInt(2) + 2; //2~4
        this.방어력 = rd.nextInt(2) + 2; //2~4
        this.최대체력 = rd.nextInt(30) + 130; //130~160
        this.현재체력 = this.최대체력;
        this.경험치 = rd.nextInt(5) + 25; //25~30
        this.소지금 = rd.nextInt(195) + 5; //5~200
        this.정보 = "약탈한 골드를 들고다니는 고블린입니다. 쓰러뜨릴 경우 많은 골드를 얻을 가능성이 있습니다.";
    }
}
