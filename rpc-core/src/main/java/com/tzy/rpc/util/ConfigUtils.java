package com.tzy.rpc.util;

import cn.hutool.core.util.StrUtil;
import cn.hutool.setting.dialect.Props;
import com.tzy.rpc.config.RpcConfig;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ Author: tzy
 * @ Description:  读取配置文件并返回配置对象，可以简化调用。
 * @ Date: 2024/5/21 8:47
 */
public class ConfigUtils {

    /**
     * 加载配置对象
     *
     * @param tClass 文件类型
     * @param prefix 配置内容前缀
     * @param <T>
     * @return  可以返回任意类型的对象。
     */
    public static <T> T loadConfig(Class<T> tClass , String prefix){
        return loadConfig(tClass,prefix,"");
    }


    /**
     * 加载配置对象,支持区分环境(比如dev，prod)
     *
     * @param tClass 文件类型
     * @param prefix 配置内容前缀 , 为什么需要前缀呢？为了确认这是rpc的配置文件，只有以rpc开头的才是~~~，假如我还有mysql的配置文件呢，这样方便分辨
     * @param environment 环境
     * @param <T>
     *
     *      props.toBean()方法 将配置文件中的属性转换为指定类型的Java Bean对象。其中，tClass表示要转换成的目标类型，prefix表示属性的前缀。
     * @return
     */
    public static <T> T loadConfig(Class<T> tClass , String prefix , String environment){
        StringBuilder configFileBuilder  = new StringBuilder("application");
        if(StrUtil.isNotBlank(environment)){
            configFileBuilder.append("-").append(environment);
        }
        configFileBuilder.append(".properties");
        Props props = new Props(configFileBuilder.toString());
        return props.toBean(tClass,prefix);
    }

//    public <T> T loadConfig() throws IOException {
//        Yaml yaml = new Yaml();
//        InputStream inputStream = ConfigUtils.getClass().getClassLoader().getResourceAsStream("application.yml");
//        RpcConfig serverProperties = yaml.loadAs(inputStream, RpcConfig.class);
//        System.out.println("Server port: " + serverProperties.getServerPort());
//
//        //怎么将
//        return serverProperties.
//    }

}
