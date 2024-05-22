package com.tzy.rpc.registry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author:tzy
 * @Description : 本地服务注册器
 * @Date:2024/5/2013:39
 */
public class LocalRegistry {

    /**
     * 注册信息存储 ， key为服务名称 ， value为服务实现类
     */
    private static final Map<String ,Class<?>> map = new ConcurrentHashMap<>();


    /**
     * 注册服务
     * @param serviceName
     * @param implClass
     */
    public static void register(String serviceName , Class<?> implClass){
        map.put(serviceName , implClass);
    }

    /**
     * 获取服务
     * @param serviceName
     * @return
     */
    public static Class<?>  get(String serviceName ){
        return map.get(serviceName);
    }

    /**
     * 删除服务
     *
     * @param serviceName
     */
    public static void remove(String serviceName){
        map.remove(serviceName);
    }
}
