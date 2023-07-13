package threadschedule_01;
//스레드를 일시정지 시키는 suspend() 메소드, suspend를 다시 깨우는 resume() 메소드
//스레드를 중지시키는 stop() 메소드, 스레드를 잠시 쉬게하는 sleep() 메소드 실습 예제

import java.util.ArrayList;
import java.util.List;

class Tsc03 implements Runnable{
    @Override
    public void run() {
        while(true){
            System.out.println(Thread.currentThread().getName());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
    }
}

public class ThreadSc03 {
    public static void main(String[] args) throws InterruptedException {
        Tsc03 th = new Tsc03();

        ArrayList<Thread> arr = new ArrayList<>();
        for (int i = 0; i < 3; i++) arr.add(new Thread(th, String.valueOf(i)));


        arr.forEach(Thread::start);

        Thread.sleep(2000);
        arr.get(0).suspend();
        Thread.sleep(2000);
        arr.get(1).suspend();
        Thread.sleep(3000);
        arr.get(0).resume();

        Thread.sleep(2000);
        for(Thread thread : arr) thread.stop();
    }
}