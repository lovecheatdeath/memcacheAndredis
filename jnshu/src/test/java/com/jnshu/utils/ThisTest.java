package com.jnshu.utils;

import com.jnshu.utils.This;
import org.junit.Test;

import java.math.BigInteger;


public class ThisTest {
    int i;
    @Test
    public void TestThis(){
        Long j=1L;
        for(this.i=0;i<32;i++){
            j=j*2;
        }
        System.out.println(j);
    }
}
