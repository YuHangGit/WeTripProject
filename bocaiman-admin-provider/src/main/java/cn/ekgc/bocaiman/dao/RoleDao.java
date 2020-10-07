package cn.ekgc.bocaiman.dao;

import cn.ekgc.bocaiman.pojo.admin.entity.Role;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-后台管理-角色数据持久层接口</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
public interface RoleDao {

	/**
	 * <b>根据查询对象查询列表</b>
	 */
	List<Role> findListByQuery(Role query) throws Exception;

	/**
	 * <b>保存对象</b>
	 */
	Integer save(Role entity) throws Exception;

	/**
	 * <b>修改对象</b>
	 */
	Integer update(Role entity) throws Exception;
}
