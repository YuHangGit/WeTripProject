package cn.ekgc.bocaiman.order.dao;

import cn.ekgc.bocaiman.pojo.order.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-订单信息数据持久层接口</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public interface OrderDao {

	/**
	 * <b>根据查询对象查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<Order> findListByQuery(Order query)throws Exception;

	/**
	 * <b>保存</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Integer save(Order entity) throws Exception;

	/**
	 * <b>修改</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Integer update(Order entity)throws Exception;
}
