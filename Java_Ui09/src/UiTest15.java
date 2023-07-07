import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//익명 클래스 (내부 무명클래스: 외부클래스명$번호.class))
class MyFrame15 extends JFrame{
    private JButton button;
    private JLabel label;

    public MyFrame15(){
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("익명클래스 문법");

        JPanel panel = new JPanel();
        button = new JButton("클릭");
        label = new JLabel("버튼 클릭 전");

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               if(e.getSource()==button){
                   System.out.println(e.getSource());
                   label.setText("버튼 클릭 완료");
               }
            }
        });

        panel.add(button); panel.add(label);
        add(panel);
    }
}

public class UiTest15 {
    public static void main(String[] args) {
        new MyFrame15().setVisible(true);
    }
}
