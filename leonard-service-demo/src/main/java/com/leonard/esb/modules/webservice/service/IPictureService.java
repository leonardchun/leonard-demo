package com.leonard.esb.modules.webservice.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/*
 * 文件名：IPictureService.java
 * 版权：Copyright © Fable  Data Technology NanJing Co , Ltd.
 * 描述：〈图片webservice〉
 * 创建人： wanghaichun
 * 创建时间：2017/11/21 04:18 PM
 */
@WebService(name = "IPictureService", targetNamespace = "DefaultNamespace")
public interface IPictureService {

    @WebMethod
    String getTenDataInfo(@WebParam(name = "size")String size);

    @WebMethod
    String getBase64Image(@WebParam(name = "imageSize")String imageSize);
}
