package java4.아이템.소모.지속형;

import java4.아이템.소모.소모아이템;
import java4.아이템.아이템;
import java4.캐릭터.캐릭터;

public abstract class 지속형 extends 소모아이템 {
    public 지속형() {
        this.적용=true;
    }

    @Override
    public boolean 사용효과(캐릭터 캐릭터) throws CloneNotSupportedException, InterruptedException {
        아이템 소모템 = (아이템) this.clone();
        boolean 사용완료 = false;
//        System.out.println("(지속형.사용효과) if문 진입");
        if(캐릭터.사용중.size() != 0) { //사용중인 템이 있다면
            for (int i = 0; i < 캐릭터.사용중.size() ; i++){ //사용중 크기만큼 반복
                if(소모템.아이템이름.equals(캐릭터.사용중.get(i).아이템이름)){ //사용중인 아이템 중에 선택된 아이템과 동일한 템이 있으면
//                    System.out.println("(지속형.사용효과) 동일한템있음");
                    캐릭터.사용중.set(i,소모템); //그 아이템을 선택한 아이템으로 대체
                    사용완료=true;
                    this.스택수--;
                }
            }
            if(!사용완료){ //앞에서 사용되지 않았다면(지속중인 아이템 중에 선택된 아이템과 동일한 템이 없다면)
//                System.out.println("(지속형.사용효과) 동일한템없음");
                캐릭터.사용중.add(소모템);
                this.스택수--;
            }
        }
        else{ //사용중인 템이 없다면
//            System.out.println("(아이템.소모템사용) 사용중인템없음");
            캐릭터.사용중.add(소모템);
            this.스택수--;
        }
        System.out.println(this.아이템이름+"을(를) 사용했습니다.");
        Thread.sleep(1000);
        return false;
    }

    public abstract void 효과적용(캐릭터 캐릭터) throws InterruptedException;

    public abstract boolean 효과삭제(캐릭터 캐릭터) throws InterruptedException;
}
