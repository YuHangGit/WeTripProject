package cn.ekgc.bocaiman.order.service.impl;

import cn.ekgc.bocaiman.order.dao.OrderDao;
import cn.ekgc.bocaiman.order.service.OrderService;
import cn.ekgc.bocaiman.pojo.order.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-订单信息业务层接口实现类</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {
	@Autowired
	private OrderDao dao;
	/**
	 * <b>根据订单编号查询订单信息</b>
	 * @param orderNo
	 * @return
	 * @throws Exception
	 */
	@Override
	public Order getOrderByOrderNo(String orderNo) throws Exception {
		//创建查询对象
		Order query = new Order();
		query.setOrderNo(orderNo);

		//进行查询
		List<Order> list = dao.findListByQuery(query);
		//提取数据
		if(list != null && !list.isEmpty()){
			return list.get(0);
		}

		return null;
	}
}
