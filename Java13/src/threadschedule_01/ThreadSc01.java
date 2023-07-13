package threadschedule_01;

import javax.swing.*;

class ThreadS1 extends Thread{
    @Override
    public void run() {
        System.out.println("isInterrupted(): " + isInterrupted());
        int i=10;

        while(i != 0 && !isInterrupted()){ // Interrupt = 일시정지상태
            System.out.println(i--);
            for(long x=0; x<1200000000L;x++); //sleep
        }

        System.out.println("카운터 종료");
    }
}
public class ThreadSc01 {
    public static void main(String[] args) {
        ThreadS1 ts = new ThreadS1();
        ts.start();

        String name = JOptionPane.showInputDialog("이름 입력");
        ts.interrupt(); //쓰레드 일시정지
        System.out.println("입력: "+name);
        System.out.println("isInterrupted(): " + ts.isInterrupted());
    }
}