package com.leonard.demo.utils.zip;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import net.lingala.zip4j.model.ZipParameters;
import net.lingala.zip4j.util.Zip4jConstants;

import java.io.File;

/**
 * 文件压缩包处理
 *
 * @author leonard
 * @date 2018/5/18 22:03
 */
public class ZipUtil {

    /**
     * 压缩包解压
     * 解密
     *
     * @param fileDeCompressionUrl 解压输出路径
     *                             zipFilePath    压缩包文件路径
     * @return [返回类型说明]
     * @author leonard
     * @create 2018/5/18 22:03
     **/
    public static boolean deCompression(String fileDeCompressionUrl, String zipFilePath, String filePass) throws ZipException {
        try {
            ZipFile zipFile = new ZipFile(zipFilePath);
            if (zipFile.isEncrypted()) {

                zipFile.setPassword(filePass);
            }
            zipFile.extractAll(fileDeCompressionUrl);
            return true;
        } catch (ZipException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * 文件压缩
     * 加密
     *
     * @param fileExportUrl 输出路径
     *                      zipFilePath    文件路径
     * @return [返回类型说明]
     * @author leonard
     * @create 2018/5/18 22:03
     **/
    public static void compressing(String fileExportUrl, String zipFilePath, String filePass) throws ZipException {

        File filepath = new File(fileExportUrl);
        ZipFile zipFile = new ZipFile(zipFilePath);
        ZipParameters params = new ZipParameters();
        params.setCompressionMethod(Zip4jConstants.COMP_DEFLATE);
        params.setCompressionLevel(Zip4jConstants.DEFLATE_LEVEL_NORMAL);
        params.setEncryptFiles(true);
        params.setEncryptionMethod(Zip4jConstants.ENC_METHOD_AES);
        params.setAesKeyStrength(Zip4jConstants.AES_STRENGTH_256);
        params.setPassword(filePass);
        zipFile.addFolder(filepath, params);

    }
}
