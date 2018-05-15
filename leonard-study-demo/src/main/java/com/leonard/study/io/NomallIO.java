package com.leonard.study.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 简单的文件IO 文件的读写
 */
public class NomallIO {
    public static void main(String[] args) {
        try {
            FileOutputStream fos = new FileOutputStream("D:/test/test.txt");
            fos.write("我是测试文件".getBytes());
            fos.close();

            FileInputStream fis = new FileInputStream("D:/test/read.txt");
            byte [] bytes = new byte[100];
            while (fis.read(bytes) != -1){
                System.out.println(new String(bytes));
            }
            fis.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
