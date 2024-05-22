package com.tzy.rpc;

import com.tzy.rpc.config.RpcConfig;
import com.tzy.rpc.constant.RpcConstant;
import com.tzy.rpc.util.ConfigUtils;
import lombok.extern.slf4j.Slf4j;

/**
 * @Author: tzy
 * @Description:    RPC 框架应用
 *  *               相当于 holder，存放了项目全局用到的变量。双检锁单例模式实现
 * @Date: 2024/5/21 9:11
 */
@Slf4j
public class RpcApplication {

    private static volatile RpcConfig rpcConfig;

    /**
     * 框架初始化，支持传入自定义配置
     *
     * @param newRpcConfig 自定义框架的配置
     */
    public static void init(RpcConfig newRpcConfig){
        rpcConfig = newRpcConfig;
        log.info("rpc init, config = {}", newRpcConfig.toString());
    }


    /**
     * 初始化  --使用自定义框架的配置初始化
     */
    public static void init(){
        RpcConfig newRpcConfig;
        try {
            newRpcConfig = ConfigUtils.loadConfig(RpcConfig.class, RpcConstant.DEFAULT_CONFIG_PREFIX);
        } catch (Exception e) {
            // 配置加载失败，使用默认值
            newRpcConfig = new RpcConfig();
        }
        init(newRpcConfig);
    }

    /**
     * 获取配置
     *
     * 通过 双检锁单例模式实现 ，支持在获取配置时才调用 init 方法实现懒加载。
     * 为了便于扩展，还支持自己传入配置对象；如果不传入，则默认调用前面写好的 ConfigUtils 来加载配置。
     *
     * @return
     */
    public static RpcConfig getRpcConfig() {
        if(rpcConfig == null){
            synchronized (RpcApplication.class){
                if(rpcConfig == null){
                    init();
                }
            }
        }
        return rpcConfig;
    }

}
