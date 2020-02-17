package com.io.thinkinginjava.nio.unit02getthebasetype;

import java.nio.ByteBuffer;

/**
 * 获取基本类型
 * ByteBuffer只能保存字节类型的数据，但具有可以从其所容纳的字节中产生不同基本类型值的方法
 */
public class GetData {

    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        // 查看缓冲器分配模式将其内容全部自动置0
        int i = 0;
        while (i++ < bb.limit()) {
            if (bb.get() != 0) {
                System.out.println("nonzero");
            }
        }
        System.out.println("i = " + i); // 一共是1024次检测，现在值为1025

        /* 向ByteBuffer插入基本类型的数据，利用asCharBuffer...获得该缓冲区上的视图，然后使用该视图的put方法 */

        // asCharBuffer（例外：需要进行类型转换，可能会截取或改变结果）
        // TODO 测试英文和汉字未发现问题
        bb.rewind();
        bb.asCharBuffer().put("测试汉字!");
        char c;
        while ((c = bb.getChar()) != 0) {
            System.out.print(c + " ");
        }
        System.out.println();

        // asShortBuffer 填入471142.输出12390，因为超出了最大值
        bb.rewind();
        bb.asShortBuffer().put((short)471142);
        System.out.println(bb.getShort());

        // asIntBuffer int类型测试
        bb.rewind();
        bb.asIntBuffer().put(99471142);
        System.out.println(bb.getInt());

        // asLongBuffer Long类型测试
        bb.rewind();
        bb.asLongBuffer().put((long)99471142);
        System.out.println(bb.getLong());

        // asFloatBuffer 单精度浮点小数测试 输出：9.9471144E7
        bb.rewind();
        bb.asFloatBuffer().put(99471142);
        System.out.println(bb.getFloat());

        // asDoubleBuffer 双精度浮点小数 输出：9.9471142E7
        bb.rewind();
        bb.asDoubleBuffer().put(99471142);
        System.out.println(bb.getDouble());
        bb.rewind();
    }

}
