package br.ufmg.ppgee.secondscreen.controller;

import static br.ufmg.ppgee.secondscreen.platform.objectify.OfyService.ofy;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.ufmg.ppgee.secondscreen.platform.entities.Viewer;

@Controller
public class LoginController {

    @RequestMapping(value = "login", method = RequestMethod.POST, headers = "Accept=application/json")
    public @ResponseBody
    Viewer login(Viewer viewer, HttpSession session) {
	Viewer assertViewer = ofy().load().type(Viewer.class)
		.filter("username", viewer.getUsername()).first().now();
	boolean isUsernameOk = assertViewer.getUsername().equals(
		viewer.getUsername());
	boolean isPasswordOk = assertViewer.getPassword().equals(
		viewer.getPassword());
	if (isUsernameOk && isPasswordOk) {
	    session.setAttribute("username", viewer.getUsername());
	    return assertViewer;
	}
	return null;
    }

    @RequestMapping(value = "logout", method = RequestMethod.POST)
    public String logout(HttpSession session) {
	session.invalidate();
	return "redirect:logout";
    }
}
