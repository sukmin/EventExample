package me.ujung.eventexample.web;

import me.ujung.eventexample.domain.User;
import me.ujung.eventexample.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(path = { "/", "/user" }, method = RequestMethod.GET)
	public String getUserJoin() {
		return "user-join";
	}

	@RequestMapping(path = "/user", method = RequestMethod.POST)
	@ResponseBody
	public String postUserJoin(User aUser) {
		return userService.join(aUser).name();
	}

}
