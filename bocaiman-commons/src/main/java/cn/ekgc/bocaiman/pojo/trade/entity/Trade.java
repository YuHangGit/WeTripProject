package cn.ekgc.bocaiman.pojo.trade.entity;

import cn.ekgc.bocaiman.base.pojo.entity.BaseEntity;
import cn.ekgc.bocaiman.pojo.order.entity.Order;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-订单支付实体信息</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
public class Trade extends BaseEntity {
	private static final long serialVersionUID = 6994696831693340008L;
	private String id;                                  //主键
	private String tradeNo;                             //交易编号
	private Order order;                              //订单信息
	private BigDecimal amount;                          //支付金额
	private PaymentPlatform paymentPlatform;            //支付平台
	private Date startTime;                             //交易开始时间
	private Date endTime;                               //交易结束时间

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTradeNo() {
		return tradeNo;
	}

	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public PaymentPlatform getPaymentPlatform() {
		return paymentPlatform;
	}

	public void setPaymentPlatform(PaymentPlatform paymentPlatform) {
		this.paymentPlatform = paymentPlatform;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
