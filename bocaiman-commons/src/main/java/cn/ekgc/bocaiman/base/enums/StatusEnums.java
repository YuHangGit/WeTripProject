package cn.ekgc.bocaiman.base.enums;


/**
 * <b>基础架构-系统状态枚举信息</b>
 * @author 10316
 * @version 1.0.0
 * @since 1.0.0
 */
public enum StatusEnums {
	STATUS_ENABLE(1, "启用"),
	STATUS_DISABLE(0, "禁用");
	private Integer code;           //系统状态
	private String remark;          //系统状态说明

	private StatusEnums(Integer code, String remark){
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
