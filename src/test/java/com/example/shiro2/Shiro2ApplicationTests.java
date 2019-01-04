package com.example.shiro2;
import com.example.shiro2.entity.User;
import com.example.shiro2.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.validation.constraints.AssertTrue;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.ThreadPoolExecutor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Shiro2ApplicationTests {
    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
        /*SimpleHash simpleHash = new SimpleHash("MD5","1111","salt",2);
        System.out.println(simpleHash.toString());
       *//**
        * 加盐后默认散列一次*//*
       String md5 = new Md5Hash("1111","salt",2).toString();
        System.out.println(md5);*/
        /*List<? extends String> integers = Arrays.asList((java.lang.String) new java.lang.String[]{"1"}, "2", "3");
        System.out.println(integers);*/
        /**不要在foreach中使用remove ,add操作
         * */
       /* Map map = new HashMap();
        Arrays.sort(new String[]{"a","b'"});
        map.keySet();*/
        /*Instant instant = Instant.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime localDateTime =  LocalDateTime.now();
        java.lang.String format = localDateTime.format(dateTimeFormatter);
        LocalDateTime parse = LocalDateTime.parse("-1", dateTimeFormatter);*//*
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_MONTH,-1);
        Date time = calendar.getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.lang.String format = simpleDateFormat.format(time);
        System.out.println(format);*/
       /* String s = "123";
        Optional<java.lang.String> optional = Optional.ofNullable(s);
        if(optional.isPresent()){
            System.out.println(optional.get());
        }*/
       int a = 1;
       int b = 2;
       Assert.assertNotEquals(a,b);

    }

}

