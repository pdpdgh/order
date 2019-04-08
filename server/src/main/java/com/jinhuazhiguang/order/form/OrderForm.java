package com.jinhuazhiguang.order.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * @Desc : OrderForm
 * @auth : pdp
 * @date : 2019/04/05 18:38
 */
@Data
public class OrderForm {

    /** @Desc : 买家姓名 */
    @NotEmpty(message = "姓名必填")
    private String name;

    /** @Desc : 买家手机号 */
    @NotEmpty(message = "手机号必填")
    private String phone;

    /** @Desc : 买家地址 */
    @NotEmpty(message = "地址必填")
    private String address;

    /** @Desc : 买家微信openid */
    @NotEmpty(message = "openid必填")
    private String openid;

    /** @Desc : 购物车 */
    @NotEmpty(message = "购物车不能为空")
    private String items;
}
