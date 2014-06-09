package br.ufmg.ppgee.secondscreen.controller;

import static br.ufmg.ppgee.secondscreen.platform.objectify.OfyService.ofy;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.ufmg.ppgee.secondscreen.platform.entities.Viewer;

@Controller
public class LoginController {

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(Viewer viewer, HttpSession session) {
	Viewer assertViewer = ofy().load().type(Viewer.class)
		.filter("username", "ricardoerikson").first().now();

	System.out.println(assertViewer);
	if (assertViewer != null) {
	    boolean isUsernameOk = assertViewer.getUsername().equals(
		    viewer.getUsername());
	    boolean isPasswordOk = assertViewer.getPassword().equals(
		    viewer.getPassword());
	    if (isUsernameOk && isPasswordOk) {
		session.setAttribute("username", viewer.getUsername());
		return "login/success";
	    }
	}
	return "redirect:login/form";
    }

    @RequestMapping("/login/form")
    public String form() {
	return "login/loginForm";
    }

    @RequestMapping("/login/viewer/form")
    public String newViewerForm() {
	return "user/userForm";
    }

    @RequestMapping(value = "/login/viewer/new", method = RequestMethod.POST)
    public String newViewer(Viewer viewer) {
	ofy().save().entity(viewer);
	return "redirect:/login/form";
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
	session.invalidate();
	return "redirect:logout";
    }
}
