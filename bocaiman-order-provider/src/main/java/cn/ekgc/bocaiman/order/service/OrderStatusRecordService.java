package cn.ekgc.bocaiman.order.service;

import cn.ekgc.bocaiman.pojo.order.entity.OrderStatusRecord;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-订单状态记录业务层接口</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
public interface OrderStatusRecordService {

	/**
	 *<b>保存订单状态</b>
	 * @param orderStatusRecord
	 * @return
	 */
	boolean save(OrderStatusRecord orderStatusRecord)throws Exception;
}
