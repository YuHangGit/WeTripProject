package cn.ekgc.bocaiman.order.transport.impl;

import cn.ekgc.bocaiman.order.service.OrderService;
import cn.ekgc.bocaiman.pojo.order.entity.Order;
import cn.ekgc.bocaiman.transport.order.OrderTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-订单信息传输层接口实现类</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("orderTransport")
@RequestMapping("/order/trans")
public class OrderTransportImpl implements OrderTransport {
	@Autowired
	private OrderService service;
	/**
	 * <b>根据订单编号查询订单信息</b>
	 * @param orderNo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/orderNo")
	@Override
	public Order getOrderByOrderNo(String orderNo) throws Exception {
		return service.getOrderByOrderNo(orderNo);
	}
}
