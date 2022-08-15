package java4.스킬;

import java4.사냥터.몬스터.몬스터;
import java4.사냥터.사냥터;
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
//    public int 전투입력;
    public Scanner sc = new Scanner(System.in);



    //지속피해 :
    //찌르기.사용확인() : 누굴 공격할건지 묻고 사용효과를 호출
    //찌르기.사용효과() : 몬스터의 지속피해 어레이에 출혈을 추가
    //
    //지속피해.출혈.효과 : (int)플레이어 공격력*0.1
    //지속피해.출혈.효과적용() : 행동게이지 상승시마다 출혈.효과 만큼의 데미지, 몬스터가 행동할 시 3배의 데미지
    //
    //디버프 :
    //무기파괴.사용확인() : 누굴 공격할건지 묻고 사용효과를 호출
    //무기파괴.사용효과() : 몬스터의 지속중 어레이에 무기파괴를 추가
    //무기파괴.지속효과() : 몬스터의 공격력을 30깎음
    //무기파괴.지속효과삭제 : 몬스터의 공격력을 30올림

    public int 공격력(캐릭터 플레이어){
        int 공격력 = (int) Math.ceil(플레이어.캐릭터최종공격력*(Math.random()*0.2+0.9));
        return 공격력;
    }
    public abstract boolean 사용확인(ArrayList<몬스터> 몬스터어레이, 캐릭터 캐릭터, 사냥터 출력) throws InterruptedException ;
    public abstract void 사용효과(ArrayList<몬스터> 몬스터어레이, 캐릭터 캐릭터, 몬스터 타겟) throws InterruptedException;
}
