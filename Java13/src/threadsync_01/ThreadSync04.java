package threadsync_01;
//멀티스레드가 아닌 단일 프로그램이다. 즉, 하나의 프로그램이 끝이 나야 다음 프로그램이 실행된다.

import javax.swing.*;

public class ThreadSync04 {
    public static void main(String[] args) {
        String inputName = JOptionPane.showInputDialog("이름을 입력하세요.");
        //showInputDialog 메소드는 메세지를 담고 입력필드를 가진 다일로그 창을 만듦

        System.out.println("입력 하신 이름: " + inputName);

        for (int i = 0; i < 10; i++) {
            System.out.println(10-i);
            try {
                Thread.sleep(150);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
