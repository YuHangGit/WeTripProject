package cn.ekgc.bocaiman.trade.service.impl;

import cn.ekgc.bocaiman.pojo.order.entity.Order;
import cn.ekgc.bocaiman.pojo.trade.entity.Trade;
import cn.ekgc.bocaiman.pojo.trade.vo.AlipayTradeVO;
import cn.ekgc.bocaiman.trade.dao.TradeDao;
import cn.ekgc.bocaiman.trade.service.TradeService;
import cn.ekgc.bocaiman.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-订单支付业务层接口实现类</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("tradeService")
@Transactional
public class TradeServiceImpl implements TradeService {
	@Autowired
	private TradeDao dao;
	@Autowired
	private IdGenerator idGenerator;
	/**
	 * <b>使用支付宝支付，保存交易信息</b>
	 * @author zyh
	 * @version 1.0.0
	 * @since 1.0.0
	 */
	@Override
	public boolean saveByAlipayTradeVO(Trade trade) throws Exception {
		//设定主键
		trade.setId(idGenerator.nextId());
		//保存信息
		Integer count = dao.save(trade);
		if (count != null && count > 0){
			return true;
		}
		return false;
	}
}
