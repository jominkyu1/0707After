import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*  스윙 컴포넌트 종류)
    1. JCheckBox    : 네모 버튼
    2. JRadioButton : 동그란 버튼 (ButtonGroup으로 묶으면 하나만 선택가능)
    3. JTextArea    : 한 줄 이상 여러줄 입력가능
    4. JComboBox    : 선택된 리스트 항목만 표시되고 나머지는 숨겨져서 리스트 항목으로 표시하고자 할 때 사용 
* */

// JTextArea 실습 예제
public class UiTest21 extends JFrame implements ActionListener {

    JTextField textField;
    JTextArea textArea;
    JComboBox<String> jc = new JComboBox<>();

    UiTest21() {
        setSize(700, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());



        textField = new JTextField(30);
        textField.addActionListener(this);

        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);


        jc.addItem("AA");
        jc.addItem("BB");
        jc.addItem("CC");

        add(jc);
        add(textField, BorderLayout.CENTER);
        add(textArea, BorderLayout.WEST);

        pack();
    }

    public static void main(String[] args) {
        new UiTest21().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String str = textField.getText();

        textArea.append( jc.getSelectedItem() + str + "\n");
        textField.setText(null);

        pack();
//        textField.selectAll();
    }
}
