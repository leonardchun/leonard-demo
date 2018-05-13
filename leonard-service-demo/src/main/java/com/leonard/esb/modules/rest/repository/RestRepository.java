package com.leonard.esb.modules.rest.repository;

import com.leonard.esb.modules.rest.domain.HotelInformation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
 * 文件名：RestRepository
 * 描述：〈一句话功能简述〉
 * 创建人： wanghaichun
 * 创建时间：2017/8/19 1:08 .
 */
public interface RestRepository extends JpaRepository<HotelInformation,Long> {

    List<HotelInformation> findByNameOrHotelNameOrResCode(String name,String hotelName,String resCode);

  /*  @TemplateQuery
    List<String> queryHotelInfo();*/
}
