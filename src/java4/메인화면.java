package java4;

import java.util.ArrayList;

public class 메인화면 { //화면에 표시하기 위한 메소드는 이곳에
    public String 능력치창(능력치 캐릭터){
        String 능력치표기="" +
                "\n┌──────────────────" +
                "\n│레벨: " + 캐릭터.캐릭터레벨 +
                "\n│소지금: "+캐릭터.소지금+ "골드" +
                "\n│체력: " + 캐릭터.캐릭터최종체력 + "/" + 캐릭터.캐릭터현재체력 +
                "\n│마나: " + 캐릭터.캐릭터최종마나 + "/" + 캐릭터.캐릭터현재마나 +
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

        //만약 회복물약 종류가 늘어난다면 이부분을 for문으로 바꿔야함
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
                    인벤토리표기2.append(캐릭터.소지품.get(i-1).아이템이름).append(" : ").append(캐릭터.소지품.get(i-1).스택수).append("개\n");
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
                    인벤토리표기2.append(i+2).append(".").append(캐릭터.소지품.get(i-1).아이템이름).append(" : ").append(캐릭터.소지품.get(i-1).스택수).append("개\n");
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
                        .append(" │ 공격력:").append(몬스터어레이.get(i - 1).공격력).append(" │ 방어력:").append(몬스터어레이.get(i - 1).방어력).append(")\n");
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
                        .append(" │ 공격력:").append(몬스터어레이.get(i - 1).공격력).append(" │ 방어력:").append(몬스터어레이.get(i - 1).방어력).append(")\n");
            }
        }
        몬스터목록.append("\n┌────────────────────────────────────\n" ).append("│0. 취소\n").append(몬스터목록2).append("└────────────────────────────────────\n");
        return 몬스터목록;
    }

    public StringBuilder 상점구매목록(능력치 캐릭터, 상점 상점){
        StringBuilder 구매목록표기 = new StringBuilder();
        구매목록표기.append("\n┌─상점품목(소지금:"+캐릭터.소지금+"골드)");
        for(int i = 1; i <= 상점.리스트.size(); i++){
            if(상점.리스트.get(i-1).상점판매여부){ //상점판매여부가 true면
                구매목록표기.append("\n│").append(상점.리스트.get(i-1).아이템이름).append(" (").append(상점.리스트.get(i-1).구매가격).append("골드)");
            }
        }
        구매목록표기.append("\n└──────────────────");
        return 구매목록표기;
    }
    public StringBuilder 행동상점구매목록(능력치 캐릭터, 상점 상점){
        StringBuilder 구매목록표기 = new StringBuilder();
        구매목록표기.append("" +
                "\n┌─상점품목(소지금:"+캐릭터.소지금+"골드)" +
                "\n│0.취소");
        for(int i = 1; i <= 상점.리스트.size(); i++){
            if(상점.리스트.get(i-1).상점판매여부){ //상점판매여부가 true면
                구매목록표기.append("\n│").append(i).append(".").append(상점.리스트.get(i-1).아이템이름).append(" (").append(상점.리스트.get(i-1).구매가격).append("골드)");
            }
        }
        return 구매목록표기;
    }
    public StringBuilder 행동상점판매목록(능력치 캐릭터){
        StringBuilder 판매목록표기 = new StringBuilder();
        판매목록표기.append("" +
                        "\n┌─인벤토리(소지금:"+캐릭터.소지금+"골드)"+
                        "\n│0.취소하기\n")
                .append("│1.").append(캐릭터.회복물약가방.get(0).아이템이름).append(" (").append(캐릭터.회복물약가방.get(0).판매가격).append("골드) : ").append(캐릭터.회복물약가방.get(0).스택수).append("개\n")
                .append("│2.").append(캐릭터.회복물약가방.get(1).아이템이름).append(" (").append(캐릭터.회복물약가방.get(1).판매가격).append("골드) : ").append(캐릭터.회복물약가방.get(1).스택수).append("개\n");
        for(int i=1 ; i <= 캐릭터.소지품.size() ; i++) {
            //고유번호가 0이 아닐때
            if(캐릭터.소지품.get(i-1).고유번호!=0) {
                //착용가능여부가 true일때
                //방패
                if(캐릭터.소지품.get(i-1).착용가능여부) {
                    판매목록표기.append("│").append(i+2).append(".").append(캐릭터.소지품.get(i - 1).아이템이름);
                    //착용가능여부가 true이고 착용여부가 true일때
                    if(캐릭터.소지품.get(i-1).착용여부){
                        판매목록표기.append("(착용중)\n");
                    }
                    else{
                        판매목록표기.append("\n");
                    }
                }
                //착용가능여부가 false이고 스택가능여부가 true일 때(스택수가 1이상일때 조건도 넣었었으나 스택수가 0이면 삭제하는 메소드를 따로 넣었으므로 삭제함.)
                else if(캐릭터.소지품.get(i-1).스택가능여부){
                    판매목록표기.append("│").append(i+2).append(".").append(캐릭터.소지품.get(i-1).아이템이름).append(" (").append(캐릭터.소지품.get(i-1).판매가격).append("골드) : ").append(캐릭터.소지품.get(i-1).스택수).append("개\n");
                }
                //착용가능여부가 false이고 스택가능여부가 false일때
                else if(!캐릭터.소지품.get(i-1).스택가능여부) {//현재 이런 아이템은 빈아이템 밖에 없음
                    판매목록표기.append("│").append(i+2).append(".").append(캐릭터.소지품.get(i-1).아이템이름).append(" (").append(캐릭터.소지품.get(i-1).판매가격).append("골드)").append("\n");
                }
            }
            else{ //빈 아이템을 목록에 표시하도록 하는 부분
                판매목록표기.append("│").append(i+2).append(".").append(캐릭터.소지품.get(i-1).아이템이름).append("\n");
            }
        }
        //아래는 인벤토리의 각각 항목과 스택수를 표시하는 부분으로, 판매메소드 완성 후 지우기
        for(int i=1 ; i <= 캐릭터.소지품.size() ; i++) {
            System.out.println("소지품창의 "+(i-1)+"번 항목 (이름: " + 캐릭터.소지품.get(i-1).아이템이름+", 스택수: "+캐릭터.소지품.get(i-1).스택수+")");

        }
        //위는 인벤토리의 각각 항목과 스택수를 표시하는 부분으로, 판매메소드 완성 후 지우기
        판매목록표기.append("└──────────────────");
        return 판매목록표기;
    }

    public StringBuilder 행동강화목록(능력치 캐릭터){
        StringBuilder 강화목록표기 = new StringBuilder();
        강화목록표기.append("" +
                "\n┌─인벤토리(소지금:"+캐릭터.소지금+"골드)"+
                "\n│0.취소하기\n");
        for(int i=0 ; i <=캐릭터.강화목록.size()-1 ; i++){
            //System.out.println("i : " + i);
            강화목록표기.append("│").append(i+1).append(".").append(캐릭터.강화목록.get(i).아이템이름);
            if(캐릭터.강화목록.get(i).착용여부){
                강화목록표기.append("(착용중)\n");
            }
            else{
                강화목록표기.append("\n");
            }
        }
        강화목록표기.append("└──────────────────");
        return 강화목록표기;
    }

    public StringBuilder 살펴보기(아이템 아이템) {
        StringBuilder 살펴보기표기 = new StringBuilder();
        if (아이템.아이템분류 == 1) { //아이템이 장비아이템이면
            살펴보기표기.append("\n" + 아이템.아이템이름 + "\n" +
                    아이템.아이템효과+"\n");
            if (아이템.추가체력 >= 1) { //선택한 아이템이 추가체력이 1 이상일 때
                살펴보기표기.append("추가 체력: " + 아이템.추가체력 + "\n");
            }
            if (아이템.추가마나 >= 1) {
                살펴보기표기.append("추가 마나: " + 아이템.추가마나 + "\n");
            }
            if (아이템.추가공격력 >= 1) {
                살펴보기표기.append("추가 공격력: " + 아이템.추가공격력 + "\n");
            }
            if (아이템.추가방어력 >= 1) {
                살펴보기표기.append("추가 방어력: " + 아이템.추가방어력 + "\n");
            }
            if (아이템.추가치확 >= 1) {
                살펴보기표기.append("추가 치명확률: " + 아이템.추가치확 + "\n");
            }
            if (아이템.추가치피 >= 1) {
                살펴보기표기.append("추가 치명피해: " + 아이템.추가치피 + "\n");
            }
        }
        else{ //장비아이템이 아니면
            살펴보기표기.append("\n" + 아이템.아이템이름 + "\n" +
                    아이템.아이템효과);
        }
        return 살펴보기표기;
    }
    public StringBuilder 장비살펴보기(아이템 아이템){
        StringBuilder 장비살펴보기표기 = new StringBuilder();
        장비살펴보기표기.append("\n" + 아이템.아이템이름 + "\n");
        if (아이템.추가체력 >= 1) { //선택한 아이템이 추가체력이 1 이상일 때
            장비살펴보기표기.append("추가 체력: " + 아이템.추가체력 + "\n");
        }
        if (아이템.추가마나 >= 1) {
            장비살펴보기표기.append("추가 마나: " + 아이템.추가마나 + "\n");
        }
        if (아이템.추가공격력 >= 1) {
            장비살펴보기표기.append("추가 공격력: " + 아이템.추가공격력 + "\n");
        }
        if (아이템.추가방어력 >= 1) {
            장비살펴보기표기.append("추가 방어력: " + 아이템.추가방어력 + "\n");
        }
        if (아이템.추가치확 >= 1) {
            장비살펴보기표기.append("추가 치명확률: " + 아이템.추가치확 + "\n");
        }
        if (아이템.추가치피 >= 1) {
            장비살펴보기표기.append("추가 치명피해: " + 아이템.추가치피 + "\n");
        }
        return 장비살펴보기표기;
    }



//"" +
//        "\n┌──────────────────" +
//        "\n│레벨: " + 캐릭터.캐릭터레벨 +
//            "\n│소지금: "+캐릭터.소지금+ "골드" +
//            "\n│체력: " + 캐릭터.캐릭터최대체력 + "/" + 캐릭터.캐릭터현재체력 +
//            "\n│마나: " + 캐릭터.캐릭터최대마나 + "/" + 캐릭터.캐릭터현재마나 +
//            "\n│공격력: " + 캐릭터.캐릭터공격력 + " +" + 캐릭터.캐릭터추가공격력 +
//            "\n│방어력: " + 캐릭터.캐릭터방어력 + " +" + 캐릭터.캐릭터추가방어력 +
//            "\n│치명확률: " + 캐릭터.캐릭터치명확률 + "%" +
//            "\n│치명피해: " + 캐릭터.캐릭터치명피해 + "%" +
//            "\n│회피율: " + 캐릭터.캐릭터회피 +
//            "\n└──────────────────";




    //아이디용 16진수 난수 생성
    public static String convert(byte[] bytes){
        StringBuilder result = new StringBuilder();
        for(byte temp : bytes){
            result.append(String.format("%02x",temp));
        }
        return result.toString();
    }



}
