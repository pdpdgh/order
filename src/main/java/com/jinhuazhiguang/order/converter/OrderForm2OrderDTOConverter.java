package com.jinhuazhiguang.order.converter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jinhuazhiguang.order.dataobject.OrderDetail;
import com.jinhuazhiguang.order.dto.OrderDTO;
import com.jinhuazhiguang.order.enums.ResultEnum;
import com.jinhuazhiguang.order.exception.OrderException;
import com.jinhuazhiguang.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @Desc : OrderForm2OrderDTOConverter
 * @auth : pdp
 * @date : 2019/04/05 19:01
 */
@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm) {
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetailList = new ArrayList<>();
        try {
            orderDetailList = gson.fromJson(orderForm.getItems(),
                    new TypeToken<List<OrderDetail>>() {}.getType());
        } catch (Exception e) {
            log.error("【json转换】 错误， string={}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetailList(orderDetailList);

        return orderDTO;
    }
}
