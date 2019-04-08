package com.jinhuazhiguang.order.repository;

import com.jinhuazhiguang.order.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Desc : 订单详情repo
 * @auth : pdp
 * @date : 2019/04/05 17:40
 */
public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
