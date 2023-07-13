package threadsync_01;

//동기화가 처리된 출금작업 스레드
class Account07 {
    private int balance = 1000;

    public int getBalance() {
        return balance;
    }

    //동기화 처리로 하나의 스레드에서만 출금작업이 이루어진다.
    public synchronized void withdraw(int money) {
        if (balance >= money) {
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            balance -= money;
        }
    }
}

class Thread07 extends Thread {
    Account07 acc = new Account07();

    @Override
    public void run() {
        while(acc.getBalance()>0){
            int money = (int)(Math.random()*3+1)*100;
            acc.withdraw(money);
            System.out.println(Thread.currentThread().getName() + " 남은잔액: " + acc.getBalance());
        }
    }
}

public class ThreadSync02 {
    public static void main(String[] args) {

        Thread07 th = new Thread07();
        th.start();
        new Thread(th).start();
    }
}
