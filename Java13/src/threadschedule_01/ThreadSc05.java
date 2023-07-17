package threadschedule_01;
// wait()와 notify() 스레드 스케쥴링 메소드 사용예제

import java.util.ArrayList;

class Table05 {
    String[] dishNames = {"donut", "donut", "burger"};
    final int MAX_FOOD = 6;
    private ArrayList<String> dishes = new ArrayList<>();

    public ArrayList<String> getDishes(){
        return dishes;
    }

    //동기화 된 음식 추가
    public synchronized void add(String dish) {
        while (dishes.size() >= MAX_FOOD) { //만들어놓은 음식이 6개 이상이면 대기
            String name = Thread.currentThread().getName();
            System.out.println(name + "is waiting");

            try {
                wait(); //스레드를 기다리게 함. (요리사)
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        dishes.add(dish);
        notifyAll(); // 기다리고 있는 소비자를 깨워서 음식을 먹게 함.
        System.out.printf("[%s] 추가\n", dish);
        System.out.println("추가 된 음식 목록: " + dishes.toString());
    }

    public void remove(String dishName) {
        synchronized (this) {
            String name = Thread.currentThread().getName();

            while (dishes.size() == 0) { //테이블(dishes)에 음식이 없으면 기다리게함
                System.out.println(name + " is waiting (size=0)");
                try {
                    wait(); // 소비자를 기다리게 함.
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }

            while (true) {
                for (int i = 0; i < dishes.size(); i++) {
                    if (dishName.equals(dishes.get(i))) {
                        dishes.remove(i);
                        notifyAll(); //대기실에 있는 요리사를 깨운다
                        return;
                    }
                }

                try {
                    System.out.println(name + " is waiting");
                    wait(); //음식이 없어 소비자를 대기실로 보낸다
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }//동기화 영역
    }

    public int dishNum() {
        return dishNames.length; // donut, donut, burger
    }
}

//소비자 클래스
class Customer05 implements Runnable {
    private Table05 table;
    private String food;

    Customer05(Table05 table, String food) {
        this.table = table;
        this.food = food;
    }


    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            String name = Thread.currentThread().getName();

            table.remove(food);
            System.out.println(name + " ate a " + food + "\n남은 음식 목록: " + table.getDishes());
        }
    }
}

//요리사 클래스
class Cook05 implements Runnable{
    private Table05 table;

    Cook05(Table05 table){
        this.table=table;
    }

    @Override
    public void run() {
        while(true){
            int idx = (int)(Math.random()*table.dishNum());

            table.add(table.dishNames[idx]);

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

public class ThreadSc05 {
    public static void main(String[] args) throws Exception {
        Table05 table = new Table05();

        new Thread(new Cook05(table), "Cook01").start();
        new Thread(new Customer05(table, "donut")).start();
        new Thread(new Customer05(table, "burger")).start();

        Thread.sleep(2000);
        System.exit(0);
    }
}
