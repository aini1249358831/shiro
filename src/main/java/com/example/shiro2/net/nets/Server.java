package com.example.shiro2.net.nets;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {

    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        ExecutorService pool = Executors.newCachedThreadPool();
        int clientNo = 1;
        try{
            while (true){
                pool.execute(new SigleServer(serverSocket.accept(),clientNo));
                clientNo++;

            }

        }finally {
            serverSocket.close();
        }

    }
}
