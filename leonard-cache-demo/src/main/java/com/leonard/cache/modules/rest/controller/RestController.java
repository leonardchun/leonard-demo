package com.leonard.cache.modules.rest.controller;

import com.leonard.cache.SystemProperties;
import com.leonard.cache.modules.rest.domain.HotelInformation;
import com.leonard.cache.modules.rest.domain.QueryDTO;
import com.leonard.cache.modules.rest.domain.SizeDTO;
import com.leonard.cache.modules.rest.service.IRestService;
import com.leonard.cache.utils.Base64ImageUtil;
import com.leonard.cache.utils.RandomValidateCodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.List;

/*
 * 文件名：RestController
 * 描述：〈一句话功能简述〉
 * 创建人： wanghaichun
 * 创建时间：2017/8/19 1:08 .
 */
@Slf4j
@org.springframework.web.bind.annotation.RestController
@Api(value = "Rest管理", description = "Rest管理")
public class RestController {

    @Autowired
    private IRestService restService;

    @Autowired
    private SystemProperties systemProperties;
    private byte[] bytes;

    /**
     * 获取宾馆居住信息GET
     */
    @RequestMapping(value = "/findHotelInformationGet", method = RequestMethod.GET)
    @ApiOperation(value = "获取宾馆居住信息GET", notes = "获取宾馆居住信息GET")
    public List<HotelInformation> findHotelInformationGet() {

        return this.restService.findHotelInformationGet();
    }

    /**
     * 获取宾馆居住信息POST
     */
    @RequestMapping(value = "/findHotelInformationPost", method = RequestMethod.POST)
    @ApiOperation(value = "获取宾馆居住信息POST", notes = "获取宾馆居住信息POST")
    public List<HotelInformation> findHotelInformationPost(@RequestBody QueryDTO queryDTO) {

        return this.restService.findHotelInformationPost(queryDTO);
    }

    /**
     * GET方式根据参数大小获取对应大小字符串
     *
     * @param size
     * @return
     */
    @RequestMapping(value = "/getTenDataInfo", method = RequestMethod.GET)
    @ApiOperation(value = "GET方式根据参数大小获取对应大小字符串", notes = "根据参数大小获取对应大小字符串，支持1,10,20,30,40,50,100，200,300,400,500,1M,5M,10M,20M")
    public String getTenDataInfo(@RequestParam("size") String size) {
        return this.restService.getTenDataInfo(size);
    }

    /**
     * POST方式根据参数大小获取对应大小字符串
     *
     * @param sizeDTO
     * @return
     */
    @RequestMapping(value = "/getTenDataInfoByPost", method = RequestMethod.POST)
    @ApiOperation(value = "POST方式根据参数大小获取对应大小字符串", notes = "根据参数大小获取对应大小字符串，支持1,10,20,30,40,50,100，200,300,400,500,1M,5M,10M,20M")
    public String getTenDataInfoByPost(@RequestBody SizeDTO sizeDTO) {
        return this.restService.getTenDataInfo(sizeDTO.getSize());
    }


    /**
     * 获取不同大小图片
     *
     * @param imageSize
     * @return
     */
    @RequestMapping(value = "/getImage", method = RequestMethod.GET)
    @ApiOperation(value = "获取不同大小图片", notes = "获取不同大小图片，支持100，300，500，1000")
    public String getImage(@RequestParam("imageSize") String imageSize) {
        return this.restService.getImage(imageSize);
    }

    @RequestMapping(value = "/getImageCode", method = RequestMethod.GET)
    @ApiOperation(value = "直接获取不同大小图片流", notes = "直接获取不同大小图片流，支持100，300，500，1000")
    public void getLoginImageCode(@RequestParam("imageSize") String imageSize, HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("image/jpeg");//设置响应类型，告知浏览器输出的是图片
        response.setHeader("Pragma", "No-cache");//设置响应头信息，告诉浏览器不要缓存此内容
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Set-Cookie", "name=value; HttpOnly");//设置HttpOnly属性,防止Xss攻击
        response.setDateHeader("Expire", 0);
        RandomValidateCodeUtil randomValidateCode = new RandomValidateCodeUtil();

        try {
            String upload = systemProperties.getUpload();
            byte[] bytes = null;
            if ("100".equals(imageSize)) {
                bytes = Base64ImageUtil.readImageByte(upload + File.separator + "100k", "1.jpg");
            } else if ("300".equals(imageSize)) {
                bytes = Base64ImageUtil.readImageByte(upload + File.separator + "300k", "1.png");
            } else if ("500".equals(imageSize)) {
                bytes = Base64ImageUtil.readImageByte(upload + File.separator + "500k", "1.jpg");
            } else if ("1000".equals(imageSize)) {
                bytes = Base64ImageUtil.readImageByte(upload + File.separator + "1024k", "1.png");
            } else {
                bytes = Base64ImageUtil.readImageByte(upload + File.separator + "100k", "2.jpg");
            }
            Integer contentLength = bytes.length;//内容长度
            response.setHeader("content-length", contentLength + "");
            response.getOutputStream().write(bytes);//通过response输出图片
        } catch (Exception e) {
            log.error(e.getMessage());
        } finally {
            try {
                response.getOutputStream().flush();
                response.getOutputStream().close();
            } catch (Exception e) {
                log.error(e.getMessage());
            }
        }
    }
}
