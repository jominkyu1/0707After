// Thread가 적용된 다중 접속가능한 멀티채팅 서버 프로그램 예제

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

class EchoServerThread implements Runnable{
    Socket child;
    InputStream is;
    ObjectInputStream ois;

    OutputStream os; //바이트 출력 스트람의 최상위 추상 클래스
    ObjectOutputStream oos;

    String receiveData; //전송받은 자료

    public EchoServerThread(Socket child){
        this.child=child;

        try{
            System.out.println(child.getInetAddress() + "로 부터 연결 요청 받음.");

            is = child.getInputStream();
            ois = new ObjectInputStream(is); //입력 스트림 생성

            os = child.getOutputStream();
            oos = new ObjectOutputStream(os); //출력 스트림 생성
        }catch(IOException ie){
            ie.printStackTrace();
        }
    }

    @Override
    public void run() {
        try{
            while(true){
                receiveData = (String) ois.readObject(); //사용자로부터 전송된 데이터를 저장함
                System.out.println(child.getInetAddress()+"의 메세지: "+receiveData);
                oos.writeObject(receiveData); // 다시 사용자에게 데이터를 송신함
                oos.flush();
            }
        }catch(Exception e){
            System.out.println("클라이언트 강제 종료");
        }finally {
            try{
                if(is!=null) is.close();
                if(ois!=null) ois.close();
                if(os!=null) os.close();
                if(oos!=null) oos.close();;
                if(child!=null) child.close();
            }catch(IOException ie){
                ie.printStackTrace();
            }
        }
    }
}

public class MultiChatServer {
    ServerSocket server; //서버상에서 사용자 접속을 기다리기 위해 필요한 클래스
    static final int PORT=5000;
    Socket child;

    public MultiChatServer(){
        try{
            server = new ServerSocket(PORT);
        }catch(Exception e){
            e.printStackTrace();
            System.exit(0);
        }

        System.out.println("***** 채팅서버 *****");
        System.out.println("서버는 클라이언트 소켓의 접속을 기다리고 있음.");

        while(true){
            try{//Socket = ServerSocket.accept();
                child = server.accept();

                EchoServerThread childThread = new EchoServerThread(child);
                Thread th = new Thread(childThread);
                th.start();

            }catch(Exception e){
                e.printStackTrace();
                System.exit(0);
            }
        }
    }

    public static void main(String[] args) {
        new MultiChatServer();
    }
}