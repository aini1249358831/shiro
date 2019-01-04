package com.example.shiro2.net.nets;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client1 {
    public static void main(String[] args) throws Exception {
        Socket socket = new Socket("localhost",8080);
        DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
        DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
        boolean flag = false;
        Scanner scanner = new Scanner(System.in);
        while(!flag){
            System.out.println("请输入正方形的长度");
            double v = scanner.nextDouble();
            dos.writeDouble(v);
            dos.flush();
            double readDouble = dis.readDouble();
            System.out.println("从服务器端接收到的数据为"+readDouble);
            while(true){
                System.out.println("是否继续运算Y/N");
                String next = scanner.next();
                if(next.equalsIgnoreCase("Y")){
                    dos.writeInt(1);
                    dos.flush();
                    break;
                }
                else if (next.equalsIgnoreCase("N")){
                    dos.writeInt(0);
                    dos.flush();
                    flag = true;
                    break;
                }

            }

        }
        socket.close();






    }
}
