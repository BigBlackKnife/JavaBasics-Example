package com.io.thinkinginjava.nio.unit03attemptbuffer;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

/**
 * 视图缓冲器
 * 通过特定类型的视窗查看其底层的ByteBuffer,并且成批的读取基本类型
 */
public class IntBufferDemo {

    private static final int BSIZE = 1024;

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.allocate(BSIZE);
        IntBuffer ib = bb.asIntBuffer();
        // 以数组形式成批的添加
        ib.put(new int[]{11, 42, 47, 99, 143, 811, 1016});
        // 通过下标获取数据
        System.out.println(ib.get(3));
        // 通过下表修改数据
        ib.put(3, 1811);
        // 位置重回0
        ib.flip();
        // 表示当前位置和极限位置之间是否有数据，即判断是否应该停止循环
        while (ib.hasRemaining()) {
            System.out.print(ib.get() + ", ");
        }
        ib.rewind();
    }

}
