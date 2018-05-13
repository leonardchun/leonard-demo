package com.leonard.esb.modules.rest.service.impl;


import com.leonard.esb.modules.rest.domain.HotelInformation;
import com.leonard.esb.modules.rest.domain.QueryDTO;
import com.leonard.esb.modules.rest.repository.RestRepository;
import com.leonard.esb.modules.rest.service.IRestService;
import com.leonard.esb.utils.CacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * 文件名：RestServiceImpl
 * 描述：〈一句话功能简述〉
 * 创建人： wanghaichun
 * 创建时间：2017/8/19 1:06 .
 */
@Service
public class RestServiceImpl implements IRestService {

    @Autowired
    private RestRepository restRepository;

    @Override
    public List<HotelInformation> findHotelInformationGet() {

        List<HotelInformation> hotelInformations = this.restRepository.findAll();
        return hotelInformations;
    }

    @Override
    public List<HotelInformation> findHotelInformationPost(QueryDTO queryDTO) {
        List<HotelInformation> hotelInformations = this.restRepository.findByNameOrHotelNameOrResCode(queryDTO.getName(), queryDTO.getHotelName(), queryDTO.getResCode());
        return hotelInformations;
    }

    @Override
    public String getTenDataInfo(String size) {
        if ("10".equals(size)) {
            return CacheUtil.cacheMap.get("a");
        } else if ("20".equals(size)) {
            return CacheUtil.cacheMap.get("b");
        } else if ("30".equals(size)) {
            return CacheUtil.cacheMap.get("c");
        } else if ("40".equals(size)) {
            return CacheUtil.cacheMap.get("d");
        } else if ("50".equals(size)) {
            return CacheUtil.cacheMap.get("e");
        } else if ("100".equals(size)) {
            return CacheUtil.cacheMap.get("f");
        } else if ("200".equals(size)) {
            return CacheUtil.cacheMap.get("g");
        } else if ("300".equals(size)) {
            return CacheUtil.cacheMap.get("h");
        } else if ("400".equals(size)) {
            return CacheUtil.cacheMap.get("i");
        } else if ("500".equals(size)) {
            return CacheUtil.cacheMap.get("j");
        }else if ("1".equals(size)) {
            return CacheUtil.cacheMap.get("k");
        }else if ("1M".equals(size)) {
            return CacheUtil.cacheMap.get("clob1");
        }else if ("5M".equals(size)) {
            return CacheUtil.cacheMap.get("clob5");
        }else if ("10M".equals(size)) {
            return CacheUtil.cacheMap.get("clob10");
        }else if ("20M".equals(size)) {
            return CacheUtil.cacheMap.get("clob20");
        }else if ("30M".equals(size)) {
            return CacheUtil.cacheMap.get("clob30");
        }else if ("50M".equals(size)) {
            return CacheUtil.cacheMap.get("clob50");
        }else if ("100M".equals(size)) {
            return CacheUtil.cacheMap.get("clob100");
        }
        return "暂未取到数据，数据有可能在初始化时失败!";
    }

    @Override
    public String getImage(String imageSize) {
        if ("100".equals(imageSize)) {
            return CacheUtil.cacheMap.get("image100");
        } else if ("300".equals(imageSize)) {
            return CacheUtil.cacheMap.get("image300");
        } else if ("500".equals(imageSize)) {
            return CacheUtil.cacheMap.get("image500");
        } else if ("1000".equals(imageSize)) {
            return CacheUtil.cacheMap.get("image1024");
        } else {
            return "不支持其他大小图片，支持100k,300k,500k,1000k!";
        }
    }
}
