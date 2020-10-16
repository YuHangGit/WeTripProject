package cn.ekgc.bocaiman.trade.transport.impl;

import cn.ekgc.bocaiman.pojo.trade.entity.Trade;
import cn.ekgc.bocaiman.pojo.trade.vo.AlipayTradeVO;
import cn.ekgc.bocaiman.trade.service.TradeService;
import cn.ekgc.bocaiman.transport.trade.TradeTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-订单支付传输层接口实现类</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("tradeTransport")
@RequestMapping("/trade/trans")
public class TradeTransportImpl implements TradeTransport {
	@Autowired
	private TradeService service;
	/**
	 * <b>使用支付宝支付，保存交易信息</b>
	 * @author zyh
	 * @version 1.0.0
	 * @since 1.0.0
	 */
	@PostMapping("/save/alipay")
	@Override
	public boolean saveByAlipayTradeVO(Trade trade) throws Exception {
		return service.saveByAlipayTradeVO(trade);
	}
}
