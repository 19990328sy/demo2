package com.example.demo.util;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.Random;

public class SaltUtil {
    public static String getSalt(int n) {
        char[] chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz01234567890!@#$%^&*()".toCharArray ();
        StringBuilder sb = new StringBuilder ();
        for (int i = 0; i < n; i++) {
            char c = chars[new Random ().nextInt ( chars.length )];
            sb.append ( c );
        }
        return sb.toString ();
    }

    public static void main(String[] args) {
        System.out.println ("不翻船");
    }
}
