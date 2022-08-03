package java4.캐릭터;


import java4.사냥터.몬스터.몬스터;
import java4.스킬.강타;
import java4.스킬.스킬;
import java4.스킬.휩쓸기;
import java4.상점.상점;
import java4.아이템.아이템;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class 캐릭터 extends 캐릭터전투 { //캐릭터의 능력치나 소지품에 영향을 미치는 메소드는 이곳에
    //    double 실수강화;

    Scanner sc = new Scanner(System.in);
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
        this.캐릭터공격력 = 30;
        this.캐릭터최종공격력=30;
        this.캐릭터방어력 = 0;
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

    public void 스킬초기화(){ //초기 보유 스킬을 설정
        스킬 스킬 = new 강타();
        this.스킬목록.add(스킬);
        스킬 = new 휩쓸기();
        this.스킬목록.add(스킬);
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