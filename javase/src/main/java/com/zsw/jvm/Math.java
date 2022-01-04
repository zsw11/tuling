package com.zsw.jvm;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author zsw
 * @date 2021/12/20 18:17
 * @Company: 广州市两棵树网络科技有限公司
 * 其中loadClass的类加载过程有如下几步：
 * 加载 >> 验证 >> 准备 >> 解析 >> 初始化 >> 使用 >> 卸载
 */
public class Math {
    //随手测试demo
    public static void main(String[] args) {
        String test = test();
        System.out.println(test);
//        Integer a = 150;
//        Integer b = 150;
//        List<String> strings = new ArrayList<String>();
//        for (int i = 0; i < 150; i++) {
//            strings.add("2");
//        }
//        String s = "s";
//        System.out.println(strings.size() == a);// Integer与int比较时，Ingeger都会自动拆箱
//        System.out.println(b == a);
//        double aDouble = Double.valueOf(0.005);
//        System.out.println(aDouble);
    }

    private static String test() {
        String str = "start";
        try {
            System.out.println("try:" + str);
            System.out.println("try is running......");
            str = str + ":tyr";
            int a = 1 / 0;
            return str;
        } catch (Exception e) {
            System.out.println("catch:" + str);
            System.out.println("catch is running......");
            return str = str + "->catch return";
        }finally {
            System.out.println("finally:" + str);
            str = "finally:" + str;
            System.out.println("finally is running......");
            return str;
        }
    }
}
