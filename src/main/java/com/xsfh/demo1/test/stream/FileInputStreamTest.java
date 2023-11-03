package com.xsfh.demo1.test.stream;

import java.io.*;

public class FileInputStreamTest {
    public static void main(String[] args) throws IOException {
        String name = "aaa.txt";
        String pathName = "/Users/xsfh/Documents/";
        File file = new File(pathName,name);
        InputStream inputStream = new FileInputStream(file);
        byte[] bytes = new byte[inputStream.available()];

        while(inputStream.read(bytes) != -1){
            String s = String.valueOf(bytes);
            System.out.println(s);
        }
        inputStream.close();



    }
}
