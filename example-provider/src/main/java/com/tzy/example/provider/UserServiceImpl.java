package com.tzy.example.provider;

import com.tzy.example.common.model.User;
import com.tzy.example.common.service.UserService;

/**
 * @Author:tzy
 * @Description : 用户服务实现类
 * @Date:2024/5/1917:04
 */
public class UserServiceImpl implements UserService {

    /**
     *  获取用户
     * @param user
     * @return
     */
    @Override
    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}
