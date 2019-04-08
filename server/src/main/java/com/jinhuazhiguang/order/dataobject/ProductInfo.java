package com.jinhuazhiguang.order.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Desc : 商品信息
 * @auth : pdp
 * @date : 2019/04/05 13:30
 */
@Data
@Entity
public class ProductInfo {

    /** @desc : id */
    @Id
    private String productId;

    /** @desc : 名称 */
    private String productName;

    /** @desc : 单价 */
    private BigDecimal productPrice;

    /** @desc : 库存 */
    private Integer productStock;

    /** @desc : 描述 */
    private String productDescription;

    /** @desc : 小图 */
    private String productIcon;

    /** @desc : 状态 0正常1下架 */
    private Integer productStatus;

    /** @desc : 类目编号 */
    private Integer categoryType;

    /** @desc : 创建时间 */
    private Date createTime;

    /** @desc : 更新时间 */
    private Date updateTime;
}
