import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//스윙버튼 Event 처리 예제
class MyFrame14 extends JFrame implements ActionListener{
    private JButton button;
    private JLabel label;
    public MyFrame14(){
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("스윙 이벤트 예제1");

        JPanel panel = new JPanel();
        button = new JButton("버튼을 누르세요");
        label = new JLabel("아직 버튼이 클릭되지 않았습니다.");

        button.addActionListener(this);

        panel.add(button);
        panel.add(label);

        add(panel);
    }

    @Override
    public void actionPerformed(ActionEvent e) { //버튼클릭시 호출
        if(e.getSource() == button){ //getSource() 메소드는 이벤트발생 객체반환
            label.setText("버튼 클릭됨");
        }

        System.out.println(e.getActionCommand());
        System.out.println(e.paramString());
    }
}
public class UiTest14 {
    public static void main(String[] args) {
        new MyFrame14().setVisible(true);
    }
}
