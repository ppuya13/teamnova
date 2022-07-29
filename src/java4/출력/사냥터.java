package java4.출력;

import java4.몬스터;
import java4.아이템;

import java.util.ArrayList;
import java.util.Random;

public class 사냥터 extends 출력 {

    public ArrayList<몬스터> 몬스터어레이 = new ArrayList<>();
    public int 몬스터머릿수;
    public int 죽은몬스터수;
    String 몬스터번호; // 각 몬스터마다 고유 번호
    몬스터 몬스터정보; // 몬스터의 이름과 능력치가 들어있음
    String[] 몬스터종류배열 = {"슬라임","고블린","오크"};
    double 몬스터생성난수;
    ArrayList<아이템> 드랍템 = new ArrayList<>();
    아이템 드랍아이템;
    int num;
    int 몬스터난수;
    int 경험치허브 = 0;
    int 소지금허브 = 0;
    String 랜덤몬스터결과;
    Random rd = new Random();


    public void 사냥터메인() {
        System.out.print(""+
                "\n몬스터를 사냥하러 왔습니다. 무엇을 하시겠습니까?"+
                "\n0.마을로 돌아가기"+
                "\n1.몬스터 탐색"+
                "\n2.인벤토리"+
                "\n3.휴식"+
                "\n→");
    }

    public void 사냥터행동(){
        System.out.print("" +
//                        몬스터머릿수+죽은몬스터수 +"\n"+
                (몬스터머릿수 - 죽은몬스터수) + "마리의 몬스터가 살아있습니다." +
                "\n무엇을 하시겠습니까?" +
                "\n1.공격" +
                "\n2.스킬" +
                "\n3.아이템" +
                "\n4.살펴보기" +
                "\n5.도망치기" +
                "\n→");
    }
    public void 공격선택(){

    }

    public void 몬스터생성() throws InterruptedException {
        몬스터어레이.clear();
        몬스터머릿수 = rd.nextInt(9)+1;
        System.out.println(몬스터머릿수 + "마리의 몬스터를 발견했다!!!");
        Thread.sleep(1000);

        for (int i = 1; i <= 몬스터머릿수; i++) {
            몬스터생성난수 = Math.random();
            num = (int) Math.floor(몬스터생성난수 * 몬스터종류배열.length);
            랜덤몬스터결과 = 몬스터종류배열[num];

            몬스터번호 = Integer.toString(i);
            몬스터정보 = new 몬스터(몬스터번호, 랜덤몬스터결과);
            몬스터어레이.add(몬스터정보);
        }
    }

    public StringBuilder 몬스터목록(){
        StringBuilder 몬스터목록 = new StringBuilder();
        StringBuilder 몬스터목록2 = new StringBuilder();
        for(int i=1 ; i <= 몬스터머릿수-죽은몬스터수 ; i++) {
            if (몬스터어레이.get(i-1).현재체력 > 0) {
                몬스터목록2.append("│ ").append(몬스터어레이.get(i - 1).이름).append(" (체력:").append(몬스터어레이.get(i - 1).현재체력).append("/").append(몬스터어레이.get(i - 1).최대체력)
                        .append(" │ 공격력:").append(몬스터어레이.get(i - 1).공격력).append(" │ 방어력:").append(몬스터어레이.get(i - 1).방어력).append(")\n");
            }
        }
        몬스터목록.append("\n┌────────────────────────────────────\n" ).append(몬스터목록2).append("└────────────────────────────────────\n");
        return 몬스터목록;
    }

    public StringBuilder 행동몬스터목록(){
        StringBuilder 몬스터목록 = new StringBuilder();
        StringBuilder 몬스터목록2 = new StringBuilder();
        for(int i=1 ; i <= 몬스터머릿수-죽은몬스터수 ; i++) {
            if (몬스터어레이.get(i-1).현재체력 > 0) {
                몬스터목록2.append("│").append(i).append(". ").append(몬스터어레이.get(i - 1).이름).append(" (체력:").append(몬스터어레이.get(i - 1).현재체력).append("/").append(몬스터어레이.get(i - 1).최대체력)
                        .append(" │ 공격력:").append(몬스터어레이.get(i - 1).공격력).append(" │ 방어력:").append(몬스터어레이.get(i - 1).방어력).append(")\n");
            }
        }
        몬스터목록.append("\n┌────────────────────────────────────\n" ).append("│0. 취소\n").append(몬스터목록2).append("└────────────────────────────────────\n");
        return 몬스터목록;
    }

    public void 몬스터삭제(boolean 몬스터삭제, 몬스터 몬스터타겟) throws InterruptedException {
        while (몬스터삭제) {
//                    System.out.println("몬스터삭제 while문 시작");
//                    System.out.println(몬스터어레이.size());
            if(몬스터어레이.size()==0){ //몬스터어레이의 크기가 0이면 바로 나감
                몬스터삭제=false;
            }
            else{ //몬스터어레이의 크기가 0이 아니면 몬스터 삭제 시작
                for (int i = 0; i < 몬스터어레이.size(); i++) {//전체공격에 대응하기 위해 for문을 사용하여 체력이 0이 된 몬스터들을 한마리씩 찾아서 없앰
//                            System.out.println("몬스터어레이의 " + i + "번째 몬스터 이름 : " + 몬스터어레이.get(i).이름 + ", 체력 : " + 몬스터어레이.get(i).현재체력 + "어레이 길이 : " + 몬스터어레이.size());
//                                System.out.println("몬스터삭제 실행");
                    if (몬스터어레이.get(i).현재체력 <= 0) { //몬스터어레이에 체력이 0이하인 몬스터가 있으면
                        //이 아래에 몬스터가 죽었을 경우 일어나는 일을 코딩

                        //아이템 드랍 시작
                        for(int j = 0 ; j < 몬스터어레이.get(i).드랍테이블.size() ; j++){ //해당 몬스터의 드랍테이블의 사이즈만큼 반복
                            몬스터난수 = rd.nextInt(100); //0~99
//                                        System.out.println("난수 : " + 몬스터난수 + ", 드랍테이블의 드랍률 : "+몬스터어레이.get(i).드랍테이블.get(j).드랍률);
                            if(몬스터난수<몬스터어레이.get(i).드랍테이블.get(j).드랍률){ //드랍률이 10이면 0~9까지가 성공
                                System.out.println("" + 몬스터어레이.get(i).이름 + "이(가) 쓰러지며 " + 몬스터어레이.get(i).드랍테이블.get(j).아이템이름 + "을(를) 남겼다.");
                                드랍아이템 = new 아이템(몬스터어레이.get(i).드랍테이블.get(j).고유번호); //난수판정이 성공한 아이템과 동일한 아이템을 새로운 객체로 생성
                                드랍템.add(드랍아이템); //생성한 아이템을 드랍템 어레이에 넣음
                            }
                        }
                        //아이템 드랍 끝
                        경험치허브 = 경험치허브 + 몬스터어레이.get(i).경험치;
                        소지금허브 = 소지금허브 + 몬스터어레이.get(i).소지금;
                        System.out.println(몬스터어레이.get(i).이름+"이(가)"+몬스터어레이.get(i).소지금+"골드를 떨어뜨렸다.");
                        System.out.println("전투 승리 시 받을 경험치가 " + 몬스터어레이.get(i).경험치 + " 늘어 " + 경험치허브 + "이(가) 되었다.");
                        Thread.sleep(1000);
                        System.out.println("");
                        몬스터어레이.remove(i); //몬스터어레이에서 몬스터를 삭제
                        죽은몬스터수 = 죽은몬스터수 + 1; //전투종료를 위해 죽은몬스터수를 늘림(근데 그냥 전투종료 조건을 몬스터어레이가 0이면으로 바꾸는 것도 고려해보기)
                        break;
                    }
                    if(i==몬스터어레이.size()-1){ //몬스터어레이에 체력이 0이하인 몬스터가 없으면
//                                System.out.println("몬스터어레이와 i의 값이 같아졌으므로 몬스터삭제를 false로 함.");
                        몬스터삭제=false;
                    }
                }
            }
//            아이템정보 = null; //다른데서 쓰던 변수를 가져온거라 밖에서 널참조를 하면 에러가 날 수도 있으니 안에서 실행(선언도 안에서하고 안에서만 사용함)
        }
    }



}
