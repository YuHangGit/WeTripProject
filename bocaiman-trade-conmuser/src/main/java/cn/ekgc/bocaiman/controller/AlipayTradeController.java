package cn.ekgc.bocaiman.controller;

import cn.ekgc.bocaiman.base.controller.BaseController;
import cn.ekgc.bocaiman.base.pojo.vo.ResponseVO;
import cn.ekgc.bocaiman.pojo.trade.vo.AlipayTradeVO;
import cn.ekgc.bocaiman.util.trade.AlipayConstantUtil;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.fasterxml.jackson.databind.json.JsonMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *菠菜侠旅游租赁平台-支付管理-支付控制器
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
@Api(value = "菠菜侠旅游租赁平台-支付管理-支付控制器", tags = {"菠菜侠旅游租赁平台-支付管理-支付交互接口"})
@RestController("AlipaytradeController")
@RequestMapping("/trade/alipay")
public class AlipayTradeController extends BaseController {
	@ApiOperation(value = "统一收单下单并支付页面接口", httpMethod = "POST")
	@PostMapping("/pay")
	public void pay(@RequestBody AlipayTradeVO alipayTradeVO)throws Exception{
		//判断支付金额是否有效
		if(alipayTradeVO.getTotal_amount() != null && alipayTradeVO.getTotal_amount().doubleValue() > 0){
			//设定销售产品码信息
			alipayTradeVO.setProduct_code(AlipayConstantUtil.PRODUCT_CODE);
			//设定超时时间
			alipayTradeVO.setTime_expire();
			//将此时的支付信息进行保存到支付表中
			//入库成功，调用支付宝接口进行支付
			payTrade(alipayTradeVO);
		}
	}

	/**
	 * <b>调用支付宝接口进行支付操作</b>
	 * @author zyh
	 * @version 1.0.0
	 * @since 1.0.0
	 */

	private void payTrade(AlipayTradeVO alipayTradeVO) throws Exception{
		AlipayClient alipayClient =  new DefaultAlipayClient( AlipayConstantUtil.URL , AlipayConstantUtil.APPID,
				AlipayConstantUtil.APP_PRIVATE_KEY, AlipayConstantUtil.FORMAT, AlipayConstantUtil.CHARSET,
				AlipayConstantUtil.ALIPAY_PUBLIC_KEY, AlipayConstantUtil.SIGN_TYPE);  //获得初始化的AlipayClient
		AlipayTradePagePayRequest alipayRequest =  new  AlipayTradePagePayRequest(); //创建API对应的request
		alipayRequest.setReturnUrl(AlipayConstantUtil.RETURN_URL);
		alipayRequest.setNotifyUrl(AlipayConstantUtil.NOTIFY_URL); //在公共参数中设置回跳和通知地址

		//将AlipayTradeVO 变为JSON
		JsonMapper jsonMapper = new JsonMapper();
		String alipayTradeVOJSON = jsonMapper.writeValueAsString(alipayTradeVO);
		//设定相关参数
		alipayRequest.setBizContent(alipayTradeVOJSON);

		String form= alipayClient.pageExecute(alipayRequest).getBody();  //调用SDK生成表单
		response.setContentType( "text/html;charset="  + AlipayConstantUtil.CHARSET);
		response.getWriter().write(form); //直接将完整的表单html输出到页面
		response.getWriter().flush();
		response.getWriter().close();
	}
}
