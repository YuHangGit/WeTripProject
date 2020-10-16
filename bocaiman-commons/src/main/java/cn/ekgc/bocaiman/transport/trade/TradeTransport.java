package cn.ekgc.bocaiman.transport.trade;

import cn.ekgc.bocaiman.pojo.trade.entity.Trade;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-订单支付传输层接口</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(name = "bocaiman-trade-provider")
@RequestMapping("/trade/trans")
public interface TradeTransport {
	/**
	 * <b>使用支付宝支付，保存交易信息</b>
	 * @author zyh
	 * @version 1.0.0
	 * @since 1.0.0
	 */
	@PostMapping("/save/alipay")
	boolean saveByAlipayTradeVO(@RequestBody Trade trade)throws Exception;
}
