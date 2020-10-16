package cn.ekgc.bocaiman.trade.service;

import cn.ekgc.bocaiman.pojo.trade.entity.Trade;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-订单支付业务层接口</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
public interface TradeService {
	/**
	 * <b>使用支付宝支付，保存交易信息</b>
	 * @author zyh
	 * @version 1.0.0
	 * @since 1.0.0
	 */
	boolean saveByAlipayTradeVO(Trade trade)throws Exception;
}
