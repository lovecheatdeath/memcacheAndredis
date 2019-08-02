package com.jnshu.service;

import junit.framework.TestCase;
import net.rubyeye.xmemcached.exception.MemcachedException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/applicationContext-*.xml")
public class ProfessionServiceTest extends TestCase {
    @Autowired
    ProfessionService professionService;

    @Test
    public void ListProfession() throws InterruptedException, MemcachedException, TimeoutException {
        List<Integer> s= Arrays.asList(1,2,3);
        System.out.println(professionService.upLoadProfession(s));
    }
    @Test
    public void listByType() throws InterruptedException, MemcachedException, TimeoutException {
        Integer status=new Integer(1);
        System.out.println(professionService.upLoadProfessions(status));
    }
}