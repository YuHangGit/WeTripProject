package cn.ekgc.bocaiman.pojo.contacts.entity;

import cn.ekgc.bocaiman.base.pojo.entity.BaseEntity;
import cn.ekgc.bocaiman.pojo.contacts.vo.ContactsInfoVO;
import cn.ekgc.bocaiman.util.enums.CheckStatusEnum;
import org.springframework.beans.BeanUtils;

import java.util.Date;

/**
 * <b>菠菜侠旅游租赁平台-联系人管理-联系人信息实体</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
public class ContactsInfo extends BaseEntity {
	private static final long serialVersionUID = 4766637365799073693L;
	private String id;              //主键
	private String corporation;     //所属公司
	private String name;            //联系人
	private String cellphone;       //联系人电话
	private String idCard;          //身份证号码
	private String idCardImg;       //身份证照片
	private String checkStatus;     //审核状态
	private String checkName;       //审核人
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

	public static ContactsInfoVO parseToEntity(ContactsInfo entity){
		ContactsInfoVO vo = new ContactsInfoVO();
		//将VO中的属性提取，设定到entity 中
		//借助于Spring 所提供的BeanUtils 来拷贝属性值
		BeanUtils.copyProperties(entity, vo);

		return vo;
	}
}
