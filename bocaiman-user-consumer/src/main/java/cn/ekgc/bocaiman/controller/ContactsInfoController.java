package cn.ekgc.bocaiman.controller;

import cn.ekgc.bocaiman.base.controller.BaseController;
import cn.ekgc.bocaiman.base.pojo.vo.PageVO;
import cn.ekgc.bocaiman.base.pojo.vo.ResponseVO;
import cn.ekgc.bocaiman.pojo.contacts.vo.ContactsInfoVO;
import cn.ekgc.bocaiman.transport.contacts.ContactsInfoTransport;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-联系人信息管理-联系人信息控制器</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
@Api(value = "菠菜侠旅游租赁平台-联系人信息管理-联系人信息控制器", tags = {"菠菜侠旅游租赁平台-联系人信息管理-联系人信息交互接口"})
@RestController("contactsInfoController")
@RequestMapping("/contactsinfo")
public class ContactsInfoController extends BaseController {
	@Autowired
	private ContactsInfoTransport transport;

	@ApiOperation(value = "根据分页信息分页查询", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "当前页码", dataType = "Integer", dataTypeClass = Integer.class, required = false),
			@ApiImplicitParam(value = "每页显示数量", dataType = "Integer", dataTypeClass = Integer.class, required = false)
	})
	@PostMapping("/page")
	public ResponseVO queryByPage(Integer pageNum, Integer pagerSize)throws Exception{
		//根据pageNum 和pageSize  创建Page对象
		PageVO<ContactsInfoVO> pageVO = new PageVO<ContactsInfoVO>(pageNum, pagerSize);
		//使用传输层调用provider 进行查询
		pageVO=transport.getByPage(pageVO);
		return ResponseVO.success(pageVO);
	}

	@ApiOperation(value = "根据查询对象查询列表", httpMethod = "POST")
	@ApiImplicitParam(value = "查询视图", dataType = "ContactsInfoVO", dataTypeClass =ContactsInfoVO.class, required = true)
	@ApiResponse(code = 200, message = "响应成功")
	@PostMapping("/list")
	public ResponseVO queryListByQuery(ContactsInfoVO queryVO) throws Exception {
		// 使用 Transport 层进行列表查询
		List<ContactsInfoVO> list = transport.getListByQuery(queryVO);
		return ResponseVO.success(list);
	}

	@ApiOperation(value = "根据主键查询对象", httpMethod = "GET")
	@ApiResponse(code = 200, message = "响应成功")
	@GetMapping("/id/{id}")
	public ResponseVO queryById(@PathVariable("id") String id) throws Exception {
		// 使用 Transport 层进行列表查询
		ContactsInfoVO contactsInfoVO = transport.getById(id);
		return ResponseVO.success(contactsInfoVO);
	}

	@ApiOperation(value = "保存信息", httpMethod = "POST")
	@ApiImplicitParam(value = "保存视图", dataType = "ContactsInfoVO", dataTypeClass =ContactsInfoVO.class, required = true)
	@ApiResponse(code = 200, message = "响应成功")
	@PostMapping("/save")
	public ResponseVO save(@RequestBody ContactsInfoVO vo) throws Exception {
		// 判断此时用户所填写的名称不能为空
		if ((vo.getName() != null && !"".equals(vo.getName().trim())) &&
				(vo.getCorporation() != null && !"".equals(vo.getCorporation().trim())) &&
				(vo.getCellphone() != null && !"".equals(vo.getCellphone().trim())) &&
				(vo.getIdCard() != null && !"".equals(vo.getIdCard().trim()))) {
			// 校验名字是否唯一
			ContactsInfoVO queryVO = new ContactsInfoVO();
			queryVO.setCorporation(vo.getCorporation());
			queryVO.setName(vo.getName());
			queryVO.setCellphone(vo.getCellphone());
			queryVO.setIdCard(vo.getCellphone());
			List<ContactsInfoVO> list = transport.getListByQuery(queryVO);
			if (list == null || list.isEmpty()) {
				// 此时的名字可用，保存信息
				boolean flag = transport.save(vo);
				if (flag) {
					return ResponseVO.success();
				} else {
					return ResponseVO.failure("添加失败");
				}
			} else {
				return  ResponseVO.failure("信息重复请检查");
			}
		} else {
			return ResponseVO.failure("请填写完整的信息");
		}
	}

	@ApiOperation(value = "修改信息", httpMethod = "POST")
	@ApiImplicitParam(value = "修改视图", dataType = "ContactsInfoVO", dataTypeClass =ContactsInfoVO.class, required = true)
	@ApiResponse(code = 200, message = "响应成功")
	@PostMapping("/update")
	public ResponseVO update(@RequestBody ContactsInfoVO vo) throws Exception {
		boolean flag = transport.update(vo);
		if (flag) {
			return ResponseVO.success();
		} else {
			return ResponseVO.failure("添加失败");
		}
	}
}
