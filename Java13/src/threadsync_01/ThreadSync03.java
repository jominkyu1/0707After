package threadsync_01;
// 입출금 멀티스레드 동기화 예제

class Atm {
    private int money; //은행계좌잔액

    Atm() {
    }

    Atm(int money) {
        this.money = money;
    }

    synchronized void deposit(int amount, String name) {
        money += amount;
        System.out.println(name + " 입금 금액: " + amount);
    }

    synchronized void withdraw(int amount, String name) {
        if ((money - amount) > 0) {
            money -= amount;
            System.out.println(name + " 출금 금액: " + amount);
        } else {
            System.out.println(name + " 잔액부족");
        }
    }

    public int getMoney() {
        return money;
    }
}

class AtmUser extends Thread {
    boolean flag = false;
    Atm obj;

    public AtmUser(Atm obj, String name) {
        super(name);
        this.obj = obj;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            if (flag) { //첫값 false
                int rand = (int) ((Math.random() * 10 + 2) * 100); //200~1100 백의 단위
                obj.deposit(rand, getName()); //입금
                System.out.println(getName() + " 입금 후 잔액:" + obj.getMoney());
            } else {
                int rand = (int) ((Math.random() * 10 + 2) * 100);
                obj.withdraw(rand, getName()); //출금
                System.out.println(getName() + " 출금 후 잔액: " + obj.getMoney());
            }
            flag = !flag; //입출금 반복
        }
    }
}

public class ThreadSync03 {
    public static void main(String[] args) {
        Atm obj = new Atm(1000);

        AtmUser user01 = new AtmUser(obj, "첫번째");
        AtmUser user02 = new AtmUser(obj, "두번째");
        AtmUser user03 = new AtmUser(obj, "세번째");

        user01.start();
        user02.start();
        user03.start();
    }
}