package com.jnshu.utils;

import org.junit.Test;

import static org.junit.Assert.*;

public class MD5UtilTest {

    @Test
    public void MD5() {

        String plaintext = "7210332..";
        //  plaintext = "123456";
        System.out.println("原始：" + plaintext);
        System.out.println("普通MD5后：" + MD5Util.MD5(plaintext));

        // 获取加盐后的MD5值
        String ciphertext = MD5Util.generate(plaintext);
        System.out.println("加盐后MD5：" + ciphertext);
        System.out.println("是否是同一字符串:" + MD5Util.verify(plaintext, ciphertext));
        /**
         * 其中某次DingSai字符串的MD5值
         */
        String[] tempSalt = { "c4d980d6905a646d27c0c437b1f046d4207aa2396df6af86", "66db82d9da2e35c95416471a147d12e46925d38e1185c043", "61a718e4c15d914504a41d95230087a51816632183732b5a" };

        for (String temp : tempSalt) {
            System.out.println("是否是同一字符串:" + MD5Util.verify(plaintext, temp));
        }
    }

    @Test
    public void generate() {
    }

    @Test
    public void verify() {
    }
}