package me.shengeNo1.utils;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockHttpServletRequest;

import java.text.SimpleDateFormat;
import java.util.Date;

import static me.shengeNo1.utils.StringUtils.getIp;
import static me.shengeNo1.utils.StringUtils.getWeekDay;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author shengeNo1 liuyuanshenno.1@gmail.com
 * @ClassName StringUtilsTest.java
 * @Description TODO
 * @createTime 2021年01月02日 14:30:00
 */

public class StringUtilsTest {
    @Test
    public void testGetWeekDay() {
        SimpleDateFormat simpleDateformat = new SimpleDateFormat("E");
        assertEquals(simpleDateformat.format(new Date()), getWeekDay());
    }

    @Test
    public void testGetIP() {
        assertEquals("127.0.0.1", getIp(new MockHttpServletRequest()));
    }
}
