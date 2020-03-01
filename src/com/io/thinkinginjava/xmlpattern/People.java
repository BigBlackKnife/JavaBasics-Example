package com.io.thinkinginjava.xmlpattern;

import nu.xom.*;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * xml模式
 *
 */
public class People extends ArrayList<Person> {

    public People(String fileName) throws Exception {
        // 直接填写文件名提示java.net.UnknownHostException: file错误，
        // 将其装换成InputStream即可正常处理
        // 可能是由于build(String systemID)方法取文件时出现的问题
        Document doc = new Builder().build(new FileInputStream(fileName));
        Elements elements = doc.getRootElement().getChildElements();
        for (int i = 0; i < elements.size(); i++) {
            add(new Person(elements.get(i)));
        }
    }

    public static void main(String[] args) throws Exception {
        People p = new People("people.xml");
        System.out.println(p);
    }
}
