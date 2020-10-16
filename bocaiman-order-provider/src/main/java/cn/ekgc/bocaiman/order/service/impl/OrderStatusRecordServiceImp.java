package cn.ekgc.bocaiman.order.service.impl;

import cn.ekgc.bocaiman.order.dao.OrderStatusRecordDao;
import cn.ekgc.bocaiman.order.service.OrderStatusRecordService;
import cn.ekgc.bocaiman.pojo.order.entity.OrderStatusRecord;
import cn.ekgc.bocaiman.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-订单状态记录业务层接口实现类</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("orderStatusRecordService")
@Transactional
public class OrderStatusRecordServiceImp implements OrderStatusRecordService {
	@Autowired
	private OrderStatusRecordDao dao;
	@Autowired
	private IdGenerator idGenerator;
	/**
	 *<b>保存订单状态</b>
	 * @param orderStatusRecord
	 * @return
	 */
	@Override
	public boolean save(OrderStatusRecord orderStatusRecord) throws Exception {
		//设定参数id
		orderStatusRecord.setId(idGenerator.nextId());
		Integer count = dao.save(orderStatusRecord);
		if(count > 0){
			return true;
		}
		return false;
	}
}
