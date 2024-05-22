package com.tzy.example.consumer;


import com.tzy.example.common.model.User;
import com.tzy.example.common.service.UserService;
import com.tzy.rpc.config.RpcConfig;
import com.tzy.rpc.proxy.ServiceProxyFactory;
import com.tzy.rpc.util.ConfigUtils;

/**
 * @Author:tzy
 * @Description : 简易版 消费者示例
 * @Date:2024/5/1917:14
 */
public class EasyConsumerExample {
    public static void main(String[] args) {
        RpcConfig rpc = ConfigUtils.loadConfig(RpcConfig.class, "rpc");
        System.out.println(rpc);
        // todo 需要获取 UserService 的实现类对象
        // 静态代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
//        UserService userService = null;
        User user = new User();
        user.setName("yupi");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
    }
}
