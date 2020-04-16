package com.providertwos.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.util.List;


/**
 * @Auther: Administrator
 * @Date: 2020/4/15 0015 09 21
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootRedisApplicationTests {
    public static Logger logger = LoggerFactory.getLogger(SpringbootRedisApplicationTests.class);
    @Test
    public void contextLoads(){}
    @Autowired
    RedisDao redisDao;
    @Test
    public void testRedis() {
//        redisDao.setKey("name","jerry");
//        redisDao.setKey("age","11");
//        logger.info(redisDao.getValue("name"));
//        logger.info(redisDao.getValue("age"));
        Jedis jedis=new Jedis();
        jedis.lpush("1","r");
        jedis.lpush("1","r2");
        jedis.lpush("1","r3");
        List<String> list = jedis.lrange("1", 0 ,2);
        for(int i=0; i<list.size(); i++) {
            System.out.println("列表项为: "+list.get(i));
        }



    }

}
