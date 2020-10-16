package cn.ekgc.bocaiman.dao;


import cn.ekgc.bocaiman.pojo.admin.entity.Admin;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-后台管理-管理员数据持久层接口</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
@Repository
public interface AdminDao {
	/**
	 * <b>根据查询对象查询列表</b>
	 */
	List<Admin> findListByQuery(Admin query) throws Exception;

	/**
	 * <b>保存对象</b>
	 */
	Integer save(Admin entity) throws Exception;

	/**
	 * <b>修改对象</b>
	 */
	Integer update(Admin entity) throws Exception;
}
