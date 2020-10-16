package cn.ekgc.bocaiman.order.dao;


import cn.ekgc.bocaiman.pojo.order.entity.OrderStatusRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderStatusRecordDao {
	/**
	 * <b>根据查询对象查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<OrderStatusRecord> findListByQuery(OrderStatusRecord query)throws Exception;

	/**
	 * <b>保存</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Integer save(OrderStatusRecord entity) throws Exception;

}
