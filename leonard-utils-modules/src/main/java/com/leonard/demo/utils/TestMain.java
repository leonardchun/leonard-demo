package com.leonard.demo.utils;

import com.leonard.demo.utils.qrcode.QRCodeUtil;

/**
 * @author leonard
 * @date 2018/5/18 22:13
 */
public class TestMain {
    public static void main(String[] args) {
        String text = "https://mp.weixin.qq.com/s/Bp0z4nLq3K0OutkU8-nj9w。。";
        try {
            QRCodeUtil.encode(text, "D:/test/timg.jpg", "D:/test/erweima.png", true,600);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
