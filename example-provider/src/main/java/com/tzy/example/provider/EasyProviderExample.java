package com.tzy.example.provider;

import com.tzy.example.common.service.UserService;
import com.tzy.rpc.RpcApplication;
import com.tzy.rpc.registry.LocalRegistry;
import com.tzy.rpc.server.VertxHttpServer;

/**
 * @Author:tzy
 * @Description : 简单服务提供者示例
 * @Date:2024/5/1917:06
 */
public class EasyProviderExample {

    public static void main(String[] args) {
        // RPC 框架初始化
        RpcApplication.init();
        //注册服务
        LocalRegistry.register(UserService.class.getName() , UserServiceImpl.class);

        //提供服务
        VertxHttpServer vertxHttpServer = new VertxHttpServer();
        vertxHttpServer.doStart(RpcApplication.getRpcConfig().getServerPort());
    }
}
