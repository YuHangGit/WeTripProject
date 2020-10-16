package cn.ekgc.bocaiman.contactsInfo.service.impl;

import cn.ekgc.bocaiman.base.pojo.vo.PageVO;
import cn.ekgc.bocaiman.contactsInfo.dao.ContactsInfoDao;
import cn.ekgc.bocaiman.contactsInfo.service.ContactsInfoService;
import cn.ekgc.bocaiman.pojo.contacts.entity.ContactsInfo;
import cn.ekgc.bocaiman.pojo.contacts.vo.ContactsInfoVO;
import cn.ekgc.bocaiman.util.IdGenerator;
import cn.ekgc.bocaiman.util.enums.CheckStatusEnum;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("contactsInfoService")
@Transactional
public class ContactsInfoServiceImpl implements ContactsInfoService {
	@Autowired
	private ContactsInfoDao dao;
	@Autowired
	private IdGenerator idGenerator;

	/**
	 * <b>根据分页对象查询分页信息</b>
	 * @param pageVO
	 * @return
	 */
	@Override
	public PageVO<ContactsInfoVO> getPage(PageVO<ContactsInfoVO> pageVO) throws Exception {
		//创建查询对象
		ContactsInfo query = new ContactsInfo();
		//开启PageHelper 分页对象过滤器
		PageHelper.startPage(pageVO.getPageNum(),pageVO.getPageSize());
		//进行分页查询
		List<ContactsInfo> list = dao.findListByQuery(query);
		//创建PageInfo 对象
		PageInfo pageInfo = new PageInfo(list);
		//提取查询对象
		List<ContactsInfoVO> resultList = new ArrayList<ContactsInfoVO>();
		for (ContactsInfo entity : (List<ContactsInfo>)pageInfo.getList()){
			resultList.add(ContactsInfo.parseToEntity(entity));
		}
		pageVO.setList(resultList);
		pageVO.setTotalPage(pageInfo.getPages());
		pageVO.setTotalCount(pageInfo.getTotal());

		return pageVO;
	}

	/**
	 * <b>根据查询对象查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<ContactsInfoVO> getListByQuery(ContactsInfoVO queryVO) throws Exception {
		//将VO对象变成实体对象
		ContactsInfo query = ContactsInfoVO.parseToEntity(queryVO);
		// 进行列表查询
		List<ContactsInfo> list = dao.findListByQuery(query);
		// 将实体列表切换为视图列表
		List<ContactsInfoVO> resultVO = new ArrayList<ContactsInfoVO>();
		if (list != null) {
			for (ContactsInfo entity : list) {
				resultVO.add(ContactsInfo.parseToEntity(entity));
			}
		}
		return resultVO;
	}


	/**
	 * <b>根据id查询列表</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@Override
	public ContactsInfoVO getById(String id) throws Exception {
		// 创建查询实体
		ContactsInfo query = new ContactsInfo();
		query.setId(id);
		// 进行列表查询
		List<ContactsInfo> list = dao.findListByQuery(query);
		if (list != null && !list.isEmpty()) {
			ContactsInfo entity = list.get(0);
			return ContactsInfo.parseToEntity(entity);
		}
		return null;
	}


	/**
	 * <b>保存</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean save(ContactsInfoVO vo) throws Exception {
		// 将 vo 转换为 entity
		ContactsInfo entity = ContactsInfoVO.parseToEntity(vo);
		// 设定主键
		entity.setId(idGenerator.nextId());
		entity.setCheckStatus(CheckStatusEnum.CHECK_STATUS_PENDING.getRemark());
		// 保存
		Integer count = dao.save(entity);

		if (count != null && count > 0) {
			return true;
		}
		return false;
	}

	/**
	 * <b>修改</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@Override
	public boolean update(ContactsInfoVO vo) throws Exception {
		// 将 vo 转换为 entity
		ContactsInfo entity = ContactsInfoVO.parseToEntity(vo);
		// 保存
		Integer count = dao.update(entity);

		if (count != null && count > 0) {
			return true;
		}
		return false;
	}
}
