package com.jinhuazhiguang.order.exception;

import com.jinhuazhiguang.order.enums.ResultEnum;

/**
 * @Desc : OrderException
 * @auth : pdp
 * @date : 2019/04/05 19:11
 */
public class OrderException extends RuntimeException {

    private Integer code;

    public OrderException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
