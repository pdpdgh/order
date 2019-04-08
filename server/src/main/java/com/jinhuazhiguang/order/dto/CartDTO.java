package com.jinhuazhiguang.order.dto;

import lombok.Data;

/**
 * @Desc : CartDTO
 * @auth : pdp
 * @date : 2019/04/07 15:42
 */
@Data
public class CartDTO {

    /** 商品id */
    private String productId;

    /** 商品数量 */
    private Integer productQuantity;

    public CartDTO() {
    }

    public CartDTO(String productId, Integer productQuantity) {
        this.productId = productId;
        this.productQuantity = productQuantity;
    }
}
