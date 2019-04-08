package com.jinhuazhiguang.order.service.impl;

import com.jinhuazhiguang.product.client.ProductClient;
import com.jinhuazhiguang.product.common.ProductInfoOutput;
import com.jinhuazhiguang.product.common.DecreaseStockInput;
import com.jinhuazhiguang.order.dataobject.OrderDetail;
import com.jinhuazhiguang.order.dataobject.OrderMaster;
import com.jinhuazhiguang.order.dataobject.ProductInfo;
import com.jinhuazhiguang.order.dto.CartDTO;
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
import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

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

    @Autowired
    private ProductClient productClient;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtil.genUniqueKey();

        /** 查询商品信息（调用商品服务） */
        List<String> productIdList = orderDTO.getOrderDetailList().stream()
                .map(OrderDetail::getProductId)
                .collect(Collectors.toList());
        List<ProductInfoOutput> productInfoList = productClient.listForOrder(productIdList);

        /** 计算总价 */
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail: orderDTO.getOrderDetailList()) {
            for (ProductInfoOutput productInfo: productInfoList) {
                if (productInfo.getProductId().equals(orderDetail.getProductId())) {
                    /** 单价*数量 */
                    orderAmount = productInfo.getProductPrice()
                            .multiply(new BigDecimal(orderDetail.getProductQuantity()))
                            .add(orderAmount);
                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtil.genUniqueKey());
                    /** 订单详情入库 */
                    orderDetailRepository.save(orderDetail);
                }
            }
        }
        
        /** 扣库存（调用商品服务） */
        List<DecreaseStockInput> decreaseStockInputList = orderDTO.getOrderDetailList().stream()
                .map(e -> new DecreaseStockInput(e.getProductId(), e.getProductQuantity()))
                .collect(Collectors.toList());
        productClient.decreaseStock(decreaseStockInputList);

        /** 订单入库 */
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.WAIT.getCode());
        orderMasterRepository.save(orderMaster);

        return orderDTO;
    }
}
