package cn.ekgc.bocaiman.pojo.trade.vo;

import cn.ekgc.bocaiman.base.pojo.vo.BaseVO;
import cn.ekgc.bocaiman.pojo.trade.entity.PaymentPlatform;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-支付平台视图信息</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel("菠菜侠旅游租赁平台-支付管理-支付平台视图信息")
public class PaymentPlatformVO extends BaseVO {
	private static final long serialVersionUID = 4486576623053304874L;
	@ApiModelProperty(value = "主键")
	private String id;                      //主键
	@ApiModelProperty(value = "支付平台")
	private String platform;                //支付平台
	@ApiModelProperty(value = "平台图标")
	private String platformIcon;            //平台图标

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = platform;
	}

	public String getPlatformIcon() {
		return platformIcon;
	}

	public void setPlatformIcon(String platformIcon) {
		this.platformIcon = platformIcon;
	}

	public static PaymentPlatform parseToEntity(PaymentPlatformVO vo){
		PaymentPlatform entity = new PaymentPlatform();
		//将VO中的属性提取，设定到entity 中
		//借助于Spring 所提供的BeanUtils 来拷贝属性值
		BeanUtils.copyProperties(vo, entity);

		return entity;
	}
}
