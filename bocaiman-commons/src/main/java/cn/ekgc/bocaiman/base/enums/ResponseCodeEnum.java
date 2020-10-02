package cn.ekgc.bocaiman.base.enums;

/**
 * <b>菠菜侠旅游租赁平台-基础功能-系统响应码枚举信息</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
public enum  ResponseCodeEnum {
	RESPONSE_CODE_200(200, "系统响应成功"),
	RESPONSE_CODE_500(500, "系统响应异常");

	private Integer code;           //系统状态
	private String remark;          //系统状态说明

	private ResponseCodeEnum(Integer code, String remark){
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
