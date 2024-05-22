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
        UserService mockUserService = ServiceProxyFactory.getMockProxy(UserService.class);

        User user = new User();
        user.setName("dandan");
        User newUser = mockUserService.getUser(user);
        System.out.println("user对象为"+ObjectUtil.isEmpty(newUser));

        System.out.println("mock的数据类型为"+mockUserService.getNumber());
    }
}
