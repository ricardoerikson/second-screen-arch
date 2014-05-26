package br.ufmg.ppgee.secondscreen.controller;

import static br.ufmg.ppgee.secondscreen.platform.objectify.OfyService.ofy;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufmg.ppgee.secondscreen.platform.entities.User;

@Controller
@RequestMapping("user")
public class UserController {

	@RequestMapping("new")
	public String createUser(User user) {
		ofy().save().entity(user);
		return "saved";
	}

}
