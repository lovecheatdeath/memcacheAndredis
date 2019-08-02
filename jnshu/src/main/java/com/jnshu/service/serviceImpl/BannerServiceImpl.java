package com.jnshu.service.serviceImpl;

import com.jnshu.mapper.BannerMapper;
import com.jnshu.pojo.Banner;
import com.jnshu.service.BannerService;

import com.jnshu.utils.RedisCache;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Service
@CacheConfig(cacheNames = "Banner")
public class BannerServiceImpl implements BannerService {

    @Autowired
    BannerMapper bannerMapper;
    @Autowired
    private RedisCache redisCache;
//    @Autowired
//    MemcachedClient memcachedClient;

    private static Logger logger = LogManager.getLogger(BannerService.class);
    @Override
    @SuppressWarnings("unchecked")
    @Cacheable
//        public List ListUpLoad(@Param("status")Integer status)throws TimeoutException,InterruptedException, MemcachedException {
    public List ListUpLoad(@Param("status")Integer status){
            logger.info("first select from mysql");
            List<Banner> bannerList=bannerMapper.upLoadBanner(status);
            return bannerList;
        }
    }
//        if (null == memcachedClient.get("ListUpLoad")) {
//        logger.info("first select from mysql");
//        List<Banner> bannerList=bannerMapper.upLoadBanner(status);
//        memcachedClient.set("ListUpLoad", 0, bannerList);
//        return bannerList;
//        } else {
//        logger.info("select data from cache");
//        return memcachedClient.get("ListUpLoad");
//        }
//        }
//        }

