package com.io.thinkinginjava.objectserialization.unit02serializationcontrol;


import java.io.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * transien(瞬时)关键字
 * 使Serializable对象中的某子对象不自动保存及恢复
 */
public class Logon implements Serializable {

    private Date date = new Date();
    private String username;
    private transient String password;

    public Logon(String username, String password) {
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Logon{" +
                "date=" + date +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        Logon l = new Logon("Hulk", "myLittlePony");
        System.out.println("Logon l = " + l);
        ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("Logon.out"));
        o.writeObject(l);
        o.close();

        TimeUnit.SECONDS.sleep(1); // 休眠1s
        ObjectInputStream i = new ObjectInputStream(new FileInputStream("Logon.out"));
        System.out.println(new Date());
        l = (Logon) i.readObject();
        System.out.println("Logon l = " + l);

        /*
        null引用会自动更换成null字符串
        Logon l = Logon{date=Thu Feb 27 14:41:51 CST 2020, username='Hulk', password='myLittlePony'}
        Thu Feb 27 14:41:52 CST 2020
        Logon l = Logon{date=Thu Feb 27 14:41:51 CST 2020, username='Hulk', password='null'}
        */
    }
}
