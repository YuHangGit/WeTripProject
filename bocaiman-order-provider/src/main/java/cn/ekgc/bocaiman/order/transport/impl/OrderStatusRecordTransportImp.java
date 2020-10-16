package cn.ekgc.bocaiman.order.transport.impl;

import cn.ekgc.bocaiman.order.service.OrderStatusRecordService;
import cn.ekgc.bocaiman.pojo.order.entity.OrderStatusRecord;
import cn.ekgc.bocaiman.transport.order.OrderStatusRecordTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * <b>菠菜侠旅游租赁平台-支付管理-订单状态传输层接口实现类</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("orderStatusRecordTransport")
@RequestMapping("/orderstatus/trans")
public class OrderStatusRecordTransportImp implements OrderStatusRecordTransport {
	@Autowired
	private OrderStatusRecordService service;
	/**
	 *<b>保存订单状态</b>
	 * @param orderStatusRecord
	 * @return
	 */
	@PostMapping("/save")
	@Override
	public boolean save(@RequestBody OrderStatusRecord orderStatusRecord) throws Exception {
		return service.save(orderStatusRecord);
	}
}
