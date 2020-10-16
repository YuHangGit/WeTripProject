package cn.ekgc.bocaiman.controller;

import cn.ekgc.bocaiman.base.controller.BaseController;
import cn.ekgc.bocaiman.base.pojo.vo.PageVO;
import cn.ekgc.bocaiman.base.pojo.vo.ResponseVO;
import cn.ekgc.bocaiman.pojo.trade.vo.PaymentPlatformVO;
import cn.ekgc.bocaiman.transport.trade.PaymentPlatformTransport;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <b>菠菜侠旅游租赁平台-支付管理-支付平台控制器</b>
 * @author zyh
 * @version 1.0.0
 * @since 1.0.0
 */
@Api(value = "菜侠旅游租赁平台-支付管理-支付平台控制器", tags = {"菜侠旅游租赁平台-支付管理-支付平台控制器"})
@RestController("paymentPlatformController")
@RequestMapping("/trade/paymentplatform")
public class PaymentPlatformController extends BaseController {
	@Autowired
	private PaymentPlatformTransport transport;

	@ApiOperation(value = "根据分页信息分页查询", httpMethod = "POST")
	@ApiImplicitParams({
			@ApiImplicitParam(value = "当前页码", dataType = "Integer",dataTypeClass = ResponseVO.class,required = false),
			@ApiImplicitParam(value = "每页显示数量", dataType = "Integer",dataTypeClass = ResponseVO.class, required = false)
	})
	@ApiResponse(code = 200, message = "响应成功")
	@PostMapping("/page")
	public ResponseVO queryByPage(Integer pageNum, Integer pageSize)throws Exception{
		//根据pageNum 和pageSize 创建page 对象
		PageVO<PaymentPlatformVO> pageVO = new PageVO<PaymentPlatformVO>(pageNum, pageSize);
		//使用传输层调用Provider 进行查询
		pageVO = transport.getByPage(pageVO);
		//返回结果
		return ResponseVO.success(pageVO);
	}

	@ApiOperation(value = "查询列表", httpMethod = "POST")
	@ApiImplicitParam(value = "当前页码", dataType = "PaymentPlatformVO", dataTypeClass = ResponseVO.class)
	@ApiResponse(code = 200, message = "响应成功")
	@PostMapping("/list")
	public ResponseVO queryListByQuery(PaymentPlatformVO queryVO)throws Exception{
		//使用Transport（传输层）进行查询
		List<PaymentPlatformVO> list = transport.getListByQuery(queryVO);
		return ResponseVO.success(list);
	}

	@ApiOperation(value = "根据主键查询对象", httpMethod = "GET")
	@ApiResponse(code = 200, message = "响应成功")
	@PostMapping("/id/{id}")
	public ResponseVO queryById (@PathVariable("id") String id)throws Exception{
		//使用Transport 层进行查询
		PaymentPlatformVO paymentPlatformVO = transport.getById(id);
		return ResponseVO.success(paymentPlatformVO);
	}

	@ApiOperation(value = "保存信息", httpMethod = "POST")
	@ApiImplicitParam(value = "保存视图", dataTypeClass = ResponseVO.class, dataType = "PaymentPlatformVO")
	@ApiResponse(code = 200, message = "响应成功")
	@PostMapping("/save")
	public ResponseVO save(@RequestBody PaymentPlatformVO vo)throws Exception{
		//判断用户输入的名称不能为空
		if(vo.getPlatform() != null && !"".equals(vo.getPlatform().trim())){
			//校验名字是否唯一
			PaymentPlatformVO queryVO = new PaymentPlatformVO();
			queryVO.setPlatform(vo.getPlatform());
			List<PaymentPlatformVO> list = transport.getListByQuery(queryVO);
			if(list == null || list.isEmpty()){
				//此时名字可用
				boolean flag = transport.save(vo);
				if(flag){
					return ResponseVO.success();
				}else {
					return ResponseVO.failure("添加失败");
				}
			}else {
				return ResponseVO.failure("该支付平台已存在！");
			}
		}else {
			return ResponseVO.failure("请填写有效的支付平台名称！");
		}
	}
	@ApiOperation(value = "修改信息", httpMethod = "POST")
	@ApiImplicitParam(value = "修改视图", dataTypeClass = ResponseVO.class, dataType = "PaymentPlatformVO")
	@ApiResponse(code = 200, message = "响应成功")
	@PostMapping("/update")
	public ResponseVO update(@RequestBody PaymentPlatformVO vo)throws Exception {
		boolean flag = transport.update(vo);
		if (flag) {
			return ResponseVO.success();
		} else {
			return ResponseVO.failure("添加失败");
		}
	}
}
