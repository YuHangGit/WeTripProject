package cn.ekgc.bocaiman.pojo.trade.entity;

import cn.ekgc.bocaiman.base.pojo.entity.BaseEntity;
import cn.ekgc.bocaiman.pojo.trade.vo.PaymentPlatformVO;
import org.springframework.beans.BeanUtils;


/**
 * <b>菠菜侠旅游租赁平台-支付管理-支付平台实体信息</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
public class PaymentPlatform extends BaseEntity {
	private static final long serialVersionUID = -8024192951654190032L;
	private String id;                      //主键
	private String platform;                //支付平台
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

	public static PaymentPlatformVO parseToEntity(PaymentPlatform entity){
		PaymentPlatformVO vo = new PaymentPlatformVO();
		//将VO中的属性提取，设定到entity 中
		//借助于Spring 所提供的BeanUtils 来拷贝属性值
		BeanUtils.copyProperties(entity, vo);

		return vo;
	}
}
