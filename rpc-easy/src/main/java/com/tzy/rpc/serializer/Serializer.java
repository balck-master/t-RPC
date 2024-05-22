package com.tzy.rpc.serializer;

import java.io.IOException;

/**
 * @Author:tzy
 * @Description : 序列化器接口
 * @Date:2024/5/2015:14
 */
public interface Serializer  {

    /**
     * 序列化
     *
     * @param object
     * @param <T>
     * @return
     * @throws IOException
     */
    <T> byte[] serialize(T object) throws IOException;

    /**
     * 反序列化
     *
     * @param bytes
     * @param type
     * @param <T>
     * @return
     * @throws IOException
     */
    <T> T deserialize(byte[] bytes, Class<T> type) throws IOException;
}
