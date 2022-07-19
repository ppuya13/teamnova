package java4;

public class 마린 { //public: 접근권한자, class:클래스이다, 마린:이름은 마린

    static String 소지품;
    int 공격력;
    float 방어력;
    String 이름;

    마린(int 공격력, float 방어력, String 이름) { //공격력, 방어력, 이름 등의 이름은 그냥 변수명같은거라 자유임.
        this.공격력 = 공격력;
        this.방어력 = 방어력;
        this.이름 = 이름;
    }

    public String 공격(String 몬스터이름) {

        String 몬스터와싸움결과 = this.이름 + "님이 " + 몬스터이름 + "을 쓰러뜨렸습니다.";

        return 몬스터와싸움결과;
    }

    public void 인자도없고리턴값도없음() {
        System.out.println("출력!!");
    }

    public void 인자만있는경우(String 출력할문자열) {
        System.out.println(출력할문자열);
    }

    public String 시스템비밀번호() { //리턴값만있는경우
        String 비밀번호 = "1234";

        return 비밀번호;
    }

    public int sum(int 첫번째숫자, int 두번째숫자) { //두 가지 숫자를 더하는 매서드
        return 첫번째숫자 + 두번째숫자;
    }

    public int sum2(int 첫번째숫자, int 두번째숫자) { //두 가지 숫자를 더하는 매서드
        return 첫번째숫자 + 두번째숫자;

    }

//    String[] 몬스터뽑기 = {"슬라임","고블린","오크"};
//    double random=Math.random();
//    int num=(int)Math.round(random * 몬스터뽑기.length-1);
//
//    public String 마린몬스터(){
//        String 랜덤몬스터결과 = 몬스터뽑기[num];
//        return 랜덤몬스터결과;
//    }
//    몬스터(String 이름) { //공격력, 방어력, 이름 등의 이름은 그냥 변수명같은거라 자유임.
//        this.이름 = 이름;
//    }
}
