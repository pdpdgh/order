package com.jinhuazhiguang.order.service;

import com.jinhuazhiguang.order.dto.OrderDTO;

/**
 * @Desc : 订单服务
 * @auth : pdp
 * @date : 2019/04/05 18:17
 */
public interface OrderService {

    /**
    * @Desc : 创建订单
    */
    OrderDTO create(OrderDTO orderDTO);
}
