package com.jnshu.service.serviceImpl;

import com.jnshu.mapper.ProfessionMapper;
import com.jnshu.pojo.Profession;
import com.jnshu.service.ProfessionService;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
@CacheConfig(cacheNames = "Profession")
public class ProfessionServiceImpl implements ProfessionService {
    @Autowired
    ProfessionMapper professionMapper;
//    @Autowired
//    MemcachedClient memcachedClient;

    private static Logger logger=LogManager.getLogger(ProfessionService.class);
    @Override
    @SuppressWarnings("unchecked")
    @Cacheable
//    public List<Map<Integer, List>> upLoadProfession(List type)throws TimeoutException,InterruptedException, MemcachedException {
        public List<Map<Integer, List>> upLoadProfession(List type) {
            logger.info("first select from mysql");
            List model=new ArrayList();
            Profession profession=new Profession();
            Map<Integer,List> map=new HashMap<Integer, List>();
            for(int i=0;i<type.size();i++){
                List typeList=professionMapper.upLoadProfession((Integer) type.get(i));
                map.put((Integer) type.get(i),typeList);
            }
            model.add(map);
            return model;
        }
//            if(null==memcachedClient.get("upLoadProfession")){
//        logger.info("first select from mysql");
//        List model=new ArrayList();
//        Profession profession=new Profession();
//        Map<Integer,List> map=new HashMap<Integer, List>();
//        for(int i=0;i<type.size();i++){
//            List typeList=professionMapper.upLoadProfession((Integer) type.get(i));
//            map.put((Integer) type.get(i),typeList);
//        }
//        model.add(map);
//        memcachedClient.set("upLoadProfession",0,model);
//        return model;
//    }else{
//        logger.info("select data from cache");
//        return memcachedClient.get("upLoadProfession");
//    }
//}

    @Override
    @SuppressWarnings("unchecked")
    @Cacheable
//    public Map<Integer,List> upLoadProfessions(@Param("status")Integer status) throws InterruptedException, MemcachedException, TimeoutException {
    public Map<Integer,List> upLoadProfessions(@Param("status")Integer status){
        List alltype=professionMapper.distinctType(status);
         Map<Integer,List> map=new HashMap<Integer, List>();
         for(int i=0;i<alltype.size();i++){
             Profession profession=(Profession) alltype.get(i);
             List type=professionMapper.professionByType(profession.getType());
             map.put(profession.getType(),type);

         }
         return map;
        }
//     if(null==memcachedClient.get("upLoadProfession")){
//
//
//         List alltype=professionMapper.distinctType(status);
//         Map<Integer,List> map=new HashMap<Integer, List>();
//        for(int i=0;i<alltype.size();i++){
//        Profession profession=(Profession) alltype.get(i);
//        List type=professionMapper.professionByType(profession.getType());
//        map.put(profession.getType(),type);
//
//        }
//        memcachedClient.set("upLoadProfession",0,map);
//        return map;
//        }else {
//        return memcachedClient.get("upLoadProfession");
//        }
//        }

    @Override
    @SuppressWarnings("unchecked")
    @Cacheable
    public List upLoadProfession(@Param("status")Integer status){
        return professionMapper.upLoadProfession(status);
    }
}

