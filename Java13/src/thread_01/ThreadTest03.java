package thread_01;
//스레드 흉내내기
class Thread03{
    String name;

    Thread03(String name){
        this.name=name;
    }

    public void start(){
        run();
    }

    public void run(){
        for(int i=1; i<=5; i++){
            for(int j=1; j<10000000; j++); //sleep

            System.out.println(name+":"+i);
        }
    }
}

public class ThreadTest03 {
    public static void main(String[] args) {
        Thread03 th = new Thread03("첫번째 스레드");
        Thread03 th2 = new Thread03("두번째 스레드");

        th.start();
        th2.start();
    }
}
