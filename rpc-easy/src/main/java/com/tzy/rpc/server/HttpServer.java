package com.tzy.rpc.server;

/**
 * @Author:tzy
 * @Description : http服务器接口
 * @Date:2024/5/1917:22
 */
public interface HttpServer  {
    /**
     * 启动服务器
     *
     * @param port
     *
     */
    void doStart(int port);
}
