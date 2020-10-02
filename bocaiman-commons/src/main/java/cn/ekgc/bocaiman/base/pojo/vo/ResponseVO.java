package cn.ekgc.bocaiman.base.pojo.vo;

import cn.ekgc.bocaiman.base.enums.ResponseCodeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.crypto.Data;
import javax.xml.ws.Response;
import java.io.Serializable;

/**
 * <b>菠菜侠旅游租赁平台-基础功能-系统响应视图信息</b>
 * <p>
 *     所有和前端交互返回的数据，必须是本视图
 * </p>
 * @param <E>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
@ApiModel("系统响应视图信息")
public class ResponseVO<E> implements Serializable {
	private static final long serialVersionUID = -5988061517005111312L;
	@ApiModelProperty(value = "HTTP 响应码", example = "200")
	private Integer code;               //系统HTTP 响应码
	@ApiModelProperty(value = "系统处理结果")
	private boolean result;             //系统处理结果
	@ApiModelProperty(value = "系统响应数据")
	private E data;                     //系统响应数据

	public ResponseVO(ResponseCodeEnum responseCodeEnum, boolean result){
		this.code = responseCodeEnum.getCode();
		this.result = result;
	}

	public ResponseVO(ResponseCodeEnum responseCodeEnum, boolean result, E data){
		this.code = responseCodeEnum.getCode();
		this.result = result;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	/**
	 * <b>获得系统处理成功，响应成功的视图</b>
	 */
	public static ResponseVO success(){
		ResponseVO responseVO = new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_200, true);
		return responseVO;
	}

	/**
	 * <b>获得系统处理成功，响应成功的视图,返回处理信息</b>
	 */
	public static ResponseVO success(Object data){
		ResponseVO responseVO = new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_200, true, data);
		return responseVO;
	}

	/**
	 * <b><b>获得系统处理失败，响应成功的视图,返回处理信息</b></b>
	 * @param data
	 * @return
	 */
	public static ResponseVO failure(Object data){
		ResponseVO responseVO = new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_200, false, data);
		return responseVO;
	}

	/**
	 * <b>获得系统响应失败视图，返回处理信息</b>
	 * @param data
	 * @return
	 */
	public static ResponseVO exception(Object data){
		ResponseVO responseVO = new ResponseVO(ResponseCodeEnum.RESPONSE_CODE_500, false, data);
		return responseVO;
	}
}
