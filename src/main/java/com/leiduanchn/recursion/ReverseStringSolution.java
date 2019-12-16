package com.leiduanchn.recursion;

/**
 * 反转字符串
 * @author leiduanchn
 * @create 2019-12-15 11:09 p.m.
 */
public class ReverseStringSolution {

    // 公式： f(s) = f(s[1->length]) + s[0], 终止： a.length = 1
    public String reverseString(String s){
        if(s == null || s.length() == 0) return s;
        if(s.length() == 1) return s;
        return reverseString(s.substring(1)) + s.charAt(0);
    }


    public static void main(String[] args) {
        String s = "hello world";
        ReverseStringSolution solution = new ReverseStringSolution();
        String s1 = solution.reverseString(s);
        System.out.println(s1);
    }

}
