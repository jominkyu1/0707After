package thread_01;

// Multi Thread 구현 방법
// Thread 클래스를 상속받는다. (Thread클래스는 Runnable인터페이스를 상속받고있음)
public class ThreadTest01 extends Thread {
    ThreadTest01(String name){
        super(name); //스레드이름
    }
    
    @Override
    public void run() {
        for(int i=0; i<5; i++){
            for(int j=1; j<100000000; j++);//스레드가 교대작업을 하기위해 시간적 여유를 줌
            System.out.println(getName() + " : " + i);
        }
    }

    public static void main(String[] args) {
        ThreadTest01 th = new ThreadTest01("첫번째 스레드");
        ThreadTest01 th2 = new ThreadTest01("두번째 스레드");

        th.start();
        th2.start();


    }
}