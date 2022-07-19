package java4;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

public class Practice4 {
    String 스트링;
    int 인트;

//    //16진수생성 예제 시작
//    private static String convert(byte[] bytes){
//        StringBuilder result = new StringBuilder();
//        for(byte temp : bytes){
//            result.append(String.format("%02x",temp));
//        }
//        return result.toString();
//    }
//    //16진수생성 예제 끝

    public static void main(String[] args) {
        Random rd = new Random();
        메인화면 메인=new 메인화면();
//        //16진수 생성 예제2 시작
//        byte[]arr = new byte[4];
//        new Random().nextBytes(arr);
//        System.out.println(convert(arr));
//        //16진수 생성 예제2 끝

        //랜덤 몬스터 뽑기 연습
//        몬스터 test = new 몬스터("섹스");

        String[] 몬스터종류배열 = {"슬라임","고블린","오크"};
        double 몬스터생성난수;
        int num;
        String 랜덤몬스터결과;
        //랜덤 몬스터 뽑기 연습 끝

        //몬스터 객체 생성 연습
        ArrayList<몬스터> 몬스터어레이 = new ArrayList<>();
        몬스터어레이.clear();
        String 몬스터번호;
        몬스터 몬스터정보;
        int 몬스터머릿수 = rd.nextInt(9)+1;
        int 죽은몬스터수 = 0;


        System.out.println("\n"+몬스터머릿수+"마리의 몬스터를 생성합니다.\n");

        for(int i = 1; i<=몬스터머릿수; i++){
            몬스터생성난수 = Math.random();
            num=(int)Math.floor(몬스터생성난수*몬스터종류배열.length);
            랜덤몬스터결과 = 몬스터종류배열[num];

            몬스터번호 = Integer.toString(i);
            몬스터정보 = new 몬스터(몬스터번호,랜덤몬스터결과);
            몬스터어레이.add(몬스터정보);
        }

        System.out.println(메인.몬스터목록(몬스터머릿수,몬스터어레이,죽은몬스터수));

        상점 상점=new 상점();

//        //상점초기화연습
//        for (int i = 0; i < 상점.리스트.size(); i++) {
//            System.out.println(상점.리스트.get(i).아이템이름);
//        }
//        ArrayList<String> 상점판매가능개수 = new ArrayList<>();
//
//        for(int i = 0 ; i<=상점.리스트.size()-1;i++){
//            if(상점.리스트.get(i).상점판매여부) {
//                상점판매가능개수.add(상점.리스트.get(i).아이템이름);
//            }
//        };
//        System.out.println("상점판매품목개수 : " + 상점판매가능개수.size()+"개");
//        //상점초기화연습끝



//        for(int i = 1; i<=몬스터머릿수; i++){
//
//            System.out.println("이름 : "+몬스터어레이.get(i-1).이름);
//            System.out.println("체력 : "+몬스터어레이.get(i-1).최대체력+"/"+몬스터어레이.get(i-1).현재체력);
//            System.out.println("공격력 : "+몬스터어레이.get(i-1).공격력);
//            System.out.println("");
//        }


        //몬스터 객체 생성 연습 끝



















    }





}
