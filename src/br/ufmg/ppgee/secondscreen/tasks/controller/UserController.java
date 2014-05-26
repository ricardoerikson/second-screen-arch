package br.ufmg.ppgee.secondscreen.tasks.controller;

import static com.googlecode.objectify.ObjectifyService.ofy;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.googlecode.objectify.ObjectifyService;

import br.ufmg.ppgee.secondscreen.platform.entities.User;

@Controller
@RequestMapping("user")
public class UserController {

	static {
		ObjectifyService.register(User.class);
	}

	@RequestMapping("create")
	public void createUser(User user, HttpServletResponse response) {
		ofy().save().entity(user);
		response.setStatus(200);
	}

}
