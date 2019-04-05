package com.jinhuazhiguang.order.service.impl;

import com.jinhuazhiguang.order.dataobject.OrderMaster;
import com.jinhuazhiguang.order.dto.OrderDTO;
import com.jinhuazhiguang.order.enums.OrderStatusEnum;
import com.jinhuazhiguang.order.enums.PayStatusEnum;
import com.jinhuazhiguang.order.repository.OrderDetailRepository;
import com.jinhuazhiguang.order.repository.OrderMasterRepository;
import com.jinhuazhiguang.order.service.OrderService;
import com.jinhuazhiguang.order.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @Desc : 订单服务impl
 * @auth : pdp
 * @date : 2019/04/05 18:24
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Autowired
    private OrderMasterRepository orderMasterRepository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {

        /** 订单入库 */
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(KeyUtil.genUniqueKey());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);

        return orderDTO;
    }
}
