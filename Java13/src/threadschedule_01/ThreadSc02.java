package threadschedule_01;

import javax.swing.*;

class Tsc02 extends Thread{
    @Override
    public void run() {
        int i=10;

        while(i != 0 && !isInterrupted()){
            System.out.println(i--);

            try {
                sleep(1000);
            } catch (InterruptedException e) {
                //InterruptedException 예외 오류가 발생되면
                //interrupt상대를 자동으로 false로 설정함.

                interrupt(); //수동으로 일시정지시킴
            }
        }
        System.out.println("카운터 종료");
    }
}
public class ThreadSc02 {
    public static void main(String[] args) {
        Tsc02 th = new Tsc02();
        th.start();

        String name = JOptionPane.showInputDialog("이름?");
        System.out.println("입력한 이름: " + name);

        th.interrupt();
        System.out.println(th.isInterrupted());
    }
}