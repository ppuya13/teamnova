package java4.사냥터;

public class 전투 extends Thread{
    //전투 돌입 시 표기
    public void run(){
        while(true){
            synchronized (this){//첫 시작시와 매 루프마다 기다림
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }//run끝
}
