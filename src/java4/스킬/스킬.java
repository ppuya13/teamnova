package java4.스킬;

import java4.사냥터.몬스터.몬스터;

import java.util.Random;

public abstract class 스킬 {
    public int 고유번호; // 100~199: 단일공격 | 200~299:다중공격 | 300~399:광역공격
    public int 타입; //1:단일공격 | 2:다중공격 | 3:광역공격
    public String 스킬명;
    public String 효과;
    public int 소모량;
    Random rd = new Random();

    public abstract int 공격(몬스터 타겟) throws InterruptedException ;

    public String 스킬사용확인(){
        String 메시지 = "";
        if(this.타입==1){
            메시지=this.스킬명 + "(마나 "+ this.소모량 + ") : " + this.효과;
        } else if (this.타입 == 3){

        }
        return 메시지;
    }
}
