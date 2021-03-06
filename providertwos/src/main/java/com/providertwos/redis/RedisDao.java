package com.providertwos.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

/**
 * @Auther: gaofan
 * @Date: 2020/4/14 0014 17 42
 * @Description: Redis功能
 */
@Repository
public class RedisDao {
    @Autowired
    private StringRedisTemplate template;
    //保存数据
    public void setKey(String key,String value){
        ValueOperations<String,String> ops=template.opsForValue();
        ops.set(key, value);
    }
    //取出数据
    public String getValue(String key){
        ValueOperations<String,String> ops=this.template.opsForValue();
        return ops.get(key);
    }
}
