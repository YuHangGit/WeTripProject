package cn.ekgc.bocaiman.pojo.user.entity;

import cn.ekgc.bocaiman.base.pojo.entity.BaseEntity;

/**
 * <b>菠菜侠旅游租赁平台-用户管理-积分记录实体信息</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
public class PointRecord extends BaseEntity {
	private static final long serialVersionUID = -4250557674085780025L;
	private String id;                      //主键
	private User user;                      //用户信息
	private Integer usePoint;               //使用积分
	private Integer currentPoint;           //当前积分
	private String remark;                  //使用原因

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getUsePoint() {
		return usePoint;
	}

	public void setUsePoint(Integer usePoint) {
		this.usePoint = usePoint;
	}

	public Integer getCurrentPoint() {
		return currentPoint;
	}

	public void setCurrentPoint(Integer currentPoint) {
		this.currentPoint = currentPoint;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}
}
