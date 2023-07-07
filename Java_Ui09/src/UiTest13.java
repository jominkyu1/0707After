import javax.swing.*;

class MyFrame01 extends JFrame{
    JButton bt01;
    private JButton bt02, bt03;

    public MyFrame01(){
        setTitle("절대 위치 연습");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);

        JPanel p = new JPanel();
        p.setLayout(null); //UI 컴포넌트를 절대 위치로 배치하기위해 배치관리자로 설정하지 않음

        bt01 = new JButton("Button #01");
        p.add(bt01);
        bt02 = new JButton("Button #02");
        p.add(bt02);
        bt03 = new JButton("Button #03");
        p.add(bt03);

        bt01.setBounds(20, 5, 95, 30);
        bt02.setBounds(55, 45, 105, 70);
        bt03.setBounds(180, 15, 105, 90);

        add(p);
    }
}
public class UiTest13 {
    public static void main(String[] args) {
        new MyFrame01().setVisible(true);
    }
}
