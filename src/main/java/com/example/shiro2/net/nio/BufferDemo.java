package com.example.shiro2.net.nio;

import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

public class BufferDemo {
    private static final int start = 0;
    private static final int end = 1024;


    public static void main(String[] args) throws Exception {
        /**不能设置为非阻塞的
         * */
       /* FileChannel rw = new RandomAccessFile("d:\\abc.txt", "rw").getChannel();

      *//*  MappedByteBuffer map = rw.map(FileChannel.MapMode.READ_WRITE,start,end);
        byte[] bs = new byte[]{'a','c','s','c'};
        map.put(bs);
        rw.close();*//*
        ByteBuffer buffer = ByteBuffer.wrap("我爱我家".getBytes());
        ByteBuffer buffer1 = ByteBuffer.wrap("中华人名共和国万岁".getBytes());
        ByteBuffer[] byteBuffers = {buffer,buffer1};
        rw.write(byteBuffers);
        rw.close();*/
        DatagramChannel channel = DatagramChannel.open();
        ServerSocketChannel socketChannel =  ServerSocketChannel.open();
        Selector selector = Selector.open();
        channel.configureBlocking(false);
        socketChannel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_CONNECT);
        socketChannel.register(selector,SelectionKey.OP_ACCEPT);
        Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
        while(iterator.hasNext()){
            SelectionKey key = iterator.next();

            if(key.isReadable()){

          }
          else if(key.isWritable()){

            }
            else if(key.isAcceptable()){

            }
            else if (key.isConnectable()){

            }


        }


    }
}
