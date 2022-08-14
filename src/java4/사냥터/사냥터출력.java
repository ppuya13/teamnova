package java4.사냥터;

import java4.사냥터.몬스터.몬스터;
import java4.사냥터.몬스터.스킬.몬스터스킬;

import static java4.사냥터.사냥터.몬스터어레이;
import static java4.Main.메인;

public class 사냥터출력{
    public void 사냥터메인() {
        System.out.println(메인.능력치창());
        System.out.print(""+
                "\n몬스터를 사냥하러 왔습니다. 무엇을 하시겠습니까?"+
                "\n0.마을로 돌아가기"+
                "\n1.몬스터 탐색"+
                "\n2.인벤토리"+
                "\n3.휴식" +
                "\n4.보스전"+
                "\n");
    }
    public void 사냥터행동(boolean 보스전){
        if(!보스전) { //보스전이 아닐경우 도망치기가 있음
            System.out.print("" +
//                        몬스터머릿수+죽은몬스터수 +"\n"+
                    몬스터어레이.size() + "마리의 몬스터가 살아있습니다." +
                    "\n무엇을 하시겠습니까?" +
                    "\n1.공격" +
                    "\n2.스킬" +
                    "\n3.아이템" +
                    "\n4.살펴보기" +
                    "\n5.도망치기" +
                    "\n→");
        }else{ //보스전일경우 도망치기가 없음
            System.out.print("" +
                    "오크 로드가 살아있습니다." +
                    "\n무엇을 하시겠습니까?" +
                    "\n1.공격" +
                    "\n2.스킬" +
                    "\n3.아이템" +
                    "\n4.살펴보기" +
                    "\n→");
        }
    }
    public StringBuilder 몬스터목록(){
        StringBuilder 몬스터목록 = new StringBuilder();
        StringBuilder 몬스터목록2 = new StringBuilder();
        몬스터 타겟;
        몬스터스킬 스킬;
//        System.out.println("몬스터머릿수 : " + this.몬스터머릿수 + ", 죽은몬스터수 : " + this.죽은몬스터수);
        for(int i=1 ; i <= 몬스터어레이.size() ; i++) {
            타겟 = 몬스터어레이.get(i-1);
//            System.out.println(this.몬스터머릿수 + "-" + this.죽은몬스터수 + "i : " +i);
//            System.out.println("this.몬스터어레이.size() : " + this.몬스터어레이.size());
            if (몬스터어레이.get(i-1).현재체력 > 0) {
                몬스터목록2.append("│ "+타겟.이름+" (체력:" + 타겟.현재체력 + "/" + 타겟.최대체력 + ") │ 공격력: " + 타겟.공격력 + "+" + 타겟.추가공격력 + " │ 방어력: " + 타겟.방어력 + "+" + 타겟.추가방어력);
                if(몬스터어레이.get(i-1).지속스킬.size()>0){
                    몬스터목록2.append(" 지속중: ");
                    for(int j = 0; j < 타겟.지속스킬.size();j++) {
                        스킬 = 타겟.지속스킬.get(j);
                        몬스터목록2.append(스킬.스킬명+"("+(스킬.지속시간)+"턴) ");
                    }
                }
                몬스터목록2.append("\n");
            }
        }
        몬스터목록.append("\n┌────────────────────────────────────\n" ).append(몬스터목록2).append("└────────────────────────────────────\n");
        return 몬스터목록;
    }
    public StringBuilder 행동몬스터목록(){
        StringBuilder 몬스터목록 = new StringBuilder();
        StringBuilder 몬스터목록2 = new StringBuilder();
        몬스터 타겟;
        몬스터스킬 스킬;
        for(int i=1 ; i <= 몬스터어레이.size() ; i++) {
            타겟 = 몬스터어레이.get(i-1);
            if (몬스터어레이.get(i-1).현재체력 > 0) {
                몬스터목록2.append("│ "+i+ ". " +타겟.이름+" (체력:" + 타겟.현재체력 + "/" + 타겟.최대체력 + ") │ 공격력: " + 타겟.공격력 + "+" + 타겟.추가공격력 + " │ 방어력: " + 타겟.방어력 + "+" + 타겟.추가방어력);
                if(몬스터어레이.get(i-1).지속스킬.size()>0){
                    몬스터목록2.append(" 지속중: ");
                    for(int j = 0; j < 타겟.지속스킬.size();j++) {
                        스킬 = 타겟.지속스킬.get(j);
                        몬스터목록2.append(스킬.스킬명+"("+(스킬.지속시간)+"턴) ");
                    }
                }
                몬스터목록2.append("\n");
            }
        }
        몬스터목록.append("\n┌────────────────────────────────────\n" ).append("│ 0. 취소\n").append(몬스터목록2).append("└────────────────────────────────────\n");
        return 몬스터목록;
    }
}
