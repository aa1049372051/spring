package com.yunix.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.task.SpringDynamicCronTask;
import com.test.Test;
import com.tools.Tools;
import com.yunix.models.PostParams;
import com.yunix.models.User;
import com.yunix.service.IOrderService;
import com.yunix.service.IUserService;

@Scope("prototype")
@Controller
@RequestMapping("/order")
public class OrderController {
	@Resource(name = "orderServiceImpl")
	private IOrderService orderService;

	@Resource(name = "userServiceImpl")
	private IUserService userService;

	/**
	 * HelloWord
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String getProducts(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		int a = orderService.getOrderCount();
		System.out.println(a);
		request.setAttribute("name", "helloWord");
		User user = new User();
		user.setStatus(1);
		// user.setWebsite("1ss");
		List<User> users = userService.getUsers(user);
		return "products/list";

	}

	// http://localhost:8080/Spring03/api/order/info/sss.json
	// =>{"pro":{"id":0,"name":"sss","dept":null,"phone":null,"website":null,"status":0},"name":"sss"}
	// http://localhost:8080/Spring03/api/order/info/sss => 显示视图
	@RequestMapping(value = { "/info/{pid}" }, method = RequestMethod.GET)
	public ModelAndView getProductInfo(@PathVariable String pid,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();

		User pro = new User();
		pro.setName(pid);
		map.put("name", pid);
		map.put("pro", pro);

		ModelAndView mav = new ModelAndView("products/list", map);

		return mav;

	}

	
	//http://localhost:8080/Spring03/api/order/query.json body={"status":1} header={"organID":1}
	@RequestMapping(value = "/query", method = RequestMethod.POST)
	public ModelAndView queryProduct(PostParams p, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		JSONObject bodyJson = JSONObject.fromObject(p.getBody());
		Map bodyMap = bodyJson;
		JSONObject headerJson = JSONObject.fromObject(p.getHeader());
		Map headerMap = headerJson;
		Map<String, Object> map = new HashMap<String, Object>();
		User u=Tools.JsonStringToObject(p.getBody());
		List<User> users = userService.getUsers(u);
		map.put("code", 200);
		map.put("lists", users);
		Map m=userService.findByPk(1);
		map.put("list", m);
		map.put("retMsg","操作成功");
		ModelAndView mav = new ModelAndView("products/list", map);
		return mav;

	}
	
	//http://localhost:8080/Spring03/api/order/setcron.json body=1/2 * * * * ?
	@RequestMapping(value = "/setcron", method = RequestMethod.GET)
	public ModelAndView setCron(PostParams p, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		SpringDynamicCronTask.setCron(p.getBody());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("code", 200);
		map.put("retMsg","操作成功");
		ModelAndView mav = new ModelAndView("products/list", map);
		return mav;

	}
}
