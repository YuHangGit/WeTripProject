package cn.ekgc.bocaiman.trade.service;


import cn.ekgc.bocaiman.base.pojo.vo.PageVO;
import cn.ekgc.bocaiman.pojo.trade.entity.PaymentPlatform;
import cn.ekgc.bocaiman.pojo.trade.vo.PaymentPlatformVO;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-支付平台业务层接口</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
public interface PaymentPlatformService {
	/**
	 * <b>根据分页对象查询分页信息</b>
	 * @param pageVO
	 * @return
	 */
	PageVO<PaymentPlatformVO> getByPage(PageVO<PaymentPlatformVO> pageVO)throws Exception;

	/**
	 * <b>查询列表</b>
	 * @param queryVO
	 * @return
	 */
	List<PaymentPlatformVO> getListByQuery(PaymentPlatformVO queryVO)throws Exception;

	/**
	 * <b>根据id查询列表</b>
	 * @param id
	 * @return
	 */
	PaymentPlatformVO getById(String id)throws Exception;

	/**
	 * <b>保存信息</b>
	 * @param vo
	 * @return
	 */
	boolean save(PaymentPlatformVO vo)throws Exception;

	/**
	 * <b>修改</b>
	 * @param vo
	 * @return
	 */
	boolean update(PaymentPlatformVO vo)throws Exception;

	/**
	 * <b>按照平台名称查询平台信息</b>
	 * @param platform
	 * @return
	 * @throws Exception
	 */
	PaymentPlatform getByPaymentPlatform(String platform)throws Exception;
}
