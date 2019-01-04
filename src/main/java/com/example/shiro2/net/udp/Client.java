package com.example.shiro2.net.udp;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.nio.channels.Pipe;
import java.util.Enumeration;
import java.util.Vector;

public class Client {
    public static void main(String[] args) throws Exception {
       /* DatagramSocket client = new DatagramSocket();
        client.connect(InetAddress.getLocalHost(),8097);
        byte[] bytes = "我爱我家".getBytes();
        DatagramPacket send = new DatagramPacket(bytes,0,bytes.length);
        client.send(send);
        ServerSocketChannel serverSocketChannel = new ServerSocket(8080).getChannel();
        SocketChannel accept = serverSocketChannel.accept();*/
        Pipe pipe = Pipe.open();
        Pipe.SinkChannel sinkChannel = pipe.sink();
        ByteBuffer buffer = ByteBuffer.wrap("我爱我家".getBytes());
        sinkChannel.write(buffer);
        Pipe.SourceChannel source = pipe.source();
        buffer.clear();
        int read = source.read(buffer);
        System.out.println(read);
        buffer.flip();
        sinkChannel.close();
        source.close();
        FileChannel fileChannel = new RandomAccessFile("d:\\abc.txt","rw").getChannel();
        /***
         * lock为阻塞的
         * try lock 为非阻塞的方法
         */
        FileLock fileLock =fileChannel.tryLock();
        System.out.println(fileLock.isShared());
        Vector<String> vector = new Vector<>();
        vector.add("abc");
        Enumeration enumeration =  vector.elements();

    }
}
