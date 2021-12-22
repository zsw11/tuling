package com.zsw.jvm;

import jdk.internal.dynalink.beans.StaticClass;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * 判断对象已经死亡，引用计数法（计数器就加1，计数器为0就提示回收，但是无法解决循环依赖问题），可达性分析算法（GC Roots” 对象作为起点，从这些节点开始向下搜索引用的对象，找到的对象都标记为非垃圾对象），
 * finalize()方法最终判定对象是否存活，对象在回收之前会被调用一次
 */
public class OOMTest {
    static List<User> list = new ArrayList<User>();

    public static void main(String[] args) {

        int i = 0;
        int j = 0;
        while (true) {
            list.add(new User(i++, UUID.randomUUID().toString()));
            new User(j--, UUID.randomUUID().toString());
        }
    }
}

class User {
    int id;

    public User(int i, String s) {
        id = i;
    }

    //User类需要重写finalize方法
    @Override
    protected void finalize() throws Throwable {
        OOMTest.list.add(this);
        System.out.println("关闭资源，userid=" + id + "即将被回收");
    }
}




