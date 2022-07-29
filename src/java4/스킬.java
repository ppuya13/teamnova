package java4;

public class 스킬 {
    public int 고유번호; // 100~199: 단일공격 | 200~299:다중공격 | 300~399:광역공격
    public int 타입; //1:단일공격 | 2:다중공격 | 3:광역공격
    public String 스킬명;
    public String 효과;
    public int 소모량;

    스킬(int 고유번호) {
        if(고유번호==100){
            this.강타(고유번호);
        }
        else if(고유번호==300){
            this.휩쓸기(고유번호);
        }
    }

    public void 강타(int 고유번호){
        this.고유번호=고유번호;
        this.스킬명="강타";
        this.효과="적 하나를 강하게 타격하여 공격력에 비례한 데미지를 입힙니다. 대상의 방어력을 무시합니다.";
        this.타입=1;
        this.소모량=5;
    }

    public void 휩쓸기(int 고유번호){
        this.고유번호=고유번호;
        this.스킬명="휩쓸기";
        this.효과="모든 적을 공격하여 공격력에 비례한 데미지를 입힙니다.";
        this.타입=3;
        this.소모량=10;
    }
}
