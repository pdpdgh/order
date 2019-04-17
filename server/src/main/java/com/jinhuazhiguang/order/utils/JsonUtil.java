package com.jinhuazhiguang.order.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jinhuazhiguang.product.common.ProductInfoOutput;

import java.io.IOException;

/**
 * @Desc : JsonUtil
 * @auth : pdp
 * @date : 2019/04/17 2:47
 */
public class JsonUtil {

    private static ObjectMapper objectMapper = new ObjectMapper();

    /**
    * @Desc : 转换为json字符串
    */
    public static String toJson(Object object) {
        try {
            return objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
    * @Desc : 字符串转换为json对象
    */
    public static Object fromJson(String string, TypeReference typeReference) {
        try {
            return objectMapper.readValue(string, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
