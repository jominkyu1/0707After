package functional_02;
//내장함수형인터페이스 Thread, Runnable
//람다식으로 멀티쓰레드 프로그램 구현 (하나의 프로그램내에서 동시 작업이 이루어지는것)

public class RunnableExample {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 1; i <= 10; i++) {
                System.out.print(" " + i);
            }
        };

        Thread th = new Thread(runnable);
        th.start(); //스레드 시작

        Thread th1 = new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                System.out.print(" " + i);
            }
        });

        th1.start(); //스레드2 시작
    }
}
