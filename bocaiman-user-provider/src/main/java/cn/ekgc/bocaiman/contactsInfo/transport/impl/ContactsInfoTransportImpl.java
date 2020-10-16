package cn.ekgc.bocaiman.contactsInfo.transport.impl;

import cn.ekgc.bocaiman.base.pojo.vo.PageVO;
import cn.ekgc.bocaiman.contactsInfo.service.ContactsInfoService;
import cn.ekgc.bocaiman.pojo.contacts.vo.ContactsInfoVO;
import cn.ekgc.bocaiman.transport.contacts.ContactsInfoTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController("contactsInfoTransport")
@RequestMapping("/contactsinfo/trans")
public class ContactsInfoTransportImpl implements ContactsInfoTransport {
	@Autowired
	private ContactsInfoService service;
	/**
	 * <b>根据分页对象查询分页信息</b>
	 * @param pageVO
	 * @return
	 */
	@PostMapping("/page")
	@Override
	public PageVO<ContactsInfoVO> getByPage(@RequestBody PageVO<ContactsInfoVO> pageVO) throws Exception {
		return service.getPage(pageVO);
	}


	/**
	 * <b>根据查询对象查询列表</b>
	 * @param queryVO
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/list")
	@Override
	public List<ContactsInfoVO> getListByQuery(@RequestBody ContactsInfoVO queryVO) throws Exception {
		return service.getListByQuery(queryVO);
	}

	/**
	 * <b>根据di查询列表</b>
	 * @param id
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/id/{id}")
	@Override
	public ContactsInfoVO getById(@RequestParam String id) throws Exception {
		return service.getById(id);
	}

	/**
	 * <b>保存</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/save")
	@Override
	public boolean save(@RequestBody ContactsInfoVO vo) throws Exception {
		return service.save(vo);
	}

	/**
	 * <b>修改</b>
	 * @param vo
	 * @return
	 * @throws Exception
	 */
	@PostMapping("/update")
	@Override
	public boolean update(@RequestBody ContactsInfoVO vo) throws Exception {
		return service.update(vo);
	}
}
