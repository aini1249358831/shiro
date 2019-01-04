package com.example.shiro2.net;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) throws IOException {

        // 端口号
        int port = 6900;
        //定义客户端的数量
        int clientNo = 1;
        // 在端口上创建一个服务器套接字
        ServerSocket serverSocket = new ServerSocket(port);
        // 监听来自客户端的连接
        ExecutorService pool = Executors.newCachedThreadPool();
        try{
            while(true){
                Socket socket = serverSocket.accept();
                pool.execute(new SingleServer(socket,clientNo));
                clientNo++;
            }

        }finally {

            serverSocket.close();
        }
    }



    }
