package com.zsw.JVM;

/**
 * JVM设置  -Xss128k(默认1M)
 * -Xss设置越小count值越小，说明一个线程栈里能分配的栈帧就越少，但是对JVM整体来说能开启的线程数会更多
 */
public class StackOverflowTest {
    
    static int count = 0;
    
    static void redo() {
        count++;
        redo(); // 循环发生栈溢出
    }

    public static void main(String[] args) {
        try {
            redo();
        } catch (Throwable t) {
            t.printStackTrace();
            System.out.println(count);
        }
    }
}