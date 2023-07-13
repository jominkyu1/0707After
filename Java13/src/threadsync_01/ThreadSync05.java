package threadsync_01;

import javax.swing.*;

public class ThreadSync05 implements Runnable{
    @Override
    public void run() {
        String cityName = JOptionPane.showInputDialog("도시 이름 입력");
        System.out.println("도시 이름: " + cityName);

        for (int i = 10; i >= 1; i--) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args) {
        new Thread(new ThreadSync05()).start();
        new Thread(new ThreadSync05()).start();
    }
}