package java4.캐릭터;


import java4.스킬.단일스킬.강타;
import java4.스킬.단일스킬.찌르기;
import java4.스킬.스킬;
import java4.스킬.광역스킬.휩쓸기;
import java4.아이템.기타.슬라임젤리;
import java4.아이템.소모.회복형.마나물약;
import java4.아이템.소모.회복형.체력물약;
import java4.아이템.아이템;

import java.util.ArrayList;

public class 플레이어 extends 캐릭터 {

    public 플레이어()
    {
        this.이름 = "플레이어";
        this.캐릭터속도 = 200;
        this.캐릭터최종속도 = 0;
        this.캐릭터레벨 = 1;
        this.캐릭터최대경험치 = 100;
        this.캐릭터현재경험치 = 0;
        this.캐릭터최대체력 = 1000;
        this.캐릭터최종체력 = this.캐릭터최대체력;
        this.캐릭터현재체력 = this.캐릭터최대체력;
        this.캐릭터최대마나 = 100;
        this.캐릭터최종마나 = this.캐릭터최대마나;
        this.캐릭터현재마나 = this.캐릭터최대마나;
        this.캐릭터공격력 = 30;
        this.캐릭터최종공격력=0;
        this.캐릭터방어력 = 100;
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
        this.전투횟수 = 0;
        this.전투승리횟수=0;

//        this.활력=0;
//        this.명상=0;
//        this.완력강화=0;
//        this.두꺼운피부=0;
//        this.기회포착=0;
//        this.상업의재능=0;
//        this.장비다루기=0;
//        this.대기만성=0;
//        this.소매치기=0;
//        this.불굴=0;
    }

    public void 스킬초기화(){ //초기 보유 스킬을 설정
        스킬 스킬 = new 강타();
        this.스킬목록.add(스킬);
        스킬 = new 휩쓸기();
        this.스킬목록.add(스킬);
        스킬 = new 찌르기();
        this.스킬목록.add(스킬);
    }
    public void 인벤토리초기화 () { //초기 보유 아이템을 설정
        체력물약 체력물약 = new 체력물약("체력물약");
        체력물약.스택수 = 300;
        마나물약 마나물약 = new 마나물약("마나물약");
        마나물약.스택수 = 30;
        this.회복물약가방.add(체력물약);
        this.회복물약가방.add(마나물약);
//        //이 아래로는 테스트용 아이템생성. 나중에 지우기
        아이템 아이템;
        아이템 = new 슬라임젤리("슬라임젤리");
        아이템.스택수=20;
        this.소지품.add(아이템);
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