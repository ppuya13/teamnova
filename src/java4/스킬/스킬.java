package java4.스킬;

import java4.사냥터.몬스터.몬스터;
import java4.사냥터.사냥터출력;
import java4.캐릭터.캐릭터;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public abstract class 스킬 {
    public int 고유번호; // 100~199: 단일공격 | 200~299:다중공격 | 300~399:광역공격
    public int 타입; //1:단일공격 | 2:다중공격 | 3:광역공격
    public String 스킬명;
    public String 효과;
    public int 소모량;
    public Random rd = new Random();
    public int 전투입력;
    public Scanner sc = new Scanner(System.in);

    public int 공격력(캐릭터 플레이어){
        int 공격력 = (int) Math.ceil(플레이어.캐릭터최종공격력*(Math.random()*0.2+0.9));
        return 공격력;
    }
    public abstract boolean 사용확인(ArrayList<몬스터> 몬스터어레이, 캐릭터 캐릭터, 사냥터출력 출력) throws InterruptedException ;
    public abstract void 사용효과(ArrayList<몬스터> 몬스터어레이, 캐릭터 캐릭터, 몬스터 타겟) throws InterruptedException;
}
