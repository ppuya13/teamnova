package 연습;

import java4.Main;
import java4.사냥터.몬스터.고블린.고블린궁수;
import java4.사냥터.몬스터.고블린.고블린전사;
import java4.사냥터.몬스터.고블린.보물고블린;
import java4.사냥터.몬스터.몬스터;
import java4.사냥터.몬스터.스킬.몬스터스킬;
import java4.사냥터.몬스터.슬라임.빨간슬라임;
import java4.사냥터.몬스터.슬라임.초록슬라임;
import java4.사냥터.몬스터.오크.오크전사;
import java4.사냥터.몬스터.오크.오크주술사;
import java4.아이템.소모.지속형.공격력물약;
import java4.아이템.아이템;
import java4.캐릭터.캐릭터;
import java4.캐릭터.플레이어;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.Callable;

public class 연습용클래스 {
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

    static int 공유변수 = 10; //이런식으로 스태틱으로 변수를 선언하면 모든 스레드에서 사용할 수 있음.
    public static void main(String[] args) throws InterruptedException {
        int 몬스터머릿수=0;
        Scanner sc = new Scanner(System.in);
        int 입력=1;
        String 몬스터번호;
        double 몬스터생성난수;
        int num;
        String[] 몬스터종류배열 = {"슬라임","고블린","오크"};
        String 랜덤몬스터결과;
        Random rd = new Random();
        몬스터 몬스터정보;
        ArrayList<몬스터> 몬스터어레이 = new ArrayList<>();
        캐릭터 플레이어2 = new 플레이어();
        아이템 공격력물약 = new 공격력물약("공격력물약");

        ///////////////////////////////////////////스레드연습 시작////////////////////////////////////////////////
//        Runnable 실행할코드 = new Runnable() { //가장 기본적인 구조, new에서 자동완성을 하면 기본구조가 자동완성됨.
//            @Override
//            public void run() {
//                //실행할 코드를 작성
//                int i=0;
//                while(true){
////                    System.out.println("백쓰레드"+i++);
//                    System.out.println(Thread.currentThread().getName());
//                    try {
//                        Thread.sleep(10000);
//                    } catch(InterruptedException e){
//
//                    }
//                }
//            }
//        };
        //처음 부여받은 스레드는 메인 쓰레드라고 부르고, 새로 만든 쓰레드를 백그라운드 쓰레드라고 부름.
//        Thread 백쓰레드 = new Thread(실행할코드);
//        백쓰레드.setPriority(Thread.MIN_PRIORITY); //쓰레드의 실행 우선순위(중요도) 지정, 인자는 정수를 입력할 수도 있음. (1~10, 높을수록 높은 중요도)
//        백쓰레드.start();
//        Thread 백쓰레드2 = new Thread(실행할코드);
//        백쓰레드2.start();


//        System.out.println("입력시 시작...");
//        입력 = sc.nextInt();
//        System.out.println("시작합니다..");

        몬스터어레이.clear();
        몬스터머릿수 = rd.nextInt(9) + 2;
        System.out.println(몬스터머릿수 + "마리의 몬스터를 발견했다!!!");
        플레이어2.start();
        for (int i = 1; i <= 몬스터머릿수; i++) {
            몬스터번호 = Integer.toString(i);
            몬스터생성난수 = Math.random();
            num = (int) Math.floor(몬스터생성난수 * 몬스터종류배열.length);
            랜덤몬스터결과 = 몬스터종류배열[num];
            if (랜덤몬스터결과.equals("슬라임")) {
                num = rd.nextInt(5) + 1;
                if (num <= 2) {
                    몬스터정보 = new 빨간슬라임(몬스터번호);
                } else {
                    몬스터정보 = new 초록슬라임(몬스터번호);
                }
            } else if (랜덤몬스터결과.equals("고블린")) {
                num = rd.nextInt(10) + 1; //1~10
                if (num <= 4) {
                    몬스터정보 = new 고블린궁수(몬스터번호);
                } else if (num <= 8) {
                    몬스터정보 = new 고블린전사(몬스터번호);
                } else {
                    몬스터정보 = new 보물고블린(몬스터번호);
                }
            }else{ //오크면
//            } else if (랜덤몬스터결과.equals("오크")) {
                num = rd.nextInt(10) + 1; //1~10
                if(num<=4){
                    몬스터정보 = new 오크전사(몬스터번호);
                }else if(num<=8){
                    몬스터정보 = new 오크전사(몬스터번호);
                }else{
                    몬스터정보 = new 오크주술사(몬스터번호);
                }
            }
            몬스터어레이.add(몬스터정보);
        }

        for(int i = 0 ; i < 몬스터어레이.size() ; i++) {
//            몬스터어레이.get(i).start();
        }

        JPanel panel = new JPanel();
        panel.setBackground(Color.DARK_GRAY);

//        JFrame 캐릭터 = new JFrame("캐릭터"); //인자는 창의 제목을 지정
//        캐릭터.setBounds(100,100,500,400); //창의 크기와 위치를 지정
//        캐릭터.add(panel); //위에 패널을 추가해서 색을바꿈
//        캐릭터.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); //창의 종료버튼이 동작하지 않게 설정함.
//        캐릭터.setAlwaysOnTop(true); //창이 항상위로 가게 설정함.
//        캐릭터.setVisible(true); //출력하기
//        캐릭터.revalidate(); //새로고침 비슷한 기능

        Runnable 몬스터창코드 = new Runnable() {
            @Override
            public void run() {
                JLabel[] 라벨 = new JLabel[몬스터어레이.size()];
                몬스터 타겟;
                몬스터스킬 스킬;

                //레이아웃 설정
                JFrame 몬스터 = new JFrame("몬스터");
                몬스터.setBounds(1000,100,500,몬스터어레이.size()*40+20);
                몬스터.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
                몬스터.setLayout(new GridLayout(몬스터어레이.size(),1,10,3)); //행, 열, 좌우간격, 상하간격
//        몬스터.add(panel);
                몬스터.setAlwaysOnTop(true);
                몬스터.setVisible(true);//출력하기

                //처음 라벨 초기화(일회성)
                for (int i = 0; i < 몬스터어레이.size(); i++) {
                    라벨[i] = new JLabel("");
                }

                //라벨 입력(일회성)
                for (int i = 0; i < 몬스터어레이.size(); i++) {
                    타겟 = 몬스터어레이.get(i);
                    라벨[i].setText(타겟.이름 + " (체력:" + 타겟.현재체력 + "/" + 타겟.최대체력 + ") │ 공격력: " + 타겟.공격력 + "+" + 타겟.추가공격력 + " │ 방어력: " + 타겟.방어력 + "+1" + 타겟.추가방어력+ ", 행동게이지: " + 타겟.행동게이지);
                    if (타겟.지속스킬.size() > 0) {
                        라벨[i].setText(라벨[i].getText() + " 지속중: ");
                        for (int j = 0; j < 타겟.지속스킬.size(); j++) {
                            스킬 = 타겟.지속스킬.get(j);
                            라벨[i].setText(라벨[i].getText() + 스킬.스킬명 + "(" + (스킬.지속시간) + "턴) ");
                        }
                    }
                    라벨[i].setText(라벨[i].getText() + ")\n");
                    몬스터.add(라벨[i]);
                }

                //라벨 갱신
                while(true) {
                    for (int i = 0; i < 몬스터어레이.size(); i++) {
                        라벨[i].setText("");
                    }
                    for (int i = 0; i < 몬스터어레이.size(); i++) {
                        타겟 = 몬스터어레이.get(i);
                        라벨[i].setText(타겟.이름 + " (체력:" + 타겟.현재체력 + "/" + 타겟.최대체력 + ") │ 공격력: " + 타겟.공격력 + "+" + 타겟.추가공격력 + " │ 방어력: " + 타겟.방어력 + "+1" + 타겟.추가방어력+ ", 행동게이지: " + ((int)Math.ceil(타겟.행동게이지)/100) + "%");
                        if (타겟.지속스킬.size() > 0) {
                            라벨[i].setText(라벨[i].getText() + " 지속중: ");
                            for (int j = 0; j < 타겟.지속스킬.size(); j++) {
                                스킬 = 타겟.지속스킬.get(j);
                                라벨[i].setText(라벨[i].getText() + 스킬.스킬명 + "(" + (스킬.지속시간) + "턴) ");
                            }
                        }
                        라벨[i].setText(라벨[i].getText() + ")\n");
                    }
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    재시작:
                    while (true) {
                        for (int i = 0; i < 몬스터어레이.size(); i++) {
                            타겟 = 몬스터어레이.get(i);
                            if (타겟.현재체력 < 0) {
                                라벨[몬스터어레이.size() - 1].setText("");
                                몬스터어레이.remove(i);
                                continue 재시작;
                            }
                        }
                        break;
                    }
                }


            }
        }; //몬스터의 상태창을 출력하는 코드
        Thread 몬스터창= new Thread(몬스터창코드);
        몬스터창.start();

        Runnable 캐릭터창코드 = new Runnable() {
            @Override
            public void run() {
                int 사용중사이즈;
                JLabel 라벨;
                JPanel 패널 = new JPanel();
                JLabel 라벨2;

                //레이아웃 설정
                JFrame 캐릭터 = new JFrame("캐릭터"); //인자는 창의 제목을 지정
                캐릭터.setBounds(100,100,300,500); //창의 크기와 위치를 지정
                캐릭터.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE); //창의 종료버튼이 동작하지 않게 설정함.
                캐릭터.setLayout(new GridLayout(0,1,10,0)); //행, 열, 좌우간격, 상하간격
                캐릭터.setAlwaysOnTop(true); //창이 항상위로 가게 설정함.

//                //처음 라벨 초기화(일회성)
                라벨 = new JLabel("<html>" +
                        "<br>┌──────────────────" +
                        "<br>│레벨: " + Main.플레이어.캐릭터레벨 + " (" + Main.플레이어.캐릭터현재경험치 + "/" + Main.플레이어.캐릭터최대경험치 + ")" +
                        "<br>│소지금: "+ Main.플레이어.소지금+ "골드" +
                        "<br>│체력: " + Main.플레이어.캐릭터현재체력 + "/" + Main.플레이어.캐릭터최종체력 +
                        "<br>│마나: " + Main.플레이어.캐릭터현재마나 + "/" + Main.플레이어.캐릭터최종마나 +
                        "<br>│공격력: " + Main.플레이어.캐릭터공격력 + " +" + Main.플레이어.캐릭터추가공격력 +
                        "<br>│방어력: " + Main.플레이어.캐릭터방어력 + " +" + Main.플레이어.캐릭터추가방어력 +
                        "<br>│치명확률: " + Main.플레이어.캐릭터최종치확 + "%" +
                        "<br>│치명피해: " + Main.플레이어.캐릭터최종치피 + "%" +
                        "<br>│회피율: " + Main.플레이어.캐릭터최종회피 + "%" +
                        "<br>└──────────────────" +
                        "<br>행동게이지 : " + (int)Math.ceil(플레이어.행동게이지/100) + "%" +
                        "</html>");
                라벨2 = new JLabel("" +
                        "<html>적용 중인 효과:" +
                        "<br> </html>");
                패널.setLayout(new FlowLayout(FlowLayout.LEFT,0,10));
                패널.add(라벨2);
                boolean 변경됨=true;
                사용중사이즈=플레이어2.사용중.size();
//                System.out.println(사용중사이즈);
                캐릭터.add(라벨);
                캐릭터.add(패널);
                캐릭터.setVisible(true); //출력하기
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    throw new RuntimeException(e);
//                }

                //라벨 갱신
                while(true) {
                    라벨.setText("<html>" +
                            "<br>┌──────────────────" +
                            "<br>│레벨: " + 플레이어2.캐릭터레벨 + " (" + 플레이어2.캐릭터현재경험치 + "/" + 플레이어2.캐릭터최대경험치 + ")" +
                            "<br>│소지금: "+ 플레이어2.소지금+ "골드" +
                            "<br>│체력: " + 플레이어2.캐릭터현재체력 + "/" + 플레이어2.캐릭터최종체력 +
                            "<br>│마나: " + 플레이어2.캐릭터현재마나 + "/" + 플레이어2.캐릭터최종마나 +
                            "<br>│공격력: " + 플레이어2.캐릭터공격력 + " +" + 플레이어2.캐릭터추가공격력 +
                            "<br>│방어력: " + 플레이어2.캐릭터방어력 + " +" + 플레이어2.캐릭터추가방어력 +
                            "<br>│치명확률: " + 플레이어2.캐릭터최종치확 + "%" +
                            "<br>│치명피해: " + 플레이어2.캐릭터최종치피 + "%" +
                            "<br>│회피율: " + 플레이어2.캐릭터최종회피 + "%" +
                            "<br>└────────────────── "+
                            "<br>행동게이지 : " + (int)Math.ceil(플레이어2.행동게이지/100) + "%" +
                            "</html>");
                    if(사용중사이즈!=플레이어2.사용중.size()){
                        사용중사이즈=플레이어2.사용중.size();
                        변경됨=true;
                    }
                    if(변경됨) {
                        변경됨=false;
                        if (!(플레이어2.사용중.size() == 0)) {
                            라벨2.setText("<html>" +
                                    "적용 중인 효과: ");
                            for (int i = 0; i < 플레이어2.사용중.size(); i++) {
//                                System.out.println("적용");
                                라벨2.setText(라벨2.getText() + "<br>" + 플레이어2.사용중.get(i).아이템이름 + "(" + 플레이어2.사용중.get(i).사용중 + ")");
//                                System.out.println(라벨2);
                            }
                        }
                    }
                    라벨2.setText(라벨2.getText()+"</html>");

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }; //몬스터의 상태창을 출력하는 코드
        Thread 캐릭터창= new Thread(캐릭터창코드);
        캐릭터창.start();

        while(true) {
//            Main.플레이어.캐릭터현재체력 = Main.플레이어.캐릭터현재체력 - 30;
//            if(Main.플레이어.사용중.size()<5){
//                Main.플레이어.사용중.add(공격력물약);
////                System.out.println("add함");
//            }

//            플레이어2.행동게이지 = 8000;
            if(플레이어2.행동게이지==10000) {
                System.out.println("싱크로전 : " + 플레이어2.getState());
                System.out.println("1초후 해제");
                Thread.sleep(1000);
                synchronized (플레이어2) {
                    플레이어2.행동게이지 = 0;
                    플레이어2.notify();
                    System.out.println("notify후 : " + 플레이어2.getState());
//                    플레이어2.yield();
//                    System.out.println("yield후 : " + 플레이어2.getState());
//                    플레이어2.interrupt();
//                    System.out.println("interrupt후 : " + 플레이어2.getState());
                }
                Thread.sleep(1000);
//                System.out.println("interrupt 1초 후 : " + 플레이어2.getState());

//                synchronized (플레이어2) {
//                    Thread.sleep(1000);
//                    System.out.println("재실행전");
//                    플레이어2.notify();
//                    System.out.println("재실행후");
//                }
            }
//            System.out.println(Main.플레이어.이름 + "의 체력을 30깎아서 " + Main.플레이어.캐릭터현재체력 + "이 되었습니다.");
            Thread.sleep(1000);

//            if(몬스터어레이.size())
        }



//        몬스터.add(label);
//        몬스터.add(label2);
//        몬스터.add(label3);
//        몬스터.add(label4);
//        몬스터.add(label5);
//        몬스터.add(label6);
//        몬스터.add(label7);
//        몬스터.add(label8);
//        몬스터.add(label9);
//        몬스터.add(label10);
//        몬스터.add(label11);
//        몬스터.add(label12);
//        몬스터.add(btn1,BorderLayout.WEST);
//        몬스터.add(btn2,BorderLayout.EAST);







        //스레드에 사용 가능한 메소드 :

        //Thread 클래스의 메소드:

        //1. sleep() - 실행 중인 스레드를 일시정지 상태로 재우는 것. 매개변수에 얼마동안 재울지 1/1000초 단위로 지정할 수 있음 평소에 쓰는 Thread.sleep은 이것을 스태틱으로 선언해둔 것을 쓰는 것.
        //ex) 백쓰레드.sleep(1000);

        //2. join() - join()을 호출한 스레드가 종료될 때까지 기다리게 함. 매개변수로 어느정도 기다릴지 시간을 지정할 수도 있고, 지정하지 않는다면 해당 스레드가 끝날 때까지 기다림
        //메인 스레드에서 백쓰레드.join()을 사용하면 메인스레드가 해당 줄에서 백쓰레드가 종료될 때까지 다음 줄로 넘어가지 않고 기다리게 됨.
        //ex) 백쓰레드.join();
        //ex2) 백쓰레드.join(1000);

        //3. interrupt() - sleep(), join(), wait()에 의해 일시정지 상태인 스레드를 깨워서 실행대기 상태로 만든다.
        //ex)백쓰레드.interrupt();

        //4. yield() - 스레드 자신에게 주언 실행시간을 다음 차례의 스레드에게 양보함.



//        while(!(입력==0)) {
//            System.out.println(Thread.currentThread().getName());
//            System.out.print("" +
//                    "1입력시 interrupt를 실행" +
//                    "\n입력 :");
//            입력 = sc.nextInt();
//            System.out.println("입력 : " + 입력);
//            if(입력==1){
//                System.out.println("interrupt실행");
//                백쓰레드.interrupt();
//            }
//
//        }
//        System.out.println("와일문끝");



//        new Thread(new Runnable() { //어디에 담지말고 바로 실행하려면 이런 식으로도 할수있음. 선언과 동시에 runnable를 꾸겨넣고 바로 실행시킴
//            @Override
//            public void run() {
//                int i=0;
//                while(true){
//                    System.out.println("백쓰레드"+i++);
//                    try {
//                        Thread.sleep(1000);
//                    } catch(InterruptedException e){
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();




//        int i=0;
//        while(true){
//            System.out.println(i++);
//            try {
//                Thread.sleep(1000);     //이걸 하다가
//            } catch(InterruptedException e){  //에러가 나면 에러메시지가 InterruptedException클래스의 e변수에 넣음
//                e.printStackTrace();          //e를 보여줌
//            }                                 //트라이, 캐치 검색해보기
//        }


        ///////////////////////////////////////////스레드연습 끝////////////////////////////////////////////////





















//        Random rd = new Random();
//        출력 메인=new 출력();
////        //16진수 생성 예제2 시작
////        byte[]arr = new byte[4];
////        new Random().nextBytes(arr);
////        System.out.println(convert(arr));
////        //16진수 생성 예제2 끝
//
//        //랜덤 몬스터 뽑기 연습
////        몬스터 test = new 몬스터("섹스");
//
//        String[] 몬스터종류배열 = {"슬라임","고블린","오크"};
//        double 몬스터생성난수;
//        int num;
//        String 랜덤몬스터결과;
//        //랜덤 몬스터 뽑기 연습 끝
//
//        //몬스터 객체 생성 연습
//        ArrayList<몬스터> 몬스터어레이 = new ArrayList<>();
//        몬스터어레이.clear();
//        String 몬스터번호;
//        몬스터 몬스터정보;
//        int 몬스터머릿수 = rd.nextInt(9)+1;
//        int 죽은몬스터수 = 0;


//        System.out.println("\n"+몬스터머릿수+"마리의 몬스터를 생성합니다.\n");

//        for(int i = 1; i<=몬스터머릿수; i++){
//            몬스터생성난수 = Math.random();
//            num=(int)Math.floor(몬스터생성난수*몬스터종류배열.length);
//            랜덤몬스터결과 = 몬스터종류배열[num];
//
//            몬스터번호 = Integer.toString(i);
//            몬스터정보 = new 몬스터(몬스터번호,랜덤몬스터결과);
//            몬스터어레이.add(몬스터정보);
//        }

//        System.out.println(메인.몬스터목록(몬스터머릿수,몬스터어레이,죽은몬스터수));
//        double db;
//        int a=0;
//        while(a<10) {
//            db=Math.random() * 0.2 + 0.9;
//            System.out.println("db : " + db);
//            db=Math.round((Math.random() * 0.2 + 0.9)*100);
//            System.out.println("Math.round(db*100) : " + db);
//            db=(Math.round((Math.random() * 0.2 + 0.9)*100))/100;
//            System.out.println("(Math.round(db*100))/100 : " + db);
//
////            db=Math.round((Math.random()*0.2+0.9)*100)/100;
////            System.out.println("결론 : " + db);
////            System.out.println("");
//            a++;
////            db=Math.random() * 0.2 + 0.9;
////            System.out.println("db : " + db);
////            db=Math.round(db*100);
////            System.out.println("Math.round(db*100) : " + db);
////            db=db/100;
////            System.out.println("(Math.round(db*100))/100 : " + db);
////            db=Math.round((Math.random()*0.2+0.9)*100)/100;
////            System.out.println("결론 : " + db);
////            System.out.println("");
////            a++;
//        }





//        int b=0;
//        while(b<10) {
//            db=Math.round((((Math.random() * 0.2) + 0.9) * 10)/10);
//            System.out.println(db);
//            b++;
//        }
//        int c=0;
//        while(c<10) {
//            db=Math.round(1.222 * 10) / 10;
//            System.out.println(db);
//            c++;
//        }
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
