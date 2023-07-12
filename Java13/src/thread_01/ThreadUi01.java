package thread_01;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

// Thread + AWT GUI 지나가는 글자 출력 예제
class Thread05 extends Frame implements Runnable{
    int x=1; //x좌표

    public Thread05(){
        setBackground(new Color(49, 77, 136));
        setSize(340, 180);
        setVisible(true);


        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        Dimension d; // width+height = Dimension
        d = getSize(); //프레임 윈도우 창 구하기

        g.setColor(Color.ORANGE);
        g.setFont(new Font("궁서체", Font.BOLD,30 ));
        g.drawString("장마가 시작됩니다.", x, d.height/2);

        if(d.width<x) x=0;
    }

    @Override
    public void run() {
        while(true){
            try{
                Thread.sleep(100);
            }catch(InterruptedException e){
                System.out.println(e.getMessage());
            }

            repaint();
            x+=5;
        }
    }
}

public class ThreadUi01 {
    public static void main(String[] args) {
        Thread05 t = new Thread05();

        Thread th01 = new Thread(t);
        th01.start();
    }
}
