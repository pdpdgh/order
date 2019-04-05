package com.jinhuazhiguang.order.dto;

import com.jinhuazhiguang.order.dataobject.OrderDetail;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @Desc : OrderDTO
 * @auth : pdp
 * @date : 2019/04/05 18:20
 */
@Data
public class OrderDTO {

    /** @desc : 订单id */
    private String orderId;

    /** @desc : 买家名字 */
    private String buyerName;

    /** @desc : 买家手机号 */
    private String buyerPhone;

    /** @desc : 买家地址 */
    private String buyerAddress;

    /** @desc : 买家微信openid */
    private String buyerOpenid;

    /** @desc : 订单总金额 */
    private BigDecimal orderAmount;

    /** @desc : 订单状态，默认为0新下单 */
    private Integer orderStatus;

    /** @desc : 支付状态，默认为0未支付 */
    private Integer payStatus;

    private List<OrderDetail> orderDetailList;
}
