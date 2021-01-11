package me.shengeNo1.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import lombok.RequiredArgsConstructor;
import me.shengeNo1.dao.LogMapper;
import me.shengeNo1.entity.Log;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * @author shengeNo1 liuyuanshenno.1@gmail.com
 * @ClassName Test.java
 * @Description TODO
 * @createTime 2021年01月04日 23:58:00
 */
@RequiredArgsConstructor
@Service
public class Test {
    private final LogMapper logMapper;

    @PostConstruct
    private void test() {
        Log log = new Log();
        log.setId(1L);
        QueryWrapper<Log> logQueryWrapper = new QueryWrapper<>();
        log.setRequestIp("127.0.0.1");
        Log log1 = logMapper.selectById(1);
        System.out.println(log1);
    }
}
