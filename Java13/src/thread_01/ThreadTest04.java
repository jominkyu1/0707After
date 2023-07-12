package thread_01;
    //Runnnable인터페이스를 구현 상속받아 멀티 스레드 구현 (다중 상속이 가능함)
    //단, Thread 객체를 생성하여 Runnable 객체인자를 넘겨준 후 start() 메소드를 호출해야 함

class Thread04 implements Runnable{
    @Override
    public void run() {
        for(int i=0; i<5; i++){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(Thread.currentThread().getName()+": "+i);
        }
    }
}
public class ThreadTest04 {
    public static void main(String[] args) {
        Thread t = new Thread(new Thread04(), "첫번째 스레드");
        t.start();
        
        Thread t2 = new Thread(new Thread04(), "두번째 스레드");
        t2.start();
    }
}
