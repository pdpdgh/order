package com.jinhuazhiguang.order.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Desc : 订单
 * @auth : pdp
 * @date : 2019/04/05 17:33
 */
@Data
@Entity
public class OrderMaster {

    /** @desc : 订单id */
    @Id
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

    /** @desc : 创建时间 */
    private Date createTime;

    /** @desc : 更新时间 */
    private Date updateTime;
}
