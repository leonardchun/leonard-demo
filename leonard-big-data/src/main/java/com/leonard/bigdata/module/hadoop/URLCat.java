package com.leonard.bigdata.module.hadoop;

import org.apache.hadoop.fs.FsUrlStreamHandlerFactory;
import org.apache.hadoop.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author leonard
 * @date 2018/8/1 15:43
 */
public class URLCat {
    static {
        URL.setURLStreamHandlerFactory(new FsUrlStreamHandlerFactory());
    }
    public static void main(String[] args) throws MalformedURLException, IOException {
        InputStream in = null;
        String input = "hdfs://192.168.92.138:9000/user/test.txt";
        try {
            in = new URL(input).openStream();
            IOUtils.copyBytes(in, System.out, 4096,false);
        }finally {
            IOUtils.closeStream(in);
        }
    }
}
