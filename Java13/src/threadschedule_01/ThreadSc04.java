package threadschedule_01;

import java.util.ArrayList;

class Table04 {
    String[] dishNames = {"donut", "donut", "burger"}; //음식재료
    final int MAX_FOOD = 6;
    private ArrayList<String> dishes = new ArrayList<>();
    
    //테이블에 음식 추가하는것을 동기화 처리
    public synchronized void add(String dish){
        if(dishes.size() >= MAX_FOOD) return; //dishes 원소개수6이상 add() 메소드 종료
        dishes.add(dish);
        System.out.println(dish + " 추가 됨");
        System.out.println(dishes);
    }
    
    //테이블에서 음식 제거
    public boolean remove(String dishName) throws InterruptedException{
        synchronized (this){ //동기화처리
            while(dishes.size() == 0){
                System.out.println(Thread.currentThread().getName() + " is waiting");
                Thread.sleep(500);
            }

            for(int i=0; i<dishes.size();i++){
                //주문한 음식(dishName)이 dishes 컬렉션에 있다면(먹었다면) 제거
                if(dishName.equals(dishes.get(i))) {
                    dishes.remove(i);
                    return true; //음식을 먹었으면 true
                }
            }
        }
        return false;
    }

    public int dishNum(){
        return dishNames.length; //음식재료 개수(3) 반환
    }
}

//소비자 스레드 클래스
class Customer14 implements Runnable{
    private Table04 table;
    private String food;

    public Customer14(Table04 table, String food){
        this.table=table;
        this.food=food;
    }

    @Override
    public void run() {
        while(true){
            try {Thread.sleep(10);} catch (InterruptedException e) {}
            String name = Thread.currentThread().getName();

            try {
                if(eatFood()) {
                    System.out.println(name + " ate a " + food);
                } else {
                    System.out.println(name + " failed to eat.");
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean eatFood() throws InterruptedException {
        return table.remove(food);
    }
}

//요리사 스레드
class Cook14 implements Runnable{
    private Table04 table;

    public Cook14(Table04 table){
        this.table=table;
    }
    @Override
    public void run() {
        while(true){
            int idx = (int)(Math.random()*table.dishNum());

            table.add(table.dishNames[idx]); //테이블에 음식추가
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {}
        }
    }
}


public class ThreadSc04 {
    public static void main(String[] args) throws InterruptedException {
        Table04 table = new Table04();
        new Thread(new Cook14(table), "cook").start(); //요리사클래스에서 랜덤한 인덱스 요리 생성 (dishNames 중)
        
        new Thread((new Customer14(table, "donut")), "customer 01").start();
        new Thread(new Customer14(table, "burger"), "customer 02").start();

        Thread.sleep(5000);
        System.exit(0); //계속 기다리는것을 방지하기위해 5초뒤 종료
    }
}