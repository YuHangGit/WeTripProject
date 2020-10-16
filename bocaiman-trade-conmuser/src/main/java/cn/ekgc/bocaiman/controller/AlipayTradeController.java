package cn.ekgc.bocaiman.controller;

import cn.ekgc.bocaiman.base.controller.BaseController;
import cn.ekgc.bocaiman.pojo.order.entity.Order;
import cn.ekgc.bocaiman.pojo.order.entity.OrderStatusRecord;
import cn.ekgc.bocaiman.pojo.trade.entity.PaymentPlatform;
import cn.ekgc.bocaiman.pojo.trade.entity.Trade;
import cn.ekgc.bocaiman.pojo.trade.vo.AlipayNotifyVO;
import cn.ekgc.bocaiman.pojo.trade.vo.AlipayTradeVO;
import cn.ekgc.bocaiman.transport.order.OrderStatusRecordTransport;
import cn.ekgc.bocaiman.transport.order.OrderTransport;
import cn.ekgc.bocaiman.transport.trade.PaymentPlatformTransport;
import cn.ekgc.bocaiman.transport.trade.TradeTransport;
import cn.ekgc.bocaiman.util.enums.AlipayTradeStatusEnum;
import cn.ekgc.bocaiman.util.enums.OrderStatusEnum;
import cn.ekgc.bocaiman.util.trade.AlipayConstantUtil;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


/**
 *菠菜侠旅游租赁平台-支付管理-支付控制器
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
@Api(value = "菠菜侠旅游租赁平台-支付管理-支付控制器", tags = {"菠菜侠旅游租赁平台-支付管理-支付交互接口"})
@RestController("AlipaytradeController")
@RequestMapping("/trade/alipay")
public class AlipayTradeController extends BaseController {
	@Autowired
	private TradeTransport tradeTransport;
	@Autowired
	private OrderTransport orderTransport;
	@Autowired
	private PaymentPlatformTransport paymentPlatformTransport;
	@Autowired
	private OrderStatusRecordTransport orderStatusRecordTransport;

	@ApiOperation(value = "统一收单下单并支付页面接口", httpMethod = "POST")
	@PostMapping("/pay")
	public void pay(@RequestBody AlipayTradeVO alipayTradeVO)throws Exception{
		//判断支付金额是否有效
		if(alipayTradeVO.getTotal_amount() != null && alipayTradeVO.getTotal_amount().doubleValue() > 0){
			//设定销售产品码信息
			alipayTradeVO.setProduct_code(AlipayConstantUtil.PRODUCT_CODE);
			//设定超时时间
			alipayTradeVO.setTime_expire();
			//将此时的支付信息进行保存到支付表中
			////将AlipayTradeVO 变成trade 对象
			Trade trade = new Trade();
			trade.setTradeNo(alipayTradeVO.getOut_trade_no());
			//根据交易编号 查询订单信息
			Order order = orderTransport.getOrderByOrderNo(alipayTradeVO.getOut_trade_no());
			trade.setOrder(order);
			//设定交易金额
			trade.setAmount(alipayTradeVO.getTotal_amount());
			//设定支付平台
			PaymentPlatform paymentPlatform = paymentPlatformTransport.getByPaymentPlatform("支付宝");
			trade.setPaymentPlatform(paymentPlatform);
			trade.setStartTime(new Date());
			//将订单此时的状态变为待支付
			if (tradeTransport.saveByAlipayTradeVO(trade)){
				//修改订单状态为支付中
				OrderStatusRecord orderStatusRecord = new OrderStatusRecord();
				orderStatusRecord.setOrder(order);
				orderStatusRecord.setOrderStatue(OrderStatusEnum.ORDER_STATUS_PAYING.getRemark());
				orderStatusRecord.setStatusCoder(OrderStatusEnum.ORDER_STATUS_PAYING.getCode());
				if(orderStatusRecordTransport.save(orderStatusRecord))
				//记录交易信息入库成功
				//入库成功， 调用支付宝接口进行支付
				//入库成功，调用支付宝接口进行支付
				payTrade(alipayTradeVO);
			}
		}
	}

	/**
	 * <b>支付宝交易 异步通知地址</b>
	 * @throws Exception
	 */
	@PostMapping("notify")
	public void tradeNotify(AlipayNotifyVO alipayNotifyVO) throws Exception{
		//获得此时订单编号，通过订单编号查询对应的订单信息
		Order order = orderTransport.getOrderByOrderNo(alipayNotifyVO.getOut_trade_no());
		//获得此时的交易信息
		String tradeStatus = alipayNotifyVO.getTrade_status();
		//根据状态进行判断
		if(AlipayTradeStatusEnum.TRADE_SUCCESS.getCode().equals(tradeStatus)
				|| AlipayTradeStatusEnum.TRADE_CLOSED.getCode().equals(tradeStatus)){
			//交易成功进行状态修改
			//修改订单状态为支付中
			OrderStatusRecord orderStatusRecord = new OrderStatusRecord();
			orderStatusRecord.setOrder(order);
			orderStatusRecord.setOrderStatue(OrderStatusEnum.ORDER_STATUS_PAYEND.getRemark());
			orderStatusRecord.setStatusCoder(OrderStatusEnum.ORDER_STATUS_PAYEND.getCode());
			orderStatusRecordTransport.save(orderStatusRecord);
		}
	}
	/**
	 * <b>调用支付宝接口进行支付操作</b>
	 * @author zyh
	 * @version 1.0.0
	 * @since 1.0.0
	 */
	private void payTrade(AlipayTradeVO alipayTradeVO) throws Exception{
		AlipayClient alipayClient =  new DefaultAlipayClient( AlipayConstantUtil.URL , AlipayConstantUtil.APPID,
				AlipayConstantUtil.APP_PRIVATE_KEY, AlipayConstantUtil.FORMAT, AlipayConstantUtil.CHARSET,
				AlipayConstantUtil.ALIPAY_PUBLIC_KEY, AlipayConstantUtil.SIGN_TYPE);  //获得初始化的AlipayClient
		AlipayTradePagePayRequest alipayRequest =  new  AlipayTradePagePayRequest(); //创建API对应的request
		alipayRequest.setReturnUrl(AlipayConstantUtil.RETURN_URL);
		alipayRequest.setNotifyUrl(AlipayConstantUtil.NOTIFY_URL); //在公共参数中设置回跳和通知地址

		//将AlipayTradeVO 变为JSON
		JsonMapper jsonMapper = new JsonMapper();
		String alipayTradeVOJSON = jsonMapper.writeValueAsString(alipayTradeVO);
		//设定相关参数
		alipayRequest.setBizContent(alipayTradeVOJSON);

		String form= alipayClient.pageExecute(alipayRequest).getBody();  //调用SDK生成表单
		response.setContentType( "text/html;charset="  + AlipayConstantUtil.CHARSET);
		response.getWriter().write(form); //直接将完整的表单html输出到页面
		response.getWriter().flush();
		response.getWriter().close();
	}
}
