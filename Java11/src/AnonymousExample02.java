public class AnonymousExample02 {
    public static void main(String[] args) {
        Anonymous2 an = new Anonymous2();
        an.method01();
        an.field.turnOn();

        an.method02(new RemoteControl() {
            @Override
            public void turnOn() {

            }

            @Override
            public void turnOff() {
                System.out.println("Turn OFF");
            }
        });
    }
}