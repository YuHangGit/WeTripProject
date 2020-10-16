package cn.ekgc.bocaiman.order.service;

import cn.ekgc.bocaiman.pojo.order.entity.Order;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-订单信息业务层接口</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
public interface OrderService {
	/**
	 * <b>根据订单编号查询订单信息</b>
	 * @param orderNo
	 * @return
	 * @throws Exception
	 */
	Order getOrderByOrderNo(String orderNo)throws Exception;
}
