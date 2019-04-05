package com.jinhuazhiguang.order.repository;

import com.jinhuazhiguang.order.dataobject.OrderMaster;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Desc : 订单repo
 * @auth : pdp
 * @date : 2019/04/05 17:40
 */
public interface OrderMasterRepository extends JpaRepository<OrderMaster, String> {
}
