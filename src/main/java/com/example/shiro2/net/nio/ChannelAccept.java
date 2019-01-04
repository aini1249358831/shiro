package com.example.shiro2.net.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ChannelAccept {
    public static final String STR_HELLO="我爱我家";

    public static void main(String[] args) throws Exception {
        int port = 1235;
        ServerSocketChannel channel = ServerSocketChannel.open();
        if(args.length>0){
            port = Integer.parseInt(args[0]);

        }
        ByteBuffer buff = ByteBuffer.wrap(STR_HELLO.getBytes());
        channel.socket().bind(new InetSocketAddress(port));
        System.out.println(channel.socket().getLocalPort());
        channel.configureBlocking(false);
        while(true){
            System.out.println("等待连接");
            //监听新进来的连接
            SocketChannel accept = channel.accept();
            if(accept==null){
                System.out.println("连接为空");
               Thread.sleep(500);
            }
            else{
                System.out.println("已经取得连接"+channel.socket().getLocalSocketAddress());
                buff.rewind();
                accept.write(buff);
                accept.close();

            }

        }



    }
}
