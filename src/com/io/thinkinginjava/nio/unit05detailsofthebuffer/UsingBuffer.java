package com.io.thinkinginjava.nio.unit05detailsofthebuffer;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * 缓冲器的细节 -- 交换相邻字符
 */
public class UsingBuffer {

    public static void symmetricScamble(CharBuffer cb) {
        while (cb.hasRemaining()) {
            cb.mark();
            char c1 = cb.get();
            char c2 = cb.get();
            cb.reset(); // 将此缓冲器的位置重置为之前标记的位置 配合mark使用。
            cb.put(c2).put(c1);
        }
    }

    /**
     * 输出内容为
     * UsingBuffers
     * sUniBgfuefsr
     * UsingBuffers
     * @param args
     */
    public static void main(String[] args) {
        char[] data = "UsingBuffers".toCharArray();
        ByteBuffer bb = ByteBuffer.allocate(data.length * 2);
        CharBuffer cb = bb.asCharBuffer();
        cb.put(data);
        System.out.println(cb.rewind());
        symmetricScamble(cb);
        System.out.println(cb.rewind());
        symmetricScamble(cb);
        System.out.println(cb.rewind());
    }

}
