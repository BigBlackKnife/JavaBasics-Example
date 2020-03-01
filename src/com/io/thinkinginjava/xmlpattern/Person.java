package com.io.thinkinginjava.xmlpattern;

import java.io.*;
import java.util.*;

import nu.xom.Document;
import nu.xom.Element;
import nu.xom.Serializer;

/**
 * xml模式
 * 对象序列化只是java的解决方案，xml格式是更具互操作性的解决方案
 * 需要引用com.springsource.nu.xom-XXX.jar
 */
public class Person {
    private String first, last;

    public Person(String first, String last) {
        this.first = first;
        this.last = last;
    }

    /**
     * 组装element信息
     * 得到数据如下
     * <person>
     *     <first>Dr.Bunsen</first>
     *     <last>Honeydew</last>
     * </person>
     * @return
     */
    public Element getXML() {
        Element person = new Element("person");
        Element firstName = new Element("first");
        firstName.appendChild(first);
        Element lastName = new Element("last");
        lastName.appendChild(last);
        person.appendChild(firstName);
        person.appendChild(lastName);
        return person;
    }

    /**
     * xml文件取值方法
     * @param person
     */
    public Person(Element person) {
        first = person.getFirstChildElement("first").getValue();
        last = person.getFirstChildElement("last").getValue();
    }

    /**
     * 序列化
     * @param os 指向位置
     * @param doc 文档数据
     * @throws IOException
     */
    public static void format(OutputStream os, Document doc) throws IOException {
        Serializer serializer = new Serializer(os, "ISO-8859-1");
        serializer.setIndent(4);
        serializer.setMaxLength(60);
        serializer.write(doc);
        serializer.flush();
    }

    @Override
    public String toString() {
        return first + " " + last;
    }

    public static void main(String[] args) throws IOException {
        // 数据集
        List<Person> people = Arrays.asList(
                new Person("Dr.Bunsen", "Honeydew"),
                new Person("Gonzo", "The Great"),
                new Person("Phillip J.", "Fry")
        );
        System.out.println(people);
        Element root = new Element("people"); // 创建元素
        for (Person p : people) {
            root.appendChild(p.getXML());// 在顶元素中添加元素
        }
        // root即为最终数据，然后将element对象转化成document对象
        Document doc = new Document(root);
        format(System.out, doc); // 输出到控制台
        format(new BufferedOutputStream(new FileOutputStream("people.xml")), doc); // 输出到文件
    }
}
