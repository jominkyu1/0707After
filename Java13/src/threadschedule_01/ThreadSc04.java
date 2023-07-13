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
        }

    }

    public boolean eatFood() throws InterruptedException {
        return table.remove(food);
    }
}

public class ThreadSc04 {
    public static void main(String[] args) throws InterruptedException {
        new Table04().remove("AA");
    }
}
