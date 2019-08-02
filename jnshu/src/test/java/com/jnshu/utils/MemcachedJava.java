package com.jnshu.utils;

import net.spy.memcached.MemcachedClient;
import org.junit.Test;

import java.net.*;


public class MemcachedJava {
    private int i=1;
    @Test
    public void MemcachedJava() {
        try {
            // 本地连接 Memcached 服务
            MemcachedClient mcc = new MemcachedClient(new InetSocketAddress("127.0.0.1", 11211));
            System.out.println("Connection to server sucessful.");

            // 关闭连接
            mcc.shutdown();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    @Test
    public void ThisTest(){
        this.i=i+1;
        System.out.println("Int constructor i——this.i:  "+i+"——"+this.i);

        System.out.println("i-1:"+(i-1)+"this.i+1:"+(this.i+1));
    }

}