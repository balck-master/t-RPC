package com.tzy.rpc.serializer;

import com.tzy.rpc.spi.SpiLoader;


/**
 * @Author: tzy
 * @Description: 序列化器工厂（用于获取序列化器对象）
 * @Date: 2024/5/22 16:27
 */
public class SerializerFactory {

    /**
     * 序列化映射（用于实现单例）
     */
    static {
        SpiLoader.load(Serializer.class);
    }

    /**
     * 默认序列化器 为jdk序列化
     */
    private static final Serializer DEFAULT_SERIALIZER = new JdkSerializer();

    /**
     * 获取实例
     *
     * @param key
     * @return
     */
    public static Serializer getInstance(String key) {
        return SpiLoader.getInstance(Serializer.class , key);
    }


}
