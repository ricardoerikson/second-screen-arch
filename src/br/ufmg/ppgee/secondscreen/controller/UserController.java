package br.ufmg.ppgee.secondscreen.controller;

import static br.ufmg.ppgee.secondscreen.platform.objectify.OfyService.ofy;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.ufmg.ppgee.secondscreen.platform.entities.User;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/new")
    public String createUser(User user) {
	ofy().save().entity(user);
	return "saved";
    }

    @RequestMapping("/form")
    public String getForm() {
	return "user/userForm";
    }

    @RequestMapping("/list")
    public String listUsers(Model model) {
	List<User> list = ofy().load().type(User.class).list();
	for (User u : list)
	    System.out.println(u.getId() + ", " + u.getUsername());
	model.addAttribute("users", list);
	return "user/listusers";
    }

}
