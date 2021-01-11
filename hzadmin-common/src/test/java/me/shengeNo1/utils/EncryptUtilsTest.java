package me.shengeNo1.utils;

import org.junit.jupiter.api.Test;

import static me.shengeNo1.utils.EncryptUtils.desDecrypt;
import static me.shengeNo1.utils.EncryptUtils.desEncrypt;
import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * @author shengeNo1 liuyuanshenno.1@gmail.com
 * @ClassName EncryptUtilsTest.java
 * @Description TODO
 * @createTime 2021年01月02日 15:33:00
 */

public class EncryptUtilsTest {

    /**
     * 对称加密
     */
    @Test
    public void testDesEncrypt() {
        try {
            assertEquals("7772841DC6099402", desEncrypt("123456"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 对称解密
     */
    @Test
    public void testDesDecrypt() {
        try {
            assertEquals("123456", desDecrypt("7772841DC6099402"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
