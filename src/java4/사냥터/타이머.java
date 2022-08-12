package java4.사냥터;

import java4.사냥터.몬스터.몬스터;
import java4.스킬.단일스킬.기본공격;

import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

import static java4.Main.플레이어;
import static java4.사냥터.사냥터.몬스터어레이;

public class 타이머 extends Thread {
    public int 카운트 = 10;
    public String 텍스트;


    public void run(){


        JFrame 타이머창 = new JFrame("행동");
        JLabel 라벨 = new JLabel();
        Font 폰트 = new Font("고딕",Font.BOLD,30);
        라벨.setHorizontalAlignment(JLabel.CENTER);
        라벨.setFont(폰트);

        Timer 타이머 = new Timer();
        TimerTask 태스크 = new TimerTask() {
            @Override
            public void run() {
                텍스트 = Integer.toString(카운트);
                라벨.setText(텍스트);
                if(카운트 > 0){
                    카운트--;
                }
                else{
                    try {
                        this.시간초과();
                    } catch (InterruptedException e) {
                        System.out.println("타이머(태스크)| 인터럽트 예외 발생");
                    }
                    this.cancel();
                    타이머창.setVisible(false);
                }
            }

            private void 시간초과() throws InterruptedException {
                System.out.println("제한시간을 초과해 자동으로 공격합니다.");
                기본공격 기본공격 = new 기본공격();
                몬스터 타겟 = 몬스터어레이.get(0);
                기본공격.사용효과(몬스터어레이,플레이어,타겟);
            }
        };
        타이머.schedule(태스크,0,1000);
        타이머창.setBounds(100,400,100,100);
        타이머창.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
//        타이머창.setLayout(new GridLayout(10,1,10,3)); //행, 열, 좌우간격, 상하간격
        타이머창.add(라벨);
        타이머창.setAlwaysOnTop(true);
        타이머창.setVisible(true);//출력하기

        try {
            synchronized (this) {
                this.wait();
            }
        } catch (InterruptedException e) {
            타이머.cancel();
            타이머창.setVisible(false);
        }

    }

}
