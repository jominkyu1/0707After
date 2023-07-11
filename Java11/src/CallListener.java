// 중첩 인터페이스로부터 구현 상속받은 첫번째 자손 클래스

public class CallListener implements Button01.OnClickListener{
    @Override
    public void onClick() {
        System.out.println("전화를 겁니다.");
    }
}
