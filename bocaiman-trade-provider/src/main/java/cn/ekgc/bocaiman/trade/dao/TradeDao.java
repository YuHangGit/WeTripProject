package cn.ekgc.bocaiman.trade.dao;

import cn.ekgc.bocaiman.pojo.trade.entity.Trade;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *菠菜侠旅游租赁平台-支付平台-支付平台数据持久层接口
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public interface TradeDao {

	/**
	 * <b>根据查询对象查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<Trade> findListByQuery(Trade query)throws Exception;

	/**
	 * <b>保存</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Integer save(Trade entity) throws Exception;

	/**
	 * <b>修改</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Integer update(Trade entity)throws Exception;
}
