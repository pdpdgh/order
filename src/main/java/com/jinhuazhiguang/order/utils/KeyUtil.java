package com.jinhuazhiguang.order.utils;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Random;

/**
 * @Desc : KeyUtil
 * @auth : pdp
 * @date : 2019/04/05 18:30
 */
public class KeyUtil {

    /**
    * @Desc : 生成唯一的主键  格式：时间+随机数
    */
    public static synchronized String genUniqueKey() {

        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;

        return System.currentTimeMillis() + String.valueOf(number);
    }
}
