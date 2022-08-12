package java4.사냥터;

import java.util.Timer;

public class 타이머 extends Timer {

    public void run(){
        int 카운트 = 10;
        if(카운트 > 0){ //count값이 5보다 작거나 같을때까지 수행
            System.out.println("[카운트다운 : "+카운트+"]");
            카운트--; //실행횟수 증가
        }
        else{
            this.cancel(); //타이머 종료
            System.out.println("[카운트다운 : 종료]");
        }
    }


}
