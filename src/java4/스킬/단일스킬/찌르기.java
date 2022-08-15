package java4.스킬.단일스킬;

import java4.사냥터.몬스터.몬스터;
import java4.스킬.지속피해.출혈;
import java4.스킬.지속피해.지속피해;
import java4.캐릭터.캐릭터;

import java.util.ArrayList;

public class 찌르기 extends 단일스킬{

    public 찌르기(){
        this.고유번호=0;
        this.스킬명="찌르기";
        this.효과="대상을 찔러 피해를 주고 5초간 출혈을 유발시킵니다.";
        this.소모량=10;
    }
    @Override
    public void 사용효과(ArrayList<몬스터> 몬스터어레이, 캐릭터 캐릭터, 몬스터 타겟) throws InterruptedException {
        int 공격력 = this.공격력(캐릭터);
        boolean 치명타=false;

        if(rd.nextInt(100)+캐릭터.캐릭터최종치확>99){
            공격력=(int)Math.ceil(공격력*캐릭터.캐릭터최종치피/100);
            치명타=true;
        }
        int 입힌데미지 = 공격력-타겟.최종방어력;
        if(입힌데미지<=0){
            입힌데미지=1;
        }
        //데미지 공식 끝


        캐릭터.캐릭터현재마나=캐릭터.캐릭터현재마나-this.소모량;
        System.out.println("\n" + 타겟.이름 + "을(를) 공격합니다." +
                "\n"+캐릭터.이름+"의 "+this.스킬명+"!");
        타겟.현재체력 = 타겟.현재체력 - 입힌데미지;
        Thread.sleep(500);
        if(치명타){
            System.out.println("치명타!");
            Thread.sleep(500);
        }

        지속피해 출혈 = new 출혈(캐릭터, 200, 타겟);
        출혈.적용();

        System.out.println("" +
                타겟.이름 + "에게 " + 입힌데미지 + "만큼의 데미지를 입혔다!");
        Thread.sleep(500);
        if (타겟.현재체력 <= 0) { //공격받은 뒤 타겟의 현재체력이 0이하면
            System.out.println("" +
                    "" + 타겟.이름 + "은(는) 쓰러졌다!");
            Thread.sleep(1000);
        } else { //공격받은 뒤 타겟의 체력이 남아있으면
            System.out.println("" +
                    "" + 타겟.이름 + "의 체력이" + 타겟.현재체력 + " 남았다!");
            Thread.sleep(1000);
        }
    }
}
