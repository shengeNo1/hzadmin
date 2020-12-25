package me.shengeNo1.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author 深哥哥的小迷妹 liuyuanshenno.1@gmail.com
 * @version 1.0.0
 * @ClassName RsaProperties.java
 * @Description TODO
 * @createTime 2020年12月25日 17:18:00
 */
@Data
@Component
public class RsaProperties {

    public static String privateKey;

    @Value("${rsa.private_key}")
    public void setPrivateKey(String privateKey) {
        RsaProperties.privateKey = privateKey;
    }

}
