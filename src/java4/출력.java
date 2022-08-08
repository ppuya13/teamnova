package java4;

import java4.사냥터.몬스터.몬스터;
import java4.스킬.스킬;
import java4.상점.상점;
import java4.아이템.아이템;

import java.util.ArrayList;

import static java4.Main.플레이어;

public class 출력 { //화면에 표시하기 위한 메소드는 이곳에

    public StringBuilder 능력치창(){
        boolean 소모템있음 = false;
        아이템 아이템;
        StringBuilder 능력치표기 = new StringBuilder("" +
                "\n┌──────────────────" +
                "\n│레벨: " + 플레이어.캐릭터레벨 + " (" + 플레이어.캐릭터현재경험치 + "/" + 플레이어.캐릭터최대경험치 + ")" +
                "\n│소지금: "+ 플레이어.소지금+ "골드" +
                "\n│체력: " + 플레이어.캐릭터현재체력 + "/" + 플레이어.캐릭터최종체력 +
                "\n│마나: " + 플레이어.캐릭터현재마나 + "/" + 플레이어.캐릭터최종마나 +
                "\n│공격력: " + 플레이어.캐릭터공격력 + " +" + 플레이어.캐릭터추가공격력 +
                "\n│방어력: " + 플레이어.캐릭터방어력 + " +" + 플레이어.캐릭터추가방어력 +
                "\n│치명확률: " + 플레이어.캐릭터최종치확 + "%" +
                "\n│치명피해: " + 플레이어.캐릭터최종치피 + "%" +
                "\n│회피율: " + 플레이어.캐릭터최종회피 + "%" +
                "\n└──────────────────");
        if(플레이어.사용중.size()>=1){ //적용중인 소모템이 있으면
            for(int i = 0; i < 플레이어.사용중.size() ; i++){
                아이템 = 플레이어.사용중.get(i);
                if((아이템.선적용 && 아이템.지속시간>=2) || (!아이템.선적용 && 아이템.지속시간>=0)){//(선적용템이고 지속시간이 1이상이거나) (후적용템이고 지속시간이 0이상이면) 표기
                    소모템있음=true;
                }
            }
            if(소모템있음) { //앞에 조건에 맞는 템이 하나라도 있으면
                능력치표기.append("" +
                        "\n┌──적용 중인 소모아이템");
                for(int i = 0; i < 플레이어.사용중.size() ; i++){
                    아이템 = 플레이어.사용중.get(i);
                    if(아이템.선적용) {
                        if (아이템.지속시간 >= 2) { //해당 아이템이 선적용이고 지속시간이 1이상이라면
                            능력치표기.append("\n│" + 아이템.사용중 + "(남은 지속시간 : " + (아이템.지속시간-1) + "턴)");
                        }
                    }
                    else{
                        if (아이템.지속시간 >= 0){ //해당 아이템이 후적용이고 지속시간이 0이상이라면
                            능력치표기.append("\n│" + 아이템.사용중 + "(남은 지속시간 : " + (아이템.지속시간) + "턴)");
                        }
                    }
                }
                능력치표기.append("\n└──────────────────");
            }
        }
//        능력치표기.append("\n메인화면.능력치창 | 캐릭터최종공격력 : " + 캐릭터.캐릭터최종공격력);
//        능력치표기.append("\n메인화면.능력치창 | 캐릭터최종방어력 : " + 캐릭터.캐릭터최종방어력);
        return 능력치표기;
    }

    public StringBuilder 인벤토리(){
        StringBuilder 인벤토리표기2=new StringBuilder();

        //만약 회복물약 종류가 늘어난다면 이부분을 for문으로 바꿔야함
        인벤토리표기2.append(플레이어.회복물약가방.get(0).아이템이름).append(" : ").append(플레이어.회복물약가방.get(0).스택수).append("개\n")
                .append(플레이어.회복물약가방.get(1).아이템이름).append(" : ").append(플레이어.회복물약가방.get(1).스택수).append("개\n");
        for(int i = 1; i <= 플레이어.소지품.size() ; i++) {
            //고유번호가 0이 아닐때
            if(플레이어.소지품.get(i-1).고유번호!=0) {
                //착용가능여부가 true일때
                //방패
                if(플레이어.소지품.get(i-1).착용가능여부) {
                    인벤토리표기2.append(플레이어.소지품.get(i - 1).아이템이름);
                    //착용가능여부가 true이고 착용여부가 true일때
                    if(플레이어.소지품.get(i-1).착용여부){
                        인벤토리표기2.append("(착용중)\n");
                    }
                    else{
                        인벤토리표기2.append("\n");
                    }
                }
                //착용가능여부가 false이고 스택가능여부가 true이며 스택이 1이상일때
                else if(플레이어.소지품.get(i-1).스택가능여부&& 플레이어.소지품.get(i-1).스택수>=1){
                    인벤토리표기2.append(플레이어.소지품.get(i-1).아이템이름).append(" : ").append(플레이어.소지품.get(i-1).스택수).append("개\n");
                }
                //착용가능여부가 false이고 스택가능여부가 false일때
                else if(!플레이어.소지품.get(i-1).스택가능여부) {//현재 이런 아이템은 빈아이템 밖에 없음
                    인벤토리표기2.append(플레이어.소지품.get(i-1).아이템이름).append("\n");
                }
            }
            else{ //빈 아이템을 목록에 표시하도록 하는 부분
                인벤토리표기2.append(플레이어.소지품.get(i-1).아이템이름).append("\n");
            }
        }
//        인벤토리표기2.append("끝");

        return 인벤토리표기2;
    }

    public StringBuilder 행동인벤토리(){
        StringBuilder 인벤토리표기2=new StringBuilder();

        인벤토리표기2.append("0.취소하기\n")
                .append("1.").append(플레이어.회복물약가방.get(0).아이템이름).append(" : ").append(플레이어.회복물약가방.get(0).스택수).append("개\n")
                .append("2.").append(플레이어.회복물약가방.get(1).아이템이름).append(" : ").append(플레이어.회복물약가방.get(1).스택수).append("개\n");
        for(int i = 1; i <= 플레이어.소지품.size() ; i++) {
            //고유번호가 0이 아닐때
            if(플레이어.소지품.get(i-1).고유번호!=0) {
                //착용가능여부가 true일때
                //방패
                if(플레이어.소지품.get(i-1).착용가능여부) {
                    인벤토리표기2.append(i+2).append(".").append(플레이어.소지품.get(i - 1).아이템이름);
                    //착용가능여부가 true이고 착용여부가 true일때
                    if(플레이어.소지품.get(i-1).착용여부){
                        인벤토리표기2.append("(착용중)\n");
                    }
                    else{
                        인벤토리표기2.append("\n");
                    }
                }
                //착용가능여부가 false이고 스택가능여부가 true이며 스택이 1이상일때
                else if(플레이어.소지품.get(i-1).스택가능여부&& 플레이어.소지품.get(i-1).스택수>=1){
                    인벤토리표기2.append(i+2).append(".").append(플레이어.소지품.get(i-1).아이템이름).append(" : ").append(플레이어.소지품.get(i-1).스택수).append("개\n");
                }
                //착용가능여부가 false이고 스택가능여부가 false일때
                else if(!플레이어.소지품.get(i-1).스택가능여부) {//현재 이런 아이템은 빈아이템 밖에 없음
                    인벤토리표기2.append(i+2).append(".").append(플레이어.소지품.get(i-1).아이템이름).append("\n");
                }
            }
            else{ //빈 아이템을 목록에 표시하도록 하는 부분
                인벤토리표기2.append(i+2).append(".").append(플레이어.소지품.get(i-1).아이템이름).append("\n");
            }
        }
//        인벤토리표기2.append("끝");

        return 인벤토리표기2;
    }

    public StringBuilder 상점구매목록(상점 상점){
        StringBuilder 구매목록표기 = new StringBuilder();
        구매목록표기.append("\n┌─상점품목(소지금:"+ 플레이어.소지금+"골드)");
        for(int i = 1; i <= 상점.리스트.size(); i++){
            if(상점.리스트.get(i-1).상점판매여부){ //상점판매여부가 true면
                구매목록표기.append("\n│").append(상점.리스트.get(i-1).아이템이름).append(" (").append(상점.리스트.get(i-1).구매가격).append("골드)");
            }
        }
        구매목록표기.append("\n└──────────────────");
        return 구매목록표기;
    }

    public StringBuilder 행동상점구매목록(상점 상점){
        StringBuilder 구매목록표기 = new StringBuilder();
        구매목록표기.append("" +
                "\n┌─상점품목(소지금:"+ 플레이어.소지금+"골드)" +
                "\n│0.취소");
        for(int i = 1; i <= 상점.리스트.size(); i++){
            if(상점.리스트.get(i-1).상점판매여부){ //상점판매여부가 true면
                구매목록표기.append("\n│").append(i).append(".").append(상점.리스트.get(i-1).아이템이름).append(" (").append(상점.리스트.get(i-1).구매가격).append("골드)");
            }
        }
        return 구매목록표기;
    }

    public StringBuilder 행동상점판매목록(){
        StringBuilder 판매목록표기 = new StringBuilder();
        판매목록표기.append("" +
                        "\n┌─인벤토리(소지금:"+ 플레이어.소지금+"골드)"+
                        "\n│0.취소하기\n")
                .append("│1.").append(플레이어.회복물약가방.get(0).아이템이름).append(" (").append(플레이어.회복물약가방.get(0).판매가격).append("골드) : ").append(플레이어.회복물약가방.get(0).스택수).append("개\n")
                .append("│2.").append(플레이어.회복물약가방.get(1).아이템이름).append(" (").append(플레이어.회복물약가방.get(1).판매가격).append("골드) : ").append(플레이어.회복물약가방.get(1).스택수).append("개\n");
        for(int i = 1; i <= 플레이어.소지품.size() ; i++) {
            //고유번호가 0이 아닐때
            if(플레이어.소지품.get(i-1).고유번호!=0) {
                //착용가능여부가 true일때
                //방패
                if(플레이어.소지품.get(i-1).착용가능여부) {
                    판매목록표기.append("│").append(i+2).append(".").append(플레이어.소지품.get(i - 1).아이템이름);
                    //착용가능여부가 true이고 착용여부가 true일때
                    if(플레이어.소지품.get(i-1).착용여부){
                        판매목록표기.append("(착용중)\n");
                    }
                    else{
                        판매목록표기.append("\n");
                    }
                }
                //착용가능여부가 false이고 스택가능여부가 true일 때(스택수가 1이상일때 조건도 넣었었으나 스택수가 0이면 삭제하는 메소드를 따로 넣었으므로 삭제함.)
                else if(플레이어.소지품.get(i-1).스택가능여부){
                    판매목록표기.append("│").append(i+2).append(".").append(플레이어.소지품.get(i-1).아이템이름).append(" (").append(플레이어.소지품.get(i-1).판매가격).append("골드) : ").append(플레이어.소지품.get(i-1).스택수).append("개\n");
                }
                //착용가능여부가 false이고 스택가능여부가 false일때
                else if(!플레이어.소지품.get(i-1).스택가능여부) {//현재 이런 아이템은 빈아이템 밖에 없음
                    판매목록표기.append("│").append(i+2).append(".").append(플레이어.소지품.get(i-1).아이템이름).append(" (").append(플레이어.소지품.get(i-1).판매가격).append("골드)").append("\n");
                }
            }
            else{ //빈 아이템을 목록에 표시하도록 하는 부분
                판매목록표기.append("│").append(i+2).append(".").append(플레이어.소지품.get(i-1).아이템이름).append("\n");
            }
        }
//        //아래는 인벤토리의 각각 항목과 스택수를 표시하는 부분으로, 판매메소드 완성 후 지우기
//        for(int i=1 ; i <= 캐릭터.소지품.size() ; i++) {
//            System.out.println("소지품창의 "+(i-1)+"번 항목 (이름: " + 캐릭터.소지품.get(i-1).아이템이름+", 스택수: "+캐릭터.소지품.get(i-1).스택수+")");
//
//        }
//        //위는 인벤토리의 각각 항목과 스택수를 표시하는 부분으로, 판매메소드 완성 후 지우기
        판매목록표기.append("└──────────────────");
        return 판매목록표기;
    }

    public StringBuilder 행동강화목록(){
        StringBuilder 강화목록표기 = new StringBuilder();
        강화목록표기.append("" +
                "\n┌─인벤토리(소지금:"+ 플레이어.소지금+"골드)"+
                "\n│0.취소하기\n");
        for(int i = 0; i <= 플레이어.강화목록.size()-1 ; i++){
            //System.out.println("i : " + i);
            강화목록표기.append("│").append(i+1).append(".").append(플레이어.강화목록.get(i).아이템이름);
            if(플레이어.강화목록.get(i).착용여부){
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
            if (아이템.추가회피 >= 1) {
                살펴보기표기.append("추가 회피율: " + 아이템.추가회피 + "\n");
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
        장비살펴보기표기.append("\n" + 아이템.아이템이름 +
                "\n"+아이템.아이템효과+"\n");
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
        if (아이템.추가회피 >= 1) {
            장비살펴보기표기.append("추가 회피율: " + 아이템.추가회피 + "\n");
        }
        return 장비살펴보기표기;
    }

    public String 정보출력(몬스터 타겟){
        //굳이 메소드 쓸 필요 없을 것 같음.
        String 출력값 = "" +
                "\n이름 : " + 타겟.이름 +
                "\n체력 : " + 타겟.최대체력 + "/" + 타겟.현재체력 +
                "\n공격력 : " + 타겟.공격력 + " + " + 타겟.추가공격력 +
                "\n방어력 : " + 타겟.방어력 + " + " + 타겟.추가방어력 +
                "\n몬스터 정보 : " + 타겟.정보 +
                "";
        return 출력값;
     }

    public StringBuilder 스킬창(){
        StringBuilder 스킬창 = new StringBuilder();
        스킬창.append("0.뒤로간다.");
        for(int i = 0; i < 플레이어.스킬목록.size() ; i++){
            스킬 스킬 = 플레이어.스킬목록.get(i);
            스킬창.append("\n" + (i+1) + "." + 스킬.스킬명 + "(마나 "+ 스킬.소모량 + ") : " + 스킬.효과);
        }
        return 스킬창;
    }

    public void 엔딩() throws InterruptedException {
        boolean 착용템있음=false;
        ArrayList<아이템> 착용목록 = new ArrayList<>();
        StringBuilder 착용템표기 = new StringBuilder();
        아이템 아이템;

        StringBuilder 엔딩 = new StringBuilder();
        Thread.sleep(2000);
        System.out.println("게임 클리어!");
        Thread.sleep(1000);
        System.out.print("인카운터 조우 횟수: ");
        Thread.sleep(1000);
        System.out.println(플레이어.전투횟수 + "회");
        Thread.sleep(1000);
        System.out.print("전투 승리 횟수: ");
        Thread.sleep(1000);
        System.out.println(플레이어.전투승리횟수 + "회");
        Thread.sleep(1000);
        System.out.print("총 얻은 경험치: ");
        Thread.sleep(1000);
        System.out.println(플레이어.획득경험치);
        Thread.sleep(1000);
        System.out.println("착용 중인 아이템: ");
        Thread.sleep(1000);
        if(플레이어.소지품==null){//소지품창이 비어있으면
            System.out.println("없음");
        }else{//소지품창에 뭔가 있으면
            for(int i = 0 ; i < 플레이어.소지품.size() ; i++){
                if(플레이어.소지품.get(i).착용여부){//착용한 템이 있으면
                    착용템있음=true;
                    break;
                }
            }
            if(!착용템있음){//소지품창에 뭔가 있지만 착용한 템이 없으면
                System.out.println("없음");
            }
            else {//착용한 템이 있으면
                for(int i = 0 ; i < 플레이어.소지품.size() ; i++){
                    if(플레이어.소지품.get(i).착용여부){ //선택된 템이 착용한템이면
                        착용목록.add(플레이어.소지품.get(i)); //해당 아이템을 착용목록에 넣음
                    }
                }
                for(int i = 0; i < 착용목록.size() ; i++){
                    아이템 = 착용목록.get(i);
                    착용템표기.append("\n" + 아이템.아이템이름 +
                            "\n"+아이템.아이템효과+"\n");
                    if (아이템.추가체력 >= 1) { //선택한 아이템이 추가체력이 1 이상일 때
                        착용템표기.append("추가 체력: " + 아이템.추가체력 + "\n");
                    }
                    if (아이템.추가마나 >= 1) {
                        착용템표기.append("추가 마나: " + 아이템.추가마나 + "\n");
                    }
                    if (아이템.추가공격력 >= 1) {
                        착용템표기.append("추가 공격력: " + 아이템.추가공격력 + "\n");
                    }
                    if (아이템.추가방어력 >= 1) {
                        착용템표기.append("추가 방어력: " + 아이템.추가방어력 + "\n");
                    }
                    if (아이템.추가치확 >= 1) {
                        착용템표기.append("추가 치명확률: " + 아이템.추가치확 + "\n");
                    }
                    if (아이템.추가치피 >= 1) {
                        착용템표기.append("추가 치명피해: " + 아이템.추가치피 + "\n");
                    }
                    if (아이템.추가회피 >= 1) {
                        착용템표기.append("추가 회피율: " + 아이템.추가회피 + "\n");
                    }
                    System.out.println(착용템표기 + "\n");
                    Thread.sleep(1000);
                    착용템표기.setLength(0);
                }
            }
        }
        System.out.print("최종 능력치: ");
        Thread.sleep(1000);
        System.out.println(능력치창());
        Thread.sleep(2000);

        System.out.println("플레이해 주셔서 감사합니다!");
        Thread.sleep(2000);
        System.exit(0);
    }






    //아이디용 16진수 난수 생성
//    public static String convert(byte[] bytes){
//        StringBuilder result = new StringBuilder();
//        for(byte temp : bytes){
//            result.append(String.format("%02x",temp));
//        }
//        return result.toString();
//    }



}
