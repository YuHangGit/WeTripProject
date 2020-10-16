package cn.ekgc.bocaiman.pojo.user.entity;

import cn.ekgc.bocaiman.base.pojo.entity.BaseEntity;
import cn.ekgc.bocaiman.pojo.admin.entity.Admin;

import java.util.Date;


/**
 * <b>菠菜侠旅游租赁平台-用户管理-用户实体信息</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
public class User extends BaseEntity {
	private static final long serialVersionUID = 2751387670655779114L;
	private String id;                      //主键
	private String name;                    //用户名称
	private String licenceNo;               //许可证编号
	private String UniformSocialCreditCode; //统一社会信用代码
	private String authorizedRepresentative;//法定代表人
	private String authorizedIdCard;        //法定代表人证件号码
	private String licenceImage;            //经营许可证照片
	private String cellphone;               //登录手机号
	private String password;                //登录密码
	private Integer point;                  //积分
	private String checkStatus;             //审核状态
	private Admin checkAdmin;               //审核人
	private String checkRemark;             //审核意见
	private Date checkTime;                 //审核时间

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLicenceNo() {
		return licenceNo;
	}

	public void setLicenceNo(String licenceNo) {
		this.licenceNo = licenceNo;
	}

	public String getUniformSocialCreditCode() {
		return UniformSocialCreditCode;
	}

	public void setUniformSocialCreditCode(String uniformSocialCreditCode) {
		UniformSocialCreditCode = uniformSocialCreditCode;
	}

	public String getAuthorizedRepresentative() {
		return authorizedRepresentative;
	}

	public void setAuthorizedRepresentative(String authorizedRepresentative) {
		this.authorizedRepresentative = authorizedRepresentative;
	}

	public String getAuthorizedIdCard() {
		return authorizedIdCard;
	}

	public void setAuthorizedIdCard(String authorizedIdCard) {
		this.authorizedIdCard = authorizedIdCard;
	}

	public String getLicenceImage() {
		return licenceImage;
	}

	public void setLicenceImage(String licenceImage) {
		this.licenceImage = licenceImage;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getCheckStatus() {
		return checkStatus;
	}

	public void setCheckStatus(String checkStatus) {
		this.checkStatus = checkStatus;
	}

	public Admin getCheckAdmin() {
		return checkAdmin;
	}

	public void setCheckAdmin(Admin checkAdmin) {
		this.checkAdmin = checkAdmin;
	}

	public String getCheckRemark() {
		return checkRemark;
	}

	public void setCheckRemark(String checkRemark) {
		this.checkRemark = checkRemark;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}
}
