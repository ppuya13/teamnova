package 연습;

import java4.사냥터.타이머;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class 타이머연습 {
    public static void main(String[] args) {
        int 입력;
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.print("시작하기 : ");
            입력 = sc.nextInt();
            타이머 타이머 = new 타이머();
            타이머.start();
            System.out.println(타이머.getState());


            System.out.print("멈추기 : ");
            입력 = sc.nextInt();
            타이머.interrupt();
            System.out.println(타이머.getState());
        }
    }

}
