package cn.ekgc.bocaiman.trade.transport.impl;

import cn.ekgc.bocaiman.base.pojo.vo.PageVO;
import cn.ekgc.bocaiman.pojo.trade.entity.PaymentPlatform;
import cn.ekgc.bocaiman.pojo.trade.vo.PaymentPlatformVO;
import cn.ekgc.bocaiman.trade.service.PaymentPlatformService;
import cn.ekgc.bocaiman.transport.trade.PaymentPlatformTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-支付平台传输层接口实现类</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
@RestController("paymentPlatformTransport")
@RequestMapping("/trade/paymentplatform/trans")
public class PaymentPlatformTransportImpl implements PaymentPlatformTransport {
	@Autowired
	private PaymentPlatformService service;
	/**
	 * <b>根据分页对象查询分页信息</b>
	 * @param pageVO
	 * @return
	 */
	@PostMapping("/page")
	@Override
	public PageVO<PaymentPlatformVO> getByPage(@RequestBody PageVO<PaymentPlatformVO> pageVO) throws Exception {
		return service.getByPage(pageVO);
	}

	/**
	 * <b>查询列表</b>
	 * @param queryVO
	 * @return
	 */
	@PostMapping("/list")
	@Override
	public List<PaymentPlatformVO> getListByQuery(@RequestBody PaymentPlatformVO queryVO) throws Exception {
		return service.getListByQuery(queryVO);
	}

	/**
	 * <b>根据id查询列表</b>
	 * @param id
	 * @return
	 */
	@PostMapping("/id")
	@Override
	public PaymentPlatformVO getById(@RequestParam String id) throws Exception {
		return service.getById(id);
	}

	/**
	 * <b>保存信息</b>
	 * @param vo
	 * @return
	 */
	@PostMapping("/save")
	@Override
	public boolean save(@RequestBody PaymentPlatformVO vo) throws Exception {
		return service.save(vo);
	}

	/**
	 * <b>修改</b>
	 * @param vo
	 * @return
	 */
	@PostMapping("/update")
	@Override
	public boolean update(@RequestBody PaymentPlatformVO vo) throws Exception {
		return service.update(vo);
	}

	/**
	 * <b>按照平台名称查询平台信息</b>
	 * @param platform
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/platform")
	@Override
	public PaymentPlatform getByPaymentPlatform(String platform) throws Exception {
		return service.getByPaymentPlatform(platform);
	}


}
