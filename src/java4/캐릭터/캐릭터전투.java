package java4.캐릭터;

import java4.사냥터.몬스터.몬스터;
import java4.스킬.스킬;

import java.util.ArrayList;

public abstract class 캐릭터전투 extends 캐릭인벤토리{
    public void 캐릭터공격(몬스터 타겟) throws InterruptedException {

        boolean 치명타=false;

        //데미지 공식 시작

        int 공격력 = (int) Math.ceil(this.캐릭터최종공격력*(Math.random()*0.2+0.9));
        if(rd.nextInt(100)+캐릭터최종치확>99){
            치명타=true;
//            System.out.println("공격력 : " + 공격력 + ", 공격력*캐릭터최종치피 : " + (int)Math.ceil(공격력*캐릭터최종치피) + ", 100나누면 : " + (int)Math.ceil(공격력*캐릭터최종치피)/100);
            공격력=(int)Math.ceil(공격력*캐릭터최종치피/100);
        }
//        System.out.println("캐릭터.캐릭터공격| 공격력 : " + 공격력 + ", 타겟.방어력 : " + 타겟.방어력);
//        System.out.println("캐릭터.캐릭터공격| 캐릭터최종공격력 : " + this.캐릭터최종공격력);
        int 입힌데미지 = 공격력-타겟.최종방어력;
        if(입힌데미지<=0){
            입힌데미지=1;
        }
        //데미지 공식 끝

        System.out.println("\n"+타겟.이름 + "을(를) 공격합니다." +
                "\n플레이어의 기본공격!");
        타겟.현재체력 = 타겟.현재체력-입힌데미지;
        Thread.sleep(500);
        if(치명타){
            System.out.println("치명타!");
            Thread.sleep(500);
        }
        System.out.println("" +
                타겟.이름 + "에게 " + 입힌데미지 + "만큼의 데미지를 입혔다!");
        Thread.sleep(500);
        if(타겟.현재체력<=0){ //공격받은 뒤 타겟의 현재체력이 0이하면
            System.out.println("" +
                    "" + 타겟.이름 + "은(는) 쓰러졌다!");
            Thread.sleep(1000);
        }
        else{ //공격받은 뒤 타겟의 체력이 남아있으면
            System.out.println("" +
                    "" + 타겟.이름 + "의 체력이" + 타겟.현재체력 + " 남았다!");
            Thread.sleep(1000);
        }
        치명타=false;
        System.out.println("");
//        return 타겟;
    }
    public void 단일스킬(몬스터 타겟, 스킬 스킬) throws InterruptedException {
        //여기까지 왔다면 무조건 발동함
        boolean 치명타 = false;
        System.out.println("");
        if(스킬.고유번호==100){ //사용한 스킬이 강타라면

            //데미지 공식 시작
            int 입힌데미지 = 스킬.공격(타겟);
            if(입힌데미지<=0){
                입힌데미지=1;
            }
            //데미지 공식 끝

            this.캐릭터현재마나=this.캐릭터현재마나-스킬.소모량;

            System.out.println("\n" + 타겟.이름 + "을(를) 공격합니다. (마나 " +스킬.소모량+ " 소모)" +
                    "\n플레이어의 강타!");
            타겟.현재체력 = 타겟.현재체력 - 입힌데미지;
            Thread.sleep(500);
            if(치명타){
                System.out.println("치명타!");
                Thread.sleep(500);
            }
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
        }else if(스킬.고유번호 ==101){ //사용한 스킬이 강타가 아니라 고유번호 101이라면...

        }
        System.out.println("");
    }
    public void 다중스킬(ArrayList<몬스터> 몬스터어레이, 스킬 스킬, int 타겟) throws InterruptedException {
    }
    public void 광역스킬(ArrayList<몬스터> 몬스터어레이,스킬 스킬) throws InterruptedException {
        몬스터 타겟;
        int 입힌데미지;
        this.캐릭터현재마나=this.캐릭터현재마나-스킬.소모량;
        System.out.println(스킬.스킬명 + "을(를) 사용합니다. (마나 " +스킬.소모량+ " 소모)" +
                "\n플레이어의 "+스킬.스킬명+"!");
        Thread.sleep(1000);
        for(int i = 0 ; i <몬스터어레이.size() ; i++){
            타겟 = 몬스터어레이.get(i);

            //데미지 공식 시작
            입힌데미지 = 스킬.공격(타겟);
            if(입힌데미지<=0){
                입힌데미지=1;
            }
            //데미지 공식 끝

            타겟.현재체력 = 타겟.현재체력 - 입힌데미지;
            System.out.println("" +
                    타겟.이름 + "에게 " + 입힌데미지 + "만큼의 데미지를 입혔다!");
            Thread.sleep(200);
            if (타겟.현재체력 <= 0) { //공격받은 뒤 타겟의 현재체력이 0이하면
                System.out.println("" +
                        "" + 타겟.이름 + "은(는) 쓰러졌다!");
                Thread.sleep(400);
            } else { //공격받은 뒤 타겟의 체력이 남아있으면
                System.out.println("" +
                        "" + 타겟.이름 + "의 체력이" + 타겟.현재체력 + " 남았다!");
                Thread.sleep(400);
            }
        }
        System.out.println("");
    }
}
