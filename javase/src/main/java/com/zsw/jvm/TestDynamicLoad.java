package com.zsw.jvm;

/**
 * @author zsw
 * @date 2021/12/21 10:59
 * @Company: 广州市两棵树网络科技有限公司
 *   引导类加载器：负责加载支撑JVM运行的位于JRE的lib目录下的核心类库，比如 rt.jar、charsets.jar等
 *   扩展类加载器：负责加载支撑JVM运行的位于JRE的lib目录下的ext扩展目录中的JAR 类包
 *   应用程序类加载器：负责加载ClassPath路径下的类包，主要就是加载你自己写的那些类
 * 	 自定义加载器：负责加载用户自定义路径下的类包
 * 	 为什么要设计双亲委派机制？
 * 	 沙箱安全机制：自己写的java.lang.String.class类不会被加载，这样便可以防止核心API库被随意篡改  	避免类的重复加载：
 *    当父亲已经加载了该类时，就没有必要子ClassLoader再加载一次，保证被加载类的唯一性
 */
public class TestDynamicLoad {
    static {
        System.out.println("*************load TestDynamicLoad************");
    }

    public static void main(String[] args) {
        new A();
        B b = null; //b 不会加载，除非这里执行new B()
    }

    private static class A {
        static {
            System.out.println("*************load A************");
        }

        public A() {
            System.out.println("*************init A************");
        }
    }

    private static class B {
        static {
            System.out.println("*************load B************");
        }

        public B() {
            System.out.println("*************init B************");
        }
    }
//    *************load TestDynamicLoad************
//            *************load A************
//            *************init A************
}
