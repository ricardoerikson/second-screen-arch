package br.ufmg.ppgee.secondscreen.controller;

import static br.ufmg.ppgee.secondscreen.platform.objectify.OfyService.ofy;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufmg.ppgee.secondscreen.platform.entities.User;

@Controller
@RequestMapping("user")
public class UserController {

	@RequestMapping("create")
	public void createUser(User user, HttpServletResponse response) {
		ofy().save().entity(user);
		response.setStatus(200);
	}

}
