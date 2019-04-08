package com.jinhuazhiguang.order.enums;

import lombok.Getter;

/**
 * @Desc : OrderStatusEnum
 * @auth : pdp
 * @date : 2019/04/05 17:44
 */
@Getter
public enum PayStatusEnum {

    WAIT(0, "等待支付"),
    SUCCESS(1, "支付成功"),
    ;

    private Integer code;
    private String message;

    PayStatusEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
