package cn.ekgc.bocaiman.contactsInfo.service;

import cn.ekgc.bocaiman.base.pojo.vo.PageVO;
import cn.ekgc.bocaiman.pojo.contacts.vo.ContactsInfoVO;

import java.util.List;

public interface ContactsInfoService {

	/**
	 * <b>根据分页对象查询分页信息</b>
	 * @param pageVO
	 * @return
	 */
	PageVO<ContactsInfoVO> getPage(PageVO<ContactsInfoVO> pageVO)throws Exception;

	/**
	 * <b>根据查询对象查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	List<ContactsInfoVO> getListByQuery(ContactsInfoVO queryVO)throws Exception;


	/**
	 * <b>根据id查询列表</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	ContactsInfoVO getById(String id)throws Exception;

	/**
	 * <b>保存</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	boolean save(ContactsInfoVO vo)throws Exception;

	/**
	 * <b>修改</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	boolean update(ContactsInfoVO vo)throws Exception;
}
