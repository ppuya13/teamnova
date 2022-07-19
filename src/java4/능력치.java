package java4;


import java.util.ArrayList;

public class 능력치 { //캐릭터의 능력치나 소지품에 영향을 미치는 메소드는 이곳에

    ArrayList<아이템> 회복물약가방;
    ArrayList<아이템> 소지품;
    int 소지금;
    int 캐릭터레벨;
    int 캐릭터최대경험치;
    int 캐릭터현재경험치;
    int 캐릭터최대체력;
    int 캐릭터현재체력;
    int 캐릭터최대마나;
    int 캐릭터현재마나;
    int 캐릭터최종공격력;
    int 캐릭터공격력;
    int 캐릭터추가공격력;
    int 캐릭터최종방어력;
    int 캐릭터방어력;
    int 캐릭터추가방어력;
    double 캐릭터치명확률;
    double 캐릭터치명피해;
    double 캐릭터회피;




    능력치(
            int 레벨,
            int 최대경험치,
            int 현재경험치,
            int 최대체력,
            int 현재체력,
            int 최대마나,
            int 현재마나,
            int 공격력,
            int 추가공격력,
            int 방어력,
            int 추가방어력,
            int 치명확률,
            int 치명피해,
            int 회피,
            int 소지금
    )
    {
        this.캐릭터레벨 = 레벨;
        this.캐릭터최대경험치 = 최대경험치;
        this.캐릭터현재경험치 = 현재경험치;
        this.캐릭터최대체력 = 최대체력;
        this.캐릭터현재체력 = 현재체력;
        this.캐릭터최대마나 = 최대마나;
        this.캐릭터현재마나 = 현재마나;
        this.캐릭터공격력 = 공격력;
        this.캐릭터추가공격력 = 추가공격력;
        this.캐릭터방어력 = 방어력;
        this.캐릭터추가방어력 = 추가방어력;
        this.캐릭터치명확률 = 치명확률;
        this.캐릭터치명피해 = 치명피해;
        this.캐릭터회피 = 회피;
        this.캐릭터최종공격력=this.캐릭터공격력+this.캐릭터추가공격력;
        this.캐릭터최종방어력=this.캐릭터방어력+this.캐릭터추가방어력;
        this.소지금=소지금;
        this.회복물약가방 = new ArrayList<>();
        this.소지품 = new ArrayList<>();
    }


    public void 인벤토리초기화 (능력치 캐릭터){
        아이템 체력물약 = new 아이템(-1);
        아이템 마나물약 = new 아이템(-2);
        아이템 아이템 = new 아이템(0);
        this.회복물약가방.add(체력물약);
        this.회복물약가방.add(마나물약);
        for (int i = 0; i <= 19; i++) { //0부터 19까지 총 20번 반복
            this.소지품.add(아이템);
        }//빈아이템 20개를 캐릭터의 소지품에 넣음.
    }

    public String 상점구매(int 타겟, 상점 상점){
        String 구매한템이름=상점.리스트.get(타겟-1).아이템이름;
        String 상점구매결과="";



        //1. 선택한 템이 스택가능이면 몇개를 구매할건지 물어보기
        //1-1 구매 갯수를 입력 받으면 진짜 구매할건지 물어보기
        //1-1-1 구매한다고 했으면 인벤토리 안에 고유번호가 같은 아이템이 존재하는지 확인
        //1-1-1-1 존재하면 돈이 충분한지 확인
        //1-1-1-1-1 돈이 충분하다면 같은 아이템의 스택을 구매개수만큼 늘림
        //1-1-1-1-2 돈이 부족하다면 돈이 부족하다는 문구를 띄우고 뒤로가기
        //1-1-1-2 존재하지 않으면 인벤토리의 남은 공간이 있는지 확인
        //1-1-1-2-1 남은 공간이 있다면 돈이 충분한지 확인
        //1-1-1-2-1-1 돈이 충분하다면 인벤토리에 해당 아이템을 추가
        //1-1-1-2-1-2 돈이 부족하다면 돈이 부족하다는 문구를 띄우고 뒤로가기
        //1-1-1-2-2 남은 공간이 없다면 인벤토리가 꽉찼다는 문구를 띄우고 뒤로가기
        //1-1-2 구매안한다고 했으면 뒤로가기
        //1-2 0을 입력시 뒤로가기

        //2. 선택한 템이 스택불가능이면 그냥 구매할건지 물어보기
        //2-1 구매한다고 했으면 돈이 충분한지 확인
        //2-1-1 돈이 충분하면 공간이 충분한지 확인
        //2-1-1-1 공간이 충분하면 인벤토리에 해당 아이템을 추가
        //2-1-1-2 공간이 부족하다면 인벤토리가 꽉찼다는 문구를 띄우고 뒤로가기
        //2-1-2 돈이 부족하다면 돈이 부족하다는 문구를 띄우고 뒤로가기
        //2-2 구매안한다고 했으면 뒤로가기
        return 상점구매결과;
    }


}
//        능력치.캐릭터레벨=1;
//                능력치.캐릭터최대경험치=100;
//                능력치.캐릭터현재경험치=0;
//                능력치.캐릭터최대체력=1000;
//                능력치.캐릭터현재체력=1000;
//                능력치.캐릭터최대마나=100;
//                능력치.캐릭터현재마나=100;
//                능력치.캐릭터공격력=50;
//                능력치.캐릭터추가공격력=0;
//                능력치.캐릭터방어력=10;
//                능력치.캐릭터추가방어력=0;
//                능력치.캐릭터치명확률=20;
//                능력치.캐릭터치명피해=150;
//                능력치.캐릭터회피=10;
//                능력치.캐릭터최종공격력=능력치.캐릭터공격력+능력치.캐릭터추가공격력;
//                능력치.캐릭터최종방어력=능력치.캐릭터방어력+능력치.캐릭터추가방어력;