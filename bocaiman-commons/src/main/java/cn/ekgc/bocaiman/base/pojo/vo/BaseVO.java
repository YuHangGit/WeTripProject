package cn.ekgc.bocaiman.base.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <b>菠菜侠旅游租赁平台-基础功能-基础视图信息</b>
 * <p>
 *     基础视图设定所有视图通用的属性，其他视图信息必须继承于本基础视图
 * </p>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel("基础视图信息")
public class BaseVO implements Serializable {
	private static final long serialVersionUID = 7420250166493668293L;
	@ApiModelProperty(value = "系统状态1-启用 0-禁用", dataType = "Integer", example = "1")
	private Integer status;            //系统状态1-启用 0-禁用

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
