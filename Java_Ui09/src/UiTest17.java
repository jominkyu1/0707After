import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;

class MyPanel17 extends JPanel{
    BufferedImage img = null; // BufferedImage는 이미지를 읽어들임
    int img_x = 100, img_y = 100;

    public MyPanel17(){
        try{

            img = ImageIO.read(new File("./images/car.jpg.jpg"));
        }catch (Exception e){
            System.out.println("자동차 이미지 없음");
            e.printStackTrace();
            System.exit(1);
            /*  status
                0: 문제없이 종료
                1: 문제있으면 종료 (예외가 발생했으니 종료)
            * */
        }

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keyCode = e.getKeyCode();

                switch(keyCode){
                    case KeyEvent.VK_UP: img_y -= 10; break;
                    case KeyEvent.VK_DOWN: img_y += 10; break;
                    case KeyEvent.VK_LEFT: img_x -= 10; break;
                    case KeyEvent.VK_RIGHT: img_x += 10; break;
                }

                repaint();
            }
        });

        setFocusable(true); // 패널이 키보드 포커스를 받을 수 있게함
        this.requestFocus(); //키보드 포커스 요청

    }

    @Override
    public void paint(Graphics g) { //무엇을 그리고자 호출되는 메소드
        super.paintComponent(g);
        g.drawImage(img, img_x, img_y, null);
    }
}
public class UiTest17 extends JFrame {
    public UiTest17() {
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new MyPanel17());
    }

    public static void main(String[] args) {
        new UiTest17().setVisible(true);
    }
}