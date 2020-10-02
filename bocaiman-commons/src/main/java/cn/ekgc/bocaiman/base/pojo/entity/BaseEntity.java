package cn.ekgc.bocaiman.base.pojo.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * <b>基础架构-基础实体信息</b>
 * @author 10316
 * @version 1.0.0
 * @since 1.0.0
 */
public class BaseEntity implements Serializable {
	private static final long serialVersionUID = -870086625471344268L;
	private Integer status;               //系统状态1-启用 0-禁用
	private String createAdmin;          //创建人
	private Date createTime;            //创建时间
	private String updateAdmin;         //修改人
	private Date updateTime;           //修改时间

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getCreateAdmin() {
		return createAdmin;
	}

	public void setCreateAdmin(String createAdmin) {
		this.createAdmin = createAdmin;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getUpdateAdmin() {
		return updateAdmin;
	}

	public void setUpdateAdmin(String updateAdmin) {
		this.updateAdmin = updateAdmin;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
}
