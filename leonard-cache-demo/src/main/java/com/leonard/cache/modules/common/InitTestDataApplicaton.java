package com.leonard.cache.modules.common;


import com.leonard.cache.SystemProperties;
import com.leonard.cache.utils.Base64ImageUtil;
import com.leonard.cache.utils.CacheUtil;
import com.leonard.cache.utils.RandomUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.File;

@Component
@Slf4j
public class InitTestDataApplicaton {

    @Autowired
    private SystemProperties systemProperties;

    @PostConstruct
    public void init(){
     /*   CacheUtil.cacheMap.put("a", RandomUtils.generateString(10*1024));//10k
        CacheUtil.cacheMap.put("b",RandomUtils.generateString(20*1024));//20k
        CacheUtil.cacheMap.put("c",RandomUtils.generateString(30*1024));//30k
        CacheUtil.cacheMap.put("d",RandomUtils.generateString(40*1024));//40k
        CacheUtil.cacheMap.put("e",RandomUtils.generateString(50*1024));//50k
        CacheUtil.cacheMap.put("f",RandomUtils.generateString(100*1024));//100k
        CacheUtil.cacheMap.put("g",RandomUtils.generateString(200*1024));//200k
        CacheUtil.cacheMap.put("h",RandomUtils.generateString(300*1024));//300k
        CacheUtil.cacheMap.put("i",RandomUtils.generateString(400*1024));//400k
        CacheUtil.cacheMap.put("j",RandomUtils.generateString(500*1024));//500k
        CacheUtil.cacheMap.put("k",RandomUtils.generateString(1024));//1k
        log.info("测试桩10k,20k,30k,40k,50k,100k,200k,300k,400k,500k数据初始化成功.....");
*/
    }

}
