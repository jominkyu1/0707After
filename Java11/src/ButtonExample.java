public class ButtonExample {
    public static void main(String[] args) {
        Button01 btn = new Button01();

        btn.setOnClickListener(new CallListener());
        btn.touch();

        btn.setOnClickListener(new MessageListener());
        btn.touch();
    }
}
