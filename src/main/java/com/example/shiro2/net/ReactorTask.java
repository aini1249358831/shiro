package com.example.shiro2.net;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

public class ReactorTask implements Runnable {
    private Selector selector;

    public ReactorTask() throws IOException {
        ServerSocketChannel socketChannel = ServerSocketChannel.open();
        /**配置端口和地址，设置非阻塞
         * */
        socketChannel.socket().bind(new InetSocketAddress(InetAddress.getByName("localhost"),1234));
        socketChannel.configureBlocking(false);
        /**创建reactor线程
         * */
        selector = Selector.open();
        /**将ServerScoketChannel注册到selector上，监听事件
         *
         * */
        SelectionKey register = socketChannel.register(selector, SelectionKey.OP_ACCEPT);
    }

    @Override
    public void run() {
        while(true){
            SelectionKey key = null;
            try {
                selector.select(1000);
                Set<SelectionKey> set = selector.selectedKeys();
                Iterator<SelectionKey> it = set.iterator();
                while(it.hasNext()){
                    key = it.next();
                    it.remove();
                    if (key.isValid()){
                        /**处理接入的信息
                         * */
                        if(key.isAcceptable()){
                            /**完成tcp三次握手
                             * */
                           ServerSocketChannel ssc= (ServerSocketChannel) key.channel();
                            SocketChannel sc = ssc.accept();
                            /**设置为非阻塞的
                             * */
                            sc.configureBlocking(false);
                            sc.socket().setReuseAddress(true);
                            /**将新接入的客户端连接注册到reactor线程的多路复用器上
                             * */
                             sc.register(selector,SelectionKey.OP_READ);
                             if(key.isReadable()){
                                 /**异步读取客户端的请求消息到缓存区
                                  * */
                               SocketChannel socketChannel = (SocketChannel) key.channel();
                                 ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                                 int readBytes = sc.read(readBuffer);
                                 if(readBytes>0){
                                     /**对byteBuffer进行编解码,如果有半包信息指针reset，继续读取后续的报文
                                      * */
                                     readBuffer.flip();
                                     byte[] bytes = new byte[readBuffer.remaining()];
                                     readBuffer.get(bytes);
                                     String body = new String(bytes,"utf-8");
                                     String currentTime = "".equalsIgnoreCase(body) ? new Date(System.currentTimeMillis()).toString():"Bad order";
                                     /**写应答
                                      * */
                                     byte[] bytes1 = currentTime.getBytes();
                                     ByteBuffer writeBuffer = ByteBuffer.allocate(bytes1.length);
                                     writeBuffer.put(bytes1);
                                     writeBuffer.flip();
                                     sc.write(writeBuffer);


                                 }
                                 else if(readBytes<0){
                                     key.cancel();
                                     sc.close();
                                 }else
                                     ;

                             }


                        }

                    }

                }

            } catch (IOException e) {

                if(key!=null){
                    key.cancel();
                    if(key.channel()!=null){
                        try {
                            key.channel().close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }

                    }

                }
            }

        }

    }

    /*public static void main(String[] args) throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("d:\\abc.txt","rw");
        FileChannel channel = randomAccessFile.getChannel();
        ByteBuffer byteBuffer = ByteBuffer.allocate(48);
        FileChannel position = channel.position(12L);
        int read = position.read(byteBuffer);
        while(read!=-1){
            System.out.println("读取到的大小： "+read);
            *//**反转buffer
             * *//*
            byteBuffer.flip();
            while(byteBuffer.hasRemaining()){
                System.out.print((char) byteBuffer.get());
            }
            byteBuffer.clear();
           read = channel.read(byteBuffer);
        }
        randomAccessFile.close();


    }*/
    public static void main(String[] args) throws Exception {
        RandomAccessFile randomAccessFile = new RandomAccessFile("d:\\abc.txt","rw");
        FileChannel channel = randomAccessFile.getChannel();
        FileChannel truncate = channel.truncate(14);
        ByteBuffer write = ByteBuffer.allocate(48);
        write.clear();
        write.put("我爱我家".getBytes());
        write.flip();
        while(write.hasRemaining()){
            truncate.write(write);

        }

        randomAccessFile.close();
    }
}
