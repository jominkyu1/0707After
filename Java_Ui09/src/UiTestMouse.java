import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class UiTestMouse extends JFrame {
    JLabel lbl, lbl2;

    UiTestMouse() {
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        lbl = new JLabel();
        lbl2 = new JLabel();

        JPanel pnl = new JPanel();

        pnl.add(lbl);
        pnl.add(lbl2);

        add(pnl);

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                lbl.setText("X: " + e.getX());
                lbl2.setText("Y: " + e.getY());
            }
        });


    }

    public static void main(String[] args) {
        new UiTestMouse().setVisible(true);
    }
}
