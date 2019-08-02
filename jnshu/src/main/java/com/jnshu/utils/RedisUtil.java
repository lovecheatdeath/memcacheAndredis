//package com.jnshu.utils;
//
//import com.google.common.hash.HashCode;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.redis.core.ListOperations;
//import org.springframework.data.redis.core.RedisTemplate;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.stereotype.Component;
//
//import javax.annotation.PostConstruct;
//import java.util.HashMap;
//import java.util.Hashtable;
//import java.util.List;
//import java.util.function.Function;
//import java.util.function.Supplier;
//import java.util.concurrent.TimeUnit;
//
//public class RedisUtil{
// @Autowired
// private static RedisTemplate redisTemplate;
//
// private static Logger logger=LogManager.getLogger(RedisUtil.class);
//private RedisUtil(){
//
//}
///**
// * 判断缓存中是否存在
// * @param listkey
// * @return 是否存在
// */
//public static boolean haskey(String listkey){
//    return (redisTemplate.opsForValue().get(listkey)!=null);
//}
///**
// * 添加缓存
// * @param listkey
// * @param object
// * @param expiry
// * @return 添加成功
// */
////public static  boolean add(String listkey,Object object,Long expiry){
////
////}
//}