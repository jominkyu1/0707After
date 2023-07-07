import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UiTest20 extends JFrame {
    private JButton btn;
    private JTextField text, result;
    //JTextField는 한줄 입력필드를 생성

    public UiTest20(){
        setSize(100,300);
        setLocationRelativeTo(null);
        setTitle("제곱 계산하기");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        BtnListener listener = new BtnListener(); //inner class
        JPanel panel = new JPanel(new FlowLayout());

        panel.add(new JLabel("숫자 입력: "));
        text = new JTextField(15); //입력박스 길이 15
        text.addActionListener(listener);
        panel.add(text);

        panel.add(new JLabel("제곱: "));
        result = new JTextField(15);
        result.setEditable(false); //수정불가
        panel.add(result);

        add(panel);
    }

    private class BtnListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String str = text.getText();
            int v = Integer.parseInt(str);

            result.setText(String.valueOf(v*v));
            text.requestFocus();
        }
    }
    public static void main(String[] args) {
        new UiTest20().setVisible(true);
    }
}
