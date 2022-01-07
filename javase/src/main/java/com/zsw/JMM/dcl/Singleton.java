package com.yg.edu.jmm.dcl;

/**
 * @author ：图灵-杨过
 * @date：2019/7/10
 * @version: V1.0
 * @slogan:天下风云出我辈，一入代码岁月催
 * @description
 */
public class Singleton {

    /**
     * 查看汇编指令
     * -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly -Xcomp
     */
    private volatile static Singleton myinstance;

    /**
     * 双重锁机制保证单例安全
     * @return
     */
    public static Singleton getInstance() {
        if (myinstance == null) {
            synchronized (Singleton.class) {
                if (myinstance == null) {
                    myinstance = new Singleton();
                }
            }
        }
        return myinstance;
    }

    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);
    }
}
