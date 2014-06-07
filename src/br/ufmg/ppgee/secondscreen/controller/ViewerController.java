package br.ufmg.ppgee.secondscreen.controller;

import static br.ufmg.ppgee.secondscreen.platform.objectify.OfyService.ofy;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.ufmg.ppgee.secondscreen.platform.entities.Viewer;

@Controller
@RequestMapping("/viewers")
public class ViewerController {

    @RequestMapping(value="/",method=RequestMethod.POST)
    public String createNewViewer(Viewer viewer) {
	ofy().save().entity(viewer);
	return "saved";
    }

    @RequestMapping("/form")
    public String getForm() {
	return "user/userForm";
    }

    @RequestMapping("/list")
    public String listUsers(Model model) {
	List<Viewer> list = ofy().load().type(Viewer.class).list();
	model.addAttribute("users", list);
	return "user/listusers";
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    List<Viewer> getJson() {
	List<Viewer> list = ofy().load().type(Viewer.class).list();
	return list;
    }

}
