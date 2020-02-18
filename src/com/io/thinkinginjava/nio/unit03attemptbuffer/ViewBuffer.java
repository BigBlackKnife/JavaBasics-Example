package com.io.thinkinginjava.nio.unit03attemptbuffer;

import java.nio.*;

/**
 * 视图缓冲器
 * 建立不同的视图缓冲器来验证不同数据类型所占字节
 */
public class ViewBuffer {

    public static void main(String[] args) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[]{0, 0, 0, 0, 0, 0, 0, 'a'});

        /*""""""""""""""""""""""""""""""""ByteBuffer  1位""""""""""""""""""""""""""""""""*/
        bb.rewind();
        System.out.print("Byte Buffer: ");
        while (bb.hasRemaining()) {
            System.out.print(bb.position() + "->" + bb.get() + ", ");
        }
        System.out.println();

        /*""""""""""""""""""""""""""""""""CharBuffer  2位""""""""""""""""""""""""""""""""*/
        bb.rewind();
        CharBuffer cb = bb.asCharBuffer();
        System.out.print("Char Buffer: ");
        while (cb.hasRemaining()) {
            System.out.print(cb.position() + "->" + cb.get() + ", ");
        }
        System.out.println();

        /*""""""""""""""""""""""""""""""""ShortBuffer  2位""""""""""""""""""""""""""""""""*/
        bb.rewind();
        ShortBuffer sb = bb.asShortBuffer();
        System.out.print("Short Buffer: ");
        while (sb.hasRemaining()) {
            System.out.print(sb.position() + "->" + sb.get() + ", ");
        }
        System.out.println();

        /*""""""""""""""""""""""""""""""""IntBuffer  4位""""""""""""""""""""""""""""""""*/
        bb.rewind();
        IntBuffer ib = bb.asIntBuffer();
        System.out.print("Int Buffer: ");
        while (ib.hasRemaining()) {
            System.out.print(ib.position() + "->" + ib.get() + ", ");
        }
        System.out.println();

        /*""""""""""""""""""""""""""""""""FloutBuffer  4位""""""""""""""""""""""""""""""""*/
        bb.rewind();
        FloatBuffer fb = bb.asFloatBuffer();
        System.out.print("Flout Buffer: ");
        while (fb.hasRemaining()) {
            System.out.print(fb.position() + "->" + fb.get() + ", ");
        }
        System.out.println();

        /*""""""""""""""""""""""""""""""""LongBuffer  8位""""""""""""""""""""""""""""""""*/
        bb.rewind();
        LongBuffer lb = bb.asLongBuffer();
        System.out.print("Long Buffer: ");
        while (lb.hasRemaining()) {
            System.out.print(lb.position() + "->" + lb.get() + ", ");
        }
        System.out.println();

        /*""""""""""""""""""""""""""""""""DoubleBuffer  8位""""""""""""""""""""""""""""""""*/
        bb.rewind();
        DoubleBuffer db = bb.asDoubleBuffer();
        System.out.print("Double Buffer: ");
        while (db.hasRemaining()) {
            System.out.print(db.position() + "->" + db.get() + ", ");
        }
        System.out.println();
    }

}
