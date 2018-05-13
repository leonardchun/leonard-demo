package com.leonard.esb.modules.rest.service;

import com.leonard.esb.modules.rest.domain.HotelInformation;
import com.leonard.esb.modules.rest.domain.QueryDTO;
import com.leonard.esb.modules.rest.domain.HotelInformation;
import com.leonard.esb.modules.rest.domain.QueryDTO;

import java.util.List;

/*
 * 文件名：IRestService
 * 描述：〈一句话功能简述〉
 * 创建人： wanghaichun
 * 创建时间：2017/8/19 1:06 .
 */
public interface IRestService {

    List<HotelInformation> findHotelInformationGet();

    List<HotelInformation> findHotelInformationPost(QueryDTO queryDTO);

    String getTenDataInfo(String size);

    String getImage(String imageSize);
}
