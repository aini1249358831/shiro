package com.example.shiro2.net.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class ClientChannel {
    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost",1235));
        ByteBuffer buff = ByteBuffer.allocate(1024);
        buff.clear();
        try{
            while (true){
                socketChannel.read(buff);
                byte[] array = buff.array();
                System.out.println("接受到的数据为"+new String(array,0,array.length));
            }
        }
        finally{
            socketChannel.close();
        }

    }
}
