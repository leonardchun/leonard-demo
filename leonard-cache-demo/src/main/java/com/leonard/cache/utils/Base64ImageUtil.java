package com.leonard.cache.utils;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;
import sun.misc.BASE64Encoder;

import java.io.File;
import java.io.FileInputStream;

/*
 * 文件名：Base64ImageUtil
 * 版权：Copyright © Fable  Data Technology NanJing Co , Ltd.
 * 描述：〈一句话功能简述〉
 * 创建人： wanghaichun
 * 创建时间：2017-11-22 02:27 PM
 */
@Slf4j
public class Base64ImageUtil {

    /**
     * 读取指定位置的图像文件
     *
     * @param floder
     * @param fileName
     * @return
     */
    public static String readImage(String floder, String fileName) {
        String url = floder;
        byte[] inbyte = null;
        String path = url + File.separator + fileName;
        try {
            File file = new File(path);
            if (file.exists()) {
                @Cleanup FileInputStream inStream = new FileInputStream(file);
                inbyte = FileUploadUtil.getInptStreamBytes(inStream);
            } else {
                log.error(fileName + ":文件不存在！");
                return null;
            }
        } catch (Exception e) {
            log.error(fileName + "读取指定位置的图像文件失败！", e);
        }
        // 加密
        BASE64Encoder encoder = new BASE64Encoder();
        String imageEncoder = encoder.encode(inbyte);
        if (fileName.endsWith(".jpg")){
            return "data:image/jpeg;base64," + imageEncoder;
        }else if (fileName.endsWith(".png")){
            return  "data:image/png;base64,"+ imageEncoder;
        }else {
            return imageEncoder;
        }

    }


    public static byte[] readImageByte(String floder,String fileName){
        String url = floder;
        byte[] inbyte = null;
        String path = url + File.separator + fileName;
        try {
            File file = new File(path);
            if (file.exists()) {
                @Cleanup FileInputStream inStream  = new FileInputStream(file);
                inbyte = FileUploadUtil.getInptStreamBytes(inStream);
            } else {
                log.error(fileName + ":文件不存在！");
                return null;
            }
        } catch (Exception e) {
            log.error(fileName + ":同步失败！", e);
        }
        return inbyte;

    }
}
