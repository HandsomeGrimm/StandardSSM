package grimm.study.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import grimm.study.model.User;
import grimm.study.service.UserService;
import grimm.study.vo.MessageVo;

/**
 * @author HandsomeGrimm
 * @email labilabizy@163.com
 * @date 2018-10-26
 * @time 上午9:48:08
 */
@Controller
public class UserController {
	@Autowired
	UserService userService;

	@RequestMapping(value = "/user/{id}", method = RequestMethod.POST)
	@ResponseBody
	public MessageVo getUsers(@PathVariable Long id) {
		return userService.getUsersByID(id);
	}

	@RequestMapping(value = "/user/login", method = RequestMethod.POST)
	@ResponseBody
	public MessageVo getUserInfo(User user) {
		return userService.getUserInfo(user);
	}
}
