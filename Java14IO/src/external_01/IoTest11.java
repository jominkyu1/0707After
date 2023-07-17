package external_01;
//객체 직렬화 클래스 Customer.java를 활용해서 result10.txt에 객체단위로 기록된것을 객체 단위로 읽어온다.

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class IoTest11 {
    public static void main(String[] args) {

        try{
            FileInputStream fis = new FileInputStream("./src/external_01/result10.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);

            Customer cus = (Customer) ois.readObject();

            System.out.println(cus.toString());

        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
