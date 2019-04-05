package com.jinhuazhiguang.order.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @Desc : 订单详情
 * @auth : pdp
 * @date : 2019/04/05 17:34
 */
@Data
@Entity
public class OrderDetail {

    /** @desc : 订单详情id */
    @Id
    private String detailId;

    /** @desc : 订单id */
    private String orderId;

    /** @desc : 商品id */
    private String productId;

    /** @desc : 商品名称 */
    private String productName;

    /** @desc : 商品单价 */
    private BigDecimal productPrice;

    /** @desc : 商品数量 */
    private Integer productQuantity;

    /** @desc : 商品小图 */
    private String productIcon;
}
