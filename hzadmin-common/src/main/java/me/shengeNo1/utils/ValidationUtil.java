package me.shengeNo1.utils;

import cn.hutool.core.util.ObjectUtil;
import me.shengeNo1.exception.BadRequestException;

/**
 * @author shengeNo1 liuyuanshenno.1@gmail.com
 * @ClassName ValidationUtil.java
 * @Description TODO
 * @createTime 2021年01月02日 17:29:00
 */

public class ValidationUtil {

    /**
     * 验证空
     */
    public static void isNull(Object obj, String entity, String parameter , Object value){
        if(ObjectUtil.isNull(obj)){
            String msg = entity + " 不存在: "+ parameter +" is "+ value;
            throw new BadRequestException(msg);
        }
    }

}
