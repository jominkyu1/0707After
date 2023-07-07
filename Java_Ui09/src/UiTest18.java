import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.image.BufferedImage;
import java.io.File;

//마우스를 클릭했을때 x, y좌표를 구해서 해당 자동차 이미지를 이동시키는 예제
class MyPanel18 extends JPanel {
    BufferedImage img = null;
    int img_x = 0, img_y = 0;

    public MyPanel18() {
        try {
            File fl = new File("./images/car.jpg.jpg");
            img = ImageIO.read(fl);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        
        addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
               img_x = e.getX(); img_y = e.getY();

               repaint(); //paint메소드 다시 호출

            }
        });
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img, img_x, img_y, null);
    }
}

class MyFrame18 extends JFrame{
    public MyFrame18(){
        setSize(400,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("MyFrame18");
        add(new MyPanel18());
    }
}

public class UiTest18 {
    public static void main(String[] args) {
      new MyFrame18().setVisible(true);
    }
}
