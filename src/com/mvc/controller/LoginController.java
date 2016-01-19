package com.mvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mvc.pojo.UserInfo;
import com.mvc.service.ITestService;

@Controller
public class LoginController {
	@Autowired
	@Qualifier("TestService")
	private ITestService testService;

	public void setTestService(ITestService testService) {
		this.testService = testService;
	}

	public LoginController() {
	}

	@RequestMapping(value = "/login/{user}", method = RequestMethod.GET)
	public ModelAndView myMethod(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("user") String user,
			ModelMap modelMap) throws Exception {
		modelMap.put("loginUser", user);
		return new ModelAndView("/login/hello", modelMap);
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public ModelAndView registPost(ModelMap modelMap) {
		String name = "";
		try {
			List<UserInfo> ui = testService.testTransaction();
			for (int i = 0; i < ui.size(); i++) {
				name = name + ui.get(i).getUserCode() + ":"
						+ ui.get(i).getUserName() + "|";
			}
		} catch (Exception ex) {
			ex.printStackTrace();
			name = "操作过程出错了!抱歉！";
		}
		modelMap.put("loginUser", name);
		return new ModelAndView("/login/hello", modelMap);
	}

	@RequestMapping(value = "/sayHello", method = RequestMethod.GET)
	public ModelAndView sayHello(@RequestParam("username") String username,
			ModelMap modelmap) {
		ModelAndView mv = new ModelAndView("/login/hello");
		modelmap.put("loginUser", username);
		return mv;
	}
}
