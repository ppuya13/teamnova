package java4.사냥터;

import java4.사냥터.몬스터.몬스터;
import java4.사냥터.몬스터.스킬.몬스터스킬;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


import static java4.사냥터.사냥터출력.몹사망;

public class 전투_몬스터창 extends Thread{
    ArrayList<몬스터> 몬스터어레이;

    public 전투_몬스터창(ArrayList<몬스터> 몬스터어레이){
        this.몬스터어레이 = 몬스터어레이;
    }

    public void run(){
        JLabel[] 라벨 = new JLabel[몬스터어레이.size()];
        몬스터 타겟;
        몬스터스킬 스킬;
        int 지우기=1;

        //레이아웃 설정
        JFrame 몬스터 = new JFrame("몬스터");
        몬스터.setBounds(800,600,800,몬스터어레이.size()*40+20);
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
            라벨[i].setText(타겟.이름 + " (체력:" + 타겟.현재체력 + "/" + 타겟.최대체력 + ") │ 공격력: " + 타겟.공격력 + "+" + 타겟.추가공격력 + " │ 방어력: " + 타겟.방어력 +"+"+ 타겟.추가방어력+" | 속도: "+타겟.속도 + ", 행동게이지: " + 타겟.행동게이지);
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
                라벨[i].setText(타겟.이름 + " (체력:" + 타겟.현재체력 + "/" + 타겟.최대체력 + ") │ 공격력: " + 타겟.공격력 + "+" + 타겟.추가공격력 + " │ 방어력: " + 타겟.방어력 +"+"+ 타겟.추가방어력+" | 속도: "+타겟.속도 +  ", 행동게이지: " + ((int)Math.ceil(타겟.행동게이지)/100) + "%");
                if (타겟.지속스킬.size() > 0) {
                    라벨[i].setText(라벨[i].getText() + ") (지속중: ");
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
                몬스터.dispose();
                break;
            }
            재시작:
            while (true) {
                for (int i = 0; i < 몬스터어레이.size(); i++) {
                    if (몹사망) {
                        몹사망=false;
//                        System.out.println("전투_몬스터창| 라벨.length: " + 라벨.length + ", 몬스터어레이.size(): " + 몬스터어레이.size() + ", 지우기: " + 지우기);
                        라벨[라벨.length-지우기].setText("");
//                        System.out.println(라벨[라벨.length-지우기].getText());
//                        System.out.println("전투_몬스터창| 라벨.length: " + 라벨.length + ", 몬스터어레이.size(): " + 몬스터어레이.size() + ", 지우기: " + 지우기);
                        지우기++;
                        continue 재시작;
                    }
                }
                break;
            }
        }
    }
}
