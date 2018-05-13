package com.leonard.cache.utils;

import lombok.Cleanup;
import lombok.extern.slf4j.Slf4j;

import java.io.*;

/*
 * 文件名：FileUploadUtil.java
 * 版权：Copyright © Fable  Data Technology NanJing Co , Ltd.
 * 描述：〈文件上传下载〉
 * 创建人： wanghaichun
 * 创建时间：2017/11/22 02:43 PM
 */
@Slf4j
public class FileUploadUtil {

    /**
     * 修改压缩包文件名称
     *
     * @param filePath
     * @param newName
     * @return
     */
    public static boolean updateFileName(String filePath, String newName) {
        File f = new File(filePath);
        if (f.exists()) {
            String c = f.getParent();
            File mm = new File(c + File.separator + newName);
            if (f.renameTo(mm)) {
                log.debug("修改证书名称成功...");
                return true;
            } else {
                log.debug("修改证书名称失败...");
                return false;
            }
        } else {
            log.debug("压缩文件不存在");
            return false;
        }
    }

    /**
     * @param filename 文件路径
     * @param path     文件存放路径
     * @param data     文件流
     * @return
     */
    public static boolean uploadFile(String filename, String path, InputStream data) {
        try {
            //接收客户端上送的数据
            @Cleanup BufferedInputStream in = new BufferedInputStream(data);
            //创建文件输出流
            @Cleanup BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(path + filename));

            byte[] buffer = new byte[1024];
            int read = in.read(buffer, 0, buffer.length);
            while (read > 0) {
                out.write(buffer, 0, read);
                read = in.read(buffer, 0, buffer.length);
            }
            log.info("file upload successfully");
            return true;
        } catch (IOException e) {
            log.error("文件上传异常", e);
        }
        return false;
    }

    /**
     * 根据byte数组，生成文件
     *
     * @param bfile    byte 数据
     * @param filePath 文件名称
     * @param fileName 存储路径
     */
    public static void getFile(byte[] bfile, String filePath, String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if (!dir.exists() && dir.isDirectory()) {//判断文件目录是否存在
                dir.mkdirs();
            }
            file = new File(filePath + File.separator + fileName);
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            bos.write(bfile);
            log.info(fileName + ":文件下载处理成功~");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    /**
     * 获得指定文件的byte数组
     *
     * @param filePath 文件路径
     * @return
     */
    private byte[] getBytes(String filePath) {
        byte[] buffer = null;
        try {
            File file = new File(filePath);
            @Cleanup FileInputStream fis = new FileInputStream(file);
            @Cleanup ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

    /**
     * 根据文件流获取byte数组
     *
     * @param inputStream
     * @return
     */
    public static byte[] getInptStreamBytes(InputStream inputStream) {
        byte[] buffer = null;
        try {
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1000);
            byte[] b = new byte[1000];
            int n;
            while ((n = inputStream.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            inputStream.close();
            bos.close();
            buffer = bos.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return buffer;
    }

}
