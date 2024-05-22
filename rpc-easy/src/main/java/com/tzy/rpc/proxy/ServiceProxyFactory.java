package com.tzy.rpc.proxy;

import java.lang.reflect.Proxy;

/**
 * @Author: tzy
 * @Description: 服务动态代理工厂 （用于创建代理对象）
 * @Date: 2024/5/20 17:08
 */
public class ServiceProxyFactory {
    /**
     * 根据服务类获取代理对象
     *
     * @param serviceClass
     * @param <T>
     * @return
     */
    public static <T> T getProxy(Class<T> serviceClass) {
        return (T) Proxy.newProxyInstance(
                serviceClass.getClassLoader(),
                new Class[]{serviceClass},
                new ServiceProxy());
    }
}
