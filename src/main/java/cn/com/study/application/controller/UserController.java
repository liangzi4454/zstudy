package cn.com.study.application.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.study.application.model.UserEntity;
import cn.com.study.application.service.UserService;

@Controller
public class UserController {

	@Resource
	private UserService userService;

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@RequestMapping("/{id}/showUser")
	public String showUser(@PathVariable int id, ModelMap modelMap, HttpServletRequest request) {
		UserEntity u = userService.getUserEntityById(id);

		if (u == null) {
			u = new UserEntity();
			u.setEmail("");
		}
		modelMap.put("user", u);
		return "/user/list";
	}
	
	@RequestMapping("showUser")
	public String showUserEntity(int id, ModelMap modelMap, HttpServletRequest request) {
		UserEntity u = userService.getUserEntityById(id);
		if (u == null) {
			u = new UserEntity();
			u.setEmail("");
		}
		modelMap.put("user", u);
		return "/user/list";
	}
	
	@RequestMapping("/showUserExample")
	public String showUsers(Model model) {
		return "redirect:/1/showUser";
	}

	@RequestMapping("/userList")
	public String list(ModelMap model) {
		model.put("users", userService.getUserEntities());
		return "/user/list";
	}

	@RequestMapping("/user/{id}")
	public String detail(@PathVariable(value = "id") int id, ModelMap model) {
		model.put("user", userService.getUserEntityById(id));
		return "/user/detail";
	}
	@RequestMapping("/user/save")
	public String save() {
		UserEntity userEntity = new UserEntity();
		userEntity.setEmail("liangzi4454@qq.com");
		userEntity.setPassword("123");
		userEntity.setSex("1");
		userEntity.setUserName("liangzi");
		userService.insertUserEntity(userEntity);
		return "/user/list";
	}
}