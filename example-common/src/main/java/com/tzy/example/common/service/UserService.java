package com.tzy.example.common.service;

import com.tzy.example.common.model.User;

/**
 * @Author:tzy
 * @Description : 用户服务
 * @Date:2024/5/1917:01
 */
public interface UserService {

    /**
     * 获取用户
     * @param user
     * @return
     */
    User getUser(User user);

    /**
     * 新方法 - 获取数字
     */
    default short getNumber() {
        return 1;
    }
}
