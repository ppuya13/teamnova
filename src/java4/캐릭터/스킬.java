package java4.캐릭터;

import java4.몬스터;

import java.util.ArrayList;
import java.util.Random;

public class 스킬 {
    public int 고유번호; // 100~199: 단일공격 | 200~299:다중공격 | 300~399:광역공격
    public int 타입; //1:단일공격 | 2:다중공격 | 3:광역공격
    public String 스킬명;
    public String 효과;
    public int 소모량;
    Random rd = new Random();

    public 스킬(int 고유번호) {
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

    public void 단일스킬(몬스터 타겟, 스킬 스킬) throws InterruptedException {
        //여기까지 왔다면 무조건 발동함
        System.out.println("");
        if(스킬.고유번호==100){ //사용한 스킬이 강타라면

            //데미지 공식 시작
            int 공격력 = (int) Math.ceil(this.캐릭터최종공격력*(Math.random()*0.2+0.9));
            if(rd.nextInt(100)+캐릭터최종치확>99){
                치명타=true;
                공격력=(int)Math.ceil(공격력*캐릭터최종치피/100);
            }
            int 입힌데미지 = 공격력+50;
            if(입힌데미지<=0){
                입힌데미지=1;
            }
            //데미지 공식 끝

            this.캐릭터현재마나=this.캐릭터현재마나-스킬.소모량;

            System.out.println("\n" + 타겟.이름 + "을(를) 공격합니다. (마나 " +스킬.소모량+ " 소모)" +
                    "\n플레이어의 강타!");
            타겟.현재체력 = 타겟.현재체력 - 입힌데미지;
            Thread.sleep(1000);
            if(치명타){
                System.out.println("치명타!");
                Thread.sleep(1000);
            }
            System.out.println("" +
                    타겟.이름 + "에게 " + 입힌데미지 + "만큼의 데미지를 입혔다!");
            Thread.sleep(1000);
            if (타겟.현재체력 <= 0) { //공격받은 뒤 타겟의 현재체력이 0이하면
                System.out.println("" +
                        "" + 타겟.이름 + "은(는) 쓰러졌다!");
                Thread.sleep(1000);
            } else { //공격받은 뒤 타겟의 체력이 남아있으면
                System.out.println("" +
                        "" + 타겟.이름 + "의 체력이" + 타겟.현재체력 + " 남았다!");
                Thread.sleep(1000);
            }
        }else if(스킬.고유번호 ==101){ //사용한 스킬이 강타가 아니라 고유번호 101이라면...

        }
        치명타=false;
        System.out.println("");
    }

    public void 다중스킬(ArrayList<몬스터> 몬스터어레이, 스킬 스킬, int 타겟) throws InterruptedException {

    }

    public void 광역스킬(ArrayList<몬스터> 몬스터어레이, 캐릭터 플레이어) throws InterruptedException {
        몬스터 타겟;
        int 입힌데미지;
        if(스킬.고유번호==300){ //사용한 스킬이 휩쓸기라면
            플레이어.캐릭터현재마나=플레이어.캐릭터현재마나-스킬.소모량;
            System.out.println(스킬.스킬명 + "을(를) 사용합니다. (마나 " +스킬.소모량+ " 소모)" +
                    "\n플레이어의 휩쓸기!");
            Thread.sleep(1000);
            for(int i = 0 ; i <몬스터어레이.size() ; i++){
                타겟 = 몬스터어레이.get(i);

                //데미지 공식 시작
                int 공격력 = (int)Math.round(플레이어.캐릭터최종공격력*(Math.random()*0.2+0.9));
                if(rd.nextInt(100)+플레이어.캐릭터최종치확>99){
                    치명타=true;
                    공격력=(int)Math.ceil(공격력*플레이어.캐릭터최종치피/100);
                }
                입힌데미지 = (int)Math.ceil(공격력*0.7)-타겟.방어력;//데미지 공식을 이곳에 적용
                if(입힌데미지<=0){
                    입힌데미지=1;
                }
                //데미지 공식 끝

                타겟.현재체력 = 타겟.현재체력 - 입힌데미지;
                if(치명타){
                    System.out.println("치명타!");
                    Thread.sleep(200);
                }
                System.out.println("" +
                        타겟.이름 + "에게 " + 입힌데미지 + "만큼의 데미지를 입혔다!");
                Thread.sleep(200);
                if (타겟.현재체력 <= 0) { //공격받은 뒤 타겟의 현재체력이 0이하면
                    System.out.println("" +
                            "" + 타겟.이름 + "은(는) 쓰러졌다!");
                    Thread.sleep(200);
                } else { //공격받은 뒤 타겟의 체력이 남아있으면
                    System.out.println("" +
                            "" + 타겟.이름 + "의 체력이" + 타겟.현재체력 + " 남았다!");
                    Thread.sleep(200);
                }
                치명타=false;
            }
        }
        System.out.println("");
    }
}
