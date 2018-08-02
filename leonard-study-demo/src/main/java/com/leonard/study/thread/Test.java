package com.leonard.study.thread;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author leonard
 * @date 2018/7/19 11:02
 */
public class Test {
    private static Pattern P = Pattern.compile("(?<=//|)((\\w)+\\.)+\\w+()?");

    public static void main(String[] args) {
        String url = "http://192.168.230.138:9010/sssss";
        String host = "";
        Matcher matcher = P.matcher(url);
        if (matcher.find()) {
            host = matcher.group() ;
        }
        System.out.println(host);
        String serverName = "www.esb.com";
        host = url.replaceAll(host,serverName);
        System.out.println(host);
    }
}
