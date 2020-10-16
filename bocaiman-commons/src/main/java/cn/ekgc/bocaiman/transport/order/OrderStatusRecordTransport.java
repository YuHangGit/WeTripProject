package cn.ekgc.bocaiman.transport.order;


import cn.ekgc.bocaiman.pojo.order.entity.OrderStatusRecord;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-订单状态传输层接口</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(name = "bocaiman-order-provider")
@RequestMapping("/orderstatus/trans")
public interface OrderStatusRecordTransport {
	/**
	 *<b>保存订单状态</b>
	 * @param orderStatusRecord
	 * @return
	 */
	@PostMapping("/save")
	boolean save(@RequestBody OrderStatusRecord orderStatusRecord)throws Exception;
}
