package com.tzy.rpc.test;

import com.tzy.rpc.serializer.Serializer;
import com.tzy.rpc.serializer.SerializerFactory;

/**
 * @Author: tzy
 * @Description:
 * @Date: 2024/5/23 10:38
 */
public class Main {
    public static void main(String[] args) {

//        Serializer a = SerializerFactory.getInstance();
        Serializer a = SerializerFactory.getInstance("f");
        System.out.println(a);
    }
}
