package com.tzy.example.common.model;

import java.io.Serializable;

/**
 * @Author:tzy
 * @Description : 用户实体类 ,实现序列化接口，为后续网络传输序列化提供支持。
 * @Date:2024/5/1916:29
 */
public class User implements Serializable {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
