//중첩 인터페이스로부터 구현 상속받은 두번째 자손 클래스

public class MessageListener implements Button01.OnClickListener{
    @Override
    public void onClick() {
        System.out.println("메세지를 보냅니다.");
    }
}