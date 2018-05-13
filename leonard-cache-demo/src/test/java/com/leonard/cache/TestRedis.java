package com.leonard.cache;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

/*
 * 文件名：TestRedis
 * 版权：Copyright © Fable  Data Technology NanJing Co , Ltd.
 * 描述：〈一句话功能简述〉
 * 创建人： wanghaichun
 * 创建时间：2017-11-21 02:10 PM
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EsbApplication.class)
public class TestRedis {

/*    @Autowired
    private StringRedisTemplate stringRedisTemplate;*/

    @Autowired
    private RedisTemplate redisTemplate;

/*    @Test
    public void test() throws Exception {
        stringRedisTemplate.opsForValue().set("aaa", "111");
        Assert.assertEquals("111", stringRedisTemplate.opsForValue().get("aaa"));
    }*/

    @Test
    public void testObj() throws Exception {
        ValueOperations<String, Object> operations=redisTemplate.opsForValue();
        operations.set("com.cache", "testRedis");
        Thread.sleep(1000);
        //redisTemplate.delete("com.cache");
        boolean exists=redisTemplate.hasKey("com.cache");
        if(exists){
            System.out.println("exists is true");
        }else{
            System.out.println("exists is false");
        }
    }
}
