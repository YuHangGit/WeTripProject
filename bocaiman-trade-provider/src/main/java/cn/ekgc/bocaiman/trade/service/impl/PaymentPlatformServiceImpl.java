package cn.ekgc.bocaiman.trade.service.impl;

import cn.ekgc.bocaiman.base.pojo.vo.PageVO;
import cn.ekgc.bocaiman.pojo.trade.entity.PaymentPlatform;
import cn.ekgc.bocaiman.pojo.trade.vo.PaymentPlatformVO;
import cn.ekgc.bocaiman.trade.dao.PaymentPlatformDao;
import cn.ekgc.bocaiman.trade.service.PaymentPlatformService;
import cn.ekgc.bocaiman.util.IdGenerator;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;


/**
 * <b>菠菜侠旅游租赁平台-支付管理-支付平台业务层接口实现类</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
@Service("paymentPlatformService")
@Transactional
public class PaymentPlatformServiceImpl implements PaymentPlatformService {
	@Autowired
	private IdGenerator idGenerator;
	@Autowired
	private PaymentPlatformDao dao;
	/**
	 * <b>根据分页对象查询分页信息</b>
	 * @param pageVO
	 * @return
	 */
	@Override
	public PageVO<PaymentPlatformVO> getByPage(PageVO<PaymentPlatformVO> pageVO) throws Exception {

		//创建查询对象
		PaymentPlatform query = new PaymentPlatform();
		//开启PageHelper 对象
		PageHelper.startPage(pageVO.getPageNum(), pageVO.getPageSize());
		//进行分页查询
		List<PaymentPlatform> list = dao.findListByQuery(query);
		//创建pageInfo 对象
		PageInfo pageInfo = new PageInfo(list);
		//提取数据
		List<PaymentPlatformVO> resultList = new ArrayList<PaymentPlatformVO>();
		for(PaymentPlatform entity : (List<PaymentPlatform>)pageInfo.getList()){
			resultList.add(PaymentPlatform.parseToEntity(entity));
		}
		pageVO.setList(resultList);
		pageVO.setTotalCount(pageInfo.getTotal());
		pageVO.setTotalPage(pageInfo.getPages());
		return pageVO;
	}

	/**
	 * <b>查询列表</b>
	 * @param queryVO
	 * @return
	 */
	@Override
	public List<PaymentPlatformVO> getListByQuery(PaymentPlatformVO queryVO) throws Exception {
		//将查询视图转换为查询视图
		PaymentPlatform query = PaymentPlatformVO.parseToEntity(queryVO);
		//进行列表查询
		List<PaymentPlatform> list = dao.findListByQuery(query);
		//需要返回给前端视图信息 所以需要再把实体转换成视图
		List<PaymentPlatformVO> resultVO = new ArrayList<PaymentPlatformVO>();
		if(list != null){
			for (PaymentPlatform entity : list){
				resultVO.add(PaymentPlatform.parseToEntity(entity));
			}
		}
		return resultVO;
	}

	/**
	 * <b>根据id查询列表</b>
	 * @param id
	 * @return
	 */
	@Override
	public PaymentPlatformVO getById(String id) throws Exception {
		//创建查询实体
		PaymentPlatform query = new PaymentPlatform();
		query.setId(id);
		//进行列表查询
		List<PaymentPlatform> list = dao.findListByQuery(query);
		if (list != null && !list.isEmpty()){
			PaymentPlatform entity = list.get(0);
			return PaymentPlatform.parseToEntity(entity);
		}
		return null;
	}

	/**
	 * <b>保存信息</b>
	 * @param vo
	 * @return
	 */
	@Override
	public boolean save(PaymentPlatformVO vo) throws Exception {
		//将VO 对象转换为实体对象
		PaymentPlatform entity = PaymentPlatformVO.parseToEntity(vo);
		//设定主键
		entity.setId(idGenerator.nextId());
		//保存
		Integer count = dao.save(entity);

		if(count > 0 && count != null){
			return true;
		}
		return false;
	}

	/**
	 * <b>修改</b>
	 * @param vo
	 * @return
	 */
	@Override
	public boolean update(PaymentPlatformVO vo) throws Exception {
		//将VO 对象转换为实体对象
		PaymentPlatform entity = PaymentPlatformVO.parseToEntity(vo);
		//保存
		Integer count = dao.update(entity);

		if(count > 0 && count != null){
			return true;
		}
		return false;
	}

	/**
	 * <b>按照平台名称查询平台信息</b>
	 * @param platform
	 * @return
	 * @throws Exception
	 */
	@Override
	public PaymentPlatform getByPaymentPlatform(String platform) throws Exception {
		//创建查询实体
		PaymentPlatform query = new PaymentPlatform();
		query.setPlatform(platform);
		//进行列表查询
		List<PaymentPlatform> list = dao.findListByQuery(query);
		if (list != null && !list.isEmpty()){
			return list.get(0);
		}
		return null;
	}
}
