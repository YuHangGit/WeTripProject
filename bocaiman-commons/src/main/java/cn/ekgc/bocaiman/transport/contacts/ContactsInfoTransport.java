package cn.ekgc.bocaiman.transport.contacts;

import cn.ekgc.bocaiman.base.pojo.vo.PageVO;
import cn.ekgc.bocaiman.pojo.contacts.vo.ContactsInfoVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-联系人信息管理-联系人信息传输层</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
@FeignClient(name = "bocaiman-user-provider")
@RequestMapping("/contactsinfo/trans")
public interface ContactsInfoTransport {
	/**
	 * <b>根据分页对象查询分页信息</b>
	 * @param pageVO
	 * @return
	 */
	@PostMapping("/page")
	PageVO<ContactsInfoVO> getByPage(@RequestBody PageVO<ContactsInfoVO> pageVO)throws Exception;

	/**
	 * <b>根据查询对象查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	List<ContactsInfoVO> getListByQuery(@RequestBody ContactsInfoVO queryVO)throws Exception;

	/**
	 * <b>根据di查询列表</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id/{id}")
	ContactsInfoVO getById(@RequestParam String id)throws Exception;

	/**
	 * <b>保存</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	boolean save(@RequestBody ContactsInfoVO vo)throws Exception;
	/**
	 * <b>修改</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	boolean update(@RequestBody ContactsInfoVO vo)throws Exception;
}
