package com.jnshu.service;

import net.rubyeye.xmemcached.exception.MemcachedException;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.concurrent.TimeoutException;

public interface BannerService {

    List ListUpLoad(@Param("status")Integer status);

}
