package com.tzy.example.consumer;

import cn.hutool.core.util.ObjectUtil;
import com.tzy.example.common.model.User;
import com.tzy.example.common.service.UserService;
import com.tzy.rpc.config.RpcConfig;
import com.tzy.rpc.proxy.ServiceProxyFactory;
import com.tzy.rpc.util.ConfigUtils;

import java.util.Collections;

/**
 * @Author: tzy
 * @Description: 服务消费者测试代码
 * @Date: 2024/5/21 9:47
 */
public class ConsumerExample {
    public static void main(String[] args) {
        // 获取代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("yupi");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
        long number = userService.getNumber();
        System.out.println(number);
    }
}
