// JDK1.8에서 추가된 람다식 문법으로 이벤트 처리 예제

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class MyFrame16 extends JFrame {
    private JButton button;
    private JLabel label;

    public MyFrame16(){
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("람다식 이벤트 처리 예제");

        JPanel panel = new JPanel();
        button = new JButton("버튼");
        label = new JLabel("버튼 클릭 전");

        button.addActionListener(e->label.setText("버튼 클릭 완료"));

        panel.add(button);
        panel.add(label);

        add(panel);
    }
}
public class UiTest16 {
    public static void main(String[] args) {
        new MyFrame16().setVisible(true);
    }
}
