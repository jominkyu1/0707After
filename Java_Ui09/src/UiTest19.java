import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// ImageIcon 컴포넌트를 활용하여 스윙 컴포넌트에 이미지 표시하기

public class UiTest19 extends JFrame implements ActionListener {
    private JPanel panel;
    private JLabel label;
    private JButton button;


    public UiTest19() {
        setTitle("스윙에 그림배치 연습");
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        label = new JLabel("버튼 클릭");
        button = new JButton("이미지");

        button.addActionListener(this);

        panel.add(label);
        panel.add(button);

        add(panel);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        ImageIcon icon = new ImageIcon("./images/car.jpg.jpg");
        button.setIcon(icon); //버튼에 이미지배치
        label.setText("");
        label.setIcon(new ImageIcon("./images/first.jpg"));
    }

    public static void main(String[] args) {
        new UiTest19().setVisible(true);
    }
}
