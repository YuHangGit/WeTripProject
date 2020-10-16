package cn.ekgc.bocaiman.util.enums;

/**
 * <b>菠菜侠旅游租赁平台-订单状态枚举信息</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
public enum  OrderStatusEnum {
	ORDER_STATUS_CREATE(0, "已下单，待支付"),
	ORDER_STATUS_PAYING(1, "订单支付中"),
	ORDER_STATUS_PAYEND(2, "订单已支付"),
	ORDER_STATUS_FINISH(3, "订单完成"),
	ORDER_STATUS_PAY_FAILURE(4, "订单支付失败"),
	ORDER_STATUS_CANCAL(5, "订单已取消"),
	ORDER_STATUS_BACKING(6, "订单申请退款"),
	ORDER_STATUS_BCAK_SUCCESS(7, "退款成功"),
	ORDER_STATUS_BCAK_FAILURE(8, "退款失败");
	private Integer code;           //系统状态
	private String remark;          //系统状态说明

	private OrderStatusEnum(Integer code, String remark){
		this.code=code;
		this.remark=remark;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
