package java4;

import java.util.ArrayList;

public class 메인화면 { //화면에 표시하기 위한 메소드는 이곳에
    public String 능력치창(능력치 캐릭터){
        String 능력치표기="" +
                "\n┌──────────────────" +
                "\n│레벨: " + 캐릭터.캐릭터레벨 +
                "\n│소지금: "+캐릭터.소지금+ "골드" +
                "\n│체력: " + 캐릭터.캐릭터최대체력 + "/" + 캐릭터.캐릭터현재체력 +
                "\n│마나: " + 캐릭터.캐릭터최대마나 + "/" + 캐릭터.캐릭터현재마나 +
                "\n│공격력: " + 캐릭터.캐릭터공격력 + " +" + 캐릭터.캐릭터추가공격력 +
                "\n│방어력: " + 캐릭터.캐릭터방어력 + " +" + 캐릭터.캐릭터추가방어력 +
                "\n│치명확률: " + 캐릭터.캐릭터치명확률 + "%" +
                "\n│치명피해: " + 캐릭터.캐릭터치명피해 + "%" +
                "\n│회피율: " + 캐릭터.캐릭터회피 +
                "\n└──────────────────";
        return 능력치표기;
    }

    public StringBuilder 인벤토리(능력치 캐릭터){
        StringBuilder 인벤토리표기2=new StringBuilder();

        인벤토리표기2.append(캐릭터.회복물약가방.get(0).아이템이름).append(" : ").append(캐릭터.회복물약가방.get(0).스택수).append("개\n")
                .append(캐릭터.회복물약가방.get(1).아이템이름).append(" : ").append(캐릭터.회복물약가방.get(1).스택수).append("개\n");
        for(int i=1 ; i <= 캐릭터.소지품.size() ; i++) {
            //고유번호가 0이 아닐때
            if(캐릭터.소지품.get(i-1).고유번호!=0) {
                //착용가능여부가 true일때
                //방패
                if(캐릭터.소지품.get(i-1).착용가능여부) {
                    인벤토리표기2.append(캐릭터.소지품.get(i - 1).아이템이름);
                    //착용가능여부가 true이고 착용여부가 true일때
                    if(캐릭터.소지품.get(i-1).착용여부){
                        인벤토리표기2.append("(착용중)\n");
                    }
                    else{
                        인벤토리표기2.append("\n");
                    }
                }
                //착용가능여부가 false이고 스택가능여부가 true이며 스택이 1이상일때
                else if(캐릭터.소지품.get(i-1).스택가능여부&&캐릭터.소지품.get(i-1).스택수>=1){
                    인벤토리표기2.append(캐릭터.소지품.get(i-1).아이템이름).append(" ").append(캐릭터.소지품.get(i-1).스택수).append("개\n");
                }
                //착용가능여부가 false이고 스택가능여부가 false일때
                else if(!캐릭터.소지품.get(i-1).스택가능여부) {//현재 이런 아이템은 빈아이템 밖에 없음
                    인벤토리표기2.append(캐릭터.소지품.get(i-1).아이템이름).append("\n");
                }
            }
            else{ //빈 아이템을 목록에 표시하도록 하는 부분
                인벤토리표기2.append(캐릭터.소지품.get(i-1).아이템이름).append("\n");
            }
        }
//        인벤토리표기2.append("끝");

        return 인벤토리표기2;
    }

    public StringBuilder 행동인벤토리(능력치 캐릭터){
        StringBuilder 인벤토리표기2=new StringBuilder();

        인벤토리표기2.append("0.취소하기\n")
                .append("1.").append(캐릭터.회복물약가방.get(0).아이템이름).append(" : ").append(캐릭터.회복물약가방.get(0).스택수).append("개\n")
                .append("2.").append(캐릭터.회복물약가방.get(1).아이템이름).append(" : ").append(캐릭터.회복물약가방.get(1).스택수).append("개\n");
        for(int i=1 ; i <= 캐릭터.소지품.size() ; i++) {
            //고유번호가 0이 아닐때
            if(캐릭터.소지품.get(i-1).고유번호!=0) {
                //착용가능여부가 true일때
                //방패
                if(캐릭터.소지품.get(i-1).착용가능여부) {
                    인벤토리표기2.append(i+2).append(".").append(캐릭터.소지품.get(i - 1).아이템이름);
                    //착용가능여부가 true이고 착용여부가 true일때
                    if(캐릭터.소지품.get(i-1).착용여부){
                        인벤토리표기2.append("(착용중)\n");
                    }
                    else{
                        인벤토리표기2.append("\n");
                    }
                }
                //착용가능여부가 false이고 스택가능여부가 true이며 스택이 1이상일때
                else if(캐릭터.소지품.get(i-1).스택가능여부&&캐릭터.소지품.get(i-1).스택수>=1){
                    인벤토리표기2.append(i+2).append(".").append(캐릭터.소지품.get(i-1).아이템이름).append(" ").append(캐릭터.소지품.get(i-1).스택수).append("개\n");
                }
                //착용가능여부가 false이고 스택가능여부가 false일때
                else if(!캐릭터.소지품.get(i-1).스택가능여부) {//현재 이런 아이템은 빈아이템 밖에 없음
                    인벤토리표기2.append(i+2).append(".").append(캐릭터.소지품.get(i-1).아이템이름).append("\n");
                }
            }
            else{ //빈 아이템을 목록에 표시하도록 하는 부분
                인벤토리표기2.append(i+2).append(".").append(캐릭터.소지품.get(i-1).아이템이름).append("\n");
            }
        }
//        인벤토리표기2.append("끝");

        return 인벤토리표기2;
    }

    public StringBuilder 몬스터목록(int 몬스터머릿수, ArrayList<몬스터> 몬스터어레이, int 죽은몬스터수){
        StringBuilder 몬스터목록 = new StringBuilder();
        StringBuilder 몬스터목록2 = new StringBuilder();
        for(int i=1 ; i <= 몬스터머릿수-죽은몬스터수 ; i++) {
            if (몬스터어레이.get(i-1).현재체력 > -2) {
                몬스터목록2.append("│ ").append(몬스터어레이.get(i - 1).이름).append(" (체력:").append(몬스터어레이.get(i - 1).최대체력).append("/").append(몬스터어레이.get(i - 1).현재체력)
                        .append(" | 공격력:").append(몬스터어레이.get(i - 1).공격력).append(" | 방어력:").append(몬스터어레이.get(i - 1).방어력).append(")\n");
            }
        }
        몬스터목록.append("\n┌────────────────────────────────────\n" ).append(몬스터목록2).append("└────────────────────────────────────\n");
        return 몬스터목록;
    }
    public StringBuilder 행동몬스터목록(int 몬스터머릿수, ArrayList<몬스터> 몬스터어레이, int 죽은몬스터수){
        StringBuilder 몬스터목록 = new StringBuilder();
        StringBuilder 몬스터목록2 = new StringBuilder();
        for(int i=1 ; i <= 몬스터머릿수-죽은몬스터수 ; i++) {
            if (몬스터어레이.get(i-1).현재체력 > -2) {
                몬스터목록2.append("│").append(i).append(". ").append(몬스터어레이.get(i - 1).이름).append(" (체력:").append(몬스터어레이.get(i - 1).최대체력).append("/").append(몬스터어레이.get(i - 1).현재체력)
                        .append(" | 공격력:").append(몬스터어레이.get(i - 1).공격력).append(" | 방어력:").append(몬스터어레이.get(i - 1).방어력).append(")\n");
            }
        }
        몬스터목록.append("\n┌────────────────────────────────────\n" ).append("│0. 취소\n").append(몬스터목록2).append("└────────────────────────────────────\n");
        return 몬스터목록;
    }






    //아이디용 16진수 난수 생성
    public static String convert(byte[] bytes){
        StringBuilder result = new StringBuilder();
        for(byte temp : bytes){
            result.append(String.format("%02x",temp));
        }
        return result.toString();
    }



}
