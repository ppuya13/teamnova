package java4.아이템.소모.지속형;

import java4.캐릭터.플레이어;

public class 공격력물약 extends 지속형 {
    public 공격력물약(String 이름) {
        this.아이템이름=이름;
        this.고유번호=200;
        this.선적용=false; //공격관련처럼 다음턴부터 적용되면 false;
        this.구매가격=50;
        this.판매가격=25;
        this.아이템효과="사용 아이템 : 사용시 다음 턴부터 5턴간 공격력을 30 증가시킵니다.";
        this.추가능력치=3000;
        this.사용중="공격력 물약(공격력 +" + this.추가능력치 + ") 적용중";
        this.지속시간=6; //지속시간+1로 적용
        this.드랍률=10;
    }

    @Override
    public void 효과적용(플레이어 플레이어) throws InterruptedException {
        if(this.적용){ //지속 첫턴에 일어나는 일
//            System.out.println("공격력물약 | 아이템 지속 첫턴 발동");
            this.적용 = false;
            플레이어.소모품추가공격력 = 플레이어.소모품추가공격력+this.추가능력치;
//            System.out.println("공격력물약 | this.지속시간 : " + this.지속시간);
        }
        this.지속시간--;
    }

    @Override
    public boolean 효과삭제(플레이어 플레이어) throws InterruptedException {
        if(this.지속시간==0){ //남은 지속시간이 0일 때 일어나는 일
            플레이어.소모품추가공격력 = 플레이어.소모품추가공격력-this.추가능력치;
            for(int i = 0; i < 플레이어.사용중.size() ; i++){
                if(플레이어.사용중.get(i).아이템이름.equals(this.아이템이름)){
                    플레이어.사용중.remove(i);
                    return true;
                }
            }
        }
        return false;
    }
}
