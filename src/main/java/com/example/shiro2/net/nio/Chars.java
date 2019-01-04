package com.example.shiro2.net.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class Chars {
    public static void main(String[] args) {
        char[] chars = "hello world".toCharArray();
        CharBuffer wrap = CharBuffer.wrap(chars);
        ByteBuffer buff = ByteBuffer.allocate(1024);
        char[] array = wrap.array();
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
        }

    }
}
