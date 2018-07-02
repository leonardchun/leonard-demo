package com.leonard.study.io;

import java.io.*;

/*
 * 文件名：ImageIO
 * 版权：Copyright © Fable  Data Technology NanJing Co , Ltd.
 * 描述：〈IO 流乱码〉
 * 创建人： wanghaichun
 * 创建时间：2018-06-04 02:10 PMchun
 */
public class ImageIO {

    public static void main(String[] args) {

        try {
//            FileInputStream fileInputStream = new FileInputStream("J:/test/image/get.jpg");
            FileInputStream fileInputStream = new FileInputStream("J:/test/image/get.txt");

            OutputStreamWriter oStreamWriter = new OutputStreamWriter(new FileOutputStream("J:/test/image/get.txt"), "utf-8");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] arr = new byte[1024];
            int  len = -1;
            while ((len = fileInputStream.read(arr)) != -1) {
                baos.write(arr, 0, len);
                System.out.println(new String(arr));
            }
            fileInputStream.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
