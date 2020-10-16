package cn.ekgc.bocaiman.contactsInfo.dao;

import cn.ekgc.bocaiman.pojo.contacts.entity.ContactsInfo;
import cn.ekgc.bocaiman.pojo.trade.entity.Trade;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ContactsInfoDao {
	/**
	 * <b>根据查询对象查询列表</b>
	 * @param query
	 * @return
	 * @throws Exception
	 */
	List<ContactsInfo> findListByQuery(ContactsInfo query)throws Exception;

	/**
	 * <b>保存</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Integer save(ContactsInfo entity) throws Exception;

	/**
	 * <b>修改</b>
	 * @param entity
	 * @return
	 * @throws Exception
	 */
	Integer update(ContactsInfo entity)throws Exception;
}
