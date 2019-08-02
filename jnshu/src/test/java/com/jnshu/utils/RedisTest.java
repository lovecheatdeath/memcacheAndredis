package com.jnshu.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-redis.xml")
public class RedisTest<T> {
@Autowired
RedisTemplate redisTemplate;
//    通过opsForValue方法返回一个默认操作类，来进行redis默认的String的键值操作
    @Test
    public void opsForValue(){
        redisTemplate.opsForValue().set("Value","String");
        Object result = redisTemplate.opsForValue().get("Value");
        System.out.print(result);
        System.out.println('\n');
    }
//    opsForSet返回一个Redis的Set集合的操作类接口
    @Test
    public void SetOperations() {
        SetOperations<String, Object> set = redisTemplate.opsForSet();
        set.add("set1",1, 9, 4, 9);
        set.add("set2",1, 9, 3, 7);
        System.out.println(set.members("set1"));
        set.pop("set2");
        System.out.println(set.members("set2"));
    }
//    opsForZset方法返回一个Zset类型的操作类，Zset是一个有序的集合
    @Test
    public void ZSetOperations() {
        ZSetOperations<String, Object> zset = redisTemplate.opsForZSet();
        zset.add("zset1",1,1);
        zset.add("zset1",2,3);
        zset.add("zset1",2,4);
        zset.add("zset1",3,2);

        System.out.println(zset.range("zset1",0, -1));
    }
//    put方法接收三个参数，第一个是存放map位置的key值，第二个是map的key值，第三个是map的value
    @Test
    public void HashOperations() {
        HashOperations<String, String, Object> hash = redisTemplate.opsForHash();
        hash.put("hash1","map1","value1");
        hash.put("hash1","map2","value2");
        hash.put("hash1","map3","value3");
        System.out.println(hash.get("hash1","map1"));
        System.out.println(hash.entries("hash1"));
    }
//    opsForList方法返回一个List类型的操作类
@Test
public void name() {
    ListOperations<String, Object> list = redisTemplate.opsForList();
    Object popValue = redisTemplate.opsForList().rightPop("list1");
    System.out.print("通过rightPop(K key)方法移除的元素是:" + popValue);
    System.out.println('\n');
//    list.leftPush("list1",1);
//    list.leftPush("list1",2);
//    list.rightPush("list1",3);
    System.out.println(list.range("list1",0, -1));
}
}
