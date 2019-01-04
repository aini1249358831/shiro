package com.example.shiro2.net.udp;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
public class Server {
    public static void main(String[] args) throws IOException {

        DatagramSocket server = new DatagramSocket(8089);
        DatagramPacket datagramPacket = new DatagramPacket(new byte[1024],1024);
        server.receive(datagramPacket);
        String string = new String(datagramPacket.getData(),0,datagramPacket.getLength());
        System.out.println(string);


    }
}
