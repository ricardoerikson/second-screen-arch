package br.ufmg.ppgee.secondscreen.controller;

import static br.ufmg.ppgee.secondscreen.platform.objectify.OfyService.ofy;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.ufmg.ppgee.secondscreen.platform.entities.Viewer;

@Controller
@RequestMapping("/viewers")
public class ViewerController {

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String createNewViewer(Viewer viewer) {
	ofy().save().entity(viewer);
	return "saved";
    }

    @RequestMapping(value = "", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    List<Viewer> getViewersJson() {
	List<Viewer> viewers = ofy().load().type(Viewer.class).list();
	return viewers;
    }

    @RequestMapping(value = "/{viewerId}", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    Viewer getViewer(@PathVariable Long viewerId) {
	Viewer viewer = ofy().load().type(Viewer.class).id(viewerId).now();
	return viewer;
    }

    @RequestMapping(value = "/{viewerId}/evaluations", method = RequestMethod.GET)
    public String getEvaluatedPrograms(@PathVariable Long viewerId) {
	return "forward:evaluations/viewer/" + String.valueOf(viewerId);
    }

    @RequestMapping(value = "/json", method = RequestMethod.GET, headers = "Accept=application/json")
    public @ResponseBody
    List<Viewer> getJson() {
	List<Viewer> list = ofy().load().type(Viewer.class).list();
	return list;
    }

}
