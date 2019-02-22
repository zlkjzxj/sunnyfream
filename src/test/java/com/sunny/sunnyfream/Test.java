package com.sunny.sunnyfream;

/**
 * @Description TODO
 * @Author sunny
 * Date 2019\2\2 0002 10:02
 */
public class Test {
    static String a = "aaa";
    static int b = 10;

    public static void main(String args[]) {
        System.out.println("a=" + a + ",b=" + b);
        set(a, b);
        System.out.println(a.hashCode());
        System.out.println("a=" + a + ",b=" + b);
    }

    public static void set(String a, int b) {
        a = "xxx";
        System.out.println(a.hashCode());
        b = 20;
    }
}
