package cn.ekgc.bocaiman.pojo.contacts.vo;

import cn.ekgc.bocaiman.base.pojo.vo.BaseVO;
import cn.ekgc.bocaiman.pojo.contacts.entity.ContactsInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * <b>菠菜侠旅游租赁平台-联系人管理-联系人信息视图实体</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel("菠菜侠旅游租赁平台-联系人管理-联系人信息视图实体")
public class ContactsInfoVO extends BaseVO {
	private static final long serialVersionUID = 4940278131256059491L;
	@ApiModelProperty(value = "主键")
	private String id;              //主键
	@ApiModelProperty(value = "所属公司")
	private String corporation;     //所属公司
	@ApiModelProperty(value = "联系人")
	private String name;            //联系人
	@ApiModelProperty(value = "联系人电话")
	private String cellphone;       //联系人电话
	@ApiModelProperty(value = "身份证号码")
	private String idCard;          //身份证号码
	@ApiModelProperty(value = "身份证照片")
	private String idCardImg;       //身份证照片
	@ApiModelProperty(value = "审核状态")
	private String checkStatus;     //审核状态
	@ApiModelProperty(value = "审核人")
	private String checkName;       //审核人
	@ApiModelProperty(value = "审核时间")
	private Date checkTime;         //审核时间

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCorporation() {
		return corporation;
	}

	public void setCorporation(String corporation) {
		this.corporation = corporation;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getIdCardImg() {
		return idCardImg;
	}

	public void setIdCardImg(String idCardImg) {
		this.idCardImg = idCardImg;
	}

	public String getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}

	public String getCheckName() {
		return checkName;
	}

	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public static ContactsInfo parseToEntity(ContactsInfoVO vo){
		ContactsInfo entity = new ContactsInfo();
		//将VO中的属性提取，设定到entity 中
		//借助于Spring 所提供的BeanUtils 来拷贝属性值
		BeanUtils.copyProperties(vo, entity);

		return entity;
	}
}
