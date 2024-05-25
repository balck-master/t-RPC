package com.tzy.rpc.config;

import com.tzy.rpc.serializer.SerializerKeys;
import lombok.Data;

/**
 * @Author: tzy
 * @Description:  RPC 框架配置
 * @Date: 2024/5/21 8:32
 */
@Data
public class RpcConfig {


    /**
     * rpc名称
     */
    private String rpcName = "rpc";
    /**
     * 版本号
     */
    private String version = "1.0";
    /**
     * 服务器主机名
     */
    private String serverHost  = "localhost";
    /**
     * 服务器端口号8088 ，防止和伙伴系统冲突
     */
    private Integer serverPort = 8088;

    /**
     * 模拟调用
     */
    private boolean mock = false;

    /**
     * 序列化器
     */
    private String serializer = SerializerKeys.JDK;
}
