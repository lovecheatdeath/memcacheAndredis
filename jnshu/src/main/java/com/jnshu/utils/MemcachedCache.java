package com.jnshu.utils;


import net.spy.memcached.MemcachedClient;
import net.spy.memcached.OperationTimeoutException;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MemcachedCache implements Cache {
    @Autowired
    MemcachedClient memcachedClient;
    public MemcachedCache() {
    }

    public void set(String key, Object value, int expiry)
    {
        if(StringUtils.isEmpty(key) || value == null)
        {
            return;
        } else
        {
            memcachedClient.set(key, expiry * 60, value);
            return;
        }
    }

    public Object get(String key)
    {
        if(StringUtils.isEmpty(key))
            return Boolean.valueOf(false);
        Object object;
        try
        {
            object = memcachedClient.get(key);
        }
        catch(OperationTimeoutException e)
        {
            object = memcachedClient.get(key);

        }
        return object;
    }


    public Map getMulti(List keys)
    {
        if(keys == null || keys.size() == 0)
        {
            return new HashMap(0);
        } else
        {
            String strKeys[] = new String[keys.size()];
            strKeys = (String[])keys.toArray(strKeys);
            return memcachedClient.getBulk(strKeys);
        }
    }

    public Object[] getMulti(String keys[])
    {
        if(keys == null || keys.length == 0)
        {
            return new Object[0];
        } else
        {
            Map map = memcachedClient.getBulk(keys);
            return map.values().toArray();
        }
    }

    public void delete(String key)
    {
        if(StringUtils.isEmpty(key))
        {
            return;
        } else
        {
            memcachedClient.delete(key);
            return;
        }
    }

    public boolean exists(String key)
    {
        if(StringUtils.isEmpty(key))
            return false;
        else
            return memcachedClient.get(key) != null;
    }

//    public void setMemcachedClient(MemcachedClient memcachedClient)
//    {
//        this.memcachedClient = memcachedClient;
//    }
//
//    private MemcachedClient memcachedClient;

}
