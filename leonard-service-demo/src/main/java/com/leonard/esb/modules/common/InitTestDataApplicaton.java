package com.leonard.esb.modules.common;


import com.leonard.esb.SystemProperties;
import com.leonard.esb.utils.Base64ImageUtil;
import com.leonard.esb.utils.CacheUtil;
import com.leonard.esb.utils.RandomUtils;
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
        CacheUtil.cacheMap.put("a", RandomUtils.generateString(10*1024));//10k
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

        String floder = systemProperties.getUpload();
        CacheUtil.cacheMap.put("image100", Base64ImageUtil.readImage(floder + File.separator + "100k","1.jpg"));//图片100K
        CacheUtil.cacheMap.put("image300", Base64ImageUtil.readImage(floder + File.separator + "300k","1.png"));//图片100K
        CacheUtil.cacheMap.put("image500", Base64ImageUtil.readImage(floder + File.separator + "500k","1.jpg"));//图片100K
        CacheUtil.cacheMap.put("image1024", Base64ImageUtil.readImage(floder + File.separator + "1024k","1.png"));//图片100K
        log.info("测试桩图片100k,300k,500k，1024k 数据初始化成功.....");

        CacheUtil.cacheMap.put("clob1","");//1M
        CacheUtil.cacheMap.put("clob5","");//5M
        CacheUtil.cacheMap.put("clob10","");//10M
        CacheUtil.cacheMap.put("clob20","");//20M
       /* CacheUtil.cacheMap.put("clob1",RandomUtils.generateString(1024*1024));//1M
        CacheUtil.cacheMap.put("clob5",RandomUtils.generateString(5*1024*1024));//5M
        CacheUtil.cacheMap.put("clob10",RandomUtils.generateString(10*1024*1024));//10M
        CacheUtil.cacheMap.put("clob20",RandomUtils.generateString(20*1024*1024));//20M*/
       /* CacheUtil.cacheMap.put("clob30",RandomUtils.generateString(30*1024*1024));//30M
        CacheUtil.cacheMap.put("clob50",RandomUtils.generateString(50*1024*1024));//50M
        CacheUtil.cacheMap.put("clob100",RandomUtils.generateString(100*1024*1024));//100M*/
        log.info("测试桩大字段1M,5M,10M,20M,30M,50M，100M 数据初始化成功.....");

    }

}
