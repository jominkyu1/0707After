//익명 클래스 생성
public class Anonymous2 {
    //멤버변수 초기값으로 설정하는 익명문법
    RemoteControl field = new RemoteControl() { // Anonymous2$1.class
        @Override
        public void turnOn() {
            System.out.println("TV ON");
        }

        @Override
        public void turnOff() {
            System.out.println("TV OFF");
        }
    };

    void method01(){
        RemoteControl localVar = new RemoteControl() {
            @Override
            public void turnOn() {
                System.out.println("Youtube ON");
            }

            @Override
            public void turnOff() {
                System.out.println("Youtube OFF");
            }
        };

        localVar.turnOn();
    }

    void method02(RemoteControl rc){
        rc.turnOff();
    }
}