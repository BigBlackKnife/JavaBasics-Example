package com.enumerated.unit10constantcorrelationmethod.ele01chainofresponsibility;

import com.utility.enumutils.Enums;

import java.util.Iterator;

/**
 * 职责链模式：邮局模型
 *
 * 信件类
 */
public class Mail {

    /**
     * 一个邮件的基本属性基本属性：
     * 1.邮件的存局候领处
     * 2.扫描
     * 3.可读性
     * 4.发货地址
     * 5.目的地
     */
    enum GeneralDelivery { YES, NO1, NO2, NO3, NO4, NO5 };
    enum Scannability { UNSCANNABLE, YES1, YES2, YES3, YES4 };
    enum Readability { ILLEGIBLE, YES1, YES2, YES3, YES4 };
    enum Address { INCORRECT, OK1, OK2, OK3, OK4, OK5, OK6 };
    enum ReturnAddress { MISSING, OK1, OK2, OK3, OK4, OK5 }

    GeneralDelivery generalDelivery;
    Scannability scannability;
    Readability readability;
    Address address;
    ReturnAddress returnAddress;

    /**
     * 记录当前邮件个数
     */
    static long counter = 0;

    long id = counter++;

     @Override
    public String toString() {
        return "Mail: " + id;
    }

    /**
     * 返回当前邮件的基本属性
     * @return
     */
    public String details() {
        return toString() +
                " generalDelivery=" + generalDelivery +
                ", scannability=" + scannability +
                ", readability=" + readability +
                ", address=" + address +
                ", returnAddress=" + returnAddress ;
    }

    /**
     * 对当前邮件的内容进行随机的分配
     * @return
     */
    public static Mail randomMail() {
         Mail m = new Mail();
         m.generalDelivery = Enums.random(GeneralDelivery.class);
         m.scannability = Enums.random(Scannability.class);
         m.readability = Enums.random(Readability.class);
         m.address = Enums.random(Address.class);
         m.returnAddress = Enums.random(ReturnAddress.class);
         return m;
    }

    /**
     * 迭代器输出一个Mail
     * @param count 迭代次数
     * @return
     */
    public static Iterable<Mail> generator(final int count) {
         return new Iterable<Mail>() {
             int n = count;
             @Override
             public Iterator<Mail> iterator() {
                 return new Iterator<Mail>() {

                     @Override
                     public boolean hasNext() {
                         return n-- > 0;
                     }

                     @Override
                     public Mail next() {
                         return randomMail();
                     }

                     @Override
                     public void remove() {
                         throw new UnsupportedOperationException();
                     }
                 };
             }
         };
    }
}
