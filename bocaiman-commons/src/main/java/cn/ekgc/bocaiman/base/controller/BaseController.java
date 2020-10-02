package cn.ekgc.bocaiman.base.controller;

import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <b>菠菜侠-基础控制器</b>
 * <p>
 *     基础控制器依赖注入了<b>HttpServletRequest</b>,<b>HttpServletResponse</b>和<b>HttpSession</b>
 *     其他功能模块控制器都必须继承于本基础控制器
 * </p>
 * @author 10316
 * @version 1.0.0
 * @since 1.0.0
 */
@Controller("baseController")
public class BaseController {
	@Autowired
	protected HttpServletRequest request;
	@Autowired
	protected HttpServletResponse response;
	@Autowired
	protected HttpSession session;
}
