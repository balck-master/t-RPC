package com.tzy.rpc.proxy;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.tzy.rpc.model.RpcRequest;
import com.tzy.rpc.model.RpcResponse;
import com.tzy.rpc.serializer.JdkSerializer;
import com.tzy.rpc.serializer.Serializer;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: tzy
 * @Description : 服务代理（JDK 动态代理）
 * @Date: 2024/5/20 16:44
 */
public class ServiceProxy implements InvocationHandler {


    /**
     * 调用代理
     *
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Serializer serializer = new JdkSerializer();
        RpcRequest rpcRequest = RpcRequest.builder()
                .methodName(method.getDeclaringClass().getName())
                .serviceName(method.getName())
                .parameterTypes(method.getParameterTypes())
                .args(args)
                .build();

        try {
            byte[] bodyBytes  = serializer.serialize(rpcRequest);

            try (HttpResponse httpResponse = HttpRequest.post("http://localhost:8088")
                    .body(bodyBytes)
                    .execute()) {
                byte[] result = httpResponse.bodyBytes();
                RpcResponse rpcResponse = serializer.deserialize(result, RpcResponse.class);
                return rpcResponse.getData();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
