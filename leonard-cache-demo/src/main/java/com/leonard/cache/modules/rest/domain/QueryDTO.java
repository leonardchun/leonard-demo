package com.leonard.cache.modules.rest.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/*
 * 文件名：QueryDTO
 * 描述：〈一句话功能简述〉
 * 创建人： wanghaichun
 * 创建时间：2017/8/19 1:41 .
 */
@Data
@ApiModel("查询对象")
public class QueryDTO {

    /**
     * 住宿人姓名
     */
    @ApiModelProperty("住宿人姓名")
    private String name;
    /**
     * 身份证编号
     */
    @ApiModelProperty("身份证编号")
    private String resCode;
    /**
     * 旅店名称
     */
    @ApiModelProperty("旅店名称")
    private String hotelName;
}
