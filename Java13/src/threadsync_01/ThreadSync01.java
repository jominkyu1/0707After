package threadsync_01;
//스레드 동기화 예제

class Account01{
    private int balance = 1000; //은행잔고

    public int getBalance(){
        return balance;
    }
    //동기화가 안된 출금작업 -> 동시에 여러 스레드에 의해 출금작업이 이루어짐
    public void withdraw(int money){
        try{
            Thread.sleep(100); //1초 스레드 일시정지
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        balance -= money;
    }
}
class Thread06 implements Runnable{
    Account01 acc = new Account01();

    @Override
    public void run() {
        int money = (int)(Math.random()*3+1)*100; // 100, 200, 300
        while(acc.getBalance()>=money){
            acc.withdraw(money);
            System.out.println(Thread.currentThread().getName() + "남은 잔액: " + acc.getBalance());
        }
    }
}
public class ThreadSync01 {
    public static void main(String[] args) {
        Thread06 t06 = new Thread06();
        Thread t = new Thread(t06);
        t.start();

        Thread t02 = new Thread(new Thread06());
        t02.start();
    }
}