package com.jinhuazhiguang.order.enums;

import lombok.Getter;

/**
 * @Desc : OrderStatusEnum
 * @auth : pdp
 * @date : 2019/04/05 17:44
 */
@Getter
public enum OrderStatusEnum {

    NEW(0, "新订单"),
    FINISHED(1, "完结"),
    CANCEL(2, "取消"),
    ;

    private Integer code;
    private String message;

    OrderStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
