package java4.캐릭터;

import java4.스킬.스킬;
import java4.아이템.아이템;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public abstract class 능력치 {

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

    Scanner sc = new Scanner(System.in);
    int 정수강화;



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
    public void 휴식() throws InterruptedException {
        System.out.println("\n휴식합니다.");
        Thread.sleep(1000);
        if (this.캐릭터최종체력 - this.캐릭터현재체력 >= 300) {
            this.캐릭터현재체력 = this.캐릭터현재체력 + 300;
            System.out.print("\n체력이 300회복되어 " + this.캐릭터현재체력 + "이(가) 되었습니다.");

        } else {
            System.out.print("\n체력이 " + (this.캐릭터최종체력 - this.캐릭터현재체력) + "회복되어 ");
            this.캐릭터현재체력 = this.캐릭터최종체력;
            System.out.print(this.캐릭터현재체력 + "이(가) 되었습니다.");
        }
        if (this.캐릭터최종마나 - this.캐릭터현재마나 >= 30) {
            this.캐릭터현재마나 = this.캐릭터현재마나 + 30;
            System.out.print("\n체력이 30회복되어 " + this.캐릭터현재마나 + "이(가) 되었습니다.");

        } else {
            System.out.print("\n체력이 " + (this.캐릭터최종마나 - this.캐릭터현재마나) + "회복되어 ");
            this.캐릭터현재마나 = this.캐릭터최종마나;
            System.out.print(this.캐릭터현재마나 + "이(가) 되었습니다.");
        }
        System.out.print("" +
                "\n계속하려면 아무 숫자나 입력하세요." +
                "\n→");
        int 입력 = sc.nextInt();
    }
}
