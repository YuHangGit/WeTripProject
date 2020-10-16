package cn.ekgc.bocaiman.transport.trade;

import cn.ekgc.bocaiman.base.pojo.vo.PageVO;
import cn.ekgc.bocaiman.pojo.trade.entity.PaymentPlatform;
import cn.ekgc.bocaiman.pojo.trade.vo.PaymentPlatformVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-支付平台传输层接口</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(name = "bocaiman-trade-provider")
@RequestMapping("/trade/paymentplatform/trans")
public interface PaymentPlatformTransport {

	/**
	 * <b>根据分页对象查询分页信息</b>
	 * @param pageVO
	 * @return
	 */
	@PostMapping("/page")
	PageVO<PaymentPlatformVO> getByPage(@RequestBody PageVO<PaymentPlatformVO> pageVO)throws Exception;

	/**
	 * <b>查询列表</b>
	 * @param queryVO
	 * @return
	 */
	@PostMapping("/list")
	List<PaymentPlatformVO> getListByQuery(@RequestBody PaymentPlatformVO queryVO)throws Exception;

	/**
	 * <b>根据id查询列表</b>
	 * @param id
	 * @return
	 */
	@PostMapping("/id")
	PaymentPlatformVO getById(@RequestParam String id) throws Exception;

	/**
	 * <b>保存</b>
	 * @param vo
	 * @return
	 */
	@PostMapping("/save")
	boolean save(@RequestBody PaymentPlatformVO vo)throws Exception;

	/**
	 * <b>修改</b>
	 * @param vo
	 * @return
	 */
	@PostMapping("/update")
	boolean update(@RequestBody PaymentPlatformVO vo)throws Exception;

	/**
	 * <b>按照平台名称查询平台信息</b>
	 * @param platform
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/platform")
	PaymentPlatform getByPaymentPlatform(String platform)throws Exception;
}
