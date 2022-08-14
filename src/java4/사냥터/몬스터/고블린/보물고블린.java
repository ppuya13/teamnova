package java4.사냥터.몬스터.고블린;

import java4.사냥터.몬스터.스킬.고블린.도망치기;
import java4.사냥터.몬스터.스킬.기본공격;
import java4.사냥터.몬스터.스킬.몬스터스킬;
import java4.아이템.아이템;
import java4.아이템.장비.*;

public class 보물고블린 extends 고블린{
    int 반복횟수;
    int 강화수치;
    int 정수강화;
    도망치기 도망치기 = new 도망치기();
    몬스터스킬 기본공격 = new 기본공격();
    public 보물고블린(String 이름){
        this.이름 = "보물 고블린 " + 이름;
        this.속도 =rd.nextInt(16) + 260; //260~275
        this.공격력 = rd.nextInt(3) + 2; //2~4
        this.최종공격력 = this.공격력;
        this.방어력 = rd.nextInt(3) + 2; //2~4
        this.최종방어력 = this.방어력;
        this.최대체력 = rd.nextInt(31) + 130; //130~160
        this.현재체력 = this.최대체력;
        this.경험치 = rd.nextInt(6) + 25; //25~30
        this.소지금 = rd.nextInt(196) + 5; //5~200
        this.정보 = "약탈한 물건을 들고다니는 고블린입니다. 값진 물건을 가지고 있습니다.";
        this.스킬리스트.clear();
        this.스킬리스트.add(기본공격);
        this.스킬리스트.add(도망치기);
        this.드랍테이블.clear();
        값진아이템();
    }

    private void 값진아이템(){
        for(int i = 0 ; i < rd.nextInt(3)+1 ; i++) { //1~3번 반복
            난수 = rd.nextInt(5); //0~4
            switch (난수) {
                case 0:
                    드랍템 = new 검("검");
                    break;
                case 1:
                    드랍템 = new 방패("방패");
                    break;
                case 2:
                    드랍템 = new 갑옷("갑옷");
                    break;
                case 3:
                    드랍템 = new 각반("각반");
                    break;
                case 4:
                    드랍템 = new 장갑("장갑");
                    break;
            }
            this.반복횟수=0;
            this.강화수치=0;
            while (this.반복횟수 < 10) { // 0~4강은 30%, 5~9강은 15%로 각각 성공.)
                if (this.강화수치 < 5) { //제작아이템이 5강 미만이면
                    if (rd.nextInt(100) + 30 > 99) {
                        this.강화수치++;
                    }
                } else { //제작아이템이 5강 이상이면
                    if (rd.nextInt(100) + 15 > 99) {
                        this.강화수치++;
                    }
                }
                this.반복횟수++;
            }

            for(int j = 0 ; j < this.강화수치 ; j++) {
                난수 = rd.nextInt(70); //0~9체력 | 10~19마나 | 20~29공격력 | 30~39방어력 | 40~49치확 | 50~59치피 | 60~69회피
                if (난수 <= 9) { //0~9체력
                    정수강화 = rd.nextInt(11) + 20; //20~30 상승
                    드랍템.추가체력 = 드랍템.추가체력 + 정수강화;
                } else if (난수 <= 19) { //10~19마나
                    정수강화 = rd.nextInt(6) + 5; //5~10 상승
                    드랍템.추가마나 = 드랍템.추가마나 + 정수강화;
                } else if (난수 <= 29) { //20~29공격력
                    정수강화 = rd.nextInt(6) + 5;
                    드랍템.추가공격력 = 드랍템.추가공격력 + 정수강화;
                } else if (난수 <= 39) { //30~39방어력
                    정수강화 = rd.nextInt(3) + 1;
                    드랍템.추가방어력 = 드랍템.추가방어력 + 정수강화;
                } else if (난수 <= 49) { //40~49치확
                    정수강화 = rd.nextInt(3) + 1;
                    드랍템.추가치확 = 드랍템.추가치확 + 정수강화;
                } else if (난수 <= 59) { //50~59치피
                    정수강화 = rd.nextInt(6) + 5;
                    드랍템.추가치피 = 드랍템.추가치피 + 정수강화;
                } else if (난수 <= 69) { //60~69회피
                    정수강화 = rd.nextInt(3) + 1;
                    드랍템.추가회피 = 드랍템.추가회피 + 정수강화;
                }
                드랍템.강화++;
            }
            드랍템.아이템이름="+" + 드랍템.강화 + " " + 드랍템.임시이름;
            드랍템.드랍률=100;
            this.드랍테이블.add(드랍템);
        }

    }

}
