package cn.ekgc.bocaiman.pojo.order.entity;

import cn.ekgc.bocaiman.base.pojo.entity.BaseEntity;

/**
 * <b>菠菜侠旅游租赁平台-订单管理-订单实体信息</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
public class OrderStatusRecord extends BaseEntity {
	private static final long serialVersionUID = 9195914703507292040L;
	private String id;                      //主键
	private Order order;                    //订单信息
	private String orderStatue;             //订单状态
	private Integer statusCoder;            //状态编号

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getOrderStatue() {
		return orderStatue;
	}

	public void setOrderStatue(String orderStatue) {
		this.orderStatue = orderStatue;
	}

	public Integer getStatusCoder() {
		return statusCoder;
	}

	public void setStatusCoder(Integer statusCoder) {
		this.statusCoder = statusCoder;
	}
}
